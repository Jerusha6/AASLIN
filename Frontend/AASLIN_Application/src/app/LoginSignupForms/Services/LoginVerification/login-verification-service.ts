import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginVerificationService {
  constructor(private http : HttpClient){}
  loginVerification(url : string){
    return this.http.get(url)
  }
}
