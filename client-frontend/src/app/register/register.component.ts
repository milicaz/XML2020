import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../services/user-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { KrajnjiKorisnik } from '../model/krajnji-korisnik';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;

  user: KrajnjiKorisnik = new KrajnjiKorisnik();

  constructor(private formBuilder: FormBuilder, private korisnik: UserServiceService,private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]],
      email: ['', [Validators.required, Validators.email]],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      ulica: ['', Validators.required],
      broj: ['', Validators.required],
      mesto: ['', Validators.required],
      drzava: ['', Validators.required],
    });
  }

  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    console.log("Usao sam u submit")
    this.submitted = true;
    if (this.registerForm.invalid) {
      console.log("Nije validna forma")
      return;
    } else {
      this.korisnik.register(this.user).subscribe(data => {
        this.router.navigate([''], {relativeTo: this.route})
      })
    }
  }
}
