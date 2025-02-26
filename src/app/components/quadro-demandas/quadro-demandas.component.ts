import { Component } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { ModalTarefa } from '../modais/modal-tarefa/modal-tarefa.component';
import { ActivatedRoute } from '@angular/router';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';
import { Subscription } from 'rxjs';
import { NgClass, NgFor } from '@angular/common';
import { TarefasConteudoComponent } from '../tarefas-conteudo/tarefas-conteudo.component';
import { Tarefa } from '../../model/Tarefas';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalTarefa, NgClass, TarefasConteudoComponent, NgFor],
  templateUrl: './quadro-demandas.component.html',
})
export class QuadroDemandasComponent {
  tarefasPendentes: Tarefa[] = [];
  tarefasEmAndamento: Tarefa[] = [];
  tarefasConcluidas: Tarefa[] = [];
  tarefas: Tarefa[] = [];
  alunoId: number = 0;
  projetoId: string | null = null;

  selectedTab: string = 'Quadro de Demandas';
  private routeSubscription!: Subscription;

  constructor(
    private route: ActivatedRoute,
    private tarefasService: TarefasService,
    public modalService: ModalService
  ) { }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.projetoId = params.get('projetoId');
    });
    this.tarefasService.getTarefasPorProjeto(this.projetoId).subscribe({
      next: (tarefas) => {
        this.tarefas = tarefas;
        console.log('Tarefas do projeto:', tarefas);
      },
      error: (err) => {
        console.error('Erro ao buscar tarefas:', err);
      },
      complete: () => {
        console.log('Requisição concluída.');
      }
    });
  };


  adicionarNovaDemanda(): void {
  }

  ngOnDestroy(): void {
    this.routeSubscription.unsubscribe();
  }
}

