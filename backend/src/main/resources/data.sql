INSERT INTO usuario (id, nome, email, telefone, senha, tipo_usuario)
VALUES (1, 'Alex', 'Alex@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(2, 'Leandro', 'Leandro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'COORDENADOR'),
(3, 'Rian', 'Rian@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(4, 'Lauro', 'Lauro@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(5, 'Pedro', 'Pedro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO')
ON CONFLICT (id) DO NOTHING;

INSERT INTO orientador
(area_pesquisa, cargo, orientador_disponivel, projetos_em_orientacao, id, resumo)
VALUES ('Interligencia Artificial', 'Professor', false,3, 1, 'Resumo'),
('Big Data', 'Professor', false,3, 4, 'Resumo')
ON CONFLICT (id) DO NOTHING;

INSERT INTO orientando
(tipo_curso, id)
VALUES('ADS', 3), ('REDES', 5)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.projeto (id, data_cadastro, descricao_projeto, titulo_projeto,
data_ultima_atualizacao, horas_orientacao, progresso,tipo_curso, tipo_projeto, orientando_id,
orientador_id) VALUES
(1, '2024-02-10', 'Desenvolvimento de um Sistema Web para Gestão de Tccs',
'Sistema de Gestão Acadêmica TCC', '2024-02-13', 10, 50, 'ADS', 'TCC', 3, 4),
(2, '2024-02-12', 'Aplicação de Inteligência Artificial na Detecção de Doenças',
'Aplicação de IA em Diagnósticos Médicos', '2024-02-15', 15, 70, 'REDES', 'ARTIGO', 5, 1),
(3, '2024-02-14', 'Desenvolvimento de um Sistema Web para Gestão de Atividades Complementares',
'Sistema de Atividades Complementares', '2024-02-17', 5, 25, 'ADS', 'TCC', 3, 4),
(4, '2024-02-16', 'Implementação e Análise de Desempenho de uma Rede SDN em Ambiente Corporativo',
'Rede SDN em Ambiente Corporativo', '2024-02-19', 20, 60, 'REDES', 'ARTIGO', 5, 4),
(5, '2024-02-18', 'Aplicação de Inteligência Artificial na Detecção de Fraudes em Transações Online',
'IA na Detecção de Fraudes', '2024-02-21', 18, 76, 'ADS', 'TCC', 3, 1),
(6, '2024-02-20', 'Segurança em Redes sem Fio: Avaliação e Mitigação de Vulnerabilidades em Ambientes Empresariais',
'Segurança em Redes sem Fio', '2024-02-23', 27, 99, 'REDES', 'ARTIGO', 5, 1)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.tarefa (id, data_envio, descricao, nome_tarefa, orientador_id, orientando_id, status, projeto_id, prioridade, classificacao, prazo)
VALUES (1, '2024-02-10', 'Finalizar a mockagem das classes', 'Mock das Classes', 4, 3, 'PENDENTE', 1, 'ALTA', 'PESQUISA', '2024-02-18'),
(2, '2024-02-11', 'Desenvolver a API de notificação', 'Desenvolvimento da API', 4, 3, 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-22'),
(3, '2024-02-12', 'Pesquisar cinco tipos de doenças', 'Pesquisa de Doenças', 1, 5, 'PENDENTE', 2, 'ALTA', 'PESQUISA', '2024-02-26'),
(4, '2024-02-13', 'Desenvolver protótipo da IA médica', 'Desenvolvimento do Protótipo', 1, 5, 'ANDAMENTO', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-02'),
(5, '2024-02-14', 'Finalizar leitura do regimento de horas complementares', 'Finalizar Leitura', 4, 3, 'PENDENTE', 3, 'ALTA', 'PESQUISA', '2024-03-06'),
(6, '2024-02-15', 'Desenvolver a tela inicial do projeto', 'Desenvolvimento de Tela', 4, 3, 'ANDAMENTO', 3, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(7, '2024-02-16', 'Finalizar pesquisa do conceito de SDN', 'Pesquisa de SDN', 4, 5, 'PENDENTE', 4, 'ALTA', 'PESQUISA', '2024-03-14'),
(8, '2024-02-17', 'Desenvolver protótipo no cisco packet tracer', 'Desenvolvimento do Protótipo', 4, 5, 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-18'),
(9, '2024-02-18', 'Finalizar a pesquisa de fraudes transacionais comuns', 'Pesquisa de Fraudes', 1, 3, 'PENDENTE', 5, 'ALTA', 'PESQUISA', '2024-03-22'),
(10, '2024-02-19', 'Desenvolver protótipo da IA de detecção', 'Desenvolvimento do Protótipo', 1, 3, 'ANDAMENTO', 5, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-26'),
(11, '2024-02-20', 'Finalizar pesquisa de vulnerabilidades empresariais', 'Pesquisa de Vulnerabilidades', 1, 5, 'PENDENTE', 6, 'ALTA', 'PESQUISA', '2024-03-30'),
(12, '2024-02-21', 'Desenvolver protótipo no cisco packet tracer', 'Desenvolvimento do Protótipo', 1, 5, 'ANDAMENTO', 6, 'MEDIA', 'DESENVOLVIMENTO', '2024-04-03')
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