import { Client } from './user';
import { Timetable } from './Timetable';
   

export class ClientTimetable {
    client: Client;
    timetable: Timetable;
    day: Date;
    id: number;

    constructor(client: Client, timetable: Timetable) {
        this.client = client;
        this.timetable = timetable;
        this.day = new Date();
    }
}