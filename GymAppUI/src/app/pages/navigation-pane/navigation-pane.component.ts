import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

class menuItem {
  url: string;
  text: string;
  active: boolean;
  usertype: string[];
}

class tab {
  title: string;
  items: menuItem[];
  usertype: string[];
}

@Component({
  selector: 'navigation-pane',
  templateUrl: './navigation-pane.component.html',
  styleUrls: ['./navigation-pane.component.css']
})
export class NavigationPaneComponent implements OnInit {

  @Output() closeState: EventEmitter<boolean> = new EventEmitter<boolean>();

  active: boolean = true;


  tabs: tab[] = [
    {
      title: "User", items: [
        { active: false, url: "createuser", text: "New User" , usertype: ['ADMIN' , 'TRAINER']},
        { active: false, url: "listusers", text: "User List" , usertype: ['ADMIN' , 'TRAINER']}
      ],
      usertype: ['ADMIN','TRAINER']
    },
    {
      title: "Workout", items: [
      { active: false, url: "createworkout", text: "New Workout" , usertype: ['ADMIN','TRAINER']},
      { active: false, url: "listworkout", text: "Workouts" , usertype: ['ADMIN','TRAINER']}
    ],
    usertype: ['ADMIN','TRAINER']
    },
    {
      title: "Subscription", items: [
      { active: false, url: "createsubscription", text: "New Subscription" , usertype: ['ADMIN']},
      { active: false, url: "listsubscription", text: "Subscriptions" , usertype: ['ADMIN']}
    ],
    usertype: ['ADMIN']
    },
    {
      title: "Room", items: [
      { active: false, url: "roompage", text: "Rooms" , usertype: ['ADMIN']}
    ],
    usertype: ['ADMIN']
    },
    {
      title: "Timetable", items: [
      { active: false, url: "newtimetable", text: "New Timetable" , usertype: ['ADMIN','TRAINER']},
      { active: false, url: "timetable", text: "Timetable" , usertype: ['ADMIN','TRAINER']}
    ], usertype: ['ADMIN','TRAINER']
    },
    {
      title: "Trainers", items: [
      { active: false, url: "trainer", text: "Trainers" , usertype: ['ADMIN','TRAINER']}
    ], usertype: ['ADMIN','TRAINER']
    }




    /*
    { active: false, url: "updatesubscription", text: "Update Subscription" },
    { active: false, url: "createsubscription", text: "New Subscription" },
    { active: false, url: "listsubscription", text: "Subscriptions" },
    { active: false, url: "timetable", text: "Timetable" },
    { active: false, url: "newtimetable", text: "New Timetable" }*/

  ]

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  toggleBar(): void {
    this.active = !this.active;
    this.closeState.emit(this.active);
  }

}
