import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";

class MenuCluster {
  label: string;
  children: MenuButton[];
  active: boolean = false;
}

class MenuButton {
  label: string;
  link: string;
}

@Component({
  selector: 'user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {

  buttons: MenuButton[] = [
    {
      label: "Home",
      link: "home"
    },
    {
      label: "Trainers",
      link: "trainer"
    },
    {
      label: "Subscriptions",
      link: "subscriptiondetails"
    },
    {
      label: "Schedule",
      link: "schedule"
    },
    {
      label: "Contact",
      link: "contact"
    }
  ];

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }

  navigate(url: MenuButton) {
    this.router.navigate(["/" + url.link]);
  }

  toggleHover(cluster: MenuCluster, state: boolean): void {
    cluster.active = state;
  }

  notLoggedIn(): boolean {
    return !this.authenticationService.isLoggedIn();
  }
}
