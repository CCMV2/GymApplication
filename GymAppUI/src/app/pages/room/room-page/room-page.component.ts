import { Component, OnInit } from '@angular/core';
import { Room } from '../../../models/room';
import {BackendService} from '../../../backend.service';

@Component({
  selector: 'app-room-page',
  templateUrl: './room-page.component.html',
  styleUrls: ['./room-page.component.css']
})
export class RoomPageComponent implements OnInit {

  roomToCreate: Room = new Room(0,null);
  roomToUpdate: Room = new Room(0,null);
  selectedRoom: Room;
  allRooms: Room[] = [];
  mode: string = "none";
  updating: boolean = false;

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.refreshRooms();
  }

  refreshRooms(): void {
    this.backendService.getAllRooms().subscribe(res => {
      this.allRooms = res;
      console.log(this.allRooms);
    });
  }

  addRoom(): void {
    this.backendService.addRoom(this.roomToCreate).subscribe(res => {
      console.log(res);
      this.refreshRooms();
      this.roomToCreate = new Room(0,null);
      this.mode  = "none";
    })
  }

  select(room: Room): void {
    this.selectedRoom = room;
  }

  setRoomToUpdate(room: Room) {
    this.roomToUpdate = room;
    this.updating = true;
  }

  updateRoom(): void {
    this.backendService.addRoom(this.roomToUpdate).subscribe( res=> {
      console.log(res);
      this.refreshRooms();
    });
    this.updating = false;
  }

  deleteRoom(room: Room): void {
    this.backendService.deleteRoom(room).subscribe(res => {
      console.log(res);
      this.refreshRooms();
    })
  }

}
