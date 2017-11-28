import { Component, OnInit } from '@angular/core';
import { User } from "../../../models/user";
import { BackendService } from "../../../backend.service";
import { TrainerWorkout } from "../../../models/trainer-workout";
import { Workout } from "../../../models/workout";

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  trainerWorkouts: TrainerWorkout = new TrainerWorkout(new Workout(0, "", "", ""), []);

  trainerList: User[] = [];

  message = "";

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllTrainers();
  }

  addWorkout() {
    this.backendService.addWorkout(this.trainerWorkouts).subscribe(res => {
      console.log(res);
      this.message = res;
    }
    );
  }

  getAllTrainers() {
    this.backendService.getAllTrainers().subscribe(res => this.trainerList = res);
  }

}
