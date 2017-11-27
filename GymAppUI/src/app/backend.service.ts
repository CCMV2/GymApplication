import {Headers, Http, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Room} from './models/room';
import {TrainerWorkout} from './models/trainer-workout';
import {Workout} from './models/workout';
import {Subscription} from './models/subscriptionModel';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Injectable } from '@angular/core';
import { User } from './models/user';
import { Timetable } from './models/Timetable';
import { AuthenticationService } from './services/authentication.service';
import { WorkoutList } from './models/workoutlist';

@Injectable()
export class BackendService {
    link = 'http://localhost:9123/';

    private headers = new Headers( {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authenticationService.getToken()
    } );
    private options = new RequestOptions({withCredentials: true, headers: this.headers});

    constructor( private http: Http, private authenticationService: AuthenticationService ) { }

    public getAllUsers(): Observable<User[]> {
        return this.http.get(this.link + 'getallusers', this.options).map( response => response.json() ).catch(this.handleError);
    }

    public addUser( user: User ): Observable<any> {
        return this.http.post(this.link + 'adduser', user, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public deleteUser( user: User ): Observable<any> {
        return this.http.post(this.link + 'deleteuser', user, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public getAllRooms(): Observable<Room[]> {
        return this.http.get(this.link + 'getallrooms', this.options).map( response => response.json() ).catch(this.handleError);
    }

    public addRoom( room: Room ): Observable<any> {
        return this.http.post(this.link + 'addroom', room, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public deleteRoom( room: Room ): Observable<any> {
        return this.http.post(this.link + 'deleteroom', room, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public getAllTimetables(): Observable<Timetable[]> {
        return this.http.get(this.link +'getalltimetables', this.options).map(response => response.json()).catch(this.handleError);
    }

    public addTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link +'addtimetable', timetable, this.options).map(response => response.text()).catch(this.handleError);
    }

    public deleteTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link +'deletetimetable', timetable, this.options).map(response => response.json()).catch(this.handleError);
    }

    public updateTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link + 'updatetimetable', timetable, this.options).map(response => response.text()).catch(this.handleError);
    }

    public addSubscription(subscription: WorkoutList): Observable<any> {
        return this.http.post(this.link + 'createsubscription', subscription, this.options).map(response => response.text()).catch(this.handleError);

    }
    public getAllSubscriptions(): Observable<WorkoutList[]> {
        return this.http.get(this.link + 'listsubscription', this.options).map(response => response.json()).catch(this.handleError);
    }
    public deleteSubscription(subscription: Subscription): Observable<any> {
        return this.http.post(this.link + 'deletesubscription', this.options).map(response => response.json()).catch(this.handleError);
    }

    private handleError( error: any ): Observable<any> {
        console.error( error );
        return error.message || error;
    }

    // public getAllWorkouts(): Observable<Workout[]> {
    //     return this.http.get(this.link +'getallworkouts',this.options).map(response => response.json()).catch(this.handleError)
    // }

    //this actually only returns trainer workouts
    public getAllWorkouts(): Observable<TrainerWorkout[]> {
        return this.http.get(this.link + 'gettrainerworkouts', this.options).map( response => response.json() ).catch(this.handleError);
    }

    // this return the real list of Workouts >:( 
    public getAllRealWorkouts(): Observable<Workout[]> {
        return this.http.get(this.link + 'getallworkouts', this.options).map( response => response.json() ).catch(this.handleError);
    }

    public addWorkout( trainerWorkout: TrainerWorkout ): Observable<any> {
        return this.http.post(this.link + 'addtrainerworkout', trainerWorkout, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public deleteWorkout( workout: Workout ): Observable<any> {
        return this.http.post(this.link + 'deleteworkout', workout, this.options).map( response => response.json() ).catch(this.handleError);
    }

    public getAllTrainers(): Observable<User[]> {
        return this.http.get(this.link + 'getalltrainers', this.options).map( response => response.json() ).catch(this.handleError);
    }


}
