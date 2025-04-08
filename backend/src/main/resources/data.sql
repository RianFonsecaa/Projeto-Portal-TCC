INSERT INTO usuario (id, nome, email, telefone, senha, tipo_usuario)
VALUES 
(1, 'Leandro', 'Leandro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'COORDENADOR'),
(2, 'Alex', 'Alex@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(3, 'Rian Fonseca', 'rian@gmail.com', '75998123456', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(4, 'Pedro Carlos', 'pedro@gmail.com', '75998234567', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(5, 'Guilherme Sampaio', 'guilherme@gmail.com', '75998345678', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(6, 'Gabriel Moreira', 'gabriel@gmail.com', '75998456789', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(7, 'Árlei Nóbrega', 'arlei@gmail.com', '75998567890', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(8, 'Yuri Pepe', 'yuri@gmail.com', '75998678901', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO')
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE usuario_id_seq RESTART WITH 9;

INSERT INTO orientador (area_pesquisa, cargo, orientador_disponivel, projetos_em_orientacao, id, resumo)
VALUES ('Machine Learning', 'Professor', false,6, 2, 'Professor e Doutor pela Universidade Federal da Bahia, com especialização em Inteligência Artificial e Machine Learning.')
ON CONFLICT (id) DO NOTHING;

INSERT INTO orientando (tipo_curso, id)
VALUES
('ADS', 3), 
('REDES', 4),
('REDES', 5),
('ADS', 6),
('REDES', 7),
('ADS', 8)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.projeto (id, data_cadastro, descricao_projeto, titulo_projeto,
data_ultima_atualizacao, horas_orientacao, progresso, url_imagem, tipo_curso, tipo_projeto, orientando_id,
orientador_id) VALUES
(1, '2024-02-10', 'Desenvolvimento de um Sistema Web para Gestão de Tccs',
'Sistema de Gestão Acadêmica TCC', '2024-02-13', 10, 50, 'assets/img/firmbee-com-gcsNOsPEXfs-unsplash.jpg', 'ADS', 'TCC', 3, 2),
(2, '2024-02-12', 'Aplicação de Inteligência Artificial na Detecção de Doenças',
'Aplicação de IA em Diagnósticos Médicos', '2024-02-15', 15, 70, 'assets/img/markus-winkler-tGBXiHcPKrM-unsplash.jpg', 'REDES', 'ARTIGO', 7, 2),
(3, '2024-02-16', 'Implementação e Análise de Desempenho de uma Rede SDN em Ambiente Corporativo',
'Rede SDN em Ambiente Corporativo', '2024-02-19', 20, 60, 'assets/img/stephen-phillips-hostreviews-co-uk-tN344soypQM-unsplash.jpg', 'REDES', 'ARTIGO', 4, 2),
(4, '2024-02-18', 'Aplicação de Inteligência Artificial na Detecção de Fraudes em Transações Online',
'IA na Detecção de Fraudes', '2024-02-21', 18, 76, 'assets/img/markus-winkler-tGBXiHcPKrM-unsplash.jpg', 'ADS', 'TCC', 5, 2),
(5, '2024-02-14', 'Desenvolvimento de um Sistema Web para Gestão de Atividades Complementares',
'Sistema de Atividades Complementares', '2024-02-17', 5, 25, 'assets/img/taras-shypka-iFSvn82XfGo-unsplash.jpg', 'ADS', 'TCC', 8, 2),
(6, '2024-02-20', 'Segurança em Redes sem Fio: Avaliação e Mitigação de Vulnerabilidades em Ambientes Empresariais',
'Segurança em Redes sem Fio', '2024-02-23', 27, 99, 'assets/img/adem-ay-Tk9m_HP4rgQ-unsplash.jpg', 'REDES', 'ARTIGO', 7, 1)
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE projeto_id_seq RESTART WITH 7;

INSERT INTO public.notificacoes (id, data, mensagem, remetente, visualizado) 
VALUES 
(1, '2025-02-26T18:59:26.193+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Alex@gmail.com', 'Alex@gmail.com', false),
(2, '2025-02-26T18:59:36.755+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Leandro@gmail.com', 'Leandro@gmail.com', false),
(3, '2025-02-26T18:59:44.541+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Rian@gmail.com', 'Rian@gmail.com', false),
(4, '2025-02-26T18:59:50.804+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Lauro@gmail.com', 'Lauro@gmail.com', false),
(5, '2025-02-26T18:59:57.484+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 15:59  Atenciosamente, Pedro@gmail.com', 'Pedro@gmail.com', false),
(6, '2025-02-26T19:00:06.010+00:00', '📢 Você recebeu uma nova notificação!    📅 Data: 26/02/2025 16:00  Atenciosamente, Gabriel@gmail.com', 'Gabriel@gmail.com', false)
ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE notificacoes_id_seq RESTART WITH 7;
