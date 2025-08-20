import { Tarefa } from './../../model/Tarefa';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { projetoService } from './projetoService';
import { MensagensService } from './mensagens.service';
import { BehaviorSubject, catchError, Observable, tap, throwError } from 'rxjs';
import { Documento } from '../../model/Documento';

@Injectable({ providedIn: 'root' })
export class TarefasService {
  private baseUrl = environment.tarefasURL;

  private _tarefas$ = new BehaviorSubject<Tarefa[]>([]);
  public tarefas$ = this._tarefas$.asObservable();

  private _tarefaSelecionada$ = new BehaviorSubject<Tarefa | null>(null);
  public tarefaSelecionada$ = this._tarefaSelecionada$.asObservable();

  constructor(
    private http: HttpClient,
    private projetoService: projetoService,
    private mensagensService: MensagensService
  ) {}

  // 🔁 Atualiza o observable interno com as tarefas do projeto
  listaTarefasPorProjeto(): void {
    const infoProjeto = this.projetoService.getInfoProjeto();
    if (!infoProjeto.id) {
      console.error('Projeto não encontrado');
      return;
    }

    this.http.get<Tarefa[]>(`${this.baseUrl}/${infoProjeto.id}`).subscribe({
      next: (tarefas) => this.ordenarTarefasPorData(tarefas),
      error: (err) => console.error('Erro ao buscar tarefas:', err)
    });
  }

  // ✅ Novo método: retorna Observable com as tarefas (sem inscrever direto)
  buscarTarefasPorProjeto(): Observable<Tarefa[]> {
    const infoProjeto = this.projetoService.getInfoProjeto();
    if (!infoProjeto.id) {
      throw new Error('Projeto não encontrado');
    }

    return this.http.get<Tarefa[]>(`${this.baseUrl}/${infoProjeto.id}`);
  }

  // 🔁 Ordena por data de atualização e atualiza o BehaviorSubject
  private ordenarTarefasPorData(tarefas: Tarefa[]): void {
    const tarefasOrdenadas = tarefas.sort((a, b) =>
      new Date(b.ultimaAtualizacaoEm).getTime() - new Date(a.ultimaAtualizacaoEm).getTime()
    );
    this._tarefas$.next(tarefasOrdenadas);
  }

  adicionarTarefa(novaTarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(`${this.baseUrl}?idUsuario=${localStorage.getItem('idUsuario')}`, novaTarefa).pipe(
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
    console.log(tarefaModificada)
    return this.http.put<Tarefa>(`${this.baseUrl}/${tarefaModificada.id}?idUsuario=${localStorage.getItem('idUsuario')}`, tarefaModificada).pipe(
      tap(() => {
        console.log("ATUALIZANDO")  
        this.listaTarefasPorProjeto();
        this.mensagensService.atualizarNotificacoes();
      }),
      catchError((err) => {
        console.error('Erro ao atualizar tarefa', err);
        return throwError(() => err);
      })
    );

  }

  deletarTarefa(): void {
    const tarefaSelecionada = this._tarefaSelecionada$.getValue();
    if (!tarefaSelecionada) return;

    this.http.delete(`${this.baseUrl}/${tarefaSelecionada.id}?idUsuario=${localStorage.getItem('idUsuario')}`).subscribe({
      next: () => {
        this.listaTarefasPorProjeto();
        this.mensagensService.atualizarNotificacoes();
      }
    });
  }

  getTarefaSelecionada(): Observable<Tarefa | null> {
    return this.tarefaSelecionada$;
  }

  selecionarTarefa(tarefa: Tarefa | null): void {
    this._tarefaSelecionada$.next(tarefa);
  }

  removerSelecaoTarefa(): void {
    this._tarefaSelecionada$.next(null);
  }
}
