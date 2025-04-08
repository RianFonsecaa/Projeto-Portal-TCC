package com.ifba.Gerenciador_TCC.email.tipoenum;

import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Classificacao;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.Prioridade;
import com.ifba.Gerenciador_TCC.tarefa.domain.enums.StatusTarefa;

public class TipoMensagemTarefa extends TipoMensagem {
    private final Tarefa tarefa;
    private final TipoTarefa tipo;

    public enum TipoTarefa {
        CRIAR_TAREFA, EDITAR_TAREFA, DELETAR_TAREFA
    }

    public TipoMensagemTarefa(TipoTarefa tipo, Tarefa tarefa) {
        super(definirAssunto(tipo));
        this.tipo = tipo;
        this.tarefa = tarefa;
    }

    public TipoMensagemTarefa(TipoTarefa tipo, TarefaDTO tarefaDTO) {
    super(definirAssunto(tipo));
    this.tipo = tipo;

    this.tarefa = new Tarefa();
    this.tarefa.setTitulo(tarefaDTO.getTitulo());
    this.tarefa.setDataFim(tarefaDTO.getDataFim());

    try {
        this.tarefa.setStatus(StatusTarefa.valueOf(tarefaDTO.getStatus()));
    } catch (IllegalArgumentException e) {
        throw new RuntimeException("Status inválido: " + tarefaDTO.getStatus());
    }

    try {
        this.tarefa.setPrioridade(Prioridade.valueOf(tarefaDTO.getPrioridade()));
    } catch (IllegalArgumentException e) {
        throw new RuntimeException("Prioridade inválida: " + tarefaDTO.getPrioridade());
    }

    try {
        this.tarefa.setClassificacao(Classificacao.fromString(tarefaDTO.getClassificacao()));
    } catch (IllegalArgumentException e) {
        throw new RuntimeException("Classificação inválida: " + tarefaDTO.getClassificacao());
    }

    this.tarefa.setEtapa(tarefaDTO.getEtapa());
}


    private static String definirAssunto(TipoTarefa tipo) {
        return switch (tipo) {
            case CRIAR_TAREFA -> "✅ Nova Tarefa Criada!";
            case EDITAR_TAREFA -> "✏️ Tarefa Atualizada!";
            case DELETAR_TAREFA -> "❌ Tarefa Removida!";
        };
    }

    @Override
    public String gerarMensagem() {
    String prazo = tarefa.getDataFim() != null ? tarefa.getDataFim().toString() : "Sem prazo definido";

    return switch (tipo) {
            case CRIAR_TAREFA -> "📝 A tarefa '" + tarefa.getTitulo() + "' foi criada!\n\n" +
                    "📅 Prazo: " + prazo + "\n" +
                    "📌 Status: " + tarefa.getStatus() + "\n" +
                    "⭐ Prioridade: " + tarefa.getPrioridade() + "\n" +
                    "📚 Classificação: " + tarefa.getClassificacao() + "\n" +
                    "🧩 Etapa: " + tarefa.getEtapa();

            case EDITAR_TAREFA -> "✏️ A tarefa '" + tarefa.getTitulo() + "' foi editada!\n\n" +
                    "📅 Novo prazo: " + prazo + "\n" +
                    "📌 Status: " + tarefa.getStatus() + "\n" +
                    "⭐ Prioridade: " + tarefa.getPrioridade() + "\n" +
                    "📚 Classificação: " + tarefa.getClassificacao() + "\n" +
                    "🧩 Etapa: " + tarefa.getEtapa();

            case DELETAR_TAREFA -> "❌ A tarefa '" + tarefa.getTitulo() + "' foi removida.\n\n" +
                    "Se isso foi um erro, entre em contato com o suporte.";
        };
    }

}
