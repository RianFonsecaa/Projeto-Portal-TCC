import { DatePipe, NgClass, NgFor, NgIf, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ThemeService } from '../../service/theme.service';
import { BaseModalComponent } from '../modais/base-modal/base-modal.component';
import { Notificacao } from '../../model/Notificacao';


@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgClass, NgFor, BaseModalComponent, DatePipe],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  @ViewChild(BaseModalComponent) modal!: BaseModalComponent;
  darkLogo: String = '../../../assets/img/Portal TCC Logo- DarkMode (1).png';
  lightLogo: String = '../../../assets/img/Portal TCC Logo- LightMode.png';
  iconBellWhite: String = '../../../assets/img/icons8-bell-50.png';
  iconBellGrey: String = '../../../assets/img/icons8-bell-50-grey.png';
  selectedTab: string = 'Dashboard';

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  constructor(public themeService: ThemeService, private router: Router) { }

  toggleDarkMode() {
    this.themeService.toggleDarkMode();
  }
  Logout() {
    localStorage.clear;
    this.router.navigate(['/login'])
  }

  openModal() {
    this.modal.openModal();
  }

  closeModal() {
    this.modal.closeModal();
  }

  visualizarNotificacao(notificacao: Notificacao) {
    notificacao.visualizado = true;
  }

  notificacoes: Notificacao[] = [
    {
      remetente: 'Jhon Doe',
      mensagem: 'Atualizou o status da tarefa “Pesquisa de referencial teórico e metodologia”. Confira no quadro Kanban.',
      data: new Date('2024-11-26T14:30:00'),
      visualizado: false
    },
    {
      remetente: 'Clark Kent',
      mensagem: 'Enviou a primeira versão do TCC "Implementação de Assistentes Virtuais com IA" para revisão.',
      data: new Date('2024-11-26T09:15:00'),
      visualizado: true
    },
    {
      remetente: 'Bruce Wayne',
      mensagem: 'Atualizou o status da tarefa “Análise de ferramentas para plataforma gamificada”. Verifique no Kanban.',
      data: new Date('2024-11-24T18:45:00'),
      visualizado: true
    },
    {
      remetente: 'Diana Prince',
      mensagem: 'Atualizou o progresso da tarefa “Introdução e Objetivos” do TCC "Desenvolvimento de Sistemas de Saúde".',
      data: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      remetente: 'Gabriel Moreira',
      mensagem: 'Enviou a versão 2 do TCC “Desenvolvimento de Sistemas de Saúde” para revisão.',
      data: new Date('2024-11-24T18:45:00'),
      visualizado: true
    },
    {
      remetente: 'Jhon Doe',
      mensagem: 'Solicitou reunião para discutir o progresso do TCC “Pesquisa de referencial teórico e metodologia”.',
      data: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      remetente: 'Gabriel Moreira',
      mensagem: 'Atualizou o status da tarefa “Pesquisa e Desenvolvimento de novas funcionalidades” do TCC "Desenvolvimento de Sistemas de Saúde".',
      data: new Date('2024-11-24T18:10:00'),
      visualizado: false
    },
    {
      remetente: 'Gabriel Moreira',
      mensagem: 'Atualizou o status da tarefa “Pesquisa e Desenvolvimento de novas funcionalidades” do TCC "Desenvolvimento de Sistemas de Saúde".',
      data: new Date('2024-11-24T18:10:00'),
      visualizado: false
    },
    {
      remetente: 'Gabriel Moreira',
      mensagem: 'Atualizou o status da tarefa “Pesquisa e Desenvolvimento de novas funcionalidades” do TCC "Desenvolvimento de Sistemas de Saúde".',
      data: new Date('2024-11-24T18:10:00'),
      visualizado: false
    }
  ];

}
