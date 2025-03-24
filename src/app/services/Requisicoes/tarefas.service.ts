import { Tarefa } from './../../model/Tarefa';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { projetoService } from './projetoService';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {
  private baseUrl = environment.tarefasURL;
  private tarefasSubject = new BehaviorSubject<Tarefa[]>([]);
  private tarefaSelecionada = new BehaviorSubject<Tarefa | null>(null);
  tarefas$ = this.tarefasSubject.asObservable();
  tarefaSelecionada$ = this.tarefaSelecionada.asObservable();

  constructor(private http: HttpClient, private projetoService: projetoService) {}

  listaTarefasPorProjeto() {
    const infoProjeto = this.projetoService.getInfoProjeto();
    if (!infoProjeto.id) {
      console.error('Projeto não encontrado');
      return;
    }

    this.http.get<Tarefa[]>(`${this.baseUrl}/${infoProjeto.id}`).subscribe({
      next: (tarefas) => {
        this.ordenarTarefasPorData(tarefas);
      },
      error: (err) => {
        console.error('Erro ao buscar tarefas:', err);
      }
    });
  }

  private ordenarTarefasPorData(tarefas: Tarefa[]) {
    const tarefasOrdenadas = tarefas.sort((a, b) => 
      new Date(b.ultimaAtualizacao).getTime() - new Date(a.ultimaAtualizacao).getTime()
    );
    this.tarefasSubject.next(tarefasOrdenadas);
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

  atualizarTarefa(tarefaModificada: Tarefa): void {
    this.http.put<Tarefa>(`${this.baseUrl}/${tarefaModificada.id}`, tarefaModificada).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
      },
      error: (err) => {
        console.error('Erro ao atualizar tarefa', err);
      }
    });
  }

  deletarTarefa() {
    this.http.delete(`${this.baseUrl}/${this.tarefaSelecionada.getValue()?.id}`).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
      },
    });
  }

  selecionarTarefa(tarefa: Tarefa | null) {
    this.tarefaSelecionada.next(tarefa);
  }
}