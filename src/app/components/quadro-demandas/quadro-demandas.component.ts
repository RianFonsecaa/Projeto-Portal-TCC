import { Component } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { ModalTarefa } from '../modais/modal-tarefa/modal-tarefa.component';
import { ActivatedRoute } from '@angular/router';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';
import { Subscription } from 'rxjs';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { TarefasConteudoComponent } from '../tarefas-conteudo/tarefas-conteudo.component';
import { Tarefa } from '../../model/Tarefa';
import { projetoService } from '../../services/Requisicoes/projetoService';
import { infoProjeto } from '../../model/infoProjeto';
import { Usuario } from '../../model/Usuario';
import { PerfilService } from '../../services/Requisicoes/perfil.service';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalTarefa, NgClass, TarefasConteudoComponent, NgFor, NgIf],
  templateUrl: './quadro-demandas.component.html',
})
export class QuadroDemandasComponent {
  tarefasPendentes:   Tarefa[] = [];
  tarefasEmAndamento: Tarefa[] = [];
  tarefasConcluidas:  Tarefa[] = [];
  tarefasBacklog:     Tarefa[] = [];
  tarefas: Tarefa[] = [];
  infoProjeto: infoProjeto = {} as infoProjeto;
  usuario: Usuario = {} as Usuario;

  selectedTab: string = 'Quadro de Demandas';

  constructor(
    private tarefasService: TarefasService,
    public modalService: ModalService,
    public projetoService: projetoService,
    private perfilService: PerfilService
  ) { }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  ngOnInit() {
    this.infoProjeto = this.projetoService.getInfoProjeto();
    this.perfilService.getDadosUsuario().subscribe({
      next: (usuario) => {
        this.usuario = usuario;
      },
      error: (err) => console.error('Erro ao carregar usuário:', err)
    });

    this.tarefasService.listaTarefasPorProjeto();
    this.tarefasService.tarefas$.subscribe({
      next: (tarefas) => {
        this.tarefas = tarefas;
        this.separarTarefasPorStatus();
      },
      error: (err) => console.error('Erro ao carregar tarefas:', err)
    });
  }

  separarTarefasPorStatus(){
    this.tarefasBacklog     = this.tarefas.filter(tarefa => tarefa.status === 'BACKLOG');
    this.tarefasPendentes   = this.tarefas.filter(tarefa => tarefa.status === 'PENDENTE');
    this.tarefasEmAndamento = this.tarefas.filter(tarefa => tarefa.status === 'ANDAMENTO');
    this.tarefasConcluidas  = this.tarefas.filter(tarefa => tarefa.status === 'CONCLUIDA');
  }


  abrirTarefa(tarefa: Tarefa) {
    this.tarefasService.selecionarTarefa(tarefa);
    this.modalService.abrir('modalTarefa');
  }
}

