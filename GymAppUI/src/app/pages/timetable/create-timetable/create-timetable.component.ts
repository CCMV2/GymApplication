import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../../backend.service";
import { Room } from "../../../models/room";
import { TrainerWorkout } from "../../../models/trainer-workout";
import { Timetable } from "../../../models/Timetable";
import { Workout } from "../../../models/workout";

@Component( {
    selector: 'app-create-timetable',
    templateUrl: './create-timetable.component.html',
    styleUrls: ['./create-timetable.component.css']
} )
export class CreateTimetableComponent implements OnInit {

    allRooms: Room[] = [];
    allWorkouts: TrainerWorkout[] = [];
    timetableToCreate: Timetable = new Timetable("Monday", new Date(), 0, "", "");

    constructor( private backendService: BackendService ) { }

    ngOnInit() {
        this.getRooms();
        this.getWorkouts();
    }

    addTimetable(): void {
        const roomName = this.timetableToCreate.roomName;
        const workoutType = this.timetableToCreate.workoutType;
        debugger;
        const room = this.findRoomByName(roomName);
        const workout = this.findWorkoutByType(workoutType);
        this.timetableToCreate.setRoom(room);
        this.timetableToCreate.setWorkout(workout);
        debugger;
        this.backendService.addTimetable(this.timetableToCreate).subscribe(res => {
          console.log(res);
        });
      }
    findRoomByName(name: string ): Room {
        for (let i in this.allRooms) {
            if(i.roomName == name)
                return i;
        }
        return null;
      }
    
    findWorkoutByType(type: string ): TrainerWorkout {
        for (let i in this.allWorkouts) {
            if(i.workoutType == type)
                return i;
        }
        return null;
      }
    getRooms(): void {
        this.backendService.getAllRooms().subscribe( res => {
            this.allRooms = res;
            console.log( this.allRooms );
        } );
    }
    getWorkouts(): void {
        this.backendService.getAllWorkouts().subscribe( res => {
            this.allWorkouts = res;
            console.log( this.allWorkouts );
        } );
    }
}
