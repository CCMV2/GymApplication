import { Component, OnInit } from '@angular/core';
import { User } from "../../../models/user";
import { BackendService } from "../../../backend.service";
import { SessionStorageService } from 'ngx-webstorage';
import { Subscription } from "../../../models/subscriptionModel";

@Component( {
    selector: 'app-update-user',
    templateUrl: './update-user.component.html',
    styleUrls: ['./update-user.component.css']
} )
export class UpdateUserComponent implements OnInit {
    createdUser: User;
    message = '';

    subscriptionList: Subscription[];
    constructor( private backendService: BackendService, private session: SessionStorageService ) { }

    ngOnInit() {
        this.createdUser = this.session.retrieve( 'userToUpdate' );
        
        this.getAllSubs();
    }

    getAllSubs(){
        this.backendService.getAllSubscriptionsForUser().subscribe( res => {
            this.subscriptionList = res;
        } );
    }
    
    updateUser() {
        debugger;
        this.backendService.addUser( this.createdUser ).subscribe( res => {
            this.message = res;
        } );
    }
}

