INSERT INTO usuario (id, nome, email, telefone, senha, tipo_usuario)
VALUES 
(1, 'Leandro', 'Leandro@gmail.com', '75999999999', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'COORDENADOR'),
(2, 'Alex', 'ifbanotificacao@gmail.com','75999999999','$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTADOR'),
(3, 'Rian Fonseca', 'rian@gmail.com', '75998123456', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(4, 'Pedro Carlos', 'pedro@gmail.com', '75998234567', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(5, 'Guilherme Sampaio', 'guilherme@gmail.com', '75998345678', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(6, 'Gabriel Moreira', 'gabriel@gmail.com', '75998456789', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(7, 'Árlei Nóbrega', 'arlei@gmail.com', '75998567890', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO'),
(8, 'Yuri Pepe', 'pepeyuri2003@gmail.com', '75998678901', '$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue', 'ORIENTANDO')
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

-- Tarefas para o projeto 1
INSERT INTO public.tarefa (id, descricao, nome_tarefa, status, projeto_id, prioridade, classificacao, prazo)
VALUES
(1, 'Definir requisitos do sistema', 'Requisitos do Sistema', 'PENDENTE', 1, 'ALTA', 'PLANEJAMENTO', '2024-02-20'),
(2, 'Modelar banco de dados', 'Modelagem BD', 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-25'),
(3, 'Criar wireframes', 'Wireframes', 'ANDAMENTO', 1, 'BAIXA', 'PLANEJAMENTO', '2024-02-15'),
(4, 'Definir arquitetura do sistema', 'Arquitetura', 'PENDENTE', 1, 'ALTA', 'PLANEJAMENTO', '2024-02-22'),
(5, 'Desenvolver módulos principais', 'Desenvolvimento de Módulos', 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-28'),
(6, 'Testar funcionalidade de módulos', 'Testes de Módulos', 'CONCLUIDA', 1, 'ALTA', 'DOCUMENTACAO', '2024-03-05'),
(7, 'Configurar ambiente de testes', 'Configuração de Testes', 'PENDENTE', 1, 'MEDIA', 'MANUTENCAO', '2024-03-10'),
(8, 'Ajustar feedback de usuários', 'Feedback de Usuários', 'PENDENTE', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-12'),
(9, 'Finalizar documentação do projeto', 'Documentação Final', 'CONCLUIDA', 1, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(10, 'Coletar base de dados', 'Base de Dados', 'ANDAMENTO', 2, 'ALTA', 'PESQUISA', '2024-02-22'),
(11, 'Treinar modelo IA', 'Treinamento IA', 'CONCLUIDA', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-28'),
(12, 'Avaliar precisão do modelo', 'Avaliação IA', 'ANDAMENTO', 2, 'ALTA', 'ESTUDO', '2024-03-05'),
(13, 'Melhorar algoritmos de IA', 'Aprimoramento de IA', 'PENDENTE', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-10'),
(14, 'Integrar IA com banco de dados', 'Integração IA', 'PENDENTE', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-12'),
(15, 'Documentar resultados', 'Documentação de IA', 'ANDAMENTO', 2, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(16, 'Testar modelo com novas variáveis', 'Testes Variáveis', 'PENDENTE', 2, 'ALTA', 'DOCUMENTACAO', '2024-03-20'),
(17, 'Ajustar parâmetros do modelo', 'Ajuste de Parâmetros', 'ANDAMENTO', 2, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(18, 'Ajustar rede neural', 'Ajuste de Rede Neural', 'ANDAMENTO', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-25'),
(19, 'Analisar ambiente SDN', 'Ambiente SDN', 'ANDAMENTO', 3, 'ALTA', 'ESTUDO', '2024-02-24'),
(20, 'Testar desempenho de rede', 'Testes de Rede', 'ANDAMENTO', 3, 'MEDIA', 'DOCUMENTACAO', '2024-02-27'),
(21, 'Documentar resultados', 'Documentação SDN', 'CONCLUIDA', 3, 'BAIXA', 'DOCUMENTACAO', '2024-02-28'),
(22, 'Ajustar configurações de rede', 'Ajustes de Rede', 'PENDENTE', 3, 'ALTA', 'MANUTENCAO', '2024-03-05'),
(23, 'Testar novos protocolos', 'Testes de Protocolos', 'ANDAMENTO', 3, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-08'),
(24, 'Analisar desempenho do ambiente', 'Análise de Desempenho', 'ANDAMENTO', 3, 'BAIXA', 'ESTUDO', '2024-03-10'),
(25, 'Ajustar comunicação entre dispositivos', 'Ajustes de Comunicação', 'ANDAMENTO', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-12'),
(26, 'Avaliar impacto de novas configurações', 'Avaliação de Impacto', 'ANDAMENTO', 3, 'MEDIA', 'ESTUDO', '2024-03-15'),
(27, 'Finalizar implementação de rede', 'Finalização de Rede', 'PENDENTE', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-18'),
(28, 'Analisar algoritmos de IA', 'Análise de Algoritmos', 'PENDENTE', 4, 'ALTA', 'PESQUISA', '2024-02-28'),
(29, 'Implementar modelo preditivo', 'Modelo Preditivo', 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-03'),
(30, 'Testar modelo com dados reais', 'Testes Reais', 'PENDENTE', 4, 'ALTA', 'DOCUMENTACAO', '2024-03-08'),
(31, 'Ajustar modelo para previsão', 'Ajustes de Modelo', 'ANDAMENTO', 4, 'MEDIA', 'MANUTENCAO', '2024-03-10'),
(32, 'Criar relatórios de desempenho', 'Relatórios de Desempenho', 'PENDENTE', 4, 'ALTA', 'DOCUMENTACAO', '2024-03-12'),
(33, 'Refatorar modelo preditivo', 'Refatoração de Modelo', 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-15'),
(34, 'Ajustar avaliação de risco do modelo', 'Ajuste de Avaliação', 'PENDENTE', 4, 'ALTA', 'MANUTENCAO', '2024-03-18'),
(35, 'Testar integração com sistema externo', 'Testes de Integração', 'ANDAMENTO', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-03-20'),
(36, 'Refatorar código de previsão', 'Refatoração de Código', 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-22'),
(37, 'Desenvolver protótipo inicial', 'Protótipo Inicial', 'PENDENTE', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-02-28'),
(38, 'Ajustar funcionalidades do protótipo', 'Ajustes no Protótipo', 'ANDAMENTO', 5, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-03'),
(39, 'Testar protótipo com usuários', 'Testes com Usuários', 'ANDAMENTO', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-08'),
(40, 'Documentar o protótipo', 'Documentação do Protótipo', 'PENDENTE', 5, 'BAIXA', 'DOCUMENTACAO', '2024-03-12'),
(41, 'Ajustar UI/UX do protótipo', 'Ajustes de UI/UX', 'CONCLUIDA', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-15'),
(42, 'Pesquisar como desenvolver testes automatizados', 'Testes Automatizados', 'CONCLUIDA', 5, 'ALTA', 'PESQUISA', '2024-03-18'),
(43, 'Integrar sistema com backend', 'Integração Backend', 'PENDENTE', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-20'),
(44, 'Melhorar desempenho do protótipo', 'Aprimoramento do Protótipo', 'PENDENTE', 5, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(45, 'Estudar como fazer integração de sistema', 'Testes de Integração', 'PENDENTE', 5, 'ALTA', 'ESTUDO', '2024-03-25'),
(46, 'Definir requisitos do sistema', 'Requisitos do Sistema', 'CONCLUIDA', 1, 'ALTA', 'PLANEJAMENTO', '2024-02-28'),
(47, 'Desenvolver arquitetura do sistema', 'Arquitetura do Sistema', 'ANDAMENTO', 1, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(48, 'Implementar funcionalidades principais', 'Funcionalidades Principais', 'CONCLUIDA', 1, 'ALTA', 'DESENVOLVIMENTO', '2024-03-10'),
(49, 'Revisar escrita da introdução do projeto', 'Testes de Funcionalidade', 'PENDENTE', 1, 'ALTA', 'DOCUMENTACAO', '2024-03-15'),
(50, 'Desenvolver documentação do sistema', 'Documentação do Sistema', 'ANDAMENTO', 1, 'BAIXA', 'DOCUMENTACAO', '2024-03-20'),
(51, 'Ajustar código do sistema', 'Ajustes no Sistema', 'CONCLUIDA', 1, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(52, 'Pesquisar como integrar com API externa', 'Testes de Integração', 'CONCLUIDA', 1, 'ALTA', 'PESQUISA', '2024-03-25'),
(53, 'Fazer pré apresentação do projeto para banca simulada', 'Testes de Carga', 'PENDENTE', 1, 'ALTA', 'APRESENTACAO', '2024-03-30'),
(54, 'Refatorar o código de backend', 'Refatoração de Backend', 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-04-05'),
(55, 'Definir escopo do sistema', 'Definição de Escopo', 'BACKLOG', 1, 'ALTA', 'PLANEJAMENTO', '2024-03-05'),
(56, 'Criar plano de testes para o sistema', 'Plano de Testes', 'BACKLOG', 1, 'MEDIA', 'PLANEJAMENTO', '2024-03-10'),
(57, 'Desenvolver documentação inicial', 'Documentação Inicial', 'BACKLOG', 1, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(58, 'Revisar arquitetura de IA', 'Revisão de Arquitetura IA', 'BACKLOG', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(59, 'Integrar IA com novos dados', 'Integração com Novos Dados', 'BACKLOG', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(60, 'Analisar resultados preliminares', 'Análise de Resultados', 'BACKLOG', 2, 'BAIXA', 'ESTUDO', '2024-03-15'),
(61, 'Definir protocolo de comunicação', 'Definição de Protocolo', 'BACKLOG', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(62, 'Analisar requisitos de segurança', 'Análise de Segurança', 'BACKLOG', 3, 'MEDIA', 'ESTUDO', '2024-03-10'),
(63, 'Desenvolver plano de testes de rede', 'Plano de Testes de Rede', 'BACKLOG', 3, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(64, 'Desenvolver modelo de detecção de fraudes', 'Modelo de Detecção de Fraudes', 'BACKLOG', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(65, 'Integrar modelo com sistema de pagamentos', 'Integração com Pagamentos', 'BACKLOG', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(66, 'Pesquisar precisão do modelo de fraude', 'Teste de Precisão', 'BACKLOG', 4, 'BAIXA', 'PESQUISA', '2024-03-15'),
(67, 'Desenvolver funcionalidades de cadastro de atividades', 'Cadastro de Atividades', 'BACKLOG', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(68, 'Implementar funcionalidade de validação de horas', 'Validação de Horas', 'BACKLOG', 5, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(69, 'Desenvolver módulo de relatórios', 'Módulo de Relatórios', 'BACKLOG', 5, 'BAIXA', 'DESENVOLVIMENTO', '2024-03-15'),
(70, 'Analisar vulnerabilidades presentes em sistemas web', 'Análise de Vulnerabilidades', 'BACKLOG', 1, 'ALTA', 'ESTUDO', '2024-03-05'),
(71, 'Desenvolver mais componentes responsivos', 'Mais responsividade', 'BACKLOG', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(72, 'Estudar implementação de soluções de segurança', 'Busca de Soluções de Segurança', 'BACKLOG', 1, 'BAIXA', 'ESTUDO', '2024-03-15')
ON CONFLICT (id) DO NOTHING;