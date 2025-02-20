import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { ThemeService } from '../../service/theme.service';

@Component({
  selector: 'app-dashboard-aluno',
  standalone: true,
  imports: [NgClass,],
  templateUrl: './dashboard-aluno.component.html',
})
export class DashboardAlunoComponent {
  selectedTab: string = 'Quadro de Demandas';

  constructor(public themeService: ThemeService) {

  }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
}
