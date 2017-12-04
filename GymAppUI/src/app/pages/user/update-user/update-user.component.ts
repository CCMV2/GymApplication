
import { Component, OnInit } from '@angular/core';
import { User, Client, Administrator, Trainer } from '../../../models/user';
import { BackendService } from '../../../backend.service';
import { SessionStorageService } from 'ngx-webstorage';
import { Subscription } from '../../../models/subscriptionModel';

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
        if (this.createdUser.userType === 'CLIENT') {
            const client = this.createdUser as Client;
            client.start = new Date(client.start);
            if (client.start.getMilliseconds() === 0) {
                client.start = new Date();
            }
            if (client.subscription == null) {
                client.subscription = new Subscription('', 0, 0);
            }
            this.createdUser = client;
        }
        this.getAllSubs();
    }

    getAllSubs() {
        this.backendService.getAllSubscriptionsForUser().subscribe( res => {
            this.subscriptionList = res;
        } );
    }

    updateUser() {
        if (this.createdUser.userType === 'CLIENT') {
            const client = this.createdUser as Client;
            client.subscription = this.getSubscription(client.subscription.subscriptionId);
            this.createdUser = client;
        }
        const uri = 'create' + this.createdUser.userType.toLowerCase();
        this.backendService.addUser(uri, this.createdUser).subscribe(res => {
            this.message = res;
        });
    }

    private getSubscription(id: number): Subscription {
        for (const i of this.subscriptionList) {
            if (i.subscriptionId === id) {
                return i;
            }
        }
        return null;
    }

    changeType(type: string) {
        if (type === 'CLIENT') {
            const client = this.createdUser as Client;
            if (client.subscription == null || typeof client.subscription === 'undefined') {
                client.subscription = new Subscription('', 0, 0);
            }
            this.createdUser = client;
        }
    }
}

