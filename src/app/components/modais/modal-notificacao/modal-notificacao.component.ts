import { Component, Input } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { ThemeService } from '../../../services/theme.service';
import { Notificacao } from '../../../model/Notificacao';

@Component({
  selector: 'app-modal-notificacao',
  standalone: true,
  imports: [NgClass, NgIf, NgFor],
  templateUrl: './modal-notificacao.component.html',
})
export class ModalNotificacaoComponent {
  @Input() notificacoes: Notificacao[] = []
  selectedTab: string = 'Dashboard';

  constructor(public modalService: ModalService, public themeService: ThemeService) {}
  
  selectTab(tab: string) {
    this.selectedTab = tab;
  }
  
}
