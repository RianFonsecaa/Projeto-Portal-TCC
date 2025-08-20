import { Component, ViewChild, OnInit, OnDestroy } from '@angular/core';
import { Usuario } from './../../model/Usuario';
import { NgClass, NgIf, CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ThemeService } from '../../services/theme.service';
import { ModalService } from '../../services/modal.service';
import { ModalNotificacaoComponent } from '../modais/modal-notificacao/modal-notificacao.component';
import { ModalPerfilOrientadorComponent } from "../modais/modal-perfil-orientador/modal-perfil-orientador.component";
import { PerfilService } from '../../services/Requisicoes/perfil.service';
import { ModalPerfilOrientandoComponent } from '../modais/modal-perfil-orientando/modal-perfil-orientando.component';
import { DropdownComponent } from "../dropdown/dropdown.component";
import { MensagensService } from '../../services/Requisicoes/mensagens.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-upper-bar',
  standalone: true,
  imports: [
    RouterLink,
    NgClass,
    ModalNotificacaoComponent,
    ModalPerfilOrientadorComponent,
    ModalPerfilOrientandoComponent,
    NgIf,
    DropdownComponent
  ],
  templateUrl: './upper-bar.component.html'
})
export class UpperBarComponent implements OnInit, OnDestroy {
  darkLogo = '../../../assets/img/Portal TCC Logo- DarkMode (1).png';
  lightLogo = '../../../assets/img/Portal TCC Logo- LightMode.png';

  iconBellWhite = '../../../assets/img/icons8-bell-50.png';
  iconBellGrey = '../../../assets/img/icons8-bell-50-grey.png';

  usuario: Usuario = {} as Usuario;
  tipoPerfilModal = '';
  quantidadeNaoLidas = 0;
  private notificacoesSubscription!: Subscription;

  @ViewChild(DropdownComponent) dropdown!: DropdownComponent;

  constructor(
    public themeService: ThemeService,
    public modalService: ModalService,
    private perfilService: PerfilService,
    private router: Router,
    private mensagensService: MensagensService
  ) {}

  ngOnInit(): void {
    this.carregarDadosUsuario();
    this.inscreverParaAtualizacoes();
    this.atualizarNotificacoes();
  }

  ngOnDestroy(): void {
    if (this.notificacoesSubscription) {
      this.notificacoesSubscription.unsubscribe();
    }
  }

  private carregarDadosUsuario(): void {
    this.perfilService.getDadosUsuario().subscribe({
      next: (usuario) => {
        this.usuario = usuario;
        this.tipoPerfilModal = usuario.tipoUsuario === 'ORIENTADOR'
          ? 'modalPerfilOrientador'
          : 'modalPerfilOrientando';
      },
      error: (err) => console.error('Erro ao carregar usuário:', err)
    });
  }

  private inscreverParaAtualizacoes(): void {
    this.notificacoesSubscription = this.mensagensService.notificacoesAtualizadas$.subscribe({
      next: () => this.atualizarContador(),
      error: (err) => console.error('Erro ao receber atualizações:', err)
    });
  }

  atualizarNotificacoes(): void {
    this.mensagensService.atualizarNotificacoes();
    this.atualizarContador();
  }

  private atualizarContador(): void {
    this.mensagensService.buscarQuantidadeNaoVisualizadas().subscribe({
      next: (quantidade) => {
        this.quantidadeNaoLidas = quantidade;
      },
      error: (err) => {
        console.error('Erro ao buscar quantidade de não lidas:', err);
        this.quantidadeNaoLidas = 0;
      }
    });
  }

  toggleDarkMode(): void {
    this.themeService.toggleDarkMode();
  }

  abrirDropdown(): void {
    this.dropdown.abrir();
  }
  navegarParaDashboard(): void {
    const rota = this.usuario.tipoUsuario === 'ORIENTADOR' ? 'dashboardOrientador' : 'dashboardOrientando';
    this.router.navigate(['/home', { outlets: { dashboard: [rota]} } ]);
  }
}
