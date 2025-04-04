import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';
import { Router } from '@angular/router';
import { LoginService } from '../../services/Requisicoes/login.service';
import { LoginRequest } from '../../model/login-request.model';
import { CommonModule } from '@angular/common';
import {projetoService } from '../../services/Requisicoes/projetoService';
import { infoProjeto } from '../../model/infoProjeto';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule, NgIf, CommonModule],
  templateUrl: './login-form.component.html',
  styles: []
})
export class LoginFormComponent {
  loginForm: FormGroup;
  errorMessage: string | null = null;
  projetoId!: number;

  constructor(private loginService: LoginService, private router: Router, private projetoService: projetoService) {
    this.loginForm = new FormGroup({
      email: new FormControl('', {
        validators: [Validators.email, Validators.required],
      }),
      password: new FormControl('', {
        validators: [Validators.required, Validators.minLength(6)]
      })
    });
  }

  dismissToast() {
    this.errorMessage = null;
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
    if (this.loginForm.valid) {
      const loginInfo: LoginRequest = {
        email: this.loginForm.get('email')?.value,
        senha: this.loginForm.get('password')?.value
      };

      this.loginService.login(loginInfo).subscribe({
        next: (response) => {

          console.log(response);
          localStorage.clear;
          localStorage.setItem('jwtToken', response.jwtToken);
          localStorage.setItem('idUsuario', response.usuarioId);
          localStorage.setItem('email', this.loginForm.get('email')?.value);

          switch (response.tipoUsuario) {
            case 'COORDENADOR':
            case 'ORIENTANDO':
              this.router.navigate(['/home', { outlets: { dashboard: ['dashboardOrientando'] } }]);
              break;
            case 'ORIENTADOR':
              this.router.navigate(['/home', { outlets: { dashboard: 'dashboardOrientador' } }]);
              break;
            default:
              console.warn('Tipo de usuário desconhecido:', response.tipoUsuario);
          }
        },
        error: (error) => {
          console.log('Erro ao realizar login:', error);
          this.errorMessage = 'Login ou senha inválidos';
        }
      });

    }
  }

  getControl(name: string): FormControl {
    return this.loginForm.get(name) as FormControl;
  }
}
