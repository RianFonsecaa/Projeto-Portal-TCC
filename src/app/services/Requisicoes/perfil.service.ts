import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Orientador } from '../../model/Orientador';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  private baseUrl = environment.perfilURL;

  constructor(private http: HttpClient) {}

  getDadosUsuario(): Observable<Orientador> {
    const idUsuario = localStorage.getItem('idUsuario');
    if (!idUsuario) {
      throw new Error('ID do usuário não encontrado no localStorage');
    }
    const url = `${this.baseUrl}${idUsuario}`;
    return this.http.get<Orientador>(url);
  }
}
