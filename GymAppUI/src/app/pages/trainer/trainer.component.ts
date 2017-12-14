import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../backend.service';
import {Trainer} from '../../models/user';

@Component({
  selector: 'trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {


  trainers: Trainer[];

  constructor(private backendservice:BackendService) { }

  ngOnInit() {
    this.backendservice.getAllTrainers().subscribe(rez=>{
      this.trainers = rez;
      for(let i = 0; i<this.trainers.length; i++) {
        this.trainers[i].stars = [];
        for(let j = 1; j<this.trainers[i].rat.total; j++) {
          this.trainers[i].stars.push({type:"full", value: j});
        }
        for(let j = Math.round(this.trainers[i].rat.total); j<=5; j++) {
          this.trainers[i].stars.push({type:"empty", value: j});
        }
      }
      console.log(this.trainers);
    });
  }

  sendRating(rating: number, trainer: Trainer): void {
    let newRating: number = ( (trainer.rat.total * trainer.rat.nrpers) + rating)/(trainer.rat.nrpers+1);
    console.log(newRating);
    trainer.rat.total = newRating;
    trainer.rat.nrpers = trainer.rat.nrpers + 1;
  }

}
