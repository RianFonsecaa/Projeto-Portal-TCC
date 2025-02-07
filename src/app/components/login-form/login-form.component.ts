import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';
import { LoginService } from './../../services/login.service';
import { BasicInputComponent } from '../basic-input/basic-input.component';
import { LoginRequest } from 'src/app/model/login-request.model';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule, NgIf],
  templateUrl: './login-form.component.html',
  styles: []
})
export class LoginFormComponent {
  loginForm: FormGroup;
  errorMessage: boolean = false;
  loginInformation: LoginRequest = { email: '', senha: '' };

  constructor(private loginService: LoginService) {
    this.loginForm = new FormGroup({
      email: new FormControl('', {
        validators: [Validators.email, Validators.required],
      }),
      password: new FormControl('', {
        validators: [Validators.required, Validators.minLength(6)]
      })
    });
  }

  get emailIsValid() {
    return (
      this.loginForm.controls['email'].touched &&
      this.loginForm.controls['email'].dirty &&
      this.loginForm.controls['email'].invalid
    );
  }

  get passwordIsValid() {
    return (
      this.loginForm.controls['password'].touched &&
      this.loginForm.controls['password'].dirty &&
      this.loginForm.controls['password'].invalid
    );
  }

  onSubmit() {
    const token = 'jwtToken';

    if (this.loginForm.valid) {
      this.loginInformation.email = this.loginForm.get('email')?.value;
      this.loginInformation.senha = this.loginForm.get('password')?.value;

      this.loginService.login(this.loginInformation).subscribe({
        next: (response) => {
          console.log(response);
          localStorage.setItem(token, response.jwtToken);
          console.log('Direcionando para outra página', localStorage.getItem(token));
          this.errorMessage = false;
        },
        error: (error) => {
          console.log('Erro ao realizar login:', error);
          this.errorMessage = true;
        }
      });
    } else {
      console.warn('Formulário inválido!');
    }
  }
  getControl(name: string): FormControl {
    return this.loginForm.get(name) as FormControl;
  }
}
