import { Component, OnInit } from '@angular/core';
import {User, Trainer, Client} from '../../../models/user';
import {Router} from '@angular/router';
import { BackendService } from '../../../backend.service';
import {SessionStorageService} from 'ngx-webstorage';

declare var showPleaseWait: any;
declare var hidePleaseWait: any;
@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  userLists: User[] = [];
  message = '';
  constructor(private backendService: BackendService, private router: Router , private session: SessionStorageService) {}

  ngOnInit() { this.getUsers(); }

  getUsers(): void {
    showPleaseWait();
    this.backendService.getAllUsers().subscribe( res => {
      this.userLists = res;
     
      console.log( this.userLists );
      hidePleaseWait();
    } );
  }
  delete(user: User): void {
      if(user.userType === 'TRAINER') {
          const trainer = user as Trainer;
          if(!trainer.imageBase64) {
              trainer.imageBase64 = '';
          }
      }
    const uri = 'delete' + user.userType.toLowerCase();
    if(user.userType==="CLIENT"){
        const client= user as Client;
        
        if(client.subscription.imageBase64==null){
            client.subscription.imageBase64="";
        }
    }
    this.backendService.deleteUser(uri, user).subscribe(res => {
        console.log(res);
        if (res === 'Successful') {
            this.message = res;
            const index = this.userLists.findIndex(d => d.id === user.id);
            this.userLists.splice(index, 1);
            setTimeout(()=> {
              this.message = "";
              console.log("lol");
            }, 5000);
        }
        else{
            alert("This user is still being used");
        }
        //alert(res);
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


