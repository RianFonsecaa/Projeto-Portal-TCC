import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { infoProjeto } from '../../model/infoProjeto';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class projetoService {

  constructor(private http: HttpClient) { }

  buscarInfoProjetoPorOrientador(): Observable<infoProjeto[]> {
    const idUsuario = localStorage.getItem('idUsuario');
    if (!idUsuario) {
      throw new Error('ID do usuário não encontrado no localStorage');
    }
    const url = `${environment.infoProjetoByOrientadorURL}${idUsuario}`;
    return this.http.get<infoProjeto[]>(url);
  }

  buscarInfoProjetoPorOrientando(): Observable<infoProjeto> {
    const idUsuario = localStorage.getItem('idUsuario');
    if (!idUsuario) {
      throw new Error('ID do usuário não encontrado no localStorage');
    }
    const url = `${environment.infoProjetoByOrientandoURL}${idUsuario}`;
    return this.http.get<infoProjeto>(url);
  }

  setInfoProjeto(infoProjeto: infoProjeto) {
    localStorage.setItem('infoProjeto', JSON.stringify(infoProjeto))
  }

  getInfoProjeto(): infoProjeto{
    return JSON.parse(localStorage.getItem('infoProjeto') || '{}');
  }
} 