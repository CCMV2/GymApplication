import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user';
import {Router} from '@angular/router';
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  userLists: User[] = [];
   // users: User[] = [];
  constructor(private backendService: BackendService, private router: Router , private session: SessionStorageService) {}

  ngOnInit() { this.getUsers(); }

  getUsers(): void {
    this.backendService.getAllUsers().subscribe( res => {
      this.userLists = res;
     
      console.log( this.userLists );
    } );
  }
  delete(user: User): void {
    const uri = 'delete' + user.userType.toLowerCase();
    this.backendService.deleteUser(uri, user).subscribe(res => {
        console.log(res);
        if (res === 'Successful') {
            const index = this.userLists.findIndex(d => d.id === user.id);
            this.userLists.splice(index, 1);
        }
        alert(res);
    });
  }
  updateUser(entry: User ): void {
    this.session.store('userToUpdate', entry);
    this.router.navigateByUrl('/updateuser');
    
  }
  
  showTimetable(entry: User ): void {
      this.session.store('userToUpdate', entry);
      this.router.navigateByUrl('/usertimetable');
    }
}


