import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginVerificationService } from '../../Services/LoginVerification/login-verification-service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  userNotFound : boolean = false;
  incorrectPassword : boolean = false;
  loginSuccessful : boolean = false;
  message :string = '';
  error : string ='';
  constructor(private router : Router ,  private loginService : LoginVerificationService){
  }
  signupPage() {
    this.router.navigateByUrl("/careers/send-email-otp");
  }
  forgotPassword() {
  this.router.navigateByUrl("/forgotPassword")
  }
  form : FormGroup = new FormGroup({
    username : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required,Validators.minLength(6)])
  })
  login() {
  const url = `http://localhost:8080/careers/login?email=${this.form.value.username}&password=${this.form.value.password}`;
  this.loginService.loginVerification(url).subscribe({
    next: (message) => {
      console.log(message);
      this.message = message;

      if (this.message == "Login successful") {
        this.loginSuccessful = true;
        this.incorrectPassword = false;
        this.userNotFound = false;
      } else if (this.message == "Login failed") {
        this.incorrectPassword = true;
        this.loginSuccessful = false;
        this.userNotFound = false;
      } else if(this.message == "User not found"){
        this.userNotFound = true;
        this.incorrectPassword = false;
        this.loginSuccessful = false;
      }

      else {
        this.userNotFound = false;
        this.loginSuccessful=false;
        this.incorrectPassword = false;
      }
    },
    error: (error) => {
      console.log(error);
      this.error = error;
    }
  });
}
}
