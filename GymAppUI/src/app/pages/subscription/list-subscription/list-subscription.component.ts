import {Component, OnInit} from '@angular/core';
import {Subscription} from "../../../models/subscriptionModel";
import {WorkoutList} from "../../../models/workoutlist";
import {Workout} from "../../../models/workout";
import {Router} from '@angular/router';
import {SessionStorageService} from "ngx-webstorage";

@Component({
  selector: 'app-list-subscription',
  templateUrl: './list-subscription.component.html',
  styleUrls: ['./list-subscription.component.css']
})
export class ListSubscriptionComponent implements OnInit {

  subscriptions: WorkoutList[] = [
    new WorkoutList(new Subscription( "Test1", 100, new Date(2017, 11, 3), 10), [new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description")]),
    new WorkoutList(new Subscription( "Test2", 100, new Date(2017, 11, 3), 10), [new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description")]),
    new WorkoutList(new Subscription( "Test3", 100, new Date(2017, 11, 3), 10), [new Workout(1,"TestType","Very Hard","Test Description")]),
    new WorkoutList(new Subscription( "Test4", 100, new Date(2017, 11, 3), 10), [new Workout(1,"TestType","Very Hard","Test Description")]),
    new WorkoutList(new Subscription( "Test5", 100, new Date(2017, 11, 3), 10), [new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description"),new Workout(1,"TestType","Very Hard","Test Description")])
  ];

  test: {[key:string]: string} = {"key":"value"};

  constructor(private router:Router,private session:SessionStorageService) {
  }

  ngOnInit() {
  }

  delete(entry: WorkoutList): void{
    this.subscriptions.splice(this.subscriptions.indexOf(entry),1);
  }

  deleteWorkout(workoutlist,workout): void {
    this.subscriptions[this.subscriptions.indexOf(workoutlist)].workouts.splice(this.subscriptions[this.subscriptions.indexOf(workoutlist)].workouts.indexOf(workout),1);
  }
  updateSubscription(entry:WorkoutList):void {
    this.session.store("subscriptionToUpdate",entry.subscription);
    this.session.store("workoutsToStore",entry.workouts);
    this.router.navigateByUrl('/updatesubscription');
  };
 


}


