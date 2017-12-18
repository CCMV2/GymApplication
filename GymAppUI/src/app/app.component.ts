import { Component } from '@angular/core';
import { AuthenticationService } from './pages/demo/services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private authenticationService: AuthenticationService) { }

  isAdmin(): boolean {
    return false;
    // return this.authenticationService.hasRole(["ADMIN"]);
  }

  isUser(): boolean {
    return true;
    // return this.authenticationService.hasRole(["USER"]);
  }

  isTrainer(): boolean {
    return this.authenticationService.hasRole(["TRAINER"]);
  }
}
