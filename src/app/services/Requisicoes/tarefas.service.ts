import { Tarefa } from './../../model/Tarefa';
import { computed, Injectable, signal, Signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { projetoService } from './projetoService';

@Injectable({ providedIn: 'root' })
export class TarefasService {
  private baseUrl = environment.tarefasURL;

  private _tarefas = signal<Tarefa[]>([]);
  public tarefas = this._tarefas.asReadonly();

  private _tarefaSelecionada = signal<Tarefa | null>(null);
  public tarefaSelecionada = this._tarefaSelecionada.asReadonly();

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
      new Date(b.ultimaAtualizacaoEm).getTime() - new Date(a.ultimaAtualizacaoEm).getTime()
    );
    this._tarefas.set(tarefasOrdenadas);
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
    this.http.delete(`${this.baseUrl}/${this.tarefaSelecionada()?.id}`).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
      },
    });
  }

  getTarefaSelecionada(){
    return this._tarefaSelecionada.asReadonly();
  }

  selecionarTarefa(tarefa: Tarefa | null) {
    this._tarefaSelecionada.set(tarefa);
  }

  removerSelecaoTarefa(){
    this._tarefaSelecionada.set(null);
  }
}
