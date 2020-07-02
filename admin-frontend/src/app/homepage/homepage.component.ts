import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';
import { UserServiceService } from '../services/user-service.service';
import { Korisnik } from '../model/korisnik';

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
  korisnici: any;

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

  activateUser(id: number) {
    console.log('activate user with id: ' + id);
    this.userService.activateUser(id).subscribe(data => {
      console.log('korisnik je aktivan');
      for (const kor of this.korisnici) {
        if (kor.id === id) {
          kor.enabled = true;
        }
      }
    });
  }

  blockUser(id: number) {
    console.log('block user with id: ' + id);
    this.userService.blockUser(id).subscribe(data => {
      console.log('korisnik je blokiran');
      for (const kor of this.korisnici) {
        if (kor.id === id) {
          kor.blocked = true;
        }
      }
    });
  }

  deleteUser(id: number) {
    console.log('delete user with id: ' + id);
    this.userService.deleteUser(id).subscribe(data => {
      console.log('korisnik je obrisan');
      for (const kor of this.korisnici) {
        if (kor.id === id) {
          kor.delete = true;
        }
      }
    });
  }

  logOutUser() {
    this.userService.logOut().subscribe(data => window.location.href = '');
    this.authService.removeJwtToken();
    this.notLogged = true;
    this.logged = false;
  }

}
