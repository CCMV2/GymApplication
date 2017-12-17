import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../backend.service';
import {Trainer} from '../../models/user';
import {TRAINER_IMAGE} from '../../models/trainer-image';
import {Rating} from '../../models/rating';
import { AuthenticationService } from '../demo/services/authentication.service';

@Component({
  selector: 'trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {


  trainers: Trainer[];

  trainerImage: string;

  constructor(private backendservice: BackendService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.trainerImage = TRAINER_IMAGE.image;
    this.backendservice.getAllTrainers().subscribe(rez=>{
      this.trainers = rez;
      for(let i = 0; i<this.trainers.length; i++) {
        this.trainers[i].stars = [];
        if(!this.trainers[i].rat) {
          this.trainers[i].rat = new Rating(null,0,0);
        }
        for(let j = 1; j<= Math.round(this.trainers[i].rat.total); j++) {
          this.trainers[i].stars.push({type:"full", value: j});
        }
        for(let j = Math.round(this.trainers[i].rat.total); j<5; j++) {
          this.trainers[i].stars.push({type:"empty", value: j+1});
        }
      }
      console.log(this.trainers);
    });
  }



  sendRating(rating: number, trainer: Trainer): void {
      if ( this.authenticationService.isLoggedIn() ) {
    let newRating: number = ( (trainer.rat.total * trainer.rat.nrpers) + rating)/(trainer.rat.nrpers+1);
    console.log(newRating);
    trainer.rat.total = newRating;
    trainer.rat.nrpers = trainer.rat.nrpers + 1;
    const uri = 'create' + trainer.userType.toLowerCase();
    this.backendservice.addUser(uri, trainer).subscribe( res => {
      console.log(res);
      this.ngOnInit();
    } );
    }
    else
        alert('You are not logged in!');
  }

}
