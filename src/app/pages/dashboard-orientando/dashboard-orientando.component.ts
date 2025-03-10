import { NgClass, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { TarefasConteudoComponent } from '../../components/tarefas-conteudo/tarefas-conteudo.component';
import { QuadroDemandasComponent } from "../../components/quadro-demandas/quadro-demandas.component";
import { projetoService } from '../../services/Requisicoes/projetoService';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { infoProjeto } from '../../model/infoProjeto';


@Component({
  selector: 'app-dashboard-orientando',
  standalone: true,
  imports: [NgClass, NgFor, TarefasConteudoComponent, QuadroDemandasComponent],
  templateUrl: './dashboard-orientando.component.html',
})
export class DashboardOrientandoComponent {

  constructor(private projetoService: projetoService, private route: ActivatedRoute, private router: Router ) { }

  ngOnInit() {
    this.projetoService.buscarInfoProjetoPorOrientando().subscribe({
      next: (response: infoProjeto) => {
        this.projetoService.setInfoProjeto(response);
        this.router.navigate(['/home', { outlets: { dashboard: ['projeto', response.id] } }]);
      },
      error: (err) => {
        console.error('Erro ao buscar projetos:', err);
      },
    });
  }
}
