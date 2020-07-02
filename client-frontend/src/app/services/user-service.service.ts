import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthServiceService } from './auth-service.service';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient, private authService: AuthServiceService) { }

  loginUser(korisnik: Korisnik) {
    return this.http.post('http://localhost:8762/authentication-service/auth/login', korisnik, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  getLogged(token: string) {
    return this.http.post('http://localhost:8762/rentacar-backend/korisnikAuth/userProfile', token, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  logOut() {
    return this.http.get('http://localhost:8762/authentication-service/auth/logout');
  }

  register(korisnik: Korisnik) {
    console.log('Usao u register');
    return this.http.post('http://localhost:8762/rentacar-backend/api/users/registration', korisnik);
  }
}
