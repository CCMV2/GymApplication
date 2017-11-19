import { Component, OnInit } from '@angular/core';
import { Workout } from '../models/workout';
import { BackendService } from '../backend.service';
import {TrainerWorkout} from '../models/trainerWorkout'
//import { User } from '../models/user'

@Component({
  selector: 'app-list-workout',
  templateUrl: './list-workout.component.html',
  styleUrls: ['./list-workout.component.css']
})
export class ListWorkoutComponent implements OnInit {

  selectedWorkout: Workout;

  allWorkouts: TrainerWorkout[];

  //trainerList: User[];

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllWorkouts();
  }

  getAllWorkouts() {
    this.backendService.getAllWorkouts().subscribe(res =>
      this.allWorkouts = res)
  }

  select(workout: Workout) {
    this.selectedWorkout = workout;
  }

  delete() {
    console.log("start delete");
    this.backendService.deleteWorkout(this.selectedWorkout).subscribe(res => {
      console.log(res); this.getAllWorkouts(); this.selectedWorkout = null
    })
    
    console.log(this.allWorkouts);
  }
}
