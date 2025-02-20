import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';
import { Router } from '@angular/router';
import { LoginService } from './../../services/login.service';
import { LoginRequest } from '../../model/login-request.model';
import { CommonModule } from '@angular/common';

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

  constructor(private loginService: LoginService, private router: Router) {
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
          localStorage.clear;
          localStorage.setItem('jwtToken', response.jwtToken);
          localStorage.setItem('idUsuario', response.usuario.id.toString());

          switch (response.usuario.tipoUsuario) {
            case 'COORDENADOR':
            case 'ALUNO':
              this.router.navigate(['/home', { outlets: { dashboard: 'dashboardAluno' } }]).then(() => {
                window.location.reload();
              });
              break;
            case 'PROFESSOR':
              this.router.navigate(['/home', { outlets: { dashboard: 'dashboardOrientador' } }]).then(() => {
                window.location.reload();
              });
              break;
            default:
              console.warn('Tipo de usuário desconhecido:', response.usuario.tipoUsuario);
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
