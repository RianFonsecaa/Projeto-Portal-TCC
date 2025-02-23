package com.ifba.Gerenciador_TCC.email.tipoenum;

public enum TipoMensagem {
    NOTIFICACAO("📢 Você recebeu uma nova notificação!\n\n", "Nova Notificação"),
    ADVERTENCIA("⚠️ Atenção! Uma ocorrência foi registrada!\n\n", "Alerta de Ocorrência"),
    BOAS_VINDAS("🎉 Seja muito bem-vindo ao Gerenciador de TCC! Estamos felizes em tê-lo conosco.\n\n", "Bem-vindo ao Gerenciador de TCC!");

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
