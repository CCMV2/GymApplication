export class ClientTimetable {
    client: string;
    timetable: number;
    day: Date;

    constructor(client: string, timetable: number) {
        this.client = client;
        this.timetable = timetable;
    }
}