import { Component } from '@angular/core';
import { TarefaStatusService } from '../../modais/modal-tarefa/model/TarefaStatus.service';
import { DropdownService } from '../../../services/dropdown.service';
import { NgClass, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-dropdown-status',
  standalone: true,
  imports: [NgClass, NgFor, NgIf],
  templateUrl: './dropdown-status.component.html',
})
export class DropdownStatusComponent {

  status = this.statusService.getStatus();
  statusSelecionado = this.statusService.getStatusSelecionado();

  constructor(public statusService: TarefaStatusService, public dropdownService: DropdownService) {}

  selecionarStatus(valor: string) {
    this.statusService.selecionarStatus(valor);
    this.dropdownService.toggle('dropdown-status');
  }

  getStatusSelecionado(): string {
    const key = this.statusSelecionado();
    const statusEncontrado = this.status.find(([k]) => k === key);
    return statusEncontrado ? statusEncontrado[1] : '';
  }
}