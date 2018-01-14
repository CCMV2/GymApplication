import {Component, OnDestroy, OnInit} from '@angular/core';
import {SessionStorageService} from 'ngx-webstorage';
import {Subscription} from '../../../models/subscriptionModel';
import {Workout} from '../../../models/workout';
import { WorkoutList } from '../../../models/workoutlist';
import { BackendService } from '../../../backend.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-update-subscription',
  templateUrl: './update-subscription.component.html',
  styleUrls: ['./update-subscription.component.css']

})
export class UpdateSubscriptionComponent implements OnInit, OnDestroy {
    subscription: Subscription;
    workouts: Workout[];
    workoutList: WorkoutList;
    message = '';
    subscriptionImage = '';

  constructor(private session: SessionStorageService, private backendService: BackendService, private router: Router) { }

  ngOnInit() {
    this.workoutList = this.session.retrieve('workoutlist');
    this.subscription = this.workoutList.subscription;
    this.subscriptionImage = this.subscription.imageBase64;
    //console.log(this.subscriptionImage);
    this.getWorkouts();
  }

  ngOnDestroy() {
    this.session.clear("workoutlist");
  }

  getWorkouts(): void {
    this.backendService.getAllRealWorkouts().subscribe( res => {
      this.workouts = res;
      console.log (this.workouts);
    });
  }
  updateSubscription(): void {
    let newSubscription = new Subscription(this.workoutList.subscription.name, this.workoutList.subscription.price,
      this.workoutList.subscription.duration, this.subscriptionImage);
    newSubscription.subscriptionId = this.workoutList.subscription.subscriptionId;
    let workoutListToUpdate: WorkoutList = new WorkoutList(newSubscription, this.workoutList.workouts);
    this.backendService.addSubscription(workoutListToUpdate).subscribe(res => {

      this.message = res;
      console.log(this.message);
      console.log(this.workoutList);
    });
  }

  upload($event) {
    let preview = document.querySelector('img');
    let file = $event.target.files[0];
    let reader = new FileReader();

    reader.onloadend = (e) => {
      preview.src = reader.result;
      this.subscriptionImage = preview.getAttribute("src");
    }

    if (file) {
      reader.readAsDataURL(file);
    }
  }

}
