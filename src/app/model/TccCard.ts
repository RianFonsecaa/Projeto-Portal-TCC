import { Demandas } from "./Demandas";

export interface TccCard {
    id: number;
    titulo: string;
    tituloProjeto: string;
    autor: string;
    cursoAutor: string;
    backgroundUrl: string;
    tipoProjeto: string;
    horasOrientacao: number
    orientadorId: {
      nome: string;
    };

    orientandoId: {
      nome: string;
    };
    tipoCurso: string
    demandas?: Demandas;
    demandasResolvidas: number;
    dataUltimaAtualizacao: string;
    progresso: number;

}
