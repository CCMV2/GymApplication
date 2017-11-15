import {Workout} from './workout';
import {User} from './user';

export class TrainerWorkout {
    workout: Workout;
    trainer: User;

    constructor(workout: Workout, trainer: User){
        this.workout = workout;
        this.trainer = trainer;
    }
}