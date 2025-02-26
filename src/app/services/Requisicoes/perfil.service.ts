import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { Usuario } from '../../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  private baseUrl = environment.perfilURL;

  constructor(private http: HttpClient) { }

  getDadosUsuario(): Observable<Usuario> {
    const idUsuario = localStorage.getItem('idUsuario');
    if (!idUsuario) {
      throw new Error('ID do usuário não encontrado no localStorage');
    }
    const url = `${this.baseUrl}${idUsuario}`;
    return this.http.get<Usuario>(url);
  }
}
