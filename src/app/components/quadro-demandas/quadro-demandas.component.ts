import { Component } from '@angular/core';
import { ThemeService } from '../../services/theme.service';
import { ModalService } from '../../services/modal.service';
import { ModalDemandas } from '../modais/modal-demandas/modal-demandas.component';

@Component({
  selector: 'app-quadro-demandas',
  standalone: true,
  imports: [ModalDemandas],
  templateUrl: './quadro-demandas.component.html',
})
export class QuadroDemandasComponent {
  constructor(public themeService: ThemeService, public modalService: ModalService) {

  }
}
