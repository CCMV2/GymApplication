import {Headers,Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Room} from "./models/room";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'
import { Injectable } from '@angular/core';

@Injectable()
export class BackendService {

    private headers: Headers;

    constructor(private http: Http){}

    public getAllRooms(): Observable<Room[]> {
        return this.http.get("http://localhost:9123/getallrooms",{headers: this.headers}).map(response => response.json()).catch(this.handleError)
    }

    public addRoom(room: Room): Observable<any> {
        return this.http.post("http://localhost:9123/addroom",room,{headers: this.headers}).map(response => response.json()).catch(this.handleError)
    }

    public deleteRoom(room: Room): Observable<any> {
        return this.http.post("http://localhost:9123/deleteroom",room,{headers: this.headers}).map(response => response.json()).catch(this.handleError)
    }

    private handleError(error: any): Observable<any>{
        console.error(error);
        return error.message || error;
    }

}