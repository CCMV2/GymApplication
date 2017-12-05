import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../../pages/demo/services/authentication.service';

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
  selector: 'side-button',
  templateUrl: './side-button.component.html',
  styleUrls: ['./side-button.component.css']
})
export class SideButtonComponent implements OnInit {

  activated: boolean = false;
  @Input("tab") Tab: tab;

  constructor(private route: ActivatedRoute, private router: Router, private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }

  activateButtons(){
    this.activated = !this.activated;
  }

  navigate(url: menuItem) {
    for(let i = 0; i < this.Tab.items.length; i++){
      this.Tab.items[i].active = false;
    }
    this.Tab.items[this.Tab.items.indexOf(url)].active = true;
    this.router.navigate(["/" + url.url]);
  }
}
