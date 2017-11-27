import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../../backend.service";
import { User } from "../../../models/user";

@Component( {
    selector: 'app-create-user',
    templateUrl: './create-user.component.html',
    styleUrls: ['./create-user.component.css']
} )
export class CreateUserComponent implements OnInit {
    
    message =  '';
    createdUser: User = new User( 0, '', '', '', '', '', '' );

    constructor( private backendService: BackendService ) { }

    ngOnInit() {

    }

    addUser() {
        //tslint:disable-next-line:prefer-const
        
        this.backendService.addUser( this.createdUser ).subscribe(res => {
            this.message = res;
        });
    }



}