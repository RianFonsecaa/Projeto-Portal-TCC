import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Etapa } from '../../model/Etapa';
import { Tarefa } from '../../model/Tarefa';
import { TarefasService } from '../../services/Requisicoes/tarefas.service'

@Component({
  selector: 'app-etapas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './etapas.component.html',
  styleUrls: ['./etapas.component.css']
})
export class EtapasComponent implements OnInit {
  etapasComTarefas: Etapa[] = [];
  timelineDays: Date[] = [];
  timelineMonths: any[] = [];

  today = new Date();
  cellWidth = 32;
  rowHeight = 40;
  taskNameColumnWidth = 200;

  chartStartDate: Date;
  chartEndDate: Date;

constructor(private tarefasService: TarefasService) {
  this.chartStartDate = new Date();
  this.chartEndDate = new Date(); // valor inicial apenas

  this.definirIntervaloDoGrafico();
}

private definirIntervaloDoGrafico(): void {
  this.tarefasService.tarefas$.subscribe(tarefas => {
    if (tarefas.length > 0) {
      // Encontrar a tarefa com a maior dataFim
      const ultimaDataFim = tarefas
        .map(t => new Date(t.dataFim))
        .reduce((max, curr) => (curr > max ? curr : max));

      this.chartEndDate = new Date(ultimaDataFim);
      this.chartEndDate.setMonth(this.chartEndDate.getMonth() + 1); // opcional, para garantir fim do mês
    } else {
      // fallback se não houver tarefas
      this.chartEndDate = new Date();
      this.chartEndDate.setMonth(this.chartEndDate.getMonth() + 3);
    }
  });
}
  ngOnInit(): void {
    this.fetchDataFromBackend();
    this.generateTimeline();
  }

  getNomeTarefaOuEtapa(item: any): string {
    if ('name' in item) {
      return item.name;
    } else if ('titulo' in item) {
      return item.titulo;
    }
    return '';
  }

  private fetchDataFromBackend(): void {
    this.tarefasService.buscarTarefasPorProjeto().subscribe({
      next: (tarefas: Tarefa[]) => {
        const etapasMap = new Map<string, Tarefa[]>();

        tarefas.forEach(tarefa => {
          if (!etapasMap.has(tarefa.etapa)) {
            etapasMap.set(tarefa.etapa, []);
          }
          etapasMap.get(tarefa.etapa)?.push(tarefa);
        });

        this.etapasComTarefas = Array.from(etapasMap.entries()).map(([nomeEtapa, tarefasEtapa], index) => {
          const dataInicio = new Date(Math.min(...tarefasEtapa.map(t => new Date(t.dataInicio).getTime())));
          const dataFim = new Date(Math.max(...tarefasEtapa.map(t => new Date(t.dataFim).getTime())));
          const duracao = this.getDaysDiff(dataInicio, dataFim) + 1;

          return {
            id: index + 1,
            name: nomeEtapa,
            start: dataInicio,
            end: dataFim,
            duration: duracao,
            expanded: true,
            subtasks: tarefasEtapa
          };
        });
      },
      error: (err) => {
        console.error('Erro ao buscar tarefas:', err);
      }
    });
  }
  private generateTimeline(): void {
    this.timelineDays = [];
    this.timelineMonths = [];

    const monthNames = ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'];
    let currentDate = new Date(this.chartStartDate);
    let currentMonth = currentDate.getMonth();
    let currentYear = currentDate.getFullYear();
    let monthDays = 0;
    let monthStart = new Date(currentDate);

    while (currentDate <= this.chartEndDate) {
      this.timelineDays.push(new Date(currentDate));

      if (currentDate.getMonth() !== currentMonth) {
        this.timelineMonths.push({
          month: monthNames[currentMonth],
          year: currentYear,
          days: monthDays,
          startDate: new Date(monthStart)
        });

        currentMonth = currentDate.getMonth();
        currentYear = currentDate.getFullYear();
        monthDays = 0;
        monthStart = new Date(currentDate);
      }

      monthDays++;
      currentDate.setDate(currentDate.getDate() + 1);
    }

    if (monthDays > 0) {
      this.timelineMonths.push({
        month: monthNames[currentMonth],
        year: currentYear,
        days: monthDays,
        startDate: new Date(monthStart)
      });
    }
  }

  getTaskPosition(item: Etapa | Tarefa): { left: string; width: string } {
    const start = 'dataInicio' in item ? item.dataInicio : item.start;
    const end = 'dataFim' in item ? item.dataFim : item.end;

    const startOffset = this.getDaysDiff(this.chartStartDate, new Date(start));
    const duration = this.getDaysDiff(new Date(start), new Date(end)) + 1;

    return {
      left: `${startOffset * this.cellWidth}px`,
      width: `${duration * this.cellWidth}px`
    };
  }

  private getDaysDiff(start: Date, end: Date): number {
    const diffTime = Math.max(0, end.getTime() - start.getTime());
    return Math.ceil(diffTime / (1000 * 60 * 60 * 24));
  }

  isWeekend(date: Date): boolean {
    const day = date.getDay();
    return day === 0 || day === 6;
  }

  isToday(date: Date): boolean {
    return date.toDateString() === this.today.toDateString();
  }

toggleExpand(item: Etapa | Tarefa): void {
  const etapa = item as Etapa;
  console.log
  if (etapa.subtasks && etapa.subtasks.length > 0) {
    etapa.expanded = !etapa.expanded;
  }
}
temSubtarefas(item: Etapa | Tarefa): item is Etapa {
  return 'subtasks' in item && Array.isArray(item.subtasks) && item.subtasks.length > 0;
}

isExpanded(item: Etapa | Tarefa): boolean {
  if ('subtasks' in item) {
    return item.expanded !== false && !!item.subtasks?.length;
  }
  return false;
}

canExpand(item: Etapa | Tarefa): item is Etapa {
  return 'subtasks' in item && !!item.subtasks?.length;
}
  getAllItemsToRender(): (Etapa | Tarefa)[] {
    const all: (Etapa | Tarefa)[] = [];

    for (const etapa of this.etapasComTarefas) {
      all.push(etapa);
      if (etapa.expanded && etapa.subtasks) {
        all.push(...etapa.subtasks);
      }
    }

    return all;
  }

  getMonthWidth(month: any): string {
    return `${month.days * this.cellWidth}px`;
  }

  getTaskIndent(task: Etapa | Tarefa): string {
    return 'dataInicio' in task ? '20px' : '0px';
  }
}
