import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

class menuItem {
  url: string;
  text: string;
  active: boolean;
}

class tab {
  title: string;
  items: menuItem[];
}

@Component({
  selector: 'navigation-pane',
  templateUrl: './navigation-pane.component.html',
  styleUrls: ['./navigation-pane.component.css']
})
export class NavigationPaneComponent implements OnInit {

  active: boolean = true;

  tabs: tab[] = [
    {
      title: "User", items: [
        { active: false, url: "createuser", text: "New User" },
        { active: false, url: "listusers", text: "User List" }
      ]
    },
    {
      title: "Workout", items: [
      { active: false, url: "createworkout", text: "New Workout" },
      { active: false, url: "listworkout", text: "Workouts" }
    ]
    },
    {
      title: "Subscription", items: [
      { active: false, url: "createsubscription", text: "New Subscription" },
      { active: false, url: "listsubscription", text: "Subscriptions" }
    ]
    },
    {
      title: "Room", items: [
      { active: false, url: "roompage", text: "Rooms" }
    ]
    },
    {
      title: "Timetable", items: [
      { active: false, url: "newtimetable", text: "New Timetable" },
      { active: false, url: "timetable", text: "Timetable" }
    ]
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
  }

}
