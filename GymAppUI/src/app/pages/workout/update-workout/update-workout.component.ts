import {Component, OnDestroy, OnInit} from '@angular/core';
import { BackendService } from '../../../backend.service';
import { SessionStorageService } from 'ngx-webstorage';
import { Workout } from '../../../models/workout';
import { Trainer } from '../../../models/user';
import { TrainerWorkout } from '../../../models/trainer-workout';

@Component({
  selector: 'app-update-workout',
  templateUrl: './update-workout.component.html',
  styleUrls: ['./update-workout.component.css']
})
export class UpdateWorkoutComponent implements OnInit, OnDestroy {

  constructor(private backendService: BackendService, private session: SessionStorageService) { }

  trainerWorkouts: TrainerWorkout;

  trainerList: Trainer[] = [];

  message = "";

  ngOnInit() {
    this.trainerWorkouts = this.session.retrieve('workoutToUpdate');
    for (let trainer of this.trainerWorkouts.trainers) {
        trainer.completeName = trainer.name + ' ' + trainer.surname;
    }
    this.getAllTrainers();
  }

  ngOnDestroy() {
    this.session.clear('workoutToUpdate');
  }

  updateWorkout() {
    this.backendService.addWorkout(this.trainerWorkouts).subscribe(res => {
      console.log(res);
      this.message = res;
      this.session.clear();
    }
    );
  }

  getAllTrainers() {
      this.backendService.getAllTrainers().subscribe(res => {
          this.trainerList = res;
          for ( let trainer of this.trainerList ) {
              if ( trainer.imageBase64 == null ) {
                  trainer.imageBase64 = '';
              }
          }
          for (let trainer of this.trainerList) {
              trainer.completeName = trainer.name + ' ' + trainer.surname;
          }
      });
  }

}
