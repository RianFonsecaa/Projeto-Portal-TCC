import { Tarefa } from './../../model/Tarefa';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject} from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { infoProjeto } from '../../model/infoProjeto';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {
  private baseUrl = environment.tarefasURL;
  private tarefasSubject = new BehaviorSubject<Tarefa[]>([]);
  tarefas$ = this.tarefasSubject.asObservable();

  constructor(private http: HttpClient) {}

  listaTarefasPorProjeto() {
    const infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');
    if (!infoProjeto.id) {
      console.error('Projeto não encontrado');
      return;
    }

    this.http.get<Tarefa[]>(`${this.baseUrl}/${infoProjeto.id}`).subscribe({
      next: (tarefas) => {
        this.tarefasSubject.next(tarefas);
      },
      error: (err) => {
        console.error('Erro ao buscar tarefas:', err);
      }
    });
  }

  adicionarTarefa(novaTarefa: Tarefa): void {
    this.http.post<Tarefa>(`${this.baseUrl}`, novaTarefa).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
      },
      error: (err) => {
        console.error('Erro ao cadastrar tarefa:', err);
      }
    });
  }

  atualizarTarefa(tarefaModificada: Tarefa): void{
    this.http.put<Tarefa>(`${this.baseUrl}/${tarefaModificada.id}`, tarefaModificada).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
      },
      error: (err) => {
        console.error('Erro ao atulizar tarefa', err);
      }
    });
  }
}