import { Usuario } from './../../model/Usuario';
import { DatePipe, NgClass, NgFor, NgIf, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ThemeService } from '../../services/theme.service';
import { Notificacao } from '../../model/Notificacao';
import { ModalService } from '../../services/modal.service';
import { ModalNotificacaoComponent } from '../modais/modal-notificacao/modal-notificacao.component';
import { ModalPerfilOrientadorComponent } from "../modais/modal-perfil-orientador/modal-perfil-orientador.component";
import { HttpClient } from '@angular/common/http';
import { PerfilService } from '../../services/Requisicoes/perfil.service';
import { ModalPerfilOrientandoComponent } from '../modais/modal-perfil-orientando/modal-perfil-orientando.component';
import { DropdownComponent } from "../dropdown/dropdown.component";


@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [RouterLink, NgClass, ModalNotificacaoComponent, ModalPerfilOrientadorComponent, ModalPerfilOrientandoComponent, NgIf, DropdownComponent],
  templateUrl: './upper-bar.component.html',
})
export class UpperBarComponent {
  darkLogo: String = '../../../assets/img/Portal TCC Logo- DarkMode (1).png';
  lightLogo: String = '../../../assets/img/Portal TCC Logo- LightMode.png';

  iconBellWhite: String = '../../../assets/img/icons8-bell-50.png';
  iconBellGrey: String = '../../../assets/img/icons8-bell-50-grey.png';

  usuario: Usuario = {} as Usuario;
  tipoPerfilModal: string = '';
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

  @ViewChild(DropdownComponent) dropdown: DropdownComponent = {} as DropdownComponent;

  constructor(public themeService: ThemeService, public modalService: ModalService, private PerfilService: PerfilService, private router: Router) { }

  ngOnInit(): void {
    this.PerfilService.getDadosUsuario().subscribe({
      next: (response) => {
        this.usuario = response;
        if(response.tipoUsuario == 'ORIENTADOR'){
          this.tipoPerfilModal = 'modalPerfilOrientador'
        } else if(response.tipoUsuario == 'ORIENTANDO'){
          this.tipoPerfilModal = 'modalPerfilOrientando'
        }
      },
      error: (err) => {
        console.error('Erro ao buscar dados do usuário:', err);
      },
    });
  }

  toggleDarkMode(): void {
    this.themeService.toggleDarkMode();
  }

  abrirDropdown(){
    this.dropdown.abrir();
  }

  navegarParaDashboard(): void {
    const rota = this.usuario.tipoUsuario === 'ORIENTADOR' ? 'dashboardOrientador' : 'dashboardOrientando';
    this.router.navigate(['/home', { outlets: { dashboard: [rota]} } ]);
  }

}
