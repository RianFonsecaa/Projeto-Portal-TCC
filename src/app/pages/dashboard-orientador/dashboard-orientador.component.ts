import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { TccCard } from '../../model/TccCard';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { Projeto } from '../../model/Projeto';
import { tap, mergeMap } from 'rxjs/operators';
import { Demandas } from '../../model/Demandas';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './dashboard-orientador.component.html',
})
export class DashboardOrientadorComponent {
  tccCards: TccCard[];

  constructor(private router: Router, private http: HttpClient) {
    this.tccCards =[];
  }

  ngOnInit() {
    this.getProjetos()
      .pipe(
        tap((response: TccCard[]) => {
          console.log("Response da API:", response);
          this.tccCards = response;
        }),
        mergeMap((tccCards) => {
          // criamos um array de requisições para pegar as demandas
          const requisicoes = tccCards.map(card =>
            this.getDemandasPorId(card.id).pipe(
              tap((demandas) => {
                // associamos as demandas ao respectivo card
                card.demandas = demandas;
              })
            )
          );
          return forkJoin(requisicoes); // Aguarda todas as requisições serem concluídas
        })
      )
      .subscribe({
        next: () => console.log("Todos os dados foram carregados com sucesso."),
        error: (error) => console.error("Erro ao buscar dados:", error)
      });
  }

  getProjetos(): Observable<TccCard[]> {
    return this.http.get<TccCard[]>('http://127.0.0.1:8080/api/projetos');
  }

  getDemandasPorId(id: number): Observable<Demandas> {
    return this.http.get<Demandas>(`http://127.0.0.1:8080/api/quadro-demandas/${id}`);
  }

  toggleProjetoInfo(projetoInfoDiv: HTMLElement) {
    if (projetoInfoDiv.classList.contains('max-w-full')) {
      projetoInfoDiv.classList.remove('max-w-full', 'p-3', 'border', 'border-gray-200');
      projetoInfoDiv.classList.add('max-w-0');
    } else {
      projetoInfoDiv.classList.remove('max-w-0');
      projetoInfoDiv.classList.add('max-w-full', 'p-3', 'border', 'border-gray-200');
    }
  }

  navegarParaDemanda(id: number): void {
    this.router.navigate(['/home', { outlets: { dashboard: ['demanda', id] } }]);
  }
}
