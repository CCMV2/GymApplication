import { Component, OnInit } from '@angular/core';
import { Timetable } from '../../models/Timetable';
import { BackendService } from '../../backend.service';
import { Router } from "@angular/router";
import { SessionStorageService } from "ngx-webstorage/dist/services";

declare var showPleaseWait: any;
declare var hidePleaseWait: any;
@Component( {
    selector: 'app-timetable',
    templateUrl: './timetable.component.html',
    styleUrls: ['./timetable.component.css']
} )
export class TimetableComponent implements OnInit {
    allTimetables: Timetable[] = [];
    message = '';
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
        if(timetable.trainer.imageBase64== null){
            timetable.trainer.imageBase64 = '';
        }
        this.backendService.deleteTimetable(timetable).subscribe(res => {
            if(res === 'Successful'){
                this.message = 'Successful';
                const index = this.allTimetables.findIndex(d => d.id === timetable.id);
                this.allTimetables.splice(index, 1);
                setTimeout(()=> {
                this.message = "";
                console.log("lol");
                }, 5000);
              console.log(res);
            }
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
        showPleaseWait();
        this.backendService.getAllTimetables().subscribe( res => {
            this.allTimetables = res;
            console.log( this.allTimetables );
        hidePleaseWait();
        } );
        
    }
}
