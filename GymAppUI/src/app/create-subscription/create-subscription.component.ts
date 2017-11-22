import { Component, OnInit } from '@angular/core';
import {BackendService} from '../backend.service';
import {Workout} from '../models/workout';
import {WorkoutList} from '../models/workoutlist';
import {Subscription} from '../models/subscription';
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
  
  createdWorkouts : Workout[];
  



 

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    
  }

 

}
