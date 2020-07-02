import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthServiceService } from './auth-service.service';
import { Korisnik } from '../model/korisnik';
import { Agent } from '../model/agent';

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

  addAgent(agent: Agent) {
    console.log('Usao u addAgent');
    return this.http.post('http://localhost:8762/rentacar-backend/api/users/addAgent', agent, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  getUsers() {
    console.log('Usao u getUsers');
    return this.http.get('http://localhost:8762/rentacar-backend/api/users/getUsers', {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  activateUser(id: number) {
    console.log('Usao u activateUser');
    return this.http.put('http://localhost:8762/rentacar-backend/api/users/activateUser', id, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  blockUser(id: number) {
    console.log('Usao u blockUser');
    return this.http.put('http://localhost:8762/rentacar-backend/api/users/blockUser', id, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }

  deleteUser(id: number) {
    console.log('Usao u getUsers');
    return this.http.put('http://localhost:8762/rentacar-backend/api/users/deleteUser', id, {
      headers: this.authService.createAuthorizationTokenHeader()
    });
  }
}
