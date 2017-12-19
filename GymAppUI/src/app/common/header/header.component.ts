import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';

@Component( {
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css'],
    encapsulation: ViewEncapsulation.None
} )
export class HeaderComponent implements OnInit {

    loggedInUser: string;
    constructor( private authenticationService: AuthenticationService ) { }

    ngOnInit() {
        this.loggedInUser = this.authenticationService.getCurrentUser();
    }


}
