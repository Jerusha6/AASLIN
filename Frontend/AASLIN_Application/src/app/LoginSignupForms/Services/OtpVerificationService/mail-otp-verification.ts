import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MailOtpVerification {
  constructor(private http : HttpClient){}

  otpVerification(url :string){
    return this.http.get(url,{ responseType: 'text' as const });
  }
}
