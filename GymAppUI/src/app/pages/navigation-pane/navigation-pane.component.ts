import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {style, state, animate, transition, trigger} from '@angular/core';

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
  styleUrls: ['./navigation-pane.component.css'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [   // :enter is alias to 'void => *'
        style({left: -200}),
        animate(500, style({left: 0}))
      ]),
      transition(':leave', [   // :leave is alias to '* => void'
        animate(500, style({left: -200}))
      ])
    ])
  ]
})
export class NavigationPaneComponent {

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
      { active: false, url: "timetable", text: "Timetables" , usertype: ['ADMIN','TRAINER']}
    ], usertype: ['ADMIN','TRAINER']
    },
    {
      title: "Promotion Mails", items: [
      { active: false, url: "sendMail", text: "Send Mail" , usertype: ['ADMIN']}
    ], usertype: ['ADMIN']
    }




    /*
    { active: false, url: "updatesubscription", text: "Update Subscription" },
    { active: false, url: "createsubscription", text: "New Subscription" },
    { active: false, url: "listsubscription", text: "Subscriptions" },
    { active: false, url: "timetable", text: "Timetable" },
    { active: false, url: "newtimetable", text: "New Timetable" }*/

  ]

  constructor(private route: ActivatedRoute, private router: Router) { }

  toggleBar(): void {
    this.active = !this.active;
    this.closeState.emit(this.active);
  }

  navigate(link: string): void {
    this.router.navigate([link]);
  }
}
