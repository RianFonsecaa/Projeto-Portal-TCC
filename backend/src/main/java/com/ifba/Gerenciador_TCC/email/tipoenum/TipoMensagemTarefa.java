package com.ifba.Gerenciador_TCC.email.tipoenum;

import com.ifba.Gerenciador_TCC.tarefa.domain.entity.Tarefa;
import com.ifba.Gerenciador_TCC.tarefa.domain.dto.TarefaDTO;
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
        this.tarefa.setDescricao(tarefaDTO.getDescricao());
        this.tarefa.setDataFim(tarefaDTO.getDataFim());
        
        
        try {
            this.tarefa.setStatus(StatusTarefa.valueOf(tarefaDTO.getStatus()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Status inválido: " + tarefaDTO.getStatus());
        }
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
        return switch (tipo) {
            case CRIAR_TAREFA -> "📝 A tarefa '" + tarefa.getTitulo() + "' foi criada!\n\n" +
                    "📅 Prazo: " + (tarefa.getDataFim() != null ? tarefa.getDataFim() : "Sem prazo definido") + "\n" +
                    "📌 Status: " + tarefa.getStatus() + "\n" +
                    "🔗 Acesse o Portal TCC para mais detalhes.";

            case EDITAR_TAREFA -> "✏️ A tarefa '" + tarefa.getTitulo() + "' foi editada!\n\n" +
                    "📌 Nova descrição: " + tarefa.getDescricao() + "\n" +
                    "📅 Novo prazo: " + (tarefa.getDataFim() != null ? tarefa.getDataFim() : "Sem prazo definido") + "\n" +
                    "🔗 Acesse o Portal TCC para conferir as atualizações.";

            case DELETAR_TAREFA -> "❌ A tarefa '" + tarefa.getTitulo() + "' foi removida.\n\n" +
                    "Caso tenha sido um erro, entre em contato com o suporte.\n" +
                    "🔗 Acesse o Portal TCC para continuar gerenciando suas atividades.";
        };
    }
}
