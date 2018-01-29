import {Subscription} from "./subscriptionModel";
import {Workout} from "./workout";

export class WorkoutList {
  subscription: Subscription;
  workouts: Workout[];

  constructor(subscription: Subscription, workouts: Workout[]) {
    this.subscription = subscription;
    this.workouts = workouts;
  }

  setWorkouts(workouts: Workout []): void{
    this.workouts = workouts;
  }

  setSubscription(subscription: Subscription) : void {
    this.subscription = subscription;
  }
}
