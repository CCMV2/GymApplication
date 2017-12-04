import { Component, OnInit } from '@angular/core';
import {BackendService} from '../../../backend.service';
import {Workout} from '../../../models/workout';
import {WorkoutList} from '../../../models/workoutlist';
import {Subscription} from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';


@Component({
  selector: 'app-subscription-details',
  templateUrl: './subscription-details.component.html',
  styleUrls: ['./subscription-details.component.css']
})
export class SubscriptionDetailsComponent implements OnInit {
  subscriptionsAndWorkouts: WorkoutList[] = [];
  constructor(private backendService: BackendService) { }
  
  
  ngOnInit() {
    this.getSubscriptions();
  }
  getSubscriptions(): void{
    this.backendService.getAllSubscriptions().subscribe( res => {
      this.subscriptionsAndWorkouts = res;
      console.log( this.subscriptionsAndWorkouts);
  } );
  }

}
