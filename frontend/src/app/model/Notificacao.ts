export interface Notificacao {
  id: number;
  assunto: string;
  remetente: string;
  mensagem: string;
  data: Date;
  visualizado: boolean;
}
