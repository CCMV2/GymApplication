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

  trainerWorkouts: TrainerWorkout;

  trainerList: User[] = [];

  message = "";

  ngOnInit() {
    this.trainerWorkouts = this.session.retrieve('workoutToUpdate');
    this.getAllTrainers();
  }

  updateWorkout() {
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
