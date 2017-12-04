import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { User, Client, Administrator, Trainer } from '../../../models/user';

@Component( {
    selector: 'app-create-user',
    templateUrl: './create-user.component.html',
    styleUrls: ['./create-user.component.css']
} )
export class CreateUserComponent implements OnInit {

    message =  '';
    createdUser: User = new User( 0, '', '', '', '', '', 'TRAINER' );

    constructor( private backendService: BackendService ) { }

    ngOnInit() {

    }

    addUser() {
        const uri = 'create' + this.createdUser.userType.toLowerCase();
        this.backendService.addUser(uri, this.createdUser).subscribe(res => {
            this.message = res;
        });
    }
}
