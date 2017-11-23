import { Component, OnInit } from '@angular/core';
import { Timetable } from '../models/Timetable';
import { BackendService } from '../backend.service';
import { Router } from "@angular/router";

@Component( {
    selector: 'app-timetable',
    templateUrl: './timetable.component.html',
    styleUrls: ['./timetable.component.css']
} )
export class TimetableComponent implements OnInit {
    allTimetables: Timetable[] = [];

    constructor(private backendService: BackendService, private router: Router) { }

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
    goToUpdatePage(id: number): void {
        this.router.navigate(['/updateTimetable'], { queryParams: { id: id }});
      }//de facut pagina

    getTimetables(): void {
        this.backendService.getAllTimetables().subscribe( res => {
            this.allTimetables = res;
            console.log( this.allTimetables );
        } );
    }
}
