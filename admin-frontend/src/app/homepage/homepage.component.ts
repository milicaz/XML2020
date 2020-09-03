import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';
import { UserServiceService } from '../services/user-service.service';
import { Korisnik } from '../model/korisnik';
import { CarServiceService } from '../services/car-service.service';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  show: number; // 0-nista se ne prikazuje,

  logged: boolean;
  notLogged: boolean;
  token: string;
  korisnik: Korisnik = new Korisnik();
  korisnici: any;

  agentForm: FormGroup;
  klasaAutaForm: FormGroup;
  markaAutaForm: FormGroup;
  modelAutaForm: FormGroup;
  tipMenjacaForm: FormGroup;
  vrstaGorivaForm: FormGroup;

  klaseAuta: any;

  constructor(private authService: AuthServiceService, private userService: UserServiceService,
              private carService: CarServiceService, private formBuilder: FormBuilder) { }

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

    this.agentForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
      email: ['', [Validators.required, Validators.email]],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      ulica: ['', Validators.required],
      broj: ['', Validators.required],
      mesto: ['', Validators.required],
      drzava: ['', Validators.required],
      poslovniBroj: ['', [Validators.required, Validators.pattern(/^-?[0-9]{1,10}$/)]],
      nazivFirme: ['', Validators.required]
    });

    this.klasaAutaForm = this.formBuilder.group({
      ime: ['', Validators.required]
    });

    this.markaAutaForm = this.formBuilder.group({
      ime: ['', Validators.required],
      modeli: ['', Validators.required]
    });

    this.modelAutaForm = this.formBuilder.group({
      ime: ['', Validators.required],
      markaAuta: ['', Validators.required]
    });

    this.tipMenjacaForm = this.formBuilder.group({
      ime: ['', Validators.required]
    });

    this.vrstaGorivaForm = this.formBuilder.group({
      ime: ['', Validators.required]
    });
  }

  get f() {
    return this.agentForm.controls;
  }

  get k() {
    return this.klasaAutaForm.controls;
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

  addAgent() {
    this.show = 1;
  }

  onSubmitAgent() {

  }

  loadUsers() {
    console.log('Ucitava korisnike');
    this.userService.getUsers().subscribe(data => {
      this.korisnici = data;
      this.show = 2;
    });
    this.show = 2;
  }

  addKlasaAuta() {
    this.show = 3;
    this.loadKlaseAuta();
  }

  loadKlaseAuta() {
    console.log('Ucitava klase automobila');
    this.carService.getAllKlasaAuta().subscribe(data => {
      this.klaseAuta = data;
    });
  }

  addMarkaAuta() {
    this.show = 4;
  }

  addModelAuta() {
    this.show = 5;
  }

  addTipMenjaca() {
    this.show = 6;
  }

  addVrstaGoriva() {
    this.show = 7;
  }

  loadComments() {
    this.show = 8;
  }

}
