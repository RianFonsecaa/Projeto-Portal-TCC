export interface Aluno {
    id: number;
    nome: string;
  }
  
  export interface Demanda {
    id: number;
    nomeTarefa: string;
    descricao: string;
    prazo: Date;
    prioridade: string;
    status: string;
    alunoId?: number; 
  }