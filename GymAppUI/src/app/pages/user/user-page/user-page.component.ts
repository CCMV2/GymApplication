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
      debugger;
      console.log( this.userLists );
    } );
  }
  delete(sub: User): void{
    this.backendService.deleteUser(sub);
  }
  updateUser(entry: User ): void {
    this.session.store('userToUpdate', entry.id);
    this.router.navigateByUrl('/updatesubscription');
  }
}


