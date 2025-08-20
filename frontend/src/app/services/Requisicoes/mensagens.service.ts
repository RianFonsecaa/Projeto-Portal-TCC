import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of, Subject } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { Notificacao } from '../../model/Notificacao';

@Injectable({
  providedIn: 'root'
})
export class MensagensService {
  private apiUrl = environment.mensagensURL;
  private notificacoesAtualizadasSubject = new Subject<Notificacao[]>();

  // Observable para componentes se inscreverem
  notificacoesAtualizadas$ = this.notificacoesAtualizadasSubject.asObservable();

  constructor(private http: HttpClient) { }

  obterNotificacoes(): Observable<Notificacao[]> {
    const email = localStorage.getItem('email');
    if (!email) {
      throw new Error('Email não encontrado no localStorage');
    }
    return this.http.get<Notificacao[]>(`${this.apiUrl}/${email}`);
  }

  marcarComoLida(id: number): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}/visualizar`, {});
  }

  // Método para forçar a atualização das notificações
  atualizarNotificacoes(): void {
    this.obterNotificacoes().subscribe({
      next: (notificacoes) => {
        this.notificacoesAtualizadasSubject.next(notificacoes);
      },
      error: (err) => {
        console.error('Erro ao atualizar notificações', err);
      }
    });
  }

  buscarQuantidadeNaoVisualizadas(): Observable<number> {
    const email = localStorage.getItem('email');

    if (!email) {
      console.error('Email não encontrado no localStorage');
      return of(0); // Retorna 0 se não tiver email
    }

    return this.http.get<number>(`${this.apiUrl}/nao-visualizadas/quantidade/${email}`).pipe(
      catchError(error => {
        console.error('Erro ao buscar quantidade de não visualizadas:', error);
        return of(0); // Retorna 0 em caso de erro
      })
    );
  }

}
