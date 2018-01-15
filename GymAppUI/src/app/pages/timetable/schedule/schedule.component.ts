import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Timetable } from '../../../models/Timetable';
import * as moment from 'moment';
import { AuthenticationService } from '../../../services/authentication.service';
import { Client } from '../../../models/user';
import { ClientTimetable } from '../../../models/client-timetable';

@Component({
    selector: 'app-schedule',
    templateUrl: './schedule.component.html',
    styleUrls: ['./schedule.component.css'],
    encapsulation: ViewEncapsulation.None
})
export class ScheduleComponent implements OnInit {

    events: any[];
    header: any;
    option: any;
    allTimetables: Timetable[] = [];
    userTimetables: Timetable[] = [];
    firstStart: Date;

    constructor(private backendService: BackendService, private authenticationService: AuthenticationService) { }

    isAdminOrTrainer(): boolean {
        return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
    }

    ngOnInit() {
        this.getTimetables();
        this.getUserTimetables();
        this.header = {
            left: 'prev,next today',
            center: 'title',
            right: ''
        };
        this.option = {
            firstDay: 1,
            slotLabelFormat: 'HH:mm',
            timeFormat: 'HH:mm'
        };
    }

    loadEvents(event) {
        const startDate = new Date(event.view.start._i);
        this.prepareEvents(startDate);
        console.log('Here we prepare the timetable for a certain week');
    }
    handleEventClick(event) {
        
      const startDate = new Date(event.calEvent.start._i);
      console.log('I have been clicked!');
      if (this.authenticationService.isLoggedIn()) {
        if (this.authenticationService.hasRole(['CLIENT'])) {
          if (startDate.getTime() < new Date().getTime()) {
            alert('It is too late to subscribe to this workout :(');
          } else {
            this.backendService.addClientTimetable(new ClientTimetable(this.authenticationService.getCurrentUser(), event.calEvent.id))
              .subscribe(r => {
              alert(r);
              });
            setTimeout(() => {
                window.location.reload(false);
            }, 100);
          }
        }
        } else {
          alert('You must login in order to subscribe!');
        }
      }
    prepareEvents(startWeek: Date) {
        if (this.allTimetables.length == 0) {
            this.firstStart = startWeek;
        }
        // scoatem orele extra
        startWeek = new Date(startWeek.getTime() - startWeek.getHours() * 60 * 60 * 1000);
        this.events = [];
        for (const timeTableExample of this.allTimetables) {
            const event = {};
            //ne trebuie id-ul timetable-ului mai departe (un user se inscrie la un timetable)
            event['id'] = '' + timeTableExample.id;
            // setam titlu
            event['title'] = timeTableExample.workout.workoutType + ' - ' + timeTableExample.trainer.name + ' ' + timeTableExample.trainer.surname;
            // calculam startul in functie de ziua definita (Monday, Tuesday etc) si data de inceput din calendar (care va fi mereu luni)
            let startDayMilliseconds = startWeek.getTime() + this.getDayIndex(timeTableExample.day) * 24 * 60 * 60 * 1000;
            // setam acum ora si minutele din timetable
            const timeTableStart = new Date(timeTableExample.start);
            startDayMilliseconds += timeTableStart.getHours() * 60 * 60 * 1000 + timeTableStart.getMinutes() * 60 * 1000;
            const startDay = new Date(startDayMilliseconds);
            event['start'] = moment(startDay).format('YYYY-MM-DD[T]HH:mm:ss');
            // calculam end-ul ca start + duration
            const endDayMilliseconds = startDayMilliseconds + timeTableExample.duration * 60 * 1000;
            const endDay = new Date(endDayMilliseconds);
            event['end'] = moment(endDay).format('YYYY-MM-DD[T]HH:mm:ss');
            event['intensity'] = timeTableExample.workout.difficulty;
            event['stea'] = this.hasTimetable(timeTableExample);
            this.events.push(event);
        }
    }

    getDayIndex(day: string) {
        switch (day) {
            case 'Monday':
                return 0;
            case 'Tuesday':
                return 1;
            case 'Wednesday':
                return 2;
            case 'Thursday':
                return 3;
            case 'Friday':
                return 4;
            case 'Saturday':
                return 5;
            case 'Sunday':
                return 6;
        }
    }
    eventRender(event, element, view) {
        console.log(event, element, view);
        const data = event.start._d;
        // faceti verificarea daca data e in trecut
        console.log(event);
        if (data.getTime() < new Date().getTime()) {
            element.addClass('intensity-past');
        }
        else if (event.intensity == 'HARD') {
            element.addClass('intensity-hard');
        }
        else if (event.intensity == 'MEDIUM') {
            element.addClass('intensity-medium');
        }
        else if (event.intensity == 'EASY') {
            element.addClass('intensity-easy');
        }
        if(event.stea) {
            const title = element.find('.fc-title');
            title.append('<span title="You are subscribed" class="ui-button-icon-left ui-clickable fa fa-fw fa-star" style=" float:  right;"></span>');
        }
    }

    hasTimetable(timetable: Timetable): boolean {
        for (const usertimetable of this.userTimetables) {
            if (usertimetable.id === timetable.id) {
                return true;
            }
        }
        return false;
    }

    getTimetables(): void {
        this.backendService.getAllTimetables().subscribe(res => {
            this.allTimetables = res;
            console.log(this.allTimetables);
            this.prepareEvents(this.firstStart);
        });
    }

    getUserTimetables(): void {
        if (this.authenticationService.isLoggedIn()) {
            this.backendService.getUserTimetables(this.authenticationService.getCurrentUser()).subscribe(res => {
                this.userTimetables = res;
                console.log(this.userTimetables);
            });
        }
    }


}
