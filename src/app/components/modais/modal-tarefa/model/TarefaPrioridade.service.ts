import { Injectable, signal } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class TarefaPrioridadeService {
  
  private prioridadeMap: { [key: string]: string } = {
    ALTA: 'Alta',
    MEDIA: 'Média',
    BAIXA: 'Baixa'
  };

  private prioridadeSelecionada = signal<string>('');

  public getPrioridades(): [string, string][] {
    return Object.entries(this.prioridadeMap);
  }

  public getPrioridadeSelecionada() {
    return this.prioridadeSelecionada.asReadonly();
  }

  public selecionarPrioridade(key: string): void {
    this.prioridadeSelecionada.set(key);
  }

  public limparPrioridade(): void {
    this.prioridadeSelecionada.set('');
  }

  public isPrioridadeSelecionada(): boolean {
    return this.prioridadeSelecionada() !== '';
  }
}