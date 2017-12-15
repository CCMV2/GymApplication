import { Component, OnInit } from '@angular/core';
import { Client } from "../../../models/user";
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';
import { Timetable } from "../../../models/Timetable";
@Component({
  selector: 'app-user-timetable',
  templateUrl: './user-timetable.component.html',
  styleUrls: ['./user-timetable.component.css']
})
export class UserTimetableComponent implements OnInit {

    userClient : Client;
    timeList : Timetable[];
  constructor( private backendService: BackendService,private session: SessionStorageService) { }

  ngOnInit() {
      this.userClient = this.session.retrieve('userToUpdate');
  }
  
  getAllTimetables() {
      this.backendService.getAllTimetables().subscribe(res => {
          this.timeList = res;
          for (let timeElem of this.timeList) {
              timeElem.timeTableName = timeElem.workoutType + ' ' + timeElem.start + ' ' + timeElem.duration;
          }
      });
    }

}
