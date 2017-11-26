import {Component, OnInit} from '@angular/core';
import {Subscription} from "../../../models/subscriptionModel";
import {WorkoutList} from "../../../models/workoutlist";
import {Workout} from "../../../models/workout";
import {Router} from '@angular/router';
import { BackendService } from "../../../backend.service";
import {SessionStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-list-subscription',
  templateUrl: './list-subscription.component.html',
  styleUrls: ['./list-subscription.component.css']
})
export class ListSubscriptionComponent implements OnInit {

  subscriptionAndWorkouts: WorkoutList[] = [];
  
  subscriptions: Subscription[] = [];
  // test: {[key:string]: string} = {"key":"value"};

  constructor(private backendService: BackendService, private router:Router ,private session:SessionStorageService) {
  }

  ngOnInit() {
    this.getSubscriptionAndWorkouts();
  }

getSubscriptionAndWorkouts(): void {
  this.backendService.getAllSubscriptions().subscribe( res => {
      this.subscriptionAndWorkouts = res;
      console.log( this.subscriptionAndWorkouts );
  } );
}

// getSubscriptions(): void {
//   this.subscriptionAndWork
// }


 // delete(entry: WorkoutList): void{
    //this.backendService.deleteSubscription
     //this.subscriptions.splice(this.subscriptions.indexOf(entry),1);
   //}

  //deleteWorkout(workoutlist,workout): void {
    // this.subscriptions[this.subscriptions.indexOf(workoutlist)].workouts.splice(this.subscriptions[this.subscriptions.indexOf(workoutlist)].workouts.indexOf(workout),1);
  // }
  updateSubscription(entry:WorkoutList):void {
    this.session.store("subscriptionToUpdate",entry.subscription);
    this.session.store("workoutsToStore",entry.workouts);
    this.router.navigateByUrl('/updatesubscription');
  };
 


}


