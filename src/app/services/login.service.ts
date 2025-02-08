import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { LoginResponse } from '../model/login-response.model';
import { LoginRequest } from '../model/login-request.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly apiUrl = environment.loginURL;

  constructor(private http: HttpClient) {}

  login(loginInformation: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl, loginInformation)
  }
}
