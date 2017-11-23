import { Component, OnInit } from '@angular/core';
import {Room} from "../../../models/room";
import {TrainerWorkout} from "../../../models/trainer-workout";
import {BackendService} from "../../../backend.service";


@Component( {
    selector: 'app-create-timetable',
    templateUrl: './create-timetable.component.html',
    styleUrls: ['./create-timetable.component.css']
} )
export class CreateTimetableComponent implements OnInit {

    allRooms: Room[] = [];
    allWorkouts: TrainerWorkout[] = [];

    constructor( private backendService: BackendService ) { }

    ngOnInit() {
        this.getRooms();
        this.getWorkouts();
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
