import { NgClass, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { TarefasConteudoComponent } from '../../components/tarefas-conteudo/tarefas-conteudo.component';
import { GestaoProjetoComponent } from "../gestao-projeto/gestao-projeto.component";
import { projetoService } from '../../services/Requisicoes/projetoService';
import { ActivatedRoute, Route, Router, RouterOutlet } from '@angular/router';
import { infoProjeto } from '../../model/infoProjeto';


@Component({
  selector: 'app-dashboard-orientando',
  standalone: true,
  imports: [NgClass, NgFor, TarefasConteudoComponent, GestaoProjetoComponent, RouterOutlet],
  templateUrl: './dashboard-orientando.component.html',
})
export class DashboardOrientandoComponent {

  constructor(private projetoService: projetoService, private route: ActivatedRoute, private router: Router ) { }

  ngOnInit() {
    this.projetoService.buscarInfoProjetoPorOrientando().subscribe({
      next: (response: infoProjeto) => {
        this.projetoService.setInfoProjeto(response);
        this.router.navigate(['/home', { outlets: { dashboard: 'gestaoProjeto' } }]);
      },
      error: (err) => {
        console.error('Erro ao buscar projetos:', err);
      },
    });
  }
}
