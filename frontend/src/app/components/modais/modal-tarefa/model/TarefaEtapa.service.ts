import { computed, Injectable, signal } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class TarefaEtapaService  {

    private etapasMap: { [key: string]: string } = {
        INTRODUCAO: 'Introdução',
        LEVANTAMENTO_BIBLIOGRAFICO: 'Levantamento Bibliográfico',
        METODOLOGIA: 'Metodologia',
        DESENVOLVIMENTO: 'Desenvolvimento',
        ANALISE_DE_DADOS: 'Análise de Dados',
        RESULTADOS: 'Resultados',
        CONCLUSAO: 'Conclusão',
        RESUMO: 'Resumo',
        REFERENCIAS: 'Referencias',
        APENDICES: 'Apendices',
    };

   private etapaSelecionada = signal<string>('');
  
    public getEtapas(): [string, string][] {
      return Object.entries(this.etapasMap);
    }

    public getEtapaSelecionada(){
      return this.etapaSelecionada.asReadonly();
    }
  
    public selecionarEtapa(key: string){
      this.etapaSelecionada.set(key);
      console.log(this.etapaSelecionada())
  }
  
    public limparEtapa(): void {
      this.etapaSelecionada.set('');
    }
  
    public isEtapaSelecionada(): boolean {
      return this.etapaSelecionada() !== '';
    }
  
  }