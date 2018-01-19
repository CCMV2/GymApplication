import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Timetable } from '../../../models/Timetable';
import * as moment from 'moment';
import { AuthenticationService } from '../../../services/authentication.service';
import { Client, User } from '../../../models/user';
import { ClientTimetable } from '../../../models/client-timetable';
import * as $ from 'jquery';
import { Subscription } from 'rxjs/Subscription';

declare var showPleaseWait: any;
declare var hidePleaseWait: any;
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
    firstStart: Date;
    title: any;
    client: Client;
    clientTimetables: ClientTimetable[];


    constructor(private backendService: BackendService, private authenticationService: AuthenticationService) { }

    isAdminOrTrainer(): boolean {
        return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
    }
    
    ngOnInit() {
        this.getUserById();

        this.getTimetables();
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
      this.title = $(event.jsEvent.currentTarget).find('.fc-title')[0];
      if (this.authenticationService.isLoggedIn()) {
        if (this.authenticationService.hasRole(['CLIENT'])) {
            const sDate: Date = this.authenticationService.getStart();
            console.log(new Date().valueOf());
            if(sDate < startDate){
                alert("Subscription expired");
            }else {
                if (startDate.getTime() < new Date().getTime()) {
                    alert('It is too late to subscribe to this workout :(');
                  } else {
                    if (event.calEvent.stea) {
                        const item = this.findUserTimetable(this.findTimetableById( event.calEvent.id), startDate);
                        this.deleteTimetable(item, event);
                    } else {
                          const item = new ClientTimetable(this.client, this.findTimetableById( event.calEvent.id));
                          item.day = startDate;
                        this.addTimetable(item, event);
                    }
                  }
            }
        } else {
            alert('You must login in order to subscribe!');
        }
      }
    }
    
    addStar(response: string) {
        if (response === 'Subscribed') {
            $(this.title).append('<span title="You are subscribed" class="ui-button-icon-left ui-clickable fa fa-fw fa-star" style=" float:  right;"></span>');
        }else {
            $(this.title).find('span').remove();
        }
    }
    prepareEvents(startWeek: Date) {
        $('.fa-star').remove();
        if (this.allTimetables.length === 0) {
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
            event['stea'] = this.clientTimetables ? this.hasTimetable(timeTableExample, startDay) : false;
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
        console.log(event);
        console.log(event.stea);
        if(event.stea) {
            const title = element.find('.fc-title');
            title.append('<span title="You are subscribed" class="ui-button-icon-left ui-clickable fa fa-fw fa-star" style=" float:  right;"></span>');
        }
    }

    hasTimetable(timetable: Timetable, day: Date): boolean {
        for (const clientTimetable of this.clientTimetables) {
            if (clientTimetable.timetable.id === timetable.id && clientTimetable.day.getDate() === day.getDate()
                    && clientTimetable.day.getMonth() === day.getMonth() && clientTimetable.day.getFullYear() === day.getFullYear()) {
                return true;
            }
        }
        return false;
    }
    
    findUserTimetable(timetable: Timetable, day: Date): ClientTimetable {
        for (const clientTimetable of this.clientTimetables) {
            if (clientTimetable.timetable.id === timetable.id && clientTimetable.day.getDate() === day.getDate()
                    && clientTimetable.day.getMonth() === day.getMonth() && clientTimetable.day.getFullYear() === day.getFullYear()) {
                return clientTimetable;
            }
        }
        return null;
    }

    getTimetables(): void {
        showPleaseWait();
        this.backendService.getAllTimetables().subscribe(res => {
            this.allTimetables = res;
            console.log(this.allTimetables);
            this.prepareEvents(this.firstStart);
            hidePleaseWait();
        });
    }

    getUserById() {
        if (this.authenticationService.isLoggedIn()) {
            this.backendService.getUserById(this.authenticationService.getId()).subscribe(res => {
                this.client = res;
                this.getAllClientsTimetables();
            });
        }
    }
    getAllClientsTimetables() {
        if ( this.client.subscription.imageBase64 === null) {
            this.client.subscription.imageBase64 = '';
        }
        this.backendService.getClientTimetables(this.client).subscribe(res => {
            this.clientTimetables = res;
            for (const variabila of this.clientTimetables) {
                variabila.day = new Date(variabila.day);
  }
            this.getTimetables();
        });
      }
    findTimetableById(id: number) {
        for (const timeTable of this.allTimetables) {
            if (timeTable.id == id) {
                return timeTable;
            }
        }
        return null;
    }
    
    addTimetable(item: ClientTimetable, event: any) {
        if ( item.timetable.trainer.imageBase64 === null) {
            item.timetable.trainer.imageBase64 = '';
        }
        if ( item.client.subscription.imageBase64 === null) {
            item.client.subscription.imageBase64 = '';
        }
        this.backendService.addClientTimetable(item).subscribe(res => {
          alert(res);
          event.calEvent.stea = true;
          this.addStar(res);
          this.clientTimetables.push(item);
      });
    }

    deleteTimetable(item: ClientTimetable, event: any) {
          if ( item.timetable.trainer.imageBase64 === null) {
              item.timetable.trainer.imageBase64 = '';
          }
          if ( item.client.subscription.imageBase64 === null) {
              item.client.subscription.imageBase64 = '';
          }
        this.backendService.deleteClientTimetable(item).subscribe(res => {
         alert(res);
         event.calEvent.stea = false;
         this.addStar(res);
         const index = this.clientTimetables.findIndex(d => d.timetable.id === item.timetable.id &&
                 d.day.getDate() === item.day.getDate()
                 && d.day.getMonth() === item.day.getMonth() && d.day.getFullYear() === item.day.getFullYear());
         this.clientTimetables.splice(index, 1);
      });
    }



}
