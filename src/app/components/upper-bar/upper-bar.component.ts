import { CommonModule } from '@angular/common'; // Adicione essa importação
import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

interface Mensagem {
  nome: String;
  tituloMensagem: string;
  temaTcc: string;
  dataRecebimento: Date;
}

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgFor, CommonModule], // Adicione o CommonModule aqui
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  isModalOpen: boolean = false;
  iconColor: string = '#515151';

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
    document.body.classList.add('no-scroll');
  }

  closeModal() {
    this.isModalOpen = false;
    document.body.classList.remove('no-scroll');
  }

  mensagens: Mensagem[] = [
    {
      nome: 'Clark Kent',
      tituloMensagem: 'Nova Notificação',
      temaTcc: 'Implementação de Assistentes Virtuais com IA',
      dataRecebimento: new Date('2024-11-26T10:00:00')
    },
    {
      nome: 'Bruce Wayne',
      tituloMensagem: 'Tarefa Pendentes',
      temaTcc: 'Plataforma Gamificada para Ensino de Lógica',
      dataRecebimento: new Date('2024-11-26T14:30:00')
    },
    {
      nome: 'Diana Prince',
      tituloMensagem: 'Atualização Importante',
      temaTcc: 'Desenvolvimento de Sistemas de Saúde',
      dataRecebimento: new Date('2024-11-24T16:45:00')
    }
  ];
}
