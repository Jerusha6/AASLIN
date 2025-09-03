import { Routes } from '@angular/router';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
import { Login } from './LoginSignupForms/Components/login/login';

export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login}
];
