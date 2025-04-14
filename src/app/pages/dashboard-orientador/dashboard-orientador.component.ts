import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { infoProjeto } from '../../model/infoProjeto';
import { ActivatedRoute, Router, RouterLink, RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { tap, mergeMap } from 'rxjs/operators';
import { projetoService } from '../../services/Requisicoes/projetoService';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NgFor, RouterLink, RouterOutlet],
  templateUrl: './dashboard-orientador.component.html',
})
export class DashboardOrientadorComponent {

  infoProjetos: infoProjeto[] = [];

  constructor(private projetoService: projetoService,private router: Router) {
  }

  ngOnInit() {

    this.projetoService.buscarInfoProjetoPorOrientador().subscribe({
      next: (response: infoProjeto[]) => {
        this.infoProjetos = response;
        console.log(response);
      },
      error: (err) => {
        console.error('Erro ao buscar projetos:', err);
      },
    });
  }

  navegaParaProjeto(projeto: infoProjeto){
    this.projetoService.setInfoProjeto(projeto);
    this.router.navigate(['/home', { outlets: { dashboard: 'gestaoProjeto' } }]);
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

}
