import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthServiceService } from './auth-service.service';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient, private auth: AuthServiceService) { }

  loginUser(korisnik: Korisnik) {
    return this.http.post('http://localhost:8762/authentication-service/auth/login', korisnik, {
      headers: this.auth.createAuthorizationTokenHeader()
    });
  }

  getLogged(token: string) {
    return this.http.post('http://localhost:8762/agent-backend/agentAuth/userProfile', token, {
      headers: this.auth.createAuthorizationTokenHeader()
    });
  }

  logOut() {
    return this.http.get('http://localhost:8762/authentication-service/auth/logout');
  }


}
