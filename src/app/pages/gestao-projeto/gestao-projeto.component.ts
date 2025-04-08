import { Component, computed, effect, Inject, Injector, OnInit, runInInjectionContext, Signal, ViewChild } from '@angular/core';
import { ModalService } from '../../services/modal.service';
import { ModalTarefa } from '../../components/modais/modal-tarefa/modal-tarefa.component';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';
import { NgClass, NgFor, NgIf, NgSwitch, NgSwitchCase } from '@angular/common';
import { TarefasConteudoComponent } from '../../components/tarefas-conteudo/tarefas-conteudo.component';
import { Tarefa } from '../../model/Tarefa';
import { projetoService } from '../../services/Requisicoes/projetoService';
import { infoProjeto } from '../../model/infoProjeto';
import { Usuario } from '../../model/Usuario';
import { PerfilService } from '../../services/Requisicoes/perfil.service';
import {CdkDragDrop, DragDropModule, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { Coluna } from '../../model/Coluna';
import { Quadro } from '../../model/Quadro';
import { ActivatedRoute, Router, RouterLink, RouterOutlet } from '@angular/router';
import { BancoDocumentosComponent } from "../banco-documentos/banco-documentos.component";
import { QuadroTarefasComponent } from "../quadro-tarefas/quadro-tarefas.component";

@Component({
  selector: 'app-gestao-projeto',
  standalone: true,
  imports: [ModalTarefa, NgClass, TarefasConteudoComponent, NgFor, NgIf, DragDropModule, RouterLink, RouterOutlet, BancoDocumentosComponent, QuadroTarefasComponent, NgSwitchCase, NgSwitch],
  templateUrl: './gestao-projeto.component.html',
  styleUrl: './gestao-projeto.component.css'
})
export class GestaoProjetoComponent implements OnInit {

  infoProjeto: infoProjeto = {} as infoProjeto;
  usuario: Usuario = {} as Usuario;
  selectedTab: string = 'Quadro de Demandas';

  constructor(
    public modalService: ModalService,
    public projetoService: projetoService,
    private perfilService: PerfilService,
    public router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.infoProjeto = this.projetoService.getInfoProjeto();
  
    this.perfilService.getDadosUsuario().subscribe({
      next: (usuario) => (this.usuario = usuario),
      error: (err) => console.error('Erro ao carregar usuário:', err)
    });
  }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
}