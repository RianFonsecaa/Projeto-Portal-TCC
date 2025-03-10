import { Component } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { ModalTarefa } from '../modais/modal-tarefa/modal-tarefa.component';
import { ActivatedRoute } from '@angular/router';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';
import { Subscription } from 'rxjs';
import { NgClass, NgFor } from '@angular/common';
import { TarefasConteudoComponent } from '../tarefas-conteudo/tarefas-conteudo.component';
import { Tarefa } from '../../model/tarefas';
import { projetoService } from '../../services/Requisicoes/projetoService';
import { infoProjeto } from '../../model/infoProjeto';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalTarefa, NgClass, TarefasConteudoComponent, NgFor],
  templateUrl: './quadro-demandas.component.html',
})
export class QuadroDemandasComponent {
  tarefasPendentes:   Tarefa[] = [];
  tarefasEmAndamento: Tarefa[] = [];
  tarefasConcluidas:  Tarefa[] = [];
  tarefasBacklog:     Tarefa[] = [];
  tarefas: Tarefa[] = [];
  projetoId: string | null = null;
  infoProjeto: infoProjeto = {} as infoProjeto;

  selectedTab: string = 'Quadro de Demandas';

  constructor(
    private tarefasService: TarefasService,
    public modalService: ModalService,
    public projetoService: projetoService
  ) { }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  ngOnInit(): void {
    this.infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');

    if (this.infoProjeto.id) {
      this.tarefasService.getTarefasPorProjeto(this.infoProjeto.id).subscribe({
        next: (tarefas) => {
          this.tarefas = tarefas;
          this.separarTarefasPorStatus();
        },
        error: (err) => {
          console.error('Erro ao buscar tarefas:', err);
        },
      });
    } else {
      console.error('ID do projeto não encontrado');
    }
  }

  separarTarefasPorStatus(): void {
    this.tarefasBacklog  = this.tarefas.filter(tarefa => tarefa.status === 'BACKLOG');
    this.tarefasPendentes   = this.tarefas.filter(tarefa => tarefa.status === 'PENDENTE');
    this.tarefasEmAndamento = this.tarefas.filter(tarefa => tarefa.status === 'ANDAMENTO');
    this.tarefasConcluidas  = this.tarefas.filter(tarefa => tarefa.status === 'CONCLUIDA');
  }

  adicionarNovaDemanda(): void {
  }
}

