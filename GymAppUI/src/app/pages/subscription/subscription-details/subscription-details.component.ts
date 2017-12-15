import { Component, OnInit } from '@angular/core';
import {BackendService} from '../../../backend.service';
import {Workout} from '../../../models/workout';
import {WorkoutList} from '../../../models/workoutlist';
import {Subscription} from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';
import { IStarRatingOnClickEvent } from 'angular-star-rating/src/star-rating-struct';
import {Rating} from '../../../models/rating';


@Component({
  selector: 'app-subscription-details',
  templateUrl: './subscription-details.component.html',
  styleUrls: ['./subscription-details.component.css']
})
export class SubscriptionDetailsComponent implements OnInit {
  subscriptionsAndWorkouts: WorkoutList[] = [];
  onClickResult: IStarRatingOnClickEvent;
  ratingVal = 3.5;
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

  onClick = ( $event: IStarRatingOnClickEvent ) => {
    console.log( 'onClick $event: ', $event );
    this.onClickResult = $event;
    const rating = $event.rating;
    alert(rating);
  }
 

}
