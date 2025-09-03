import { Routes } from '@angular/router';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
import { Login } from './LoginSignupForms/Components/login/login';
import { ForgotPasswordUpdate } from './LoginSignupForms/Components/forgot-password-update/forgot-password-update';
import { ForgotPassword } from './LoginSignupForms/Components/forgot-password/forgot-password';
export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login},
    {path:'UpdateForgotPassword', component:ForgotPasswordUpdate},
    {path:'forgotPassword', component:ForgotPassword}
];
