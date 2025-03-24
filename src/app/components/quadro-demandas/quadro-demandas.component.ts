import { Component, OnInit } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { ModalTarefa } from '../modais/modal-tarefa/modal-tarefa.component';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { TarefasConteudoComponent } from '../tarefas-conteudo/tarefas-conteudo.component';
import { Tarefa } from '../../model/Tarefa';
import { projetoService } from '../../services/Requisicoes/projetoService';
import { infoProjeto } from '../../model/infoProjeto';
import { Usuario } from '../../model/Usuario';
import { PerfilService } from '../../services/Requisicoes/perfil.service';
import {CdkDragDrop, DragDropModule, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { Coluna } from '../../model/Coluna';
import { Quadro } from '../../model/Quadro';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalTarefa, NgClass, TarefasConteudoComponent, NgFor, NgIf, DragDropModule],
  templateUrl: './quadro-demandas.component.html',
  styleUrl: './quadro-demandas.component.css'
})
export class QuadroDemandasComponent implements OnInit {
  quadroTarefas: Quadro = new Quadro('Quadro de Tarefas', [
    new Coluna('PENDENTE', '1', []),
    new Coluna('ANDAMENTO', '2', []),
    new Coluna('CONCLUIDA', '3', []),
    new Coluna('BACKLOG', '4', [])
  ]);

  colunasIds = this.quadroTarefas.colunas.map(c => c.id);
  
  tarefas: Tarefa[] = [];
  infoProjeto: any = {};
  usuario: any = {};
  selectedTab: string = 'Quadro de Demandas';

  constructor(
    private tarefasService: TarefasService,
    public modalService: ModalService,
    public projetoService: projetoService,
    private perfilService: PerfilService
  ) { }

  ngOnInit() {
    this.infoProjeto = this.projetoService.getInfoProjeto();
    this.perfilService.getDadosUsuario().subscribe({
      next: (usuario) => this.usuario = usuario,
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

  separarTarefasPorStatus() {
    this.quadroTarefas.colunas.forEach(coluna => {
      coluna.tarefas = this.tarefas.filter(tarefa => tarefa.status === coluna.nome);
    });
  }

  drop(event: CdkDragDrop<Tarefa[]>): void {

    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
  
      const tarefaMovida = event.container.data[event.currentIndex];
  
      tarefaMovida.status = this.quadroTarefas.colunas.find(coluna => coluna.id === event.container.id)!.nome;
      tarefaMovida.ultimaAtualizacao = new Date().toLocaleString('sv-SE');
  
      this.tarefasService.atualizarTarefa(tarefaMovida);
  
      event.container.data.sort((a, b) => new Date(a.ultimaAtualizacao).getTime() - new Date(b.ultimaAtualizacao).getTime());
    }
  }

  abrirTarefa(tarefa: Tarefa) {
    console.log(tarefa.ultimaAtualizacao)
    this.tarefasService.selecionarTarefa(tarefa);
    this.modalService.abrir('modalTarefa');
  }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
}
