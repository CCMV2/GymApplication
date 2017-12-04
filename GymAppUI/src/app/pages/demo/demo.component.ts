import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { IStarRatingOnClickEvent } from 'angular-star-rating/src/star-rating-struct';


@Component( {
    selector: 'app-demo',
    templateUrl: './demo.component.html',
    styleUrls: ['./demo.component.css'],
    encapsulation: ViewEncapsulation.None
} )
export class DemoComponent implements OnInit {

    onClickResult: IStarRatingOnClickEvent;
    ratingVal = 3.5;

    constructor() { }

    ngOnInit() {
        // get rating from db
    }

    onClick = ( $event: IStarRatingOnClickEvent ) => {
        console.log( 'onClick $event: ', $event );
        this.onClickResult = $event;
        const rating = $event.rating;
        alert(rating);
        // save the rating in the db
    }
}
