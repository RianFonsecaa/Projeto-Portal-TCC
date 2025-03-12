import { Component, EventEmitter, Output } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, FormsModule, FormGroup, Validators } from '@angular/forms';
import { NgIf, NgFor } from '@angular/common';
import { Route } from '@angular/router';
import { TarefasService } from '../../../services/Requisicoes/tarefas.service';
import { Tarefa } from '../../../model/Tarefa';
import { infoProjeto } from '../../../model/infoProjeto';

@Component({
  selector: 'app-modal-tarefa',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, FormsModule, NgFor, NgIf],
  templateUrl: './modal-tarefa.component.html',
})
export class ModalTarefa {
  classificacoes = [
    { nome: 'Bibliografia' },
    { nome: 'Redação' },
    { nome: 'Desenvolvimento' },
    { nome: 'Manutenção' },
    { nome: 'Pesquisa' },
    { nome: 'Estudo' },
    { nome: 'Planejamento' },
    { nome: 'Revisão' },
    { nome: 'Documentação' },
    { nome: 'Apresentação' }
  ];

  dropdownVisible: boolean = false;
  isRotated: boolean = false;
  infoProjeto: infoProjeto = {} as infoProjeto;
  tarefaForm: FormGroup;

  constructor(
    public modalService: ModalService,
    public themeService: ThemeService,
    private fb: FormBuilder,
    private tarefaService: TarefasService
  ) {
    this.tarefaForm = this.fb.group({
      nomeTarefa: ['', Validators.required],
      descricao: ['', Validators.required],
      prioridade: ['', Validators.required],
      status: ['', Validators.required],
      classificacao: ['', Validators.required],
      prazo: ['', Validators.required] 
    });

    this.infoProjeto = JSON.parse(localStorage.getItem('infoProjeto') || '{}');
  }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
    this.isRotated = !this.isRotated;
  }

  salvarTarefa() {
    console.log(this.tarefaForm.value);
    const tarefa: Tarefa = this.tarefaForm.value;
    tarefa.projetoId = this.infoProjeto.id;
    this.tarefaService.adicionarTarefa(tarefa);
  }
}