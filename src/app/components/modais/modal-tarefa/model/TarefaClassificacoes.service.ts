import { computed, Injectable, signal, Signal } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class TarefaClassificacaoService {
  // Mapa de classificações (igual ao original)
  private classificacoesMap: { [key: string]: string } = {
    BIBLIOGRAFIA: 'Bibliografia',
    REDACAO: 'Redação',
    DESENVOLVIMENTO: 'Desenvolvimento',
    MANUTENCAO: 'Manutenção',
    PESQUISA: 'Pesquisa',
    ESTUDO: 'Estudo',
    PLANEJAMENTO: 'Planejamento',
    REVISAO: 'Revisão',
    DOCUMENTACAO: 'Documentação',
    APRESENTACAO: 'Apresentação'
  };

  private classificacaoSelecionada = signal<string>('');

  public getClassificacoes(): [string, string][] {
    return Object.entries(this.classificacoesMap);
  }

  public getClassificacaoSelecionada(){
    return this.classificacaoSelecionada.asReadonly();
  }

  public selecionarClassificacao(key: string){
      this.classificacaoSelecionada.set(key);
      console.log(this.classificacaoSelecionada())
  }

  public limparClassificacao(){
    this.classificacaoSelecionada.set('');
  }

  public isClassificacaoSelecionada(){
    return this.classificacaoSelecionada() !== '';
  }
}