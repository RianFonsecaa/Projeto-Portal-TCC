package com.ifba.Gerenciador_TCC.email.tipoenum;

public abstract class TipoMensagem {
    private final String assunto;

    public TipoMensagem(String assunto) {
        this.assunto = assunto;
    }

    public String getAssunto() {
        return assunto;
    }


    public abstract String gerarMensagem();
}
