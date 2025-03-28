package com.ifba.Gerenciador_TCC.email.tipoenum;

public enum TipoMensagem {
    NOTIFICACAO(
        "📢 Você tem uma nova notificação no Portal TCC]! 🔔\n\n" +
        "Algo importante aconteceu no seu projeto! Não deixe de conferir as novidades e manter tudo atualizado. 📖✨\n\n" +
        "🔗 [Acesse o Portal TCC] para visualizar os detalhes.\n\n" +
        "Estamos à disposição para ajudar no que for preciso! 🚀",
        "🔔 Nova Notificação no Gerenciador de TCC"
    ),

    ADVERTENCIA(
        "⚠️ ATENÇÃO! Uma ocorrência foi registrada! ⚠️\n\n" +
        "Algo exige sua atenção no Gerenciador de TCC. Para evitar problemas futuros, confira os detalhes e tome as ações necessárias. ⏳\n\n" +
        "📌 O que fazer agora?\n" +
        "✅ Acesse o sistema para visualizar a advertência.\n" +
        "✅ Caso tenha dúvidas, entre em contato com a coordenação.\n\n" +
        "🔗 [Acesse agora] o Portal TCC!\n\n" +
        "Se precisar de ajuda, não hesite em entrar em contato. 📞",
        "⚠️ Ocorrência Registrada – Ação Necessária"
    ),

    BOAS_VINDAS(
        "🎉 Bem-vindo(a) ao Portal TCC! 🎉\n\n" +
        "Estamos felizes por tê-lo(a) conosco nesta jornada acadêmica! 🏆\n\n" +
        "O sistema foi criado para ajudar a gerenciar seu progresso, acompanhar prazos 📅 e receber notificações 📩 importantes.\n\n" +
        "✨ O que você pode fazer agora? \n" +
        "✅ Explorar as funcionalidades disponíveis.\n" +
        "✅ Configurar preferências e notificações.\n" +
        "✅ Entrar em contato com sua coordenação, se precisar de ajuda.\n\n" +
        "Se precisar de suporte, estamos à disposição! 🚀\n\n" +
        "🔗 [Acesse o Portal TCC agora]\n\n" +
        "Boa jornada acadêmica! 📚💡",
        "🎓 Bem-vindo(a) ao Portal TCC!"
    ),

    CRIAR_TAREFA(
        "📝 Uma nova tarefa foi criada com sucesso! 🚀\n\n" +
        "Agora é só acompanhar o progresso e garantir que tudo está dentro do prazo. ⏳\n\n" +
        "🔗 [Acesse o Portal TCC]para visualizar e gerenciar suas tarefas.\n\n" +
        "Se precisar de algo, estamos aqui para ajudar! 💡",
        "✅ Nova Tarefa Criada com Sucesso!"
    ),

    EDITAR_TAREFA(
        "✏️ Uma tarefa foi editada com sucesso! 🛠️\n\n" +
        "Lembre-se de revisar os detalhes para garantir que tudo está correto! ✅\n\n" +
        "🔗 [Acesse agora]para visualizar as atualizações.\n\n" +
        "Bom trabalho e siga firme no seu TCC! 🚀",
        "✏️ Tarefa Editada com Sucesso!"
    ),

    DELETAR_TAREFA(
        "🗑️ Uma tarefa foi removida! ❌\n\n" +
        "Se precisar criar uma nova ou recuperar informações, o sistema está disponível para ajudar! 💡\n\n" +
        "🔗 [Acesse o Portal TCC]para continuar gerenciando suas atividades.\n\n" +
        "Boa sorte na sua jornada acadêmica! 📚",
        "❌ Tarefa Removida com Sucesso!"
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
