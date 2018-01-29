import {Workout} from './workout';
import {Trainer} from './user';

export class TrainerWorkout {
    workout: Workout;
    trainers: Trainer[];

    constructor(workout: Workout, trainers: Trainer[]) {
        this.workout = workout;
        this.trainers = trainers;
    }
}