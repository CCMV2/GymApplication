import {Workout} from './workout';
import {User} from './user';

export class TrainerWorkout {
    workout: Workout;
    trainers: User[];

    constructor(workout: Workout, trainers: User[]){
        this.workout = workout;
        this.trainers = trainers;
    }
}