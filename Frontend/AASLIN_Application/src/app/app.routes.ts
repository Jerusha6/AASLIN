import { Routes } from '@angular/router';
import { SignUp } from './LoginSignupForms/Components/sign-up/sign-up';
import { Login } from './LoginSignupForms/Components/login/login';
import { ForgotPasswordUpdate } from './LoginSignupForms/Components/forgot-password-update/forgot-password-update';
import { ForgotPassword } from './LoginSignupForms/Components/forgot-password/forgot-password';
<<<<<<< HEAD
import { CareersFirstPage } from './CarreersPage/careers-first-page/careers-first-page';
=======
import { Register } from './Registration/Components/register/register';
>>>>>>> b51c72a9d8893be1b1e244d25231ec3ab7ce601f
export const routes: Routes = [
    {path:'signup',component:SignUp},
    {path:'login', component:Login},
    {path:'UpdateForgotPassword', component:ForgotPasswordUpdate},
    {path:'forgotPassword', component:ForgotPassword},
<<<<<<< HEAD
    {path:'careersPage', component:CareersFirstPage}
=======
    {path:'register', component:Register}
>>>>>>> b51c72a9d8893be1b1e244d25231ec3ab7ce601f
];
