import { Subscription } from "./subscriptionModel";

export class User {
    id: number;
    password: string;
    name: string;
    surname: string;
    email: string;
    phonenumber: string;
    userType: string;
     start: Date;
subscription: Subscription;

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
