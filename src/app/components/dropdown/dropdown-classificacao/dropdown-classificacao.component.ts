import { Component, computed, inject, Signal, signal } from '@angular/core';
import { DropdownService } from '../../../services/dropdown.service';
import { TarefaClassificacaoService } from '../../modais/modal-tarefa/model/TarefaClassificacoes.service';
import { NgClass, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-dropdown-classificacao',
  standalone: true,
  imports: [NgClass, NgFor, NgIf],
  templateUrl: './dropdown-classificacao.component.html',
})
export class DropdownClassificacaoComponent {
  classificacoes = this.classificacaoService.getClassificacoes();
  classificacaoSelecionada = this.classificacaoService.getClassificacaoSelecionada();

  constructor(
    public classificacaoService: TarefaClassificacaoService,
    public dropdownService: DropdownService
  ) {}

  selecionarClassificacao(valor: string) {
    this.classificacaoService.selecionarClassificacao(valor);
    this.dropdownService.toggle('dropdown-classificacao');
  }

  getClassificacaoSelecionada(): string {
    const key = this.classificacaoSelecionada();
    const classificacaoEncontrada = this.classificacoes.find(([k]) => k === key);
    return classificacaoEncontrada ? classificacaoEncontrada[1] : '';
  }
}