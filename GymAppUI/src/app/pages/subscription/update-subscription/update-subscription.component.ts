import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from "ngx-webstorage";
import {Subscription} from "../../../models/subscriptionModel";
import {Workout} from "../../../models/workout";

@Component({
  selector: 'app-update-subscription',
  templateUrl: './update-subscription.component.html',
  styleUrls: ['./update-subscription.component.css']

})
export class UpdateSubscriptionComponent implements OnInit {
  subscription :Subscription;
  workouts: Workout[];
  constructor(private session:SessionStorageService) { }

  ngOnInit() {
    this.subscription = this.session.retrieve("subscriptionToUpdate");
    this.workouts = this.session.retrieve("workoutsToStore");
  }


}
