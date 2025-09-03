import { Routes } from '@angular/router';
import { Login } from './LoginSignupForms/Components/login/login';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login}
];
