import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../../backend.service';
import { Timetable } from '../../../models/Timetable';
import * as moment from 'moment';

@Component( {
    selector: 'app-schedule',
    templateUrl: './schedule.component.html',
    styleUrls: ['./schedule.component.css']
} )
export class ScheduleComponent implements OnInit {

    events: any[];
    header: any;
    option: any;
    allTimetables: Timetable[] = [];
    firstStart: Date;

    constructor( private backendService: BackendService ) { }

    ngOnInit() {
        this.getTimetables();
        this.header = {
            left: 'prev,next today',
            center: 'title',
            right: ''
        };
        this.option = {
            firstDay: 1,
            slotLabelFormat: 'HH:mm',
            timeFormat: 'HH:mm'
        };
    }

    loadEvents( event ) {
        const startDate = new Date( event.view.start._i );
        this.prepareEvents( startDate );
        console.log( 'Here we prepare the timetable for a certain week' );
    }
    handleEventClick( event ) {
        const startDate = new Date( event.view.start._i );
        console.log( 'I have been clicked!' );
    }

    prepareEvents( startWeek: Date ) {
        if ( this.allTimetables.length == 0 ) {
            this.firstStart = startWeek;
        }
        // scoatem orele extra
        startWeek = new Date( startWeek.getTime() - startWeek.getHours() * 60 * 60 * 1000 );
        this.events = [];
        for ( const timeTableExample of this.allTimetables ) {
            const event = {};
            // setam titlu
            event['title'] = timeTableExample.workout.workoutType + ' - ' + timeTableExample.trainer.name + ' ' + timeTableExample.trainer.surname;
            // calculam startul in functie de ziua definita (Montag, Dienstag etc) si data de inceput din calendar (care va fi mereu luni)
            let startDayMilliseconds = startWeek.getTime() + this.getDayIndex( timeTableExample.day ) * 24 * 60 * 60 * 1000;
            // setam acum ora si minutele din timetable
            const timeTableStart = new Date( timeTableExample.start );
            startDayMilliseconds += timeTableStart.getHours() * 60 * 60 * 1000 + timeTableStart.getMinutes() * 60 * 1000;
            const startDay = new Date( startDayMilliseconds );
            event['start'] = moment( startDay ).format( 'YYYY-MM-DD[T]HH:mm:ss' );
            // calculam end-ul ca start + duration
            const endDayMilliseconds = startDayMilliseconds + timeTableExample.duration * 60 * 1000;
            const endDay = new Date( endDayMilliseconds );
            event['end'] = moment( endDay ).format( 'YYYY-MM-DD[T]HH:mm:ss' );
            event['intensity'] = timeTableExample.workout.difficulty;
            event['stea'] = timeTableExample.star;
            this.events.push( event );
        }
        debugger;
    }

    getDayIndex( day: string ) {
        switch ( day ) {
            case 'Montag':
                return 0;
            case 'Dienstag':
                return 1;
            case 'Mittwoch':
                return 2;
            case 'Donnerstag':
                return 3;
            case 'Freitag':
                return 4;
            case 'Samstag':
                return 5;
            case 'Sonntag':
                return 6;
        }
    }
    eventRender( event, element, view ) {
        console.log( event, element, view );
        debugger;
        const data = event.start._d;
        // faceti verificarea daca data e in trecut
        console.log( event );
        if ( data.getTime() < new Date().getTime() ) {
            element.addClass( 'intensity-past' );
        }
        else if ( event.intensity == 'HARD' ) {
            element.addClass( 'intensity-hard' );
        }
        else if ( event.intensity == 'MEDIUM' ) {
            element.addClass( 'intensity-medium' );
        }
        else if ( event.intensity == 'EASY' ) {
            element.addClass( 'intensity-easy' );
        }
    }
    getTimetables(): void {
        this.backendService.getAllTimetables().subscribe( res => {
            this.allTimetables = res;
            console.log( this.allTimetables );
            this.prepareEvents( this.firstStart );
        } );
    }
    

}
