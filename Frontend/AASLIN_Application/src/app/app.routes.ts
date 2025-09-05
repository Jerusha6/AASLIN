import { Routes } from '@angular/router';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
import { Login } from './LoginSignupForms/Components/login/login';
import { ForgotPasswordUpdate } from './LoginSignupForms/Components/forgot-password-update/forgot-password-update';
import { ForgotPassword } from './LoginSignupForms/Components/forgot-password/forgot-password';
import { CareersFirstPage } from './CarreersPage/careers-first-page/careers-first-page';
import { Register } from './Registration/Components/register/register';
import { EmailVerification } from './LoginSignupForms/Components/email-verification/email-verification';
export const routes: Routes = [
    {path:'careers/register',component:SignUp},
    {path:'careers/login', component:Login},
    {path:'UpdateForgotPassword', component:ForgotPasswordUpdate},
    {path:'forgotPassword', component:ForgotPassword},
    {path:'careersPage', component:CareersFirstPage},
    {path:'registEer', component:Register},
    {path:'careers/send-email-otp',component:EmailVerification}
];

