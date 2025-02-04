import { CommonModule } from '@angular/common';
import { NgFor, NgIf } from '@angular/common';
import { Component, Renderer2 } from '@angular/core';
import { RouterLink } from '@angular/router';
import { TccNotificacao } from '../../model/TccNotificacao';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgFor, CommonModule],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  isModalOpen: boolean = false;
  iconColor: string = '#515151';

  constructor(private renderer: Renderer2) {} // Injetando Renderer2

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
    this.isModalOpen = true;
    this.renderer.addClass(document.body, 'overflow-hidden'); // Adicionando classe ao body
  }

  closeModal() {
    this.isModalOpen = false;
    this.renderer.removeClass(document.body, 'overflow-hidden'); // Removendo classe ao fechar modal
  }

  notificacoes: TccNotificacao[] = [
    {
      quemEnviou: 'Clark Kent',
      tituloNotificacao: 'Nova Notificação',
      temaTcc: 'Implementação de Assistentes Virtuais com IA',
      dataRecebimento: new Date('2024-11-26'),
      visualizado: true
    },
    {
      quemEnviou: 'Bruce Wayne',
      tituloNotificacao: 'Tarefa Pendentes',
      temaTcc: 'Plataforma Gamificada para Ensino de Lógica',
      dataRecebimento: new Date('2024-11-26'),
      visualizado: false
    },
    {
      quemEnviou: 'Diana Prince',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      visualizado: true
    },
    {
      quemEnviou: 'Gabriel Moreira Bispo dos Santos',
      tituloNotificacao: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24'),
      visualizado: false
    }
  ];
}
