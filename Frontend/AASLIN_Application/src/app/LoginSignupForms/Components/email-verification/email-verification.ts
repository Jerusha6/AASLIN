import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { EmailService } from '../../Services/EmailService/email-service';
import { MailOtpVerification } from '../../Services/OtpVerificationService/mail-otp-verification';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-email-verification',
  imports: [ReactiveFormsModule,CommonModule, FormsModule],
  templateUrl: './email-verification.html',
  styleUrl: './email-verification.css'
})
export class EmailVerification {

  sendOtpButton: boolean = false;
  buttonText : string ='Send OTP';
  constructor(private emailService : EmailService, private mailOtpVerification :  MailOtpVerification){}
  form : FormGroup = new FormGroup({
    email : new FormControl('',[Validators.required]),
    otp : new FormControl('',[Validators.required])
  })

  sendOtp(){
    let timeleft = 15;
    this.sendOtpButton = true;
    const interval = setInterval(()=>{
      timeleft--;
      if(timeleft > 0){
        this.buttonText  = `Send OTP in \n${timeleft}`;
      }
      else{
        clearInterval(interval);
        this.sendOtpButton = false;
        this.buttonText = "Send OTP";
      }
    },1000);
    const url = `http://localhost:8080/careers/send-email-otp?receiptEmail=${this.form.value.email}`;
      this.emailService.sendMailOtp(url).subscribe({

        next:(message)=>{
          console.log(message)
        },
        error:(error)=>{
          console.log(error)
        }
      })
  }
  verify(){
    const url = `http://localhost:8080/careers/verifyOtp?email=${this.form.value.email}&otp=${this.form.value.otp}`;
    this.mailOtpVerification.otpVerification(url).subscribe({
      next : (message)=>{
        console.log(message);
      },
      error : (error)=>{
        console.log(error)
      }
    })
  }
}
