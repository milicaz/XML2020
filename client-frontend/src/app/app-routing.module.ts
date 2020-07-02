import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
    {
        path: '',
        component: HomepageComponent
    },
    {
        path: 'registration',
        component: RegisterComponent
    },
    {
        path: 'login',
        component: LoginComponent
    }


];

@NgModule({
    declarations: [],
    imports: [
        CommonModule, RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
})
export class AppRoutingModule { }
