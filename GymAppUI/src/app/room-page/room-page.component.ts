import { Component, OnInit } from '@angular/core';
import { Room } from '../models/room';
 
@Component({
  selector: 'app-room-page',
  templateUrl: './room-page.component.html',
  styleUrls: ['./room-page.component.css']
})
export class RoomPageComponent implements OnInit {

  roomToCreate: Room = new Room(0,null);
  roomToUpdate: Room = new Room(0,null);
  allRooms: Room[] = [];
  mode: string = "none";

  constructor() { }

  ngOnInit() {
  }

}
