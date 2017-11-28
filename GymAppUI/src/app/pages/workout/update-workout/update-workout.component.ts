import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { SessionStorageService } from 'ngx-webstorage';
import { Workout } from '../../../models/workout';
import { User } from '../../../models/user';
import { TrainerWorkout } from '../../../models/trainer-workout';

@Component({
  selector: 'app-update-workout',
  templateUrl: './update-workout.component.html',
  styleUrls: ['./update-workout.component.css']
})
export class UpdateWorkoutComponent implements OnInit {

  constructor(private backendService: BackendService, private session: SessionStorageService) { }

  // updatedWorkoutName: string = "";
  // updatedWorkoutDifficulty: string = "";
  // updatedWorkoutDescription: string = "";

  trainerList: User[] = [];
  selectedTrainers: User[] = [];

  workoutToUpdate: TrainerWorkout;

  ngOnInit() {
    this.workoutToUpdate = this.session.retrieve( 'workoutToUpdate' );
    console.log(this.workoutToUpdate);
    // this.updatedWorkoutName = this.workoutToUpdate.workoutType;
    // this.updatedWorkoutDescription=this.workoutToUpdate.description;
    // this.updatedWorkoutDifficulty=this.workoutToUpdate.difficulty;
    this.backendService.getAllTrainersForWorkout(this.workoutToUpdate.workout).subscribe(res => {this.selectedTrainers = res;console.log(this.selectedTrainers)});
        
    this.getAllTrainers();
  }

  getAllTrainers() {
    this.backendService.getAllTrainers().subscribe(res => this.trainerList = res);
  }
}
