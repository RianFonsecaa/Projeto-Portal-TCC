import { NgClass, NgFor } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { DemandasService } from '../../services/demandas.service';
import { ActivatedRoute } from '@angular/router';
import { Demanda } from '../../model/AlunoDemanda';
import { Subscription } from 'rxjs';
import { TarefasConteudoComponent } from '../../components/tarefas-conteudo/tarefas-conteudo.component';
import { TarefasService } from '../../services/Requisicoes/tarefas.service';


@Component({
  selector: 'app-dashboard-aluno',
  standalone: true,
  imports: [NgClass, NgFor, TarefasConteudoComponent],
  templateUrl: './dashboard-aluno.component.html',
})
export class DashboardAlunoComponent implements OnInit, OnDestroy {
  demandasPendentes: Demanda[] = [];
  demandasEmAndamento: Demanda[] = [];
  demandasConcluidas: Demanda[] = [];
  demandas: Demanda[] = [];
  alunoId: number = 0;
  projetoId: number = 0;

  selectedTab: string = 'Quadro de Demandas';
  private routeSubscription!: Subscription;

  novaDemanda: Demanda = {
    id: 0,
    nomeTarefa: '',
    descricao: '',
    prazo: new Date(),
    prioridade: 'MEDIA',
    status: 'pendente',
    alunoId: this.alunoId
  };

  constructor(
    private demandaService: DemandasService,
    private route: ActivatedRoute,
    private tarefasService: TarefasService
  ) {}

  selectTab(tab: string) {
    this.selectedTab = tab;
  }

  ngOnInit(): void {
    this.routeSubscription = this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.projetoId = +id;
        this.carregarDemandas();
      }
    });

    //Requisição utlizando o service de tarefas
    // this.tarefasService.getTarefasPorProjeto(idProjeto).subscribe({
    //   next: (tarefas) => {
    //     console.log('Tarefas do projeto:', tarefas);
    //   },
    //   error: (err) => {
    //     console.error('Erro ao buscar tarefas:', err);
    //   },
    //   complete: () => {
    //     console.log('Requisição concluída.');
    //   }
    // });
  }

  carregarDemandas(): void {
    if (this.projetoId) {
      this.demandaService.getDemandasPorIdProjeto(this.projetoId).subscribe(demandas => {
        this.demandas = demandas;
        this.demandasPendentes = demandas.filter(d => d.status === 'PENDENTE');
        this.demandasEmAndamento = demandas.filter(d => d.status === 'ANDAMENTO');
        this.demandasConcluidas = demandas.filter(d => d.status === 'CONCLUIDA');
      });
    }
  }

  adicionarNovaDemanda(): void {
    if (this.novaDemanda.nomeTarefa && this.novaDemanda.descricao) {
      this.novaDemanda.alunoId = this.alunoId;
      this.demandaService.adicionarDemanda(this.novaDemanda).subscribe(() => {
        this.carregarDemandas();
        this.novaDemanda = {
          id: 0,
          nomeTarefa: '',
          descricao: '',
          prazo: new Date(),
          prioridade: 'MEDIA',
          status: 'PENDENTE',
          alunoId: this.alunoId
        };
      });
    } else {
      alert('Preencha todos os campos!');
    }
  }

  ngOnDestroy(): void {
    this.routeSubscription.unsubscribe();
  }
}
