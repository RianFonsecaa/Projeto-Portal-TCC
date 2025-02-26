export interface Orientador {
  id: number;
  senha: string;
  nome: string;
  email: string;
  telefone: string;
  tipoUsuario: string;
  areaPesquisa: string;
  cargo: string;
  orientadorDisponivel: boolean;
  projetosEmOrientacao: number;
  resumo: string;
}
