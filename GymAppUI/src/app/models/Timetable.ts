import { Room } from './room';
import { Workout } from './workout';
import { TrainerWorkout } from './trainer-workout';
import { Trainer } from './user';

export class Timetable {
      id: number;
      day: string;
      start: Date;
      duration: number;
      room: Room;
      workout: Workout;
      roomName: string;
      workoutType: string;
      timeTableName: string;
      trainer: Trainer;


    constructor(day: string, start: Date, duration: number, roomName: string, workoutType: string, trainer: Trainer) {
        this.day = day;
        this.start = start;
        this.duration = duration;
        this.roomName = roomName;
        this.workoutType = workoutType;
        this.trainer = trainer;
    }

    setRoom(room: Room): void {
        this.room = room;
    }
    setWorkout(workout: TrainerWorkout): void {
        this.workout = workout.workout;
    }
}
