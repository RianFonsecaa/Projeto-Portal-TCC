import { CommonModule } from '@angular/common';
import { NgFor, NgIf } from '@angular/common';
import { Component, Renderer2, ViewChild } from '@angular/core';
import { RouterLink } from '@angular/router';
import { BaseModalComponent } from '../modais/base-modal/base-modal.component';
import { Notificacao } from '../../model/Notificacao';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgFor, CommonModule, BaseModalComponent],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  iconColor: string = '#515151';
  @ViewChild(BaseModalComponent) modal!: BaseModalComponent;

  constructor() { } // Injetando Renderer2

  toggleTheme(toggleButton: HTMLElement) {
    if (toggleButton.classList.contains('translate-x-10')) {
      toggleButton.classList.remove('translate-x-10');
      toggleButton.classList.add('translate-x-0');
      this.iconColor = '#515151';
    } else {
      toggleButton.classList.remove('translate-x-0');
      toggleButton.classList.add('translate-x-10');
      this.iconColor = '#61B668';
    }
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
