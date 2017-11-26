import { Component, OnInit } from '@angular/core';
import { User } from "../../../models/user";
import { BackendService } from "../../../backend.service";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  selectedUser: User;
  allUsers: User[];
  constructor(private backendService: BackendService) {
      
  }

  ngOnInit() {
      this.getAllUsers();
  }
  getAllUsers(){
      this.backendService.getAllUsers();
  }
  
  select(user: User){
      this.selectedUser = user;
  }
  
  delete() {
      console.log("start delete");
      this.backendService.deleteUser(this.selectedUser);
      this.selectedUser = null;
      console.log(this.allUsers);
  }
}

//type script
