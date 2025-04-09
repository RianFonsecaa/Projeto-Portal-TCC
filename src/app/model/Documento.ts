export interface Documento {
    id?: number; 
    titulo: string;
    escopoDocumento: string;
    tipoDocumento:string;
    caminhoArquivo?: string;
    arquivo?: File;        
    dataUpload?: string;     
    tamanho: number;
    tarefaId: string;
  }