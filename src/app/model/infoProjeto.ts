export interface infoProjeto {
  id: number;
  titulo: string;
  nomeAutor: string;
  cursoAutor: string;
  tipoProjeto: string;
  horasOrientacao: number;
  progresso: number;
  dataUltimaAlteracao: Date;
  demandasAtribuidas: number;
  demandasEmAndamento: number;
  demandasResolvidas: number;
  urlImagemCard: string;
}
