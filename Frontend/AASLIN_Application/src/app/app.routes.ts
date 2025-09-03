import { Routes } from '@angular/router';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
import { Login } from './LoginSignupForms/Components/login/login';
<<<<<<< HEAD
import { ForgotPasswordUpdate } from './LoginSignupForms/Components/forgot-password-update/forgot-password-update';
export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login},
    {path:'UpdateForgotPassword', component:ForgotPasswordUpdate}
];
=======
import { ForgotPassword } from './LoginSignupForms/Components/forgot-password/forgot-password';

export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login},
    {path:'forgotPassword', component:ForgotPassword}
];
>>>>>>> d2e5d0e0b4fa7ff60416281106207d2c18bc585c
