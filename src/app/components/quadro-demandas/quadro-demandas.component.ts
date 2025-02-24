import { Component } from '@angular/core';
import { ThemeService } from '../../services/theme.service';
import { ModalService } from '../../services/modal.service';
import { ModalDemandasOrientador } from '../modais/modal-demandas-orientador/modal-demandas-orientador.component';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalDemandasOrientador],
  templateUrl: './quadro-demandas.component.html',
})
export class QuadroDemandasComponent {
  constructor(public themeService: ThemeService, public modalService: ModalService) {

  }

  abrirModal(nomeModal: string) {
    this.modalService.abrir(nomeModal);
  }
}
