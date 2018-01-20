import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Workout } from '../../../models/workout';
import { WorkoutList } from '../../../models/workoutlist';
import { Subscription } from '../../../models/subscriptionModel';
import { Subscribable } from 'rxjs/Observable';
import { IStarRatingOnClickEvent } from 'angular-star-rating/src/star-rating-struct';
import { Rating } from '../../../models/rating';
import { AuthenticationService } from '../../../services/authentication.service';
import { SUBSCRIPTION_IMAGE } from '../../../models/trainer-image';

declare var showPleaseWait: any;
declare var hidePleaseWait: any;
@Component( {
    selector: 'app-subscription-details',
    templateUrl: './subscription-details.component.html',
    styleUrls: ['./subscription-details.component.css']
} )
export class SubscriptionDetailsComponent implements OnInit {
    subscriptionsAndWorkouts: WorkoutList[] = [];
    onClickResult: IStarRatingOnClickEvent;
    //ratingVal = 3.5;
    //ratingVal = 0;

    subscriptionImage: string;
    constructor( private backendService: BackendService, private authenticationService: AuthenticationService ) { }

    isAdminOrTrainer(): boolean {
        return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
    }

    ngOnInit() {
        
        this.getSubscriptions();
        this.subscriptionImage = SUBSCRIPTION_IMAGE.image;
    }
    getSubscriptions(): void {
        showPleaseWait();
        this.backendService.getAllSubscriptions().subscribe( res => {
            this.subscriptionsAndWorkouts = res;
            for ( let i = 0; i < this.subscriptionsAndWorkouts.length; i++ ) {
                this.subscriptionsAndWorkouts[i].subscription.stars = [];
                if ( !this.subscriptionsAndWorkouts[i].subscription.rat ) {
                    this.subscriptionsAndWorkouts[i].subscription.rat = new Rating( null, 0, 0 );
                }
                for ( let j = 1; j <= Math.round(this.subscriptionsAndWorkouts[i].subscription.rat.total); j++ ) {
                    this.subscriptionsAndWorkouts[i].subscription.stars.push( { type: 'full', value: j } );
                    //this.ratingVal = j;
                }
                for ( let j = Math.round( this.subscriptionsAndWorkouts[i].subscription.rat.total ); j < 5; j++ ) {
                    this.subscriptionsAndWorkouts[i].subscription.stars.push( { type: 'empty', value: j + 1 } );
                    //this.ratingVal = j;
                }
            }
            console.log( this.subscriptionsAndWorkouts );
            hidePleaseWait();
        } );
    }
    sendRating( rating: number, subscriptionAndWorkouts: WorkoutList ): void {
        //rating=rating+1;
        if ( this.authenticationService.isLoggedIn() ) {
        const newRating: number = ( ( subscriptionAndWorkouts.subscription.rat.total * subscriptionAndWorkouts.subscription.rat.nrpers ) + rating ) / ( subscriptionAndWorkouts.subscription.rat.nrpers + 1 );
        console.log( newRating );
        if (subscriptionAndWorkouts.subscription.imageBase64 == null) {
            subscriptionAndWorkouts.subscription.imageBase64 = '';
        }
        subscriptionAndWorkouts.subscription.rat.total = newRating;
        subscriptionAndWorkouts.subscription.rat.nrpers = subscriptionAndWorkouts.subscription.rat.nrpers + 1;
        this.backendService.addSubscription( subscriptionAndWorkouts ).subscribe( res => {
            console.log( res );
            this.ngOnInit();
        }
        );
        }
        else
            alert('You are not logged in!');
    }
    onClick = ( $event: IStarRatingOnClickEvent ) => {
            console.log( 'onClick $event: ', $event );
            this.onClickResult = $event;
            const rating = $event.rating;
            alert( rating );
    }



}
