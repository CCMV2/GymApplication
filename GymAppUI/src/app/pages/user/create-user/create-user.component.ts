import { Component, OnInit } from '@angular/core';
import { BackendService } from "../../../backend.service";
import { User } from "../../../models/user";

@Component( {
    selector: 'app-create-user',
    templateUrl: './create-user.component.html',
    styleUrls: ['./create-user.component.css']
} )
export class CreateUserComponent implements OnInit {

    createdUserName: string="";
    createdUserSurname: string="";
    createdUserEmail: string="";
    createdUserPassword: string="";
    createdUserPhoneNumber: int="";
    createduserPermission:sting="";
    
    constructor(private backendService: BackendService) { }

    ngOnInit() {
        this.getAllUsers();
    }
    
    addUser(){
// tslint:disable-next-line:prefer-const
        let createdUser: User = new User(0,this.createdUserPassword,this.createdUserName,this.createdUserSurname,this.createdUserEmail,this.createdUserPhoneNumber,this.createduserPermission);
        this.backendService.addUser(createdUser);
    }
    
    getAllUsers(){
        this.backendService.getAllUsers();
    }

}
