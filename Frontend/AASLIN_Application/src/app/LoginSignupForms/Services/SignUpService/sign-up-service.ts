import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  api_url = "http://localhost:8080/careers/register";

  constructor(private _http: HttpClient) {}

 registerUser(formValues: any) {
  return this._http.post(this.api_url, formValues, { responseType: 'text' });
}
}