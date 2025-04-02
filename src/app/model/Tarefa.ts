export interface Tarefa {
  id: number;
  projetoId: number;

  titulo: string;
  descricao: string;
  status: string;
  prioridade: string;
  etapa:string;
  classificacao: string;

  ultimaAtualizacaoEm: string;
  ultimaAtualizacaoPor: string;

  criacaoEm: string;
  criacaoPor: string;
  
  dataFim: Date;
  dataInicio: Date;

}
