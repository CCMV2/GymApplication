import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

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

  buttons: MenuCluster[] = [
    {
      label: "Trainer",
      children: [
        {
          label: "Trainer Overview",
          link: "trainer"
        }
      ],
      active: false
    }
  ];

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  navigate(url: MenuButton) {
    this.router.navigate(["/" + url.link]);
  }

  toggleHover(cluster: MenuCluster, state: boolean): void {
    cluster.active = state;
  }
}
