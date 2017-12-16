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
  //ratingVal = 3.5;
  //ratingVal = 0;
  constructor(private backendService: BackendService) { }
  
  
  ngOnInit() {
    this.getSubscriptions();
  }
  getSubscriptions(): void{
    this.backendService.getAllSubscriptions().subscribe( res => {
      this.subscriptionsAndWorkouts = res;
      for(let i=0; i<this.subscriptionsAndWorkouts.length; i++){
        this.subscriptionsAndWorkouts[i].subscription.stars = [];
        for(let j=1; j<=this.subscriptionsAndWorkouts[i].subscription.rat.total; j++){
          this.subscriptionsAndWorkouts[i].subscription.stars.push({type:"full", value:j});
          //this.ratingVal = j;
        }
        for(let j= Math.round(this.subscriptionsAndWorkouts[i].subscription.rat.total); j<5; j++){
          this.subscriptionsAndWorkouts[i].subscription.stars.push({type:"empty",value:j});
          //this.ratingVal = j;
        }
      }
      console.log( this.subscriptionsAndWorkouts);
  } );
  }
  sendRating(rating: number, subscription: Subscription): void {
    rating=rating+1;
    let newRating: number = ( (subscription.rat.total * subscription.rat.nrpers) + rating)/(subscription.rat.nrpers+1);
    console.log(newRating);
    subscription.rat.total = newRating;
    subscription.rat.nrpers = subscription.rat.nrpers + 1;
  }
  onClick = ( $event: IStarRatingOnClickEvent ) => {
    console.log( 'onClick $event: ', $event );
    this.onClickResult = $event;
    const rating = $event.rating;
    alert(rating);
  }
 

}
