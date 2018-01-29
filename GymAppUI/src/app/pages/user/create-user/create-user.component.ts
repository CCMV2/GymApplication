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
    trainerImage: string = "";

    constructor( private backendService: BackendService ) { }

    ngOnInit() {

    }

    addUser() {
        if(this.createdUser.userType === "TRAINER") {
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
        }
        else {
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
