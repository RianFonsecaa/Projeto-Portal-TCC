package com.ifba.Gerenciador_TCC.email.tipoenum;

public class TipoMensagemComum extends TipoMensagem {
    private final String mensagem;

 
    public TipoMensagemComum(String tipo) {
        super(definirAssunto(tipo));  
        this.mensagem = definirMensagem(tipo);  
    }

    @Override
    public String gerarMensagem() {
        return mensagem;
    }


    private static String definirMensagem(String tipo) {
        switch (tipo) {
            case "NOTIFICACAO":
                return "📢 Você tem uma nova notificação no Portal TCC! 🔔\n\n" +
                       "Algo importante aconteceu no seu projeto! Não deixe de conferir as novidades e manter tudo atualizado. 📖✨\n\n" +
                       "🔗 [Acesse o Portal TCC] para visualizar os detalhes.\n\n" +
                       "Estamos à disposição para ajudar no que for preciso! 🚀";

            case "ADVERTENCIA":
                return "⚠️ ATENÇÃO! Uma ocorrência foi registrada! ⚠️\n\n" +
                       "Algo exige sua atenção no Gerenciador de TCC. Para evitar problemas futuros, confira os detalhes e tome as ações necessárias. ⏳\n\n" +
                       "📌 O que fazer agora?\n" +
                       "✅ Acesse o sistema para visualizar a advertência.\n" +
                       "✅ Caso tenha dúvidas, entre em contato com a coordenação.\n\n" +
                       "🔗 [Acesse agora] o Portal TCC!\n\n" +
                       "Se precisar de ajuda, não hesite em entrar em contato. 📞";

            case "BOAS_VINDAS":
                return "🎉 Bem-vindo(a) ao Portal TCC! 🎉\n\n" +
                       "Estamos felizes por tê-lo(a) conosco nesta jornada acadêmica! 🏆\n\n" +
                       "O sistema foi criado para ajudar a gerenciar seu progresso, acompanhar prazos 📅 e receber notificações 📩 importantes.\n\n" +
                       "✨ O que você pode fazer agora? \n" +
                       "✅ Explorar as funcionalidades disponíveis.\n" +
                       "✅ Configurar preferências e notificações.\n" +
                       "✅ Entrar em contato com sua coordenação, se precisar de ajuda.\n\n" +
                       "Se precisar de suporte, estamos à disposição! 🚀\n\n" +
                       "🔗 [Acesse o Portal TCC agora]\n\n" +
                       "Boa jornada acadêmica! 📚💡";

            default:
                return "Mensagem não encontrada!";
        }
    }

  
    private static String definirAssunto(String tipo) {
        switch (tipo) {
            case "NOTIFICACAO":
                return "🔔 Nova Notificação no Gerenciador de TCC";
            case "ADVERTENCIA":
                return "⚠️ Ocorrência Registrada – Ação Necessária";
            case "BOAS_VINDAS":
                return "🎓 Bem-vindo(a) ao Portal TCC!";
            default:
                return "Assunto não definido";
        }
    }
}
