import { Component, OnInit } from '@angular/core';
import { Timetable } from '../../models/Timetable';
import { BackendService } from '../../backend.service';
import { Router } from "@angular/router";
import { SessionStorageService } from "ngx-webstorage/dist/services";

@Component( {
    selector: 'app-timetable',
    templateUrl: './timetable.component.html',
    styleUrls: ['./timetable.component.css']
} )
export class TimetableComponent implements OnInit {
    allTimetables: Timetable[] = [];

    constructor(private backendService: BackendService, private router: Router,private session: SessionStorageService) { }

    ngOnInit() {
        this.getTimetables();
    }

    addTimetable(timetable: Timetable): void {
        this.backendService.addTimetable(timetable).subscribe(res => {
          console.log(res);
          this.getTimetables();
        });
      }

    deleteTimetable(timetable: Timetable): void {
        this.backendService.deleteTimetable(timetable).subscribe(res => {
          console.log(res);
          this.getTimetables();
        });
      }
    /*
    updateTimetable(timetable: Timetable): void {
        this.backendService.updateTimetable(timetable).subscribe(res => {
          console.log(res);
          this.getTimetables();
        });
      }
      */
    goToUpdatePage(entry: Timetable): void {
        this.session.store('timetableToUpdate', entry);
        this.router.navigateByUrl('/updateTimetable');
      }

    getTimetables(): void {
        this.backendService.getAllTimetables().subscribe( res => {
            this.allTimetables = res;
            console.log( this.allTimetables );
        } );
    }
}
