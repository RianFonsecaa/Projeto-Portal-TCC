package com.ifba.Gerenciador_TCC.email.tipoenum;


public enum TipoMensagem {
    NOTIFICACAO("Você recebeu uma nova notificação: %s"),
    ADVERTENCIA("Atenção! %s"),
    BOAS_VINDAS("Olá %s, seja bem-vindo ao Gerenciador de TCC!");

    private final String template;

    TipoMensagem(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
