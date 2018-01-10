// import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Workout } from '../../../models/workout';
import { WorkoutList } from '../../../models/workoutlist';
import { Subscription } from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';


import 'rxjs/add/operator/switchMap';
import { Component, OnInit, ElementRef } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';
import { Response, Http } from '@angular/http';


@Component({
  selector: 'app-create-subscription',
  templateUrl: './create-subscription.component.html',
  styleUrls: ['./create-subscription.component.css']
})
export class CreateSubscriptionComponent implements OnInit {

  workouts: Workout[] = [];
  message = '';
  private uploadUrl = 'http://localhost:4200/createsubscription';


  subscriptionToCreate: Subscription = new Subscription('', 0, 0, '');
  workoutList: WorkoutList = new WorkoutList(this.subscriptionToCreate, null);
 // subscriptionImage: String = "";
  constructor(private backendService: BackendService, private http: Http, private el: ElementRef) { }

  ngOnInit() {
    this.getWorkouts();

  }

  getWorkouts(): void {
    this.backendService.getAllRealWorkouts().subscribe(res => {
      this.workouts = res;
      console.log(this.workouts);
    });
  }

  addSubscription(): void {
   // this.workoutList.subscription.imageBase64 = this.subscriptionImage;
    this.backendService.addSubscription(this.workoutList).subscribe(res => {

      this.message = res;
    });
  }



  upload($event) {
    let preview = document.querySelector('img');
    let file = $event.target.files[0];
    let reader = new FileReader();

    reader.onloadend = (e) => {
      preview.src = reader.result;
      this.workoutList.subscription.imageBase64 = preview.getAttribute("src");
    }

    if (file) {
      reader.readAsDataURL(file);
    }
  }

  handleError(): void {
    alert('eroare');
  }

  informUser(res: Response): void {
    alert('image ' + res.text() + ' successfully uploaded');
  }
}
