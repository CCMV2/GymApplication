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
    trainerToCreate: Trainer = new Trainer(0, '', '', '', '', '');

    constructor( private backendService: BackendService ) { }

    ngOnInit() {

    }

    addUser() {
        const uri = 'create' + this.createdUser.userType.toLowerCase();
        this.backendService.addUser(uri, this.createdUser).subscribe(res => {
            this.message = res;
        });
    }

    upload($event) {
        var preview = document.querySelector('img');
        var file = $event.target.files[0];
        var reader = new FileReader();
    
        reader.onloadend = (e) => {
          preview.src = reader.result;
          this.trainerToCreate.imageBase64 = preview.getAttribute("src");
        }
    
        if (file) {     
          reader.readAsDataURL(file);
        }
      }
}
