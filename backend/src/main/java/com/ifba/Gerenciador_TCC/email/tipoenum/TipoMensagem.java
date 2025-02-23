package com.ifba.Gerenciador_TCC.email.tipoenum;

public enum TipoMensagem {
    NOTIFICACAO("📢 Você recebeu uma nova notificação!\n\n"),
    ADVERTENCIA("⚠️ Atenção! Uma ocorrência foi registrada!\n\n"),
    BOAS_VINDAS("🎉 Seja muito bem-vindo ao Gerenciador de TCC! Estamos felizes em tê-lo conosco.\n\n");


    private final String mensagem;

    TipoMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
