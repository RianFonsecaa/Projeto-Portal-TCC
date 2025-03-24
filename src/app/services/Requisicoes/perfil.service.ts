import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { Usuario } from '../../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  constructor(private http: HttpClient) {}

  getDadosUsuario(): Observable<Usuario> {
    const idUsuario = localStorage.getItem('idUsuario');
    const url = `${environment.perfilURL}${idUsuario}`;
    return this.http.get<Usuario>(url);
  }
}
