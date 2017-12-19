import { Component } from '@angular/core';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private authenticationService: AuthenticationService) { }

  isAdminOrTrainer(): boolean {
      return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
  }

  isUser(): boolean {
    return this.authenticationService.hasRole(['CLIENT']);
  }

}
