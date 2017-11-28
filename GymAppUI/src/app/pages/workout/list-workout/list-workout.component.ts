import { Component, OnInit } from '@angular/core';
import { Workout } from '../../../models/workout';
import { BackendService } from '../../../backend.service';
import { TrainerWorkout } from '../../../models/trainer-workout'
import { Router } from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';
//import { TrainerListWorkout } from '../../../models/trainerlist-workout';
import { Observable } from 'rxjs/Observable';
//import { User } from '../models/user'

@Component({
  selector: 'app-list-workout',
  templateUrl: './list-workout.component.html',
  styleUrls: ['./list-workout.component.css']
})
export class ListWorkoutComponent implements OnInit {

  selectedWorkout: Workout;

  //allWorkouts: Workout[] = [];
  allWorkouts: TrainerWorkout[] = [];

  //finalWorkoutLists: TrainerListWorkout[] = [];

  //trainerList: TrainerWorkout[] = [];

  constructor(private backendService: BackendService, private router: Router , private session: SessionStorageService) { }

  ngOnInit() {
    this.getAllWorkouts();
  }

  getAllWorkouts() {
      this.backendService.getAllWorkouts().subscribe(res =>
        this.allWorkouts = res)
    }

  // getAllWorkouts() {
  //   this.backendService.getAllRealWorkouts().subscribe(res =>
  //     {this.allWorkouts = res;console.log(this.allWorkouts);this.initializeTrainerLists()})
  // }
  
  // initializeTrainerLists(){
  //   for(let i = 0; i<4; i++){
  //     let x = this.allWorkouts[i];
  //     let list: TrainerWorkout[] = this.newTrainerList(x);
  //     let tList: TrainerListWorkout = new TrainerListWorkout(x, list);
  //     this.finalWorkoutLists.push()
  //   }
  //   //forEach(x => {this.finalWorkoutLists.push(new TrainerListWorkout(x, this.newTrainerList(x))); console.log(x)});
  // }

  // getTrainersForWorkout(workout: Workout) {
  //     this.backendService.getAllTrainersForWorkout(workout).subscribe(res => this.trainerList = res);
  // }

  // newTrainerList(workout: Workout) {
  //   this.getTrainersForWorkout(workout);
  //   return this.trainerList;
  // }

  update(workout: Workout ): void {
    this.session.store('workoutToUpdate', workout);
    this.router.navigateByUrl('/updateworkout');
  }

  delete(workout: TrainerWorkout) {
    this.backendService.deleteWorkout(workout.workout).subscribe(res => {
      console.log(res); this.getAllWorkouts();
    });

    console.log(this.allWorkouts);
  }
}
