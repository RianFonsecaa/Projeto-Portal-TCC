import { DatePipe, NgClass, NgFor, NgIf, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ThemeService } from '../../services/theme.service';
import { Notificacao } from '../../model/Notificacao';
import { ModalService } from '../../services/modal.service';
import { ModalNotificacaoComponent } from '../modais/modal-notificacao/modal-notificacao.component';
import { ModalPerfilOrientadorComponent } from "../modais/modal-perfil-orientador/modal-perfil-orientador.component";
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../../model/Usuario';


@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgIf, NgClass, NgFor, DatePipe, ModalNotificacaoComponent, ModalPerfilOrientadorComponent],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  darkLogo: String = '../../../assets/img/Portal TCC Logo- DarkMode (1).png';
  lightLogo: String = '../../../assets/img/Portal TCC Logo- LightMode.png';
  iconBellWhite: String = '../../../assets/img/icons8-bell-50.png';
  iconBellGrey: String = '../../../assets/img/icons8-bell-50-grey.png';
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

  constructor(public themeService: ThemeService, public modalService: ModalService, private router: Router,  private http: HttpClient) { }
  usuario!: Usuario;
  ngOnInit(): void {

    const idUsuario = localStorage.getItem('idUsuario');

    if (idUsuario) {
      this.http.get<Usuario>(`http://127.0.0.1:8080/api/usuarios/${idUsuario}`)
        .subscribe({
          next: (response) => {
            this.usuario = response;
            console.log("Dados do usuário:", this.usuario);
          },
          error: (error) => console.error("Erro ao buscar usuário:", error)
        });
    } else {
      console.warn("Nenhum idUsuario encontrado no localStorage.");
    }
  }

  Logout() {
    localStorage.clear;
    this.router.navigate(['/login'])
  }

  toggleDarkMode() {
    this.themeService.toggleDarkMode();
  }

  abrirModal(nomeModal: string) {
    this.modalService.abrir(nomeModal);
  }


}
