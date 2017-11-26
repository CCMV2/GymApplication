import { Component, OnInit } from '@angular/core';
import {BackendService} from '../../../backend.service';
import {Workout} from '../../../models/workout';
import {WorkoutList} from '../../../models/workoutlist';
import {Subscription} from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';
@Component({
  selector: 'app-create-subscription',
  templateUrl: './create-subscription.component.html',
  styleUrls: ['./create-subscription.component.css']
})
export class CreateSubscriptionComponent implements OnInit {

  createdSubscriptionName: string = "";
  createdSubscriptionPrice: number = 0.0;
  createdSubscriptionStart : Date = null;
  createdSubscriptionDuration : number = null;
  workouts : Workout[] = [];
  message = '';
 

  subscriptionToCreate: Subscription = new Subscription ('', 0, new Date(), 0);
  workoutList : WorkoutList = new WorkoutList(this.subscriptionToCreate, this.workouts);

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getWorkouts();
  }

  getWorkouts(): void {
    this.backendService.getAllRealWorkouts().subscribe( res => {
      this.workouts = res;
      console.log (this.workouts);
    })
  }

  addSubscription(): void {
    const name = this.subscriptionToCreate.name;
    const price = this.subscriptionToCreate.price;
    const duration = this.subscriptionToCreate.duration;
    this.subscriptionToCreate.start = new Date();
    this.workoutList.setSubscription(this.subscriptionToCreate);
    this.workoutList.setWorkouts(this.workouts);
    this.backendService.addSubscription(this.workoutList).subscribe(res => {
      this.message = res;
    })
    
  }




}
