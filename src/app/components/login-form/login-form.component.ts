import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgIf } from '@angular/common';
import { Router } from '@angular/router';

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
  private usuarioMock = { email: 'teste@exemplo.com', senha: '123456' };
  private fakeJwtToken = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.mockToken12345';

  constructor(private router: Router) {
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
    const email = this.loginForm.get('email')?.value;
    const senha = this.loginForm.get('password')?.value;

    if (this.loginForm.valid) {
      if (email === this.usuarioMock.email && senha === this.usuarioMock.senha) {
        localStorage.setItem(token, this.fakeJwtToken);
        console.log('Login bem-sucedido. Token armazenado:', localStorage.getItem(token));
        this.errorMessage = false;
        this.router.navigate(['/home', { outlets: { dashboard: 'dashboardHome' } }]).then(() => {
          window.location.reload();
        });
      } else {
        console.log('Credenciais inválidas');
        this.errorMessage = true;
      }
    } else {
      console.warn('Formulário inválido!');
    }
  }

  getControl(name: string): FormControl {
    return this.loginForm.get(name) as FormControl;
  }
}
