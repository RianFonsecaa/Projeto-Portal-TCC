import { Component } from '@angular/core';
import { DropdownService } from '../../../services/dropdown.service';
import { TarefaEtapaService } from '../../modais/modal-tarefa/model/TarefaEtapa.service';
import { NgClass, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-dropdown-etapa',
  standalone: true,
  imports: [NgClass, NgFor, NgIf],
  templateUrl: './dropdown-etapa.component.html',
})
export class DropdownEtapaComponent {

  etapas = this.etapaService.getEtapas();
  etapaSelecionada = this.etapaService.getEtapaSelecionada();

  constructor(public etapaService: TarefaEtapaService, public dropdownService: DropdownService){}

  selecionarEtapa(valor: string) {
    this.etapaService.selecionarEtapa(valor);
    this.dropdownService.toggle('dropdown-etapa');
  }

  getEtapaSelecionada(): string {
    const key = this.etapaSelecionada();
    const classificacaoEncontrada = this.etapas.find(([k]) => k === key);
    return classificacaoEncontrada ? classificacaoEncontrada[1] : '';
  }
}