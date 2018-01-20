import { Component, OnInit } from '@angular/core';
import { Client, Trainer } from '../../../models/user';
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';
import { Timetable } from '../../../models/Timetable';
import * as moment from 'moment';
import { ClientTimetable } from '../../../models/client-timetable';

@Component({
  selector: 'app-user-timetable',
  templateUrl: './user-timetable.component.html',
  styleUrls: ['./user-timetable.component.css']
})
export class UserTimetableComponent implements OnInit {

    userClient: Client;
    clientTimetable: ClientTimetable;
    clientTimetables: ClientTimetable[];
    listTimetable: Timetable[];
    timeList: Timetable[];


    message = '';
  constructor( private backendService: BackendService, private session: SessionStorageService) { }

  ngOnInit() {
      this.userClient = this.session.retrieve('userToUpdate');
      this.getAllClientsTimetables();
      this.getAllTimetables();
      this.clientTimetable = new ClientTimetable(this.userClient, new Timetable( 'Monday', new Date(), 0, '', '', new Trainer( 0, '', '', '', '', '', '' ) ));
  }

  getAllTimetables() {
      this.backendService.getAllTimetables().subscribe(res => {
          this.timeList = res;
          for (const timeElem of this.timeList) {
              const startDay = new Date(timeElem.start);
              const start = moment( startDay ).format( 'HH:mm' );
              const endDayMilliseconds = startDay.getTime() + timeElem.duration * 60 * 1000;
              const endDay = new Date( endDayMilliseconds );
              const end = moment( endDay ).format( 'HH:mm' );
              timeElem.timeTableName = timeElem.workout.workoutType + ' ' + timeElem.day + ' ' + start + '-' + end;
          }
          this.filterTimetable();
      });
    }

  getAllClientsTimetables() {
      if ( this.userClient.subscription && this.userClient.subscription.imageBase64 === null) {
          this.userClient.subscription.imageBase64 = '';
      }
      this.backendService.getClientTimetables(this.userClient).subscribe(res => {
          this.clientTimetables = res;
          for (const variabila of this.clientTimetables) {
              variabila.day = new Date(variabila.day);
}
      });
    }
  addTimetable() {
      //console.log(JSON.stringify(this.userClient));
        if ( this.clientTimetable.timetable.trainer.imageBase64 === null) {
            this.clientTimetable.timetable.trainer.imageBase64 = '';
        }
        if ( this.clientTimetable.client.subscription && this.clientTimetable.client.subscription.imageBase64 === null) {
           this.clientTimetable.client.subscription.imageBase64 = '';
        }
      this.backendService.addClientTimetable(this.clientTimetable).subscribe(res => {
        this.message = res;
        console.log(res);
        this.clientTimetables.push(this.clientTimetable);
    });
  }
  filterTimetable() {
     const day = this.clientTimetable.day.getDay();
     const dayIndex = this.getDayIndex(day);
     this.filterList(dayIndex);
  }
  getDayIndex(day: number) {
      switch (day) {
          case 1:
              return 'Monday';
          case 2:
              return 'Tuesday';
          case 3:
              return 'Wednesday';
          case 4:
              return 'Thursday';
          case 5:
              return 'Friday';
          case 6:
              return 'Saturday';
          case 0:
              return 'Sunday';
      }
  }
  filterList(day: string) {
      this.listTimetable = [];
      for (const timetable of this.timeList) {
          if (day === timetable.day) {
              this.listTimetable.push(timetable);
          }
      }
      this.clientTimetable.timetable = this.listTimetable[0];
  }
  deleteTimetable(item: ClientTimetable) {
      //console.log(JSON.stringify(this.userClient));
        if ( item.timetable.trainer.imageBase64 === null) {
            item.timetable.trainer.imageBase64 = '';
        }
        if ( item.client.subscription.imageBase64 === null) {
            item.client.subscription.imageBase64 = '';
        }
      this.backendService.deleteClientTimetable(item).subscribe(res => {
        this.message = res;
        console.log(res);
        const index = this.clientTimetables.findIndex(d => d.timetable.id === item.timetable.id && d.day === item.day);
        this.clientTimetables.splice(index, 1);
    });
  }
}
