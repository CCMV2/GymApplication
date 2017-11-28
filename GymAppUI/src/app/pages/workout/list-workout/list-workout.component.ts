import { Component, OnInit } from '@angular/core';
import { Workout } from '../../../models/workout';
import { BackendService } from '../../../backend.service';
import { TrainerWorkout } from '../../../models/trainer-workout'
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
  
  update(workout: TrainerWorkout) {
      console.log('implement me!');
  }

  delete(workout: TrainerWorkout) {
    this.backendService.deleteWorkout(workout.workout).subscribe(res => {
      console.log(res); this.getAllWorkouts();
    });

    console.log(this.allWorkouts);
  }
}
