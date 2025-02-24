import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { ThemeService } from '../../services/theme.service';
import { ModalService } from '../../services/modal.service';
import { ModalDemandasOrientador } from '../../components/modais/modal-demandas-orientador/modal-demandas-orientador.component';
import { QuadroDemandasComponent } from '../../components/quadro-demandas/quadro-demandas.component';

@Component({
  selector: 'app-dashboard-aluno',
  standalone: true,
  imports: [NgClass, ModalDemandasOrientador, QuadroDemandasComponent],
  templateUrl: './dashboard-aluno.component.html',
})
export class DashboardAlunoComponent {
  selectedTab: string = 'Quadro de Demandas';

  constructor(public themeService: ThemeService, public modalService: ModalService) {

  }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  abrirModal(nomeModal: string) {
    this.modalService.abrir(nomeModal);
  }
}
