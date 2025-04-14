import { Injectable } from '@angular/core';
import { Etapa } from '../../model/Etapa';
import { Tarefa } from '../../model/Tarefa';
import { MonthDisplay, TimelineDay } from './gantt-chart.models'

@Injectable({ providedIn: 'root' })
export class GanttChartService {
  groupTasksByStage(tarefas: Tarefa[]): Etapa[] {
    const etapasMap = new Map<string, Tarefa[]>();

    tarefas.forEach(tarefa => {
      if (!etapasMap.has(tarefa.etapa)) {
        etapasMap.set(tarefa.etapa, []);
      }
      etapasMap.get(tarefa.etapa)?.push(tarefa);
    });

    return Array.from(etapasMap.entries()).map(([nomeEtapa, tarefasEtapa], index) => {
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
  }

  generateTimeline(startDate: Date, endDate: Date, monthNames: string[]): { days: TimelineDay[], months: MonthDisplay[] } {
    const days: TimelineDay[] = [];
    const months: MonthDisplay[] = [];

    let currentDate = new Date(startDate);
    let currentMonth = currentDate.getMonth();
    let currentYear = currentDate.getFullYear();
    let monthDays = 0;
    let monthStart = new Date(currentDate);

    while (currentDate <= endDate) {
      days.push({
        date: new Date(currentDate),
        isWeekend: this.isWeekend(currentDate)
      });

      if (currentDate.getMonth() !== currentMonth) {
        months.push({
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
      months.push({
        month: monthNames[currentMonth],
        year: currentYear,
        days: monthDays,
        startDate: new Date(monthStart)
      });
    }

    return { days, months };
  }

  getDaysDiff(start: Date, end: Date): number {
    const diffTime = Math.max(0, end.getTime() - start.getTime());
    return Math.ceil(diffTime / (1000 * 60 * 60 * 24));
  }

  isWeekend(date: Date): boolean {
    const day = date.getDay();
    return day === 0 || day === 6;
  }

  isSameDay(date1: Date, date2: Date): boolean {
    return date1.toDateString() === date2.toDateString();
  }

  getItemName(item: Etapa | Tarefa): string {
    if ('name' in item) return item.name;
    if ('titulo' in item) return item.titulo;
    return '';
  }

  toggleExpand(etapa: Etapa): void {
    if (etapa.subtasks && etapa.subtasks.length > 0) {
      etapa.expanded = !etapa.expanded;
    }
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

  getAllItemsToRender(etapas: Etapa[]): (Etapa | Tarefa)[] {
    const all: (Etapa | Tarefa)[] = [];

    for (const etapa of etapas) {
      all.push(etapa);
      if (etapa.expanded && etapa.subtasks) {
        all.push(...etapa.subtasks);
      }
    }

    return all;
  }
}
