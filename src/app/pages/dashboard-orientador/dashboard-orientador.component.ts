import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { TccCard } from '../../model/TccCard';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { tap, mergeMap } from 'rxjs/operators';
import { TccCardService } from '../../services/Requisicoes/tccCard.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './dashboard-orientador.component.html',
})
export class DashboardOrientadorComponent {
  tccCards: TccCard[];

  constructor(private router: Router, private http: HttpClient, private TccCardService: TccCardService) {
    this.tccCards =[];
  }

  ngOnInit() {
    this.TccCardService.getProjetosPorOrientador().subscribe({
      next: (response: TccCard[]) => {
        this.tccCards = response;
      },
      error: (err) => {
        console.error('Erro ao buscar projetos:', err);
      },
    });
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
