import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Headers, Http } from '@angular/http';

@Injectable()
export class AuthenticationService {

    private authUrl = 'http://localhost:9123/auth';
    private headers = new Headers( { 'Content-Type': 'application/json' } );

    constructor(private http: Http) { }

    login( username: string, password: string ): Observable<boolean> {
        return this.http.post( this.authUrl, JSON.stringify( { username: username, password: password } ), { headers: this.headers } )
            .map( response => {
                // login successful if there's a jwt token in the response
                const token = response.json() && response.json().token;
                if ( token ) {
                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem( 'currentUser', JSON.stringify( { username: username, token: token, role: response.json().role, start:response.json().start, id:response.json().id} ) );

                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            }
            ).catch(( error: any ) => Observable.throw( error.json().error || 'Server error' ) );
    }

    hasRole(role: string[]): boolean {
        const currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
        const rol = currentUser && currentUser.role;
        return role.indexOf(rol) !== -1;
    }

    getToken(): String {
        const currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
        const token = currentUser && currentUser.token;
        return token ? token : '';
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        localStorage.removeItem( 'currentUser' );
    }

    isLoggedIn(): boolean {
        return this.getToken().length > 0;
    }


    getCurrentUser(): string {
        const currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
        return currentUser && currentUser.username ? currentUser.username : '';
    }

    getStart(): Date {
        const currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
        const start = currentUser && currentUser.start;
        return start ? new Date(start) : new Date();
    }

    getId(): number {
        const currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
        const id = currentUser && currentUser.id;
        return id ? id : 0;
    }

}
