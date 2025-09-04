import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators, ValidationErrors, AbstractControl, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password-update',
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './forgot-password-update.html',
  styleUrl: './forgot-password-update.css'
})
export class ForgotPasswordUpdate {
  constructor (private router : Router){

  }
  form: FormGroup = new FormGroup({
    password: new FormControl('', [Validators.required, Validators.minLength(6),Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$")]),
    confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
  }, { validators: this.passwordsMatchValidator });
  passwordsMismatch: boolean = false;
  passwordsMatchValidator(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;

    if (password !== confirmPassword) {
      return { passwordsMismatch: true };
    }
    return null;
  }
  login() {
    this.router.navigateByUrl("/login");
  }
}