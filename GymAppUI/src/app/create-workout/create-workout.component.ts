import { Component, OnInit } from '@angular/core';
import { Workout } from '../models/workout';
import { BackendService} from '../backend.service'
import { User } from '../models/user';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  createdWorkoutName: string = "";
  createdWorkoutDifficulty: string = "";
  createdWorkoutDescription: string = "";

  createdWorkoutTrainer: User = new User(0, "", "Choose a trainer", "", "", "", "");

  trainerList: User[];

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllTrainers();
  }

  addWorkout() {
    let createdWorkout: Workout = new Workout(0, this.createdWorkoutName, this.createdWorkoutDifficulty, this.createdWorkoutDescription);
    this.backendService.addWorkout(createdWorkout).subscribe(res => console.log(res));
  }

  getAllTrainers(){
    this.backendService.getAllTrainers().subscribe(res => this.trainerList = res);
  }

}
