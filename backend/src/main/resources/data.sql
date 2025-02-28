INSERT INTO usuario (id, nome, email, telefone, senha, tipo_usuario)
VALUES (1, 'Alex', 'Alex@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(2, 'Leandro', 'Leandro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'COORDENADOR'),
(3, 'Rian', 'Rian@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(4, 'Lauro', 'Lauro@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(5, 'Pedro', 'Pedro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(6, 'Arlei', 'Arlei@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(7, 'Gabriel', 'Gabriel@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(8, 'Guilherme', 'Guilherme@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(9, 'Yuri', 'Yuri@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO')
ON CONFLICT (id) DO NOTHING;

INSERT INTO orientador
(area_pesquisa, cargo, orientador_disponivel, projetos_em_orientacao, id, resumo)
VALUES ('Interligencia Artificial', 'Professor', false,3, 1, 'Resumo'),
('Big Data', 'Professor', false,3, 4, 'Resumo')
ON CONFLICT (id) DO NOTHING;

INSERT INTO orientando
(tipo_curso, id)
VALUES ('ADS', 3), ('REDES', 5), ('MULTIMIDIA', 6), ('ADS', 7), ('REDES', 8), ('MULTIMIDIA', 9)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.projeto (id, data_cadastro, descricao_projeto, titulo_projeto,
data_ultima_atualizacao, horas_orientacao, progresso,tipo_curso, tipo_projeto, orientando_id,
orientador_id) VALUES
(1, '2024-02-10', 'Desenvolvimento de um Sistema Web para Gestão de Tccs',
'Sistema de Gestão Acadêmica TCC', '2024-02-13', 10, 50, 'ADS', 'TCC', 3, 4),
(2, '2024-02-12', 'Aplicação de Inteligência Artificial na Detecção de Doenças',
'Aplicação de IA em Diagnósticos Médicos', '2024-02-15', 15, 70, 'REDES', 'ARTIGO', 5, 1),
(3, '2024-02-14', 'Desenvolvimento de um Sistema Web para Gestão de Atividades Complementares',
'Sistema de Atividades Complementares', '2024-02-17', 5, 25, 'MULTIMIDIA', 'TCC', 6, 4),
(4, '2024-02-16', 'Implementação e Análise de Desempenho de uma Rede SDN em Ambiente Corporativo',
'Rede SDN em Ambiente Corporativo', '2024-02-19', 20, 60, 'ADS', 'ARTIGO', 7, 4),
(5, '2024-02-18', 'Aplicação de Inteligência Artificial na Detecção de Fraudes em Transações Online',
'IA na Detecção de Fraudes', '2024-02-21', 18, 76, 'REDES', 'TCC', 8, 1),
(6, '2024-02-20', 'Segurança em Redes sem Fio: Avaliação e Mitigação de Vulnerabilidades em Ambientes Empresariais',
'Segurança em Redes sem Fio', '2024-02-23', 27, 99, 'MULTIMIDIA', 'ARTIGO', 9, 1)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.tarefa (id, data_envio, descricao, nome_tarefa, orientador_id, orientando_id, status, projeto_id, prioridade, classificacao, prazo)
VALUES (1, '2024-02-10', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 3, 'PENDENTE', 1, 'ALTA', 'DESENVOLVIMENTO', '2024-02-18'),
(2, '2024-02-10', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 3, 'ANDAMENTO', 1, 'MEDIA', 'PESQUISA', '2024-02-22'),
(3, '2024-02-10', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 3, 'ANDAMENTO', 1, 'ALTA', 'BIBLIOGRAFIA', '2024-02-18'),
(4, '2024-02-10', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 3, 'CONCLUIDA', 1, 'ALTA', 'DESENVOLVIMENTO', '2024-02-22'),
(5, '2024-02-10', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 3, 'BACKLOG', 1, 'BAIXA', 'DOCUMENTACAO', '2024-02-18'),

(6, '2024-02-12', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 5, 'PENDENTE', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-02-20'),
(7, '2024-02-12', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 5, 'ANDAMENTO', 2, 'MEDIA', 'PESQUISA', '2024-02-24'),
(8, '2024-02-12', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 5, 'ANDAMENTO', 2, 'ALTA', 'BIBLIOGRAFIA', '2024-02-20'),
(9, '2024-02-12', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 5, 'CONCLUIDA', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-02-24'),
(10, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 5, 'BACKLOG', 2, 'BAIXA', 'DOCUMENTACAO', '2024-02-20'),

(11, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 6, 'PENDENTE', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-02-22'),
(12, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 6, 'ANDAMENTO', 3, 'MEDIA', 'PESQUISA', '2024-02-26'),
(13, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 6, 'ANDAMENTO', 3, 'ALTA', 'BIBLIOGRAFIA', '2024-02-22'),
(14, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 6, 'CONCLUIDA', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-02-26'),
(15, '2024-02-14', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 6, 'BACKLOG', 3, 'BAIXA', 'DOCUMENTACAO', '2024-02-22'),

(16, '2024-02-16', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 7, 'PENDENTE', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-02-24'),
(17, '2024-02-16', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 7, 'ANDAMENTO', 4, 'MEDIA', 'PESQUISA', '2024-02-28'),
(18, '2024-02-16', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 7, 'ANDAMENTO', 4, 'ALTA', 'BIBLIOGRAFIA', '2024-02-24'),
(19, '2024-02-16', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 7, 'CONCLUIDA', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-02-28'),
(20, '2024-02-16', 'Descrição da Tarefa', 'Nome da Tarefa', 4, 7, 'BACKLOG', 4, 'BAIXA', 'DOCUMENTACAO', '2024-02-24'),

(21, '2024-02-18', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 8, 'PENDENTE', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-02-26'),
(22, '2024-02-18', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 8, 'ANDAMENTO', 5, 'MEDIA', 'PESQUISA', '2024-03-02'),
(23, '2024-02-18', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 8, 'ANDAMENTO', 5, 'ALTA', 'BIBLIOGRAFIA', '2024-02-26'),
(24, '2024-02-18', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 8, 'CONCLUIDA', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-02'),
(25, '2024-02-18', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 8, 'BACKLOG', 5, 'BAIXA', 'DOCUMENTACAO', '2024-02-26'),

(26, '2024-02-20', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 9, 'PENDENTE', 6, 'ALTA', 'DESENVOLVIMENTO', '2024-02-28'),
(27, '2024-02-20', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 9, 'ANDAMENTO', 6, 'MEDIA', 'PESQUISA', '2024-03-04'),
(28, '2024-02-20', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 9, 'ANDAMENTO', 6, 'ALTA', 'BIBLIOGRAFIA', '2024-02-28'),
(29, '2024-02-20', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 9, 'CONCLUIDA', 6, 'ALTA', 'DESENVOLVIMENTO', '2024-03-04'),
(30, '2024-02-20', 'Descrição da Tarefa', 'Nome da Tarefa', 1, 9, 'BACKLOG', 6, 'BAIXA', 'DOCUMENTACAO', '2024-02-28')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.notificacoes (id, data, mensagem, remetente, visualizado) 
VALUES 
(1, '2025-02-26T18:59:26.193+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Alex@gmail.com', 'Alex@gmail.com', false),
(2, '2025-02-26T18:59:36.755+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Leandro@gmail.com', 'Leandro@gmail.com', false),
(3, '2025-02-26T18:59:44.541+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Rian@gmail.com', 'Rian@gmail.com', false),
(4, '2025-02-26T18:59:50.804+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Lauro@gmail.com', 'Lauro@gmail.com', false),
(5, '2025-02-26T18:59:57.484+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Pedro@gmail.com', 'Pedro@gmail.com', false),
(6, '2025-02-26T19:00:06.010+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 16:00  Atenciosamente, Gabriel@gmail.com', 'Gabriel@gmail.com', false)
ON CONFLICT (id) DO NOTHING;