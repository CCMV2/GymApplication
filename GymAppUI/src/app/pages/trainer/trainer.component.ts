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
    });
  }

}
