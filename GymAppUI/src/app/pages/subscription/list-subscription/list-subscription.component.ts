import {Component, OnInit} from '@angular/core';
import {Subscription} from "../../../models/subscriptionModel";
import {WorkoutList} from "../../../models/workoutlist";
import {Workout} from "../../../models/workout";
import {Router} from '@angular/router';
import { BackendService } from "../../../backend.service";
import {SessionStorageService} from "ngx-webstorage";

declare var showPleaseWait: any;
declare var hidePleaseWait: any;
@Component({
  selector: 'app-list-subscription',
  templateUrl: './list-subscription.component.html',
  styleUrls: ['./list-subscription.component.css']
})
export class ListSubscriptionComponent implements OnInit {

  subscriptionAndWorkouts: WorkoutList[] = [];
  message = '';
  subscriptions: Subscription[] = [];
  // test: {[key:string]: string} = {"key":"value"};

  constructor(private backendService: BackendService, private router:Router ,private session:SessionStorageService) {
  }

  ngOnInit() {
    this.getSubscriptionAndWorkouts();
  
  }

getSubscriptionAndWorkouts(): void {
  showPleaseWait();
  this.backendService.getAllSubscriptions().subscribe( res => {
      this.subscriptionAndWorkouts = res;
      console.log( this.subscriptionAndWorkouts );
  hidePleaseWait();
  } );
}


  delete(sub:Subscription):void{
      if(sub.imageBase64 == null){
          sub.imageBase64="";
      }
    this.backendService.deleteSubscription(sub).subscribe( res => {
      //this.getSubscriptionAndWorkouts();
      console.log( this.subscriptionAndWorkouts );
      if (res === 'Successful') {
        this.message = res;
        const index = this.subscriptionAndWorkouts.findIndex(d => d.subscription.subscriptionId === sub.subscriptionId);
        this.subscriptionAndWorkouts.splice(index, 1);
        setTimeout(()=> {
          this.message = "";
          console.log("lol");
        }, 5000);
        
        
    } else {
        alert('The subscription you are about to delete is still being used');
    }
    
   // alert(res);
  } );
  }

  
  updateSubscription(entry:WorkoutList):void {
      // de ce nu ati trimis direct un workoutlist?
    this.session.store('workoutlist', entry);
    this.router.navigateByUrl('/updatesubscription');
  }


}


