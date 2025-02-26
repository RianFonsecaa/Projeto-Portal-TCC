export interface Usuario {
  id: number;
  nome: string;
  email: string;
  telefone: string;
  tipoUsuario: string;
  areaPesquisa: string;
  cargo: string;
  orientadorDisponivel: boolean;
  projetosEmOrientacao: number;
  resumo: string;
  tipoCurso: string,
}
