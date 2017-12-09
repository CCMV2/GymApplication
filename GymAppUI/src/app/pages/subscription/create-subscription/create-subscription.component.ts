// import { Component, OnInit } from '@angular/core';
import {BackendService} from '../../../backend.service';
import {Workout} from '../../../models/workout';
import {WorkoutList} from '../../../models/workoutlist';
import {Subscription} from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';


import 'rxjs/add/operator/switchMap';
import { Component, OnInit,ElementRef }        from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';
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
 

  subscriptionToCreate: Subscription = new Subscription ('', 0, 0,'');
  workoutList : WorkoutList = new WorkoutList(this.subscriptionToCreate, null);

  constructor(private backendService: BackendService, private http: Http,   private el: ElementRef) { }

  ngOnInit() {
    this.getWorkouts();

  }

  getWorkouts(): void {
    this.backendService.getAllRealWorkouts().subscribe( res => {
      this.workouts = res;
      console.log (this.workouts);
    });
  }

  addSubscription(): void {
    this.backendService.addSubscription(this.workoutList).subscribe(res => {
      this.message = res;
    });
  }


  
  upload() {
    let inputEl: HTMLInputElement = this.el.nativeElement.querySelector('#photo');
    let fileCount: number = inputEl.files.length;
    let formData = new FormData();
    if (fileCount > 0) { // a file was selected
        formData.append('photo', inputEl.files.item(0));
        this.http.post(this.uploadUrl, formData)
        .toPromise().then(this.informUser).catch(this.handleError);
      }
   }

   handleError(): void {
    alert('eroare');
  }

  informUser(res: Response): void {
    alert('image ' + res.text() + ' successfully uploaded');
  }
}
