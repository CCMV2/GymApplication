import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from 'ngx-webstorage';
import {Subscription} from '../../../models/subscriptionModel';
import {Workout} from '../../../models/workout';
import { WorkoutList } from '../../../models/workoutlist';
import { BackendService } from '../../../backend.service';

@Component({
  selector: 'app-update-subscription',
  templateUrl: './update-subscription.component.html',
  styleUrls: ['./update-subscription.component.css']

})
export class UpdateSubscriptionComponent implements OnInit {
    subscription: Subscription;
    workouts: Workout[];
    workoutList: WorkoutList;

  constructor(private session: SessionStorageService, private backendService: BackendService) { }

  ngOnInit() {
    this.workoutList = this.session.retrieve('workoutlist');
    this.subscription = this.workoutList.subscription;
    this.subscription.start = new Date(this.subscription.start);
    debugger;
    this.getWorkouts();
  }

  getWorkouts(): void {
    this.backendService.getAllRealWorkouts().subscribe( res => {
      this.workouts = res;
      console.log (this.workouts);
    });
  }


}
