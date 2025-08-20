import { Component, Input, OnDestroy } from '@angular/core';
import { ModalService } from '../../../services/modal.service';
import { NgClass, NgFor, NgIf } from '@angular/common';
import { ThemeService } from '../../../services/theme.service';
import { Notificacao } from '../../../model/Notificacao';
import { MensagensService } from '../../../services/Requisicoes/mensagens.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modal-notificacao',
  standalone: true,
  imports: [NgClass, NgIf, NgFor],
  templateUrl: './modal-notificacao.component.html',
})
export class ModalNotificacaoComponent implements OnDestroy {
  @Input() notificacoes: Notificacao[] = [];
  filteredNotificacoes: Notificacao[] = [];
  selectedTab: string = 'Tudo';
  isLoading = false;
  errorMessage = '';
  private notificacaoSubscription!: Subscription;

  constructor(
    public mensagensService: MensagensService,
    public modalService: ModalService,
    public themeService: ThemeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarNotificacoes();
    this.buscarNotificacoes();
  }

  ngOnDestroy(): void {
    if (this.notificacaoSubscription) {
      this.notificacaoSubscription.unsubscribe();
    }
  }

  buscarNotificacoes(): void {
    this.notificacaoSubscription = this.mensagensService.notificacoesAtualizadas$.subscribe({
      next: (notificacoes) => {
        this.notificacoes = notificacoes;
        this.filtrarNotificacoes();
      },
      error: (err) => {
        console.error('Erro ao receber atualização', err);
      }
    });
  }

  carregarNotificacoes(): void {
    this.isLoading = true;
    this.errorMessage = '';

    this.mensagensService.obterNotificacoes().subscribe({
      next: (notificacoes) => {
        this.notificacoes = notificacoes;
        this.filtrarNotificacoes();
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Erro ao buscar notificações', err);
        this.errorMessage = 'Não foi possível carregar as notificações';
        this.isLoading = false;
      }
    });
  }

  filtrarNotificacoes(): void {
    if (this.selectedTab === 'Não lidas') {
      this.filteredNotificacoes = this.notificacoes.filter(n => !n.visualizado);
    } else {
      this.filteredNotificacoes = [...this.notificacoes];
    }
  }

  selecionarAba(tab: string): void {
    this.selectedTab = tab;
    this.filtrarNotificacoes();
  }

  abrirNotificacao(notificacao: Notificacao): void {
    if (!notificacao.visualizado) {
      this.mensagensService.marcarComoLida(notificacao.id).subscribe({
        next: () => {
          notificacao.visualizado = true;
          this.filtrarNotificacoes();
          this.mensagensService.atualizarNotificacoes();
          this.navegarParaMensagem(notificacao.id);
        },
        error: (err) => {
          console.error('Erro ao marcar como lida', err);
          this.navegarParaMensagem(notificacao.id);
        }
      });
    } else {
      this.navegarParaMensagem(notificacao.id);
    }
  }

  private navegarParaMensagem(notificacaoId: number): void {
    this.modalService.fechar('modalNotificacao');
    this.router.navigate(['/home', { outlets: { dashboard: ['mensagens'] } }], {
      state: { selectedMessageId: notificacaoId },
      queryParams: { notificationId: notificacaoId }
    });
  }

  atualizarNotificacoes(): void {
    this.carregarNotificacoes();
  }

  formatarData(date: Date | string): string {
    const dateObj = typeof date === 'string' ? new Date(date) : date;
    return dateObj.toLocaleDateString('pt-BR');
  }

  FormatarHora(date: Date | string): string {
    const dateObj = typeof date === 'string' ? new Date(date) : date;
    return dateObj.toLocaleTimeString('pt-BR', { hour: '2-digit', minute: '2-digit' });
  }
}
