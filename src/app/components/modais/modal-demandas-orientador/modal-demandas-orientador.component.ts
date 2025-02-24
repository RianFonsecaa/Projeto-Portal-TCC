import { Component, ViewChild } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';
import { NgIf, NgFor } from '@angular/common';

@Component({
  selector: 'app-modal-demandas-orientador',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, FormsModule, NgFor, NgIf],
  templateUrl: './modal-demandas-orientador.component.html',
})
export class ModalDemandasOrientador {
  nomesDisponiveis = [
    { nome: 'Pesquisa', selected: false },
    { nome: 'Desenvolvimento', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
    { nome: 'Leitura', selected: false },
  ];

  dropdownVisible: boolean = false;
  isRotated: boolean = false; // Variável para controlar a rotação
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
  ) {}

  fecharModal() {
    this.modalService.fechar('modalDemandasOrientador');
  }

  abrirModal(nomeModal: string) {
    this.modalService.abrir(nomeModal);
  }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
    this.isRotated = !this.isRotated; // Alterna a rotação do ícone
  }

  updateLista() {
    this.nomesSelecionados = this.nomesDisponiveis
      .filter(nome => nome.selected)
      .map(nome => nome.nome);
  }
}
