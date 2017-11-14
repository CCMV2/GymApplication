export class Workout{
  idWorkout: number;
  workoutType: string;
  difficulty: string;
  description: string;

  constructor(idWorkout: number, workoutType: string, difficulty: string, description: string) {
    this.idWorkout = idWorkout;
    this.workoutType = workoutType;
    this.difficulty = difficulty;
    this.description = description;
  }
}
