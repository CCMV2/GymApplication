import { Headers, Http, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Room } from './models/room';
import { TrainerWorkout } from './models/trainer-workout';
import { Workout } from './models/workout';
import { Subscription } from './models/subscriptionModel';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Injectable } from '@angular/core';
import { User, Trainer } from './models/user';
import { Timetable } from './models/Timetable';
import { WorkoutList } from './models/workoutlist';
import { AuthenticationService } from './services/authentication.service';
import { Router } from '@angular/router';
import { ClientTimetable } from './models/client-timetable';
import { Mail } from "./models/mail";

@Injectable()
export class BackendService {
    link = 'http://localhost:9123/';

    private headers = new Headers({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.authenticationService.getToken()
    });
    private options = new RequestOptions({ withCredentials: true, headers: this.headers });

    constructor(private http: Http, private authenticationService: AuthenticationService,
        private router: Router) { }

    public getAllUsers(): Observable<User[]> {
        return this.http.get(this.link + 'listusers', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public addUser(uri: string, user: User): Observable<any> {
        return this.http.post(this.link + uri, user, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    public deleteUser(uri: string, user: User): Observable<any> {
        return this.http.post(this.link + uri, user, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    public getAllRooms(): Observable<Room[]> {
        return this.http.get(this.link + 'getallrooms', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public addRoom(room: Room): Observable<any> {
        return this.http.post(this.link + 'addroom', room, this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public deleteRoom(room: Room): Observable<any> {
        return this.http.post(this.link + 'deleteroom', room, this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public getAllTimetables(): Observable<Timetable[]> {
        return this.http.get(this.link + 'getalltimetables', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public addTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link + 'addtimetable', timetable, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    public deleteTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link + 'deletetimetable', timetable, this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public updateTimetable(timetable: Timetable): Observable<any> {
        return this.http.post(this.link + 'addtimetable', timetable, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    public addSubscription(subscription: WorkoutList): Observable<any> {
        return this.http.post(this.link + 'createsubscription', subscription, this.options).map(response => response.text()).catch(err => this.handleError(err));

    }
    public getAllSubscriptions(): Observable<WorkoutList[]> {
        return this.http.get(this.link + 'listsubscription', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public getAllSubscriptionsForUser(): Observable<Subscription[]> {

        return this.http.get(this.link + 'listsubscriptions', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }
    public deleteSubscription(subscription: Subscription): Observable<any> {
        return this.http.post(this.link + 'deletesubscription', subscription, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    private handleError(error: any): Observable<any> {
        if (error.type === 3) {
            // nu avem drepturi sa intram pe pagina asta, sau ne-a expirat tokenul din BE
            if (this.authenticationService.isLoggedIn()) {
                // ne-a expirat tokenul
                this.router.navigate(['/login'], { queryParams: { returnUrl: this.router.routerState.snapshot.url, error: 'true' } });
            } else {
                // nu avem acces, ne intoarcem pe homepage
                this.router.navigate(['/']);
            }

        }
        return error.message || error;
    }

    //this actually only returns trainer workouts
    public getAllWorkouts(): Observable<TrainerWorkout[]> {
        return this.http.get(this.link + 'gettrainerworkouts', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    // this return the real list of Workouts >:(
    public getAllRealWorkouts(): Observable<Workout[]> {
        return this.http.get(this.link + 'getallworkouts', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public addWorkout(trainerWorkout: TrainerWorkout): Observable<any> {
        return this.http.post(this.link + 'addworkouttrainers', trainerWorkout, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }

    public deleteWorkout(workout: Workout): Observable<any> {
        return this.http.post(this.link + 'deleteworkout', workout, this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public getAllTrainers(): Observable<Trainer[]> {
        return this.http.get(this.link + 'getalltrainers', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public getUserTimetables(userName: string): Observable<Timetable[]> {
        return this.http.post(this.link + 'getusertimetables', userName , this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public getAllTrainersForWorkout(workout: Workout) {
        return this.http.get(this.link + 'getalluserworkoutsbyworkout', this.options).map(response => response.json()).catch(err => this.handleError(err));
    }

    public addClientTimetable(clientTimetable: ClientTimetable) {
        return this.http.post(this.link + 'addclienttimetable', clientTimetable, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }
    
    public sendMail(mailUtil: Mail) {
        return this.http.post(this.link + 'mailSender', mailUtil, this.options).map(response => response.text()).catch(err => this.handleError(err));
    }
}
