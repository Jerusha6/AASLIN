import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
form : FormGroup = new FormGroup({
    username : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required,Validators.minLength(6)])
  })
}