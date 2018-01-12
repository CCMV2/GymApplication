import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component( {
    selector: 'app-login-page',
    templateUrl: './login-page.component.html',
    styleUrls: ['./login-page.component.css']
} )
export class LoginPageComponent implements OnInit {

    loading = false;
    error = '';
    success = '';
    model: any = {};
    returnUrl: string;

    constructor(
            private route: ActivatedRoute,
            private router: Router,
            private authenticationService: AuthenticationService ) { }

    ngOnInit() {
        this.authenticationService.logout();
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
        this.authenticationService.logout();
        const succsess = this.route.snapshot.queryParams['logout'] && this.route.snapshot.queryParams['logout'].length > 0;
        this.success = succsess ? 'You have been succesfully logged out' : '';
        setTimeout( () => {
          this.success = "";
        }, 5000);
        const error = this.route.snapshot.queryParams['error'] && this.route.snapshot.queryParams['error'].length > 0;
        this.error = error ? 'Session expired. Please log in again.' : '';
        setTimeout( () => {
        this.error = "";
        }, 5000);
    }

    login() {
        console.log('triggered login');
        this.loading = true;
        this.authenticationService.login( this.model.username, this.model.password )
            .subscribe( result => {
                if ( result === true ) {
                    // login successful
                    this.router.navigateByUrl(this.returnUrl);
                } else {
                    // login failed
                    this.error = 'Username or password is incorrect';
                  setTimeout( () => {
                    this.error = "";
                  }, 5000);
                    this.loading = false;
                }
            }, error => {
                this.loading = false;
                this.error = 'Username or password is incorrect';
              setTimeout( () => {
                this.error = "";
              }, 5000);
            } );
    }

}
