import { Component, OnInit } from '@angular/core';
import { Subscription } from "../../models/subscriptionModel";
import { BackendService } from "../../backend.service";
import { Mail } from "../../models/mail";


@Component( {
    selector: 'app-mailutil',
    templateUrl: './mailutil.component.html',
    styleUrls: ['./mailutil.component.css']
} )
export class MailutilComponent implements OnInit {
    subList: Subscription[];
    constructor( private backendService: BackendService ) { }
    mail = new Mail( '', [], '' );
    ngOnInit() {
        this.getAllSubs();
    }

    getAllSubs() {
        this.backendService.getAllSubscriptionsForUser().subscribe( res => {
            this.subList = res;
        } );
    }
}
