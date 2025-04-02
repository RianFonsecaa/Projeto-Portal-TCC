import { Injectable, signal } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class TarefaStatusService {
  
  private statusMap: { [key: string]: string } = {
    BACKLOG: 'Backlog',
    PENDENTE: 'Pendente',
    ANDAMENTO: 'Em Andamento',
    CONCLUIDA: 'Concluída'
  };

  private statusSelecionado = signal<string>('');

  public getStatus(): [string, string][] {
    return Object.entries(this.statusMap);
  }

  public getStatusSelecionado() {
    return this.statusSelecionado.asReadonly();
  }

  public selecionarStatus(key: string): void {
    this.statusSelecionado.set(key);
  }

  public limparStatus(): void {
    this.statusSelecionado.set('');
  }

  public isStatusSelecionado(): boolean {
    return this.statusSelecionado() !== '';
  }
}