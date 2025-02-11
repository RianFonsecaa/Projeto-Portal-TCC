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
  lightLogo: String = '../../../assets/img/Portal TCC Logo- LightMode.png'
  constructor(public themeService: ThemeService, private router: Router) { }

  toggleDarkMode() {
    this.themeService.toggleDarkMode();
  }
  
  Logout(){
    localStorage.clear;
    this.router.navigate(['/login']);
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
      quemEnviou: 'Clark Kent',
      tituloNotificacao: 'Nova Notificação',
      temaTcc: 'Implementação de Assistentes Virtuais com IA',
      dataRecebimento: new Date('2024-11-26'),
      horaRecebimento: new Date('2024-11-26T14:30:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Bruce Wayne',
      tituloNotificacao: 'Tarefa Pendentes',
      temaTcc: 'Plataforma Gamificada para Ensino de Lógica',
      dataRecebimento: new Date('2024-11-26'),
      horaRecebimento: new Date('2024-11-26T09:15:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Diana Prince',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      horaRecebimento: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Diana Prince',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      horaRecebimento: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Diana Prince',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      horaRecebimento: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Diana Prince',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      horaRecebimento: new Date('2024-11-24T18:45:00'),
      visualizado: false
    },
    {
      quemEnviou: 'Gabriel Moreira Bispo dos Santos',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      horaRecebimento: new Date('2024-11-24T18:10:00'),
      visualizado: false
    }
  ];

}
