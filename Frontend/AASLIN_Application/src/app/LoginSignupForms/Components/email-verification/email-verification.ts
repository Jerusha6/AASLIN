import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { EmailService } from '../../Services/EmailService/email-service';

@Component({
  selector: 'app-email-verification',
  imports: [FormsModule],
  templateUrl: './email-verification.html',
  styleUrl: './email-verification.css'
})
export class EmailVerification {
  receiptEmail :String = '';
 
    constructor(private emailService : EmailService){}

    submit(){
      const url = `http://localhost:8080/careers/send-email-otp?receiptEmail=${this.receiptEmail}`;
      this.emailService.sendMailOtp(url).subscribe({

        next:(message)=>{
          console.log(message)
        },
        error:(error)=>{
          console.log(error)
        }
      })
     
    }
}
