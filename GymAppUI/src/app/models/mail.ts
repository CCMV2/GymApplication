import { Subscription } from "./subscriptionModel";

export class Mail {
    subject: string;
    subs: Subscription[];
    body: string;


    constructor( subject: string, subs: Subscription[], body: string ) {
        this.subject = subject;
        this.subs = subs;
        this.body = body;
    }
}