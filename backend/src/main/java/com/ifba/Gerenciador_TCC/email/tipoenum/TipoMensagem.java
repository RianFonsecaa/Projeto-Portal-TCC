package com.ifba.Gerenciador_TCC.email.tipoenum;

public enum TipoMensagem {
    NOTIFICACAO(
        "📢 Você recebeu uma nova notificação no Gerenciador de TCC!\n\n" +
        "Acesse o sistema para conferir os detalhes.\n\n",
        "Nova Notificação no Gerenciador de TCC"
    ),

    ADVERTENCIA(
        "⚠️ ATENÇÃO! Uma ocorrência foi registrada em seu nome.\n\n" +
        "Verifique sua área no sistema para mais detalhes sobre esta advertência e as ações necessárias.\n\n" +
        "Caso tenha dúvidas, entre em contato com a coordenação do TCC.",
        "⚠️ Ocorrência Registrada – Ação Necessária"
    ),

    BOAS_VINDAS(
        "🎉 Bem-vindo(a) ao Portal TCC!\n\n" +
        "Estamos felizes por tê-lo(a) conosco. O sistema ajudará a acompanhar seu progresso, prazos e notificações importantes.\n\n" +
        "Não hesite em explorar as funcionalidades disponíveis e entrar em contato se precisar de ajuda. Boa jornada acadêmica!",
        "Bem-vindo(a) ao Portal TCC!"
    ),

    INFORMACAO(
        "ℹ️ Uma nova informação foi adicionada ao seu projeto!\n\n" +
        "Acesse o sistema para visualizar as atualizações e garantir que está por dentro de todas as novidades.\n\n",
        "Nova Informação no Projeto TCC"
    ),

    ATUALIZACAO(
        "🔄 O status do seu projeto ou tarefa foi atualizado!\n\n" +
        "Verifique no sistema para acompanhar as mudanças e próximos passos.\n\n" +
        "Fique atento(a) para não perder prazos importantes.",
        "Atualização no Projeto TCC"
    );

    private final String mensagem;
    private final String assunto;

    TipoMensagem(String mensagem, String assunto) {
        this.mensagem = mensagem;
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAssunto() {
        return assunto;
    }
}
