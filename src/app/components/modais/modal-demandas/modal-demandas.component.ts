import { Component, ViewChild } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';
import { NgIf, NgFor } from '@angular/common';

@Component({
  selector: 'app-modal-demandas',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, FormsModule, NgFor, NgIf],
  templateUrl: './modal-demandas.component.html',
})
export class ModalDemandas {
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

  dropdownVisible: boolean = false;
  isRotated: boolean = false;
  nomesSelecionados: string[] = [];

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
    private fb: FormBuilder
  ) { }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
    this.isRotated = !this.isRotated;
  }

  updateLista() {
    this.nomesSelecionados = this.classificacoesDemanda
      .filter(nome => nome.selected)
      .map(nome => nome.nome);
  }
}
