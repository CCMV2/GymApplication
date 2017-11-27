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

  createdWorkoutName: string = "";
  createdWorkoutDifficulty: string = "";
  createdWorkoutDescription: string = "";

  initialWorkoutTrainer: User = new User(0, "", "Choose a trainer", "", "", "", "");
  createdWorkoutTrainer: User = null;

  trainerList: User[];

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllTrainers();
  }

  addWorkout() {
    let createdWorkout: TrainerWorkout = new TrainerWorkout(new Workout(0, this.createdWorkoutName, this.createdWorkoutDifficulty, this.createdWorkoutDescription), this.createdWorkoutTrainer);
    this.backendService.addWorkout(createdWorkout).subscribe(res => console.log(res));
  }

  getAllTrainers() {
    this.backendService.getAllTrainers().subscribe(res => this.trainerList = res);
  }

}
