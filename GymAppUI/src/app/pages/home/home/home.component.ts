import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthenticationService } from '../../../services/authentication.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  isAdminOrTrainer(): boolean {
    return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
  }

  isUser(): boolean {
    return this.authenticationService.hasRole(['CLIENT']);
  }

  ngOnInit() {
  }

  navigateTo(link: string): void {
    this.router.navigate([link]);
  }
}
