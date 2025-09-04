import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './sign-up.html',
  styleUrl: './sign-up.css'
})
export class SignUp {
signupForm:FormGroup=new FormGroup({
     firstName:new FormControl('',[Validators.required]),
     lastName:new FormControl('',[Validators.required]),
     phoneNumber: new FormControl( null,[Validators.required,Validators.min(6000000000),Validators.max(9999999999)]),
     email:new FormControl('',[Validators.required,Validators.pattern("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$")]),
     password:new FormControl('',[Validators.required,Validators.minLength(6)]),
     confirmPassword:new FormControl('',[Validators.required]),
},{validators:this.passwordMismatchValidator()});

passwordMismatchValidator(): ValidatorFn {
  return (formGroup: AbstractControl): ValidationErrors | null => {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    if (!password || !confirmPassword && confirmPassword.minLength==6) {
      return null;
    }
    return password === confirmPassword ? null : { passwordMismatch: true };
  };
}
onCancel(){
this.signupForm.reset();
}
onRegister(){
  const formValues=this.signupForm.value;
 this.signupForm.reset();
}
}                                                                                           