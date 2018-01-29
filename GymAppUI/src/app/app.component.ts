import { Component } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';
import {Router, RouterState} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';

  isClosed: boolean = false;

  pageMargin: number = 240;

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  isAdminOrTrainer(): boolean {
      return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
  }

  isUser(): boolean {
    return this.authenticationService.hasRole(['CLIENT']);
  }

  isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  changeMenuState(state: boolean): void {
    if(!state) {
      this.pageMargin = 80;
    } else {
      this.pageMargin = 240;
    }
  }

  login(): void {
    this.router.navigate(["login"]);
  }

}
