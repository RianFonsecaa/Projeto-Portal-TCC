import { Component, ViewChild } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { ThemeService } from '../../../services/theme.service';
import { NgClass } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, FormsModule, Validators } from '@angular/forms';
import { MultiSelectComponent } from '../../multi-select/multi-select.component';
import { SingleSelectComponent } from '../../single-select/single-select.component';

@Component({
  selector: 'app-modal-demandas-orientador',
  standalone: true,
  imports: [NgClass, ReactiveFormsModule, MultiSelectComponent, SingleSelectComponent, FormsModule],
  templateUrl: './modal-demandas-orientador.component.html',
})
export class ModalDemandasOrientador {
  demandasOrientador = {
    titulo: '',
    descricao: '',
    prioridade: '',
    status: '',
    classificacao: '',
    prazo: ''
  };

  isDisabled: boolean = true;
  perfilForm: FormGroup;
  selecionadosClassificacao: string[] = [];
  selecionadosPrioridade: string[] = [];
  selecionadosStatus: string[] = [];

  classificacoes = [
    { name: 'Desenvolvimento', selected: false },
    { name: 'Pesquisa', selected: false },
    { name: 'Escrita', selected: false }
  ];

  prioridades = [
    { name: 'Alta', selected: false },
    { name: 'Média', selected: false },
    { name: 'Baixa', selected: false }
  ];

  status = [
    { name: 'Pendente', selected: false},
    { name: 'Em Andamento', selected: false },
    { name: 'Concluído', selected: false }
  ];

  constructor(
    public modalService: ModalService,
    public themeService: ThemeService,
    private fb: FormBuilder
  ) {
    this.perfilForm = this.fb.group({
      titulo: ['', [Validators.required, Validators.minLength(3)]],
      descricao: ['', [Validators.required, Validators.minLength(10)]],
      prioridade: ['', Validators.required],
      status: ['', Validators.required],
      classificacao: ['', Validators.required],
      prazo: ['', Validators.required]
    });

    this.perfilForm.disable();
  }

  fecharModal() {
    this.modalService.fechar('modalDemandasOrientador');
    this.limparFormulario();
  }

  atualizarSelecionadosClassificacao(itensSelecionados: any[]) {
    this.selecionadosClassificacao = itensSelecionados.map(item => item.name);
    console.log('Itens selecionados (Classificação):', this.selecionadosClassificacao);
  }

  atualizarSelecionadosPrioridade(itensSelecionados: any[]) {
    this.selecionadosPrioridade = itensSelecionados.map(item => item.name);
    console.log('Itens selecionados (Prioridade):', this.selecionadosPrioridade);
  }

  atualizarSelecionadosStatus(itensSelecionados: any[]) {
    this.selecionadosStatus = itensSelecionados.map(item => item.name);
    console.log('Itens selecionados (Status):', this.selecionadosStatus);
  }

  limparFormulario() {
    this.perfilForm.reset();
    this.selecionadosClassificacao = [];
    this.selecionadosPrioridade = [];
    this.selecionadosStatus = [];
    this.perfilForm.reset();

    // Limpa os valores dos single-select manualmente
    this.demandasOrientador.prioridade = '';
    this.demandasOrientador.status = '';
    this.demandasOrientador.classificacao = '';
  }
}
