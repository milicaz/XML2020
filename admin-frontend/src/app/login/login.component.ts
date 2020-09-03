import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../model/korisnik';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { AuthServiceService } from '../services/auth-service.service';
import { KorisnikTokenState } from '../model/korisnik-token-state';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  korisnik: Korisnik = new Korisnik();
  htmlString: string;

  constructor(private router: Router, private userService: UserServiceService, private authService: AuthServiceService) { }

  ngOnInit() { }

  loginUser() {
    console.log('Dodavanje username: ' + this.korisnik.username + ' , pass: ' + this.korisnik.password);
    this.userService.loginUser(this.korisnik).subscribe(
      data => {
        this.checkUser(data);
      },
      err => {
        this.handleAuthError(err);
      });

  }

  checkUser(logged) {
    const userToken = logged as KorisnikTokenState;
    if (userToken.accessToken === 'error') {
      console.log('accessToken error');
      this.htmlString = 'Username ili password nije korektan.';
    } else if (userToken.accessToken === 'notActivated') {
      console.log('account active error');
      this.htmlString = 'Vas account nije jos aktiviran.';
    } else {
      console.log('accessToken je:  ' + userToken.accessToken);
      this.authService.setJwtToken(userToken.accessToken);
      this.userService.getLogged(userToken.accessToken).subscribe(
        data => {
          console.log('Podaci: ' + data);
          window.location.href = 'http://localhost:4201/homepage';
        });
    }
  }

  handleAuthError(err: HttpErrorResponse) {
    if (err.status === 404) {
      alert('Unesen username nije validan!');
    }
  }

}
