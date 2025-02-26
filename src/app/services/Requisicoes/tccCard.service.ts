import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TccCard } from '../../model/TccCard';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class TccCardService {
  private baseUrl = environment.tccCardURL;

  constructor(private http: HttpClient) { }

  getProjetosPorOrientador(): Observable<TccCard[]> {
    const idUsuario = localStorage.getItem('idUsuario');
    if (!idUsuario) {
      throw new Error('ID do usuário não encontrado no localStorage');
    }
    const url = `${this.baseUrl}${idUsuario}`;
    return this.http.get<TccCard[]>(url);
  }
}
