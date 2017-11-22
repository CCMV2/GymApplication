import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

class menuItem {
  url: string;
  text: string;
  active: boolean;
}
@Component({
  selector: 'navigation-pane',
  templateUrl: './navigation-pane.component.html',
  styleUrls: ['./navigation-pane.component.css']
})
export class NavigationPaneComponent implements OnInit {

  urls: menuItem[] = [
    { active: false, url: "roompage", text: "Rooms" },
    { active: false, url: "createworkout", text: "New Workout" },
    { active: false, url: "updatesubscription", text: "Update Subscription" },
    { active: false, url: "updateworkout", text: "Update Workout" },
    { active: false, url: "listworkout", text: "Workouts" },
    { active: false, url: "createsubscription", text: "New Subscription" },
    { active: false, url: "listsubscription", text: "Subscriptions" },
    { active: false, url: "timetable", text: "Timetable" },
    { active: false, url: "newtimetable", text: "New Timetable" },
    { active: false, url: "createuser", text: "New User" },
    { active: false, url: "deleteuser", text: "Delete User" },
    { active: false, url: "updateuser", text: "Update User" }
  ]

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    console.log(this.urls);
  }

  navigate(url: menuItem) {
    for(let i = 0; i < this.urls.length; i++){
      this.urls[i].active = false;
    }
    this.urls[this.urls.indexOf(url)].active = true;
    this.router.navigate(["/" + url.url]);
  }
}
