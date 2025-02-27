import { Component, EventEmitter, Output } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, FormsModule, FormGroup } from '@angular/forms';
import { NgIf, NgFor } from '@angular/common';
import { Route } from '@angular/router';
import { TarefasService } from '../../../services/Requisicoes/tarefas.service';
import { Tarefa } from '../../../model/tarefas';

@Component({
  selector: 'app-modal-tarefa',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, FormsModule, NgFor, NgIf],
  templateUrl: './modal-tarefa.component.html',
})
export class ModalTarefa {
  mensagem: string | null = null;

  classificacoesDemanda = [
    { nome: 'Bibliografia', selected: false },
    { nome: 'Redação', selected: false },
    { nome: 'Desenvolvimento', selected: false },
    { nome: 'Manutenção', selected: false },
    { nome: 'Pesquisa', selected: false },
    { nome: 'Estudo', selected: false },
    { nome: 'Planejamento', selected: false },
    { nome: 'Revisão', selected: false },
    { nome: 'Documentação', selected: false },
    { nome: 'Apresentação', selected: false }
  ];

  tarefa: Tarefa ={
    id:0,
    orientadorId: 0,
    orientandoId: 0,
    projetoId: 0,
    idDocumento: 0,
    nomeTarefa: '',
    descricao: '',
    dataEnvio: '',
    status: '',
    prioridade: '',
    classificacao: [] =[],
    prazo: ''
  };

  dropdownVisible: boolean = false;
  isRotated: boolean = false;
  classificacoes: string[] = [];

  demandasOrientador = {
    titulo: '',
    descricao: '',
    prioridade: '',
    status: '',
    classificacao: [] = [],
    prazo: ''
  };

  constructor(
    public modalService: ModalService,
    public themeService: ThemeService,
    private fb: FormBuilder,
    private tarefaService : TarefasService
  ) { }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
    this.isRotated = !this.isRotated;
  }

  updateLista() {
    this.classificacoes = this.classificacoesDemanda
      .filter(nome => nome.selected)
      .map(nome => nome.nome);

      this.tarefa.classificacao = this.classificacoesDemanda
      .filter(nome => nome.selected)
      .map(nome => nome.nome);
  }

  salvarTarefa(){
    this.tarefaService.adicionarTarefa(this.tarefa).subscribe({
      next: (res) => {
        this.mensagem = "Tarefa salva com sucesso!";
        console.log("Tarefa salva:", res);
      },
      error: (err) => {
        this.mensagem = "Erro ao salvar a tarefa!";
        console.error("Erro:", err);
      }
    });
  }
}
