import { Component, OnInit } from '@angular/core';
import { Client } from "../../../models/user";
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';
@Component({
  selector: 'app-user-timetable',
  templateUrl: './user-timetable.component.html',
  styleUrls: ['./user-timetable.component.css']
})
export class UserTimetableComponent implements OnInit {

    userClient : Client;
  constructor( private backendService: BackendService,private session: SessionStorageService) { }

  ngOnInit() {
      this.userClient = this.session.retrieve('userToUpdate');
  }

}
