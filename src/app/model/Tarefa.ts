export interface Tarefa {
  id: number;
  orientadorId: number;
  orientandoId: number;
  projetoId: number;
  idDocumento: number | null;
  nomeTarefa: string;
  descricao: string;
  dataEnvio: string;
  status: string;
  prioridade: string;
  classificacao: string;
  prazo: string;
}
