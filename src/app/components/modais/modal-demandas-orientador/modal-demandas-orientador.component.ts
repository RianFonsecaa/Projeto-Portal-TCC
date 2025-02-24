import { Component, ViewChild } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-modal-demandas-orientador',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, FormsModule],
  templateUrl: './modal-demandas-orientador.component.html',
})
export class ModalDemandasOrientador {
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

}
