import { Component, OnInit } from '@angular/core';
import { Trainer } from '../../../models/user';
import { BackendService } from '../../../backend.service';
import { TrainerWorkout } from '../../../models/trainer-workout';
import { Workout } from '../../../models/workout';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  trainerWorkouts: TrainerWorkout = new TrainerWorkout(new Workout(0, '', '', ''), []);

  trainerList: Trainer[] = [];

  message = '';

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.getAllTrainers();
  }

  addWorkout() {
    this.backendService.addWorkout(this.trainerWorkouts).subscribe(res => {
      console.log(res);
      this.message = res;
    }
    );
  }

  getAllTrainers() {
    this.backendService.getAllTrainers().subscribe(res => {
        this.trainerList = res;
        for ( let trainer of this.trainerList ) {
            if ( trainer.imageBase64 == null ) {
                trainer.imageBase64 = '';
            }
        }
        for (let trainer of this.trainerList) {
            trainer.completeName = trainer.name + ' ' + trainer.surname;
        }
        this.trainerWorkouts.trainers[0] = this.trainerList[0];//asta alege un default trainer dupa ce s-au incarcat din server trainerii
    });
  }

}
