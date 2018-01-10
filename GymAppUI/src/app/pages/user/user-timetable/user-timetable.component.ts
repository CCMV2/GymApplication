import { Component, OnInit } from '@angular/core';
import { Client } from '../../../models/user';
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';
import { Timetable } from '../../../models/Timetable';
import * as moment from 'moment';

@Component({
  selector: 'app-user-timetable',
  templateUrl: './user-timetable.component.html',
  styleUrls: ['./user-timetable.component.css']
})
export class UserTimetableComponent implements OnInit {

    userClient: Client;

    timeList: Timetable[];

    message: string = "";
  constructor( private backendService: BackendService, private session: SessionStorageService) { }

  ngOnInit() {
      this.userClient = this.session.retrieve('userToUpdate');
      this.getAllTimetables();
      for (const timeElem of this.userClient.userTimetable) {
        const startDay = new Date(timeElem.start);
        const start = moment( startDay ).format( 'HH:mm' );
        const endDayMilliseconds = startDay.getTime() + timeElem.duration * 60 * 1000;
        const endDay = new Date( endDayMilliseconds );
        const end = moment( endDay ).format( 'HH:mm' );
        timeElem.timeTableName = timeElem.workout.workoutType + ' ' + timeElem.day + ' ' + start + '-' + end;
    }
    debugger;
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
          debugger;
      });
    }
  addTimetable(){
      //console.log(JSON.stringify(this.userClient));
      this.backendService.addUser('createclient', this.userClient).subscribe(res => {
        this.message = res;
        //console.log(res);
    });
      alert('Implement me!');
  }
}