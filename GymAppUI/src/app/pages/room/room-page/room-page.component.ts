import { Component, OnInit } from '@angular/core';
import { Room } from '../../../models/room';
import {BackendService} from '../../../backend.service';

declare var showPleaseWait: any;
declare var hidePleaseWait: any;

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
  message = '';
  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.refreshRooms();
  }

  refreshRooms(): void {
    showPleaseWait();
    this.backendService.getAllRooms().subscribe(res => {
      this.allRooms = res;
      console.log(this.allRooms);
    hidePleaseWait();
    });
  }

  addRoom(): void {
    this.backendService.addRoom(this.roomToCreate).subscribe(res => {
      console.log(res);
      if (res === '0') {
        this.message = 'Successful';
        setTimeout(()=> {
          this.message = "";
          console.log("lol");
        }, 5000);
    }
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
      this.message = 'Successful';
      setTimeout(()=> {
        this.message = "";
        console.log("lol");
      }, 5000);
      console.log(res);
      this.refreshRooms();
    });
    this.updating = false;
  }

  deleteRoom(room: Room): void {
    this.backendService.deleteRoom(room).subscribe(res => {
      console.log( this.allRooms);
      if (res === 'Successful') {
        this.message = 'Successful';
        const index = this. allRooms.findIndex(d => d.roomId === room.roomId);
        this.allRooms.splice(index, 1);
        setTimeout(()=> {
          this.message = "";
          console.log("lol");
      }, 5000);
      //console.log(res);
    }
      else{
          alert('The room is still being used!');
      }
    });
  }

}
