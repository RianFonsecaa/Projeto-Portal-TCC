import { Component, OnInit, OnDestroy } from '@angular/core';
import { MensagensService } from '../../services/Requisicoes/mensagens.service';
import { Notificacao } from '../../model/Notificacao';
import { CommonModule } from '@angular/common';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-mensagens',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mensagens.component.html',
})
export class MensagensComponent implements OnInit, OnDestroy {
  notificacoes: Notificacao[] = [];
  filteredNotificacoes: Notificacao[] = [];
  selectedTab: string = 'Tudo';
  notificacaoSelecionada: Notificacao | null = null;
  isLoading = true;
  errorMessage = '';
  private notificacoesSubscription!: Subscription;

  constructor(
    private mensagensService: MensagensService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarNotificacoes();
    this.buscarNotificacoes();
  }

  private verificarNotificacaoNaRota(): void {
    const notificationId = this.route.snapshot.queryParams['notificationId'] ||
                         (this.router.getCurrentNavigation()?.extras.state as any)?.selectedMessageId;

    if (notificationId) {
      this.selecionarNotificacaoPorId(Number(notificationId));
    }
  }

  private selecionarNotificacaoPorId(id: number): void {
    const notificacao = this.notificacoes.find(n => n.id === id);
    if (notificacao) {
      this.notificacaoSelecionada = notificacao;
      this.marcarComoLida(notificacao);
    }
  }

  ngOnDestroy(): void {
    if (this.notificacoesSubscription) {
      this.notificacoesSubscription.unsubscribe();
    }
  }

  carregarNotificacoes(): void {
    this.isLoading = true;
    this.errorMessage = '';

    this.mensagensService.obterNotificacoes().subscribe({
      next: (notificacoes) => {
        this.notificacoes = notificacoes;
        this.filtrarNotificacoes();
        this.isLoading = false;

        // Verifica se há notificação na rota após carregar
        this.verificarNotificacaoNaRota();

        // Se não houver notificação selecionada, seleciona a primeira
        if (!this.notificacaoSelecionada && this.filteredNotificacoes.length > 0) {
          this.notificacaoSelecionada = this.filteredNotificacoes[0];
        }
      },
      error: (err) => {
        console.error('Erro ao carregar notificações:', err);
        this.errorMessage = 'Não foi possível carregar as notificações';
        this.isLoading = false;
      }
    });
  }

  buscarNotificacoes(): void {
    this.notificacoesSubscription = this.mensagensService.notificacoesAtualizadas$.subscribe({
      next: (notificacoes) => {
        this.notificacoes = notificacoes;
        this.filtrarNotificacoes();

        // Mantém a seleção atualizada
        if (this.notificacaoSelecionada) {
          const updatedNotification = this.notificacoes.find(n => n.id === this.notificacaoSelecionada?.id);
          if (updatedNotification) {
            this.notificacaoSelecionada = updatedNotification;
          }
        }
      },
      error: (err) => {
        console.error('Erro ao receber atualizações:', err);
      }
    });
  }

  filtrarNotificacoes(): void {
    this.filteredNotificacoes = this.selectedTab === 'Não lidas'
      ? this.notificacoes.filter(n => !n.visualizado)
      : [...this.notificacoes];
  }

  selectTab(tab: string): void {
    this.selectedTab = tab;
    this.filtrarNotificacoes();

    if (this.filteredNotificacoes.length > 0) {
      this.selecionarNotificacao(this.filteredNotificacoes[0]);
    } else {
      this.notificacaoSelecionada = null;
    }
  }

  selecionarNotificacao(notificacao: Notificacao): void {
    this.notificacaoSelecionada = notificacao;
    this.marcarComoLida(notificacao);
    this.atualizarNotificacoes()

    this.router.navigate([], {
      queryParams: { notificationId: notificacao.id },
      queryParamsHandling: 'merge'
    });
  }

  marcarComoLida(notificacao: Notificacao): void {
    if (!notificacao.visualizado) {
      this.mensagensService.marcarComoLida(notificacao.id).subscribe({
        next: () => {
          notificacao.visualizado = true;
          this.filtrarNotificacoes();
        },
        error: (err) => {
          console.error('Erro ao marcar como lida:', err);
        }
      });
    }
  }

  atualizarNotificacoes(): void {
    this.mensagensService.atualizarNotificacoes();
  }

  formatarData(date: Date | string): string {
    const dateObj = typeof date === 'string' ? new Date(date) : date;
    return dateObj.toLocaleDateString('pt-BR');
  }

  formatarHora(date: Date | string): string {
    const dateObj = typeof date === 'string' ? new Date(date) : date;
    return dateObj.toLocaleTimeString('pt-BR', { hour: '2-digit', minute: '2-digit' });
  }
}
