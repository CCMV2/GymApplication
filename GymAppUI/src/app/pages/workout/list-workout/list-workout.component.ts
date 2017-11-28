import { Component, OnInit } from '@angular/core';
import { Workout } from '../../../models/workout';
import { BackendService } from '../../../backend.service';
import { TrainerWorkout } from '../../../models/trainer-workout'
import { Router } from '@angular/router';
import { SessionStorageService } from 'ngx-webstorage';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-list-workout',
  templateUrl: './list-workout.component.html',
  styleUrls: ['./list-workout.component.css']
})
export class ListWorkoutComponent implements OnInit {

  selectedWorkout: Workout;

  allWorkouts: TrainerWorkout[] = [];

  constructor(private backendService: BackendService, private router: Router , private session: SessionStorageService) { }

  ngOnInit() {
    this.getAllWorkouts();
  }

  getAllWorkouts() {
      this.backendService.getAllWorkouts().subscribe(res =>
        this.allWorkouts = res)
    }

  update(workout: TrainerWorkout ): void {
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
