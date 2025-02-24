export interface Projeto {
  id: number;
  tituloProjeto: string;
  descricaoProjeto?: string;
  dataCadastro: string;
  dataUltimaAtualizacao: string;
  horasOrientacao: string;
  orientandoId: {
    nome: string;
  }

  orientadorId: {
    nome: string;
  }
  progresso: string;
  tipoProjeto: string;
  tipoCurso: string;

  urlImagem: string;
}
