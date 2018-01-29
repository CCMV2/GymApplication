
import {Component, OnDestroy, OnInit} from '@angular/core';
import { User, Client, Administrator, Trainer } from '../../../models/user';
import { BackendService } from '../../../backend.service';
import { SessionStorageService } from 'ngx-webstorage';
import { Subscription } from '../../../models/subscriptionModel';

@Component({
    selector: 'app-update-user',
    templateUrl: './update-user.component.html',
    styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit, OnDestroy {
    createdUser: User;
    message = '';
    trainerImage = '';
    subscriptionList: Subscription[];
    constructor(private backendService: BackendService, private session: SessionStorageService) { }

    ngOnInit() {
        this.createdUser = this.session.retrieve('userToUpdate');
        if (this.createdUser.userType === 'TRAINER') {
            const tempTrainer = this.createdUser as Trainer;
            this.trainerImage = tempTrainer.imageBase64;
        }else
        if (this.createdUser.userType === 'CLIENT') {
            const client = this.createdUser as Client;
            client.start = new Date(client.start);
            if (client.start.getMilliseconds() === 0) {
                client.start = new Date();
            }
            if (client.subscription == null) {
                client.subscription = new Subscription('', 0, 0, '');
            }
            this.createdUser = client;
        }
        this.getAllSubs();
    }

    ngOnDestroy() {
      this.session.clear('userToUpdate');
    }

    getAllSubs() {
        this.backendService.getAllSubscriptionsForUser().subscribe(res => {
            this.subscriptionList = res;
        });
    }

    updateUser() {
        if (this.createdUser.userType === "TRAINER") {
            if (!this.trainerImage) {
                this.trainerImage = '';
            }
            const uri = 'createtrainer';
            this.backendService.addUser(uri, new Trainer(this.createdUser.id, this.createdUser.password,
                this.createdUser.name, this.createdUser.surname, this.createdUser.email, this.createdUser.phonenumber,
                this.trainerImage)).subscribe(res => {
                    this.message = res;
                    setTimeout(()=> {
                        this.message = "";
                        console.log("lol");
                      }, 5000);
                });
        } else {
            if (this.createdUser.userType === 'CLIENT') {
                const client = this.createdUser as Client;
                client.subscription = this.getSubscription(client.subscription.subscriptionId);
                if(client.subscription.imageBase64 == null){
                    client.subscription.imageBase64 = '';
                }
                this.createdUser = client;
            }
            const uri = 'create' + this.createdUser.userType.toLowerCase();
            this.backendService.addUser(uri, this.createdUser).subscribe(res => {
                this.message = res;
                setTimeout(()=> {
                    this.message = "";
                    console.log("lol");
                  }, 5000);
            });
        }
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
                client.subscription = new Subscription('', 0, 0, '');
            }
            this.createdUser = client;
        }
    }

    upload($event) {
        var preview = document.querySelector('img');
        var file = $event.target.files[0];
        var reader = new FileReader();

        reader.onloadend = (e) => {
            preview.src = reader.result;
            this.trainerImage = preview.getAttribute("src");
        }

        if (file) {
            reader.readAsDataURL(file);
        }
    }
}

