export interface infoProjeto {
  id: number;
  titulo: string;
  nomeAutor: string;
  cursoAutor: string;
  tipoProjeto: string;
  horasOrientacao: number;
  progresso: number;
  dataUltimaAlteracao: Date;
  tarefasAtribuidas: number;
  tarefasBacklog: number;
  tarefasPendentes: number;
  tarefasAndamento: number;
  tarefasConcluidas: number;
  urlImagemCard: string;
}
