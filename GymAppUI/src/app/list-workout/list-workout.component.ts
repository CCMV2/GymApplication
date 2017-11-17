import { Component, OnInit } from '@angular/core';
import { Workout } from '../models/workout';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-list-workout',
  templateUrl: './list-workout.component.html',
  styleUrls: ['./list-workout.component.css']
})
export class ListWorkoutComponent implements OnInit {

  selectedWorkout: Workout;

  allWorkouts: Workout[];

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllWorkouts();
  }

  getAllWorkouts(){
    this.backendService.getAllWorkouts().subscribe(res =>
      this.allWorkouts = res)
  }

  select(workout: Workout) {
    this.selectedWorkout = workout;
  }

  delete() {
    console.log("start delete");
    this.backendService.deleteWorkout(this.selectedWorkout);
    this.getAllWorkouts();
    console.log(this.allWorkouts);
  }
}
