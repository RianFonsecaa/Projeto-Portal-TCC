import { Component } from '@angular/core';
import { TarefaPrioridadeService } from '../../modais/modal-tarefa/model/TarefaPrioridade.service';
import { DropdownService } from '../../../services/dropdown.service';
import { NgClass, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-dropdown-prioridade',
  standalone: true,
  imports: [NgClass, NgFor, NgIf],
  templateUrl: './dropdown-prioridade.component.html',
})
export class DropdownPrioridadeComponent {

  prioridades = this.prioridadeService.getPrioridades();
  prioridadeSelecionada = this.prioridadeService.getPrioridadeSelecionada();

  constructor(public prioridadeService: TarefaPrioridadeService, public dropdownService: DropdownService) {}

  selecionarPrioridade(valor: string) {
    this.prioridadeService.selecionarPrioridade(valor);
    this.dropdownService.toggle('dropdown-prioridade');
  }

  getPrioridadeSelecionada(): string {
    const key = this.prioridadeSelecionada();
    const prioridadeEncontrada = this.prioridades.find(([k]) => k === key);
    return prioridadeEncontrada ? prioridadeEncontrada[1] : '';
  }
}
