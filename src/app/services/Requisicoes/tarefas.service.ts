import { Tarefa } from './../../model/Tarefa';
import { computed, Injectable, signal, Signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { projetoService } from './projetoService';
import { MensagensService } from './mensagens.service';
import { BehaviorSubject, catchError, Observable, tap, throwError } from 'rxjs';
import { Documento } from '../../model/Documento';

@Injectable({ providedIn: 'root' })
export class TarefasService {
  private baseUrl = environment.tarefasURL;
  private idUsuario = localStorage.getItem('idUsuario');

  private _tarefas$ = new BehaviorSubject<Tarefa[]>([]);
  public tarefas$ = this._tarefas$.asObservable();

  private _tarefaSelecionada$ = new BehaviorSubject<Tarefa | null>(null);
  public tarefaSelecionada$ = this._tarefaSelecionada$.asObservable();

  constructor(
    private http: HttpClient,
    private projetoService: projetoService,
    private mensagensService: MensagensService
  ) {}

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
    this._tarefas$.next(tarefasOrdenadas);
  }

  adicionarTarefa(novaTarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(`${this.baseUrl}?idUsuario=${this.idUsuario}`, novaTarefa).pipe(
      tap(() => {
        this.listaTarefasPorProjeto();
        this.mensagensService.atualizarNotificacoes();
      }),
      catchError((err) => {
        console.error('Erro ao cadastrar tarefa:', err);
        return throwError(() => err);
      })
    );
  }
  
  atualizarTarefa(tarefaModificada: Tarefa): Observable<Tarefa> {
    return this.http.put<Tarefa>(`${this.baseUrl}/${tarefaModificada.id}?idUsuario=${this.idUsuario}`, tarefaModificada).pipe(
      tap(() => {
        this.listaTarefasPorProjeto();
        this.mensagensService.atualizarNotificacoes();
      }),
      catchError((err) => {
        console.error('Erro ao atualizar tarefa', err);
        return throwError(() => err);
      })
    );
  }

  deletarTarefa() {
    const tarefaSelecionada = this._tarefaSelecionada$.getValue();
    if (!tarefaSelecionada) return;

    this.http.delete(`${this.baseUrl}/${tarefaSelecionada.id}?idUsuario=${this.idUsuario}`).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
        this.mensagensService.atualizarNotificacoes();
      }
    });
  }

  getTarefaSelecionada() {
    return this.tarefaSelecionada$;
  }

  selecionarTarefa(tarefa: Tarefa | null) {
    this._tarefaSelecionada$.next(tarefa);
  }

  removerSelecaoTarefa() {
    this._tarefaSelecionada$.next(null);
  }
}