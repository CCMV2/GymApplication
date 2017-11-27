import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Room } from '../../../models/room';
import { TrainerWorkout } from '../../../models/trainer-workout';
import { Timetable } from '../../../models/Timetable';
import { Workout } from '../../../models/workout';
import { SessionStorageService } from 'ngx-webstorage/dist/services';

@Component( {
    selector: 'app-update-timetable',
    templateUrl: './update-timetable.component.html',
    styleUrls: ['./update-timetable.component.css']
} )
export class UpdateTimetableComponent implements OnInit {

    allTimetables: Timetable[] = [];
    allRooms: Room[] = [];
    allWorkouts: TrainerWorkout[] = [];
    timetableToCreate: Timetable = new Timetable('Montag', new Date(), 0, '', '');
    message = '';

    constructor( private backendService: BackendService , private session: SessionStorageService) { }
    ngOnInit() {
        this.getRooms();
        this.getWorkouts();
        this.timetableToCreate = this.session.retrieve('timetableToUpdate') ;
        this.timetableToCreate.roomName = this.timetableToCreate.room.roomName;
        this.timetableToCreate.workoutType = this.timetableToCreate.workout.workoutType;
        this.timetableToCreate.start = new Date(this.timetableToCreate.start);
    }

    findRoomByName(name: string ): Room {
        for (const i of this.allRooms) {
            if (i.roomName === name) {
                return i;
            }
        }
        return null;
      }

    updateTimetable(): void {
        const roomName = this.timetableToCreate.roomName;
        const workoutType = this.timetableToCreate.workoutType;
        const room = this.findRoomByName(roomName);
        const workout = this.findWorkoutByType(workoutType);
        this.timetableToCreate.room = room ;
        this.timetableToCreate.workout = workout.workout ;
        this.backendService.updateTimetable(this.timetableToCreate).subscribe(res => {
        this.message = res;
        });
      }

    findWorkoutByType(type: string ): TrainerWorkout {
        for (const i of this.allWorkouts) {
            if (i.workout.workoutType === type) {
                return i;
            }
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
