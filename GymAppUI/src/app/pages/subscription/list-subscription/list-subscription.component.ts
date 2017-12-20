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


  delete(sub:Subscription):void{
    this.backendService.deleteSubscription(sub).subscribe( res => {
      //this.getSubscriptionAndWorkouts();
      console.log( this.subscriptionAndWorkouts );
      if (res === 'Successful') {
        const index = this.subscriptionAndWorkouts.findIndex(d => d.subscription.subscriptionId === sub.subscriptionId);
        this.subscriptionAndWorkouts.splice(index, 1);
    }
    alert(res);
  } );
  }

  
  updateSubscription(entry:WorkoutList):void {
      // de ce nu ati trimis direct un workoutlist?
    this.session.store('workoutlist', entry);
    this.router.navigateByUrl('/updatesubscription');
  }


}


