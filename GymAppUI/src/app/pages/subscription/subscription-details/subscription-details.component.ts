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
        if(!this.subscriptionsAndWorkouts[i].subscription.rat) {
          this.subscriptionsAndWorkouts[i].subscription.rat = new Rating(null,0,0);
        }
        for(let j=1; j<=this.subscriptionsAndWorkouts[i].subscription.rat.total; j++){
          this.subscriptionsAndWorkouts[i].subscription.stars.push({type:"full", value:j});
          //this.ratingVal = j;
        }
        for(let j= Math.round(this.subscriptionsAndWorkouts[i].subscription.rat.total); j<5; j++){
          this.subscriptionsAndWorkouts[i].subscription.stars.push({type:"empty",value:j+1});
          //this.ratingVal = j;
        }
      }
      console.log( this.subscriptionsAndWorkouts);
  } );
  }
  sendRating(rating: number, subscriptionAndWorkouts: WorkoutList): void {
    //rating=rating+1;
    let newRating: number = ( (subscriptionAndWorkouts.subscription.rat.total * subscriptionAndWorkouts.subscription.rat.nrpers) + rating)/(subscriptionAndWorkouts.subscription.rat.nrpers+1);
    console.log(newRating);
    subscriptionAndWorkouts.subscription.rat.total = newRating;
    subscriptionAndWorkouts.subscription.rat.nrpers = subscriptionAndWorkouts.subscription.rat.nrpers + 1;
    this.backendService.addSubscription(subscriptionAndWorkouts).subscribe(res =>{
      console.log(res);
      this.ngOnInit();
    }
    );
    
  }
  onClick = ( $event: IStarRatingOnClickEvent ) => {
    console.log( 'onClick $event: ', $event );
    this.onClickResult = $event;
    const rating = $event.rating;
    alert(rating);
  }
 

}
