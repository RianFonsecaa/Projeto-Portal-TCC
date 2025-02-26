import { Tarefa } from './../../model/tarefas';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {
  private baseUrl = environment.tarefasURL;

  constructor(private http: HttpClient) {}

  getTarefasPorProjeto(idProjeto: number): Observable<Tarefa[]> {
    const url = `${this.baseUrl}${idProjeto}`;
    return this.http.get<Tarefa[]>(url);
  }
}
