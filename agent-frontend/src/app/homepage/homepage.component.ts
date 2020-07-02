import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../model/korisnik';
import { AuthServiceService } from '../services/auth-service.service';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  logged: boolean;
  notLogged: boolean;
  token: string;
  korisnik: Korisnik = new Korisnik();

  constructor(private authService: AuthServiceService, private userService: UserServiceService) { }

  ngOnInit() {
    this.token = this.authService.getJwtToken();
    if (!this.token) {
      this.notLogged = true;
      this.logged = false;
      console.log('Niko nije ulogovan');
    } else {
      this.notLogged = false;
      this.logged = true;
      console.log('Neko je ulogovan');
    }

    this.userService.getLogged(this.authService.getJwtToken()).subscribe(data => {
      console.log('podaci: ' + data);
      this.korisnik = data as Korisnik;
    });
  }

  logOutUser() {
    this.userService.logOut().subscribe(data => window.location.href = '');
    this.authService.removeJwtToken();
    this.notLogged = true;
    this.logged = false;
  }



}
