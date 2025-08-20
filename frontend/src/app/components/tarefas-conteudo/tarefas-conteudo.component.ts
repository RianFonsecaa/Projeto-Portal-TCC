import { Component, Input, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule, NgClass } from '@angular/common';
import { Tarefa } from '../../model/Tarefa';
import { TarefaClassificacaoService } from '../modais/modal-tarefa/model/TarefaClassificacoes.service';
import { TarefaEtapaService } from '../modais/modal-tarefa/model/TarefaEtapa.service';
import { TarefaPrioridadeService } from '../modais/modal-tarefa/model/TarefaPrioridade.service';
import { TarefaStatusService } from '../modais/modal-tarefa/model/TarefaStatus.service';



@Component({
  selector: 'app-tarefas-conteudo',
  standalone :true,
  imports :[CommonModule, NgClass],
  templateUrl: './tarefas-conteudo.component.html'
})
export class TarefasConteudoComponent implements OnInit {
  @Input() tarefa: Tarefa = {} as Tarefa;

  classificacao: string = '';
  etapa: string = '';
  status: string = '';
  prioridade: string = '';

  constructor(
    private classificacaoService: TarefaClassificacaoService,
    private etapaService: TarefaEtapaService,
    private statusService: TarefaStatusService,
    private prioridadeService: TarefaPrioridadeService
  ) {}

  ngOnInit() {
    if (this.tarefa) {
      this.classificacao = this.classificacaoService.getClassificacoes()
        .find(([key, _]) => key === this.tarefa.classificacao)?.[1] || '';

      this.etapa = this.etapaService.getEtapas()
        .find(([key, _]) => key === this.tarefa.etapa)?.[1] || '';

      this.status = this.statusService.getStatus()
        .find(([key, _]) => key === this.tarefa.status)?.[1] || '';

      this.prioridade = this.prioridadeService.getPrioridades()
        .find(([key, _]) => key === this.tarefa.prioridade)?.[1] || '';
    }
  }

  getPrioridadeClasses(): string {
    switch (this.tarefa.prioridade) {
      case 'ALTA':
        return 'text-red-600 border-red-500 bg-red-200';
      case 'MEDIA':
        return 'text-yellow-600 border-yellow-500 bg-yellow-200';
      case 'BAIXA':
        return 'text-blue-600 border-blue-500 bg-blue-200';
      default:
        return 'text-gray-600 border-gray-500 bg-gray-200';
    }
  }
}