import { Subscription } from './subscriptionModel';
import { Timetable } from "./Timetable";

export class User {
    id: number;
    password: string;
    name: string;
    surname: string;
    email: string;
    phonenumber: string;
    userType: string;

    constructor( id: number, password: string, name: string, surname: string, email: string, phonenumber: string, userType: string ) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.userType = userType;
    }

}
export class Trainer extends User {
    completeName: string;
    imageBase64: string;
    constructor( id: number, password: string, name: string, surname: string, email: string, phonenumber: string) {
       super(id, password, name, surname, email, phonenumber, 'TRAINER');
       this.password = password;
    }
}

export class Administrator extends User {
    constructor( id: number, password: string, name: string, surname: string, email: string, phonenumber: string) {
       super(id, password, name, surname, email, phonenumber, 'ADMIN');
    }
}

export class Client extends User {
    cnp: string;
    start: Date;
    subscription: Subscription;
userTimetable: Timetable[];
    constructor( id: number, cnp: string, name: string, surname: string, email: string, phonenumber: string) {
       super(id, cnp, name, surname, email, phonenumber, 'CLIENT');
       this.cnp = cnp;
    }

}
