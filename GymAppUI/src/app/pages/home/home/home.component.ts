import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthenticationService } from '../../../services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService) { }

  isAdminOrTrainer(): boolean {
    return this.authenticationService.hasRole(['ADMIN', 'TRAINER']);
  }

  isUser(): boolean {
    return this.authenticationService.hasRole(['CLIENT']);
  }

  ngOnInit() {
  }

}
