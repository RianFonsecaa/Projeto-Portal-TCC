import { Tarefa } from './../../model/tarefas';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {
  private baseUrl = environment.tarefasURL;

  constructor(private http: HttpClient) { }

  getTarefasPorProjeto(idProjeto: number): Observable<Tarefa[]> {
    const url = `${this.baseUrl}${idProjeto}`;
    return this.http.get<Tarefa[]>(url);
  }

  adicionarTarefa(tarefa: Tarefa): Observable<Tarefa> {
      if (!tarefa.prazo || !tarefa.descricao || !tarefa.nomeTarefa) {
        alert('Preencha todos os campos obrigatórios!');
        throwError(() => new Error('Preencha todos os campos obrigatórios!'));
      }
      return this.http.post<Tarefa>(this.baseUrl, tarefa);
  }
}
