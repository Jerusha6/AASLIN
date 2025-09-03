import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators, ValidationErrors, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-forgot-password-update',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './forgot-password-update.html',
  styleUrl: './forgot-password-update.css'
})
export class ForgotPasswordUpdate {
  form: FormGroup = new FormGroup({
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
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
}