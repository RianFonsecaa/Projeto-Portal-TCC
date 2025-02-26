import { NgClass, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { TarefasConteudoComponent } from '../../components/tarefas-conteudo/tarefas-conteudo.component';
import { QuadroDemandasComponent } from "../../components/quadro-demandas/quadro-demandas.component";


@Component({
  selector: 'app-dashboard-aluno',
  standalone: true,
  imports: [NgClass, NgFor, TarefasConteudoComponent, QuadroDemandasComponent],
  templateUrl: './dashboard-aluno.component.html',
})
export class DashboardAlunoComponent {

  constructor() { }

}
