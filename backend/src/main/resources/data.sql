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
'Aplicação de IA em Diagnósticos Médicos', '2024-02-15', 15, 70, 'assets/img/markus-winkler-tGBXiHcPKrM-unsplash.jpg', 'REDES', 'ARTIGO', 5, 1),
(3, '2024-02-16', 'Implementação e Análise de Desempenho de uma Rede SDN em Ambiente Corporativo',
'Rede SDN em Ambiente Corporativo', '2024-02-19', 20, 60, 'assets/img/stephen-phillips-hostreviews-co-uk-tN344soypQM-unsplash.jpg', 'REDES', 'ARTIGO', 4, 2),
(4, '2024-02-18', 'Aplicação de Inteligência Artificial na Detecção de Fraudes em Transações Online',
'IA na Detecção de Fraudes', '2024-02-21', 18, 76, 'assets/img/markus-winkler-tGBXiHcPKrM-unsplash.jpg', 'ADS', 'TCC', 5, 2),
(5, '2024-02-14', 'Desenvolvimento de um Sistema Web para Gestão de Atividades Complementares',
'Sistema de Atividades Complementares', '2024-02-17', 5, 25, 'assets/img/taras-shypka-iFSvn82XfGo-unsplash.jpg', 'ADS', 'TCC', 8, 2),
(6, '2024-02-20', 'Segurança em Redes sem Fio: Avaliação e Mitigação de Vulnerabilidades em Ambientes Empresariais',
'Segurança em Redes sem Fio', '2024-02-23', 27, 99, 'assets/img/adem-ay-Tk9m_HP4rgQ-unsplash.jpg', 'REDES', 'ARTIGO', 7, 2)
ON CONFLICT (id) DO NOTHING;

-- Tarefas para o projeto 1
INSERT INTO public.tarefa (id, data_envio, descricao, nome_tarefa, orientador_id, orientando_id, status, projeto_id, prioridade, classificacao, prazo)
VALUES
(1, '2024-02-11', 'Definir requisitos do sistema', 'Requisitos do Sistema', 2, 3, 'PENDENTE', 1, 'ALTA', 'PLANEJAMENTO', '2024-02-20'),
(2, '2024-02-12', 'Modelar banco de dados', 'Modelagem BD', 2, 3, 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-25'),
(3, '2024-02-13', 'Criar wireframes', 'Wireframes', 2, 3, 'ANDAMENTO', 1, 'BAIXA', 'PLANEJAMENTO', '2024-02-15'),
(4, '2024-02-14', 'Definir arquitetura do sistema', 'Arquitetura', 2, 3, 'PENDENTE', 1, 'ALTA', 'PLANEJAMENTO', '2024-02-22'),
(5, '2024-02-15', 'Desenvolver módulos principais', 'Desenvolvimento de Módulos', 2, 3, 'ANDAMENTO', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-28'),
(6, '2024-02-16', 'Testar funcionalidade de módulos', 'Testes de Módulos', 2, 3, 'CONCLUIDA', 1, 'ALTA', 'DOCUMENTACAO', '2024-03-05'),
(7, '2024-02-17', 'Configurar ambiente de testes', 'Configuração de Testes', 2, 3, 'PENDENTE', 1, 'MEDIA', 'MANUTENCAO', '2024-03-10'),
(8, '2024-02-18', 'Ajustar feedback de usuários', 'Feedback de Usuários', 2, 3, 'PENDENTE', 1, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-12'),
(9, '2024-02-19', 'Finalizar documentação do projeto', 'Documentação Final', 2, 3, 'CONCLUIDA', 1, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(10, '2024-02-14', 'Coletar base de dados', 'Base de Dados', 2, 6, 'ANDAMENTO', 2, 'ALTA', 'PESQUISA', '2024-02-22'),
(11, '2024-02-15', 'Treinar modelo IA', 'Treinamento IA', 2, 6, 'CONCLUIDA', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-02-28'),
(12, '2024-02-16', 'Avaliar precisão do modelo', 'Avaliação IA', 2, 6, 'ANDAMENTO', 2, 'ALTA', 'ESTUDO', '2024-03-05'),
(13, '2024-02-17', 'Melhorar algoritmos de IA', 'Aprimoramento de IA', 2, 6, 'PENDENTE', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-10'),
(14, '2024-02-18', 'Integrar IA com banco de dados', 'Integração IA', 2, 6, 'PENDENTE', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-12'),
(15, '2024-02-19', 'Documentar resultados', 'Documentação de IA', 2, 6, 'ANDAMENTO', 2, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(16, '2024-02-20', 'Testar modelo com novas variáveis', 'Testes Variáveis', 2, 6, 'PENDENTE', 2, 'ALTA', 'DOCUMENTACAO', '2024-03-20'),
(17, '2024-02-21', 'Ajustar parâmetros do modelo', 'Ajuste de Parâmetros', 2, 6, 'ANDAMENTO', 2, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(18, '2024-02-22', 'Ajustar rede neural', 'Ajuste de Rede Neural', 2, 6, 'ANDAMENTO', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-25'),
(19, '2024-02-20', 'Analisar ambiente SDN', 'Ambiente SDN', 2, 4, 'ANDAMENTO', 3, 'ALTA', 'ESTUDO', '2024-02-24'),
(20, '2024-02-21', 'Testar desempenho de rede', 'Testes de Rede', 2, 4, 'ANDAMENTO', 3, 'MEDIA', 'DOCUMENTACAO', '2024-02-27'),
(21, '2024-02-22', 'Documentar resultados', 'Documentação SDN', 2, 4, 'CONCLUIDA', 3, 'BAIXA', 'DOCUMENTACAO', '2024-02-28'),
(22, '2024-02-23', 'Ajustar configurações de rede', 'Ajustes de Rede', 2, 4, 'PENDENTE', 3, 'ALTA', 'MANUTENCAO', '2024-03-05'),
(23, '2024-02-24', 'Testar novos protocolos', 'Testes de Protocolos', 2, 4, 'ANDAMENTO', 3, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-08'),
(24, '2024-02-25', 'Analisar desempenho do ambiente', 'Análise de Desempenho', 2, 4, 'ANDAMENTO', 3, 'BAIXA', 'ESTUDO', '2024-03-10'),
(25, '2024-02-26', 'Ajustar comunicação entre dispositivos', 'Ajustes de Comunicação', 2, 4, 'ANDAMENTO', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-12'),
(26, '2024-02-27', 'Avaliar impacto de novas configurações', 'Avaliação de Impacto', 2, 4, 'ANDAMENTO', 3, 'MEDIA', 'ESTUDO', '2024-03-15'),
(27, '2024-02-28', 'Finalizar implementação de rede', 'Finalização de Rede', 2, 4, 'PENDENTE', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-18'),
(28, '2024-02-23', 'Analisar algoritmos de IA', 'Análise de Algoritmos', 2, 5, 'PENDENTE', 4, 'ALTA', 'PESQUISA', '2024-02-28'),
(29, '2024-02-24', 'Implementar modelo preditivo', 'Modelo Preditivo', 2, 5, 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-03'),
(30, '2024-02-25', 'Testar modelo com dados reais', 'Testes Reais', 2, 5, 'PENDENTE', 4, 'ALTA', 'DOCUMENTACAO', '2024-03-08'),
(31, '2024-02-26', 'Ajustar modelo para previsão', 'Ajustes de Modelo', 2, 5, 'ANDAMENTO', 4, 'MEDIA', 'MANUTENCAO', '2024-03-10'),
(32, '2024-02-27', 'Criar relatórios de desempenho', 'Relatórios de Desempenho', 2, 5, 'PENDENTE', 4, 'ALTA', 'DOCUMENTACAO', '2024-03-12'),
(33, '2024-02-28', 'Refatorar modelo preditivo', 'Refatoração de Modelo', 2, 5, 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-15'),
(34, '2024-02-29', 'Ajustar avaliação de risco do modelo', 'Ajuste de Avaliação', 2, 5, 'PENDENTE', 4, 'ALTA', 'MANUTENCAO', '2024-03-18'),
(35, '2024-03-01', 'Testar integração com sistema externo', 'Testes de Integração', 2, 5, 'ANDAMENTO', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-03-20'),
(36, '2024-03-02', 'Refatorar código de previsão', 'Refatoração de Código', 2, 5, 'ANDAMENTO', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-22'),
(37, '2024-02-23', 'Desenvolver protótipo inicial', 'Protótipo Inicial', 2, 7, 'PENDENTE', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-02-28'),
(38, '2024-02-24', 'Ajustar funcionalidades do protótipo', 'Ajustes no Protótipo', 2, 7, 'ANDAMENTO', 5, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-03'),
(39, '2024-02-25', 'Testar protótipo com usuários', 'Testes com Usuários', 2, 7, 'ANDAMENTO', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-08'),
(40, '2024-02-26', 'Documentar o protótipo', 'Documentação do Protótipo', 2, 7, 'PENDENTE', 5, 'BAIXA', 'DOCUMENTACAO', '2024-03-12'),
(41, '2024-02-27', 'Ajustar UI/UX do protótipo', 'Ajustes de UI/UX', 2, 7, 'CONCLUIDA', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-15'),
(42, '2024-02-28', 'Pesquisar como desenvolver testes automatizados', 'Testes Automatizados', 2, 7, 'CONCLUIDA', 5, 'ALTA', 'PESQUISA', '2024-03-18'),
(43, '2024-02-29', 'Integrar sistema com backend', 'Integração Backend', 2, 7, 'PENDENTE', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-20'),
(44, '2024-03-01', 'Melhorar desempenho do protótipo', 'Aprimoramento do Protótipo', 2, 7, 'PENDENTE', 5, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(45, '2024-03-02', 'Estudar como fazer integração de sistema', 'Testes de Integração', 2, 7, 'PENDENTE', 5, 'ALTA', 'ESTUDO', '2024-03-25'),
(46, '2024-02-23', 'Definir requisitos do sistema', 'Requisitos do Sistema', 2, 8, 'CONCLUIDA', 6, 'ALTA', 'PLANEJAMENTO', '2024-02-28'),
(47, '2024-02-24', 'Desenvolver arquitetura do sistema', 'Arquitetura do Sistema', 2, 8, 'ANDAMENTO', 6, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(48, '2024-02-25', 'Implementar funcionalidades principais', 'Funcionalidades Principais', 2, 8, 'CONCLUIDA', 6, 'ALTA', 'DESENVOLVIMENTO', '2024-03-10'),
(49, '2024-02-26', 'Revisar escrita da introdução do projeto', 'Testes de Funcionalidade', 2, 8, 'PENDENTE', 6, 'ALTA', 'DOCUMENTACAO', '2024-03-15'),
(50, '2024-02-27', 'Desenvolver documentação do sistema', 'Documentação do Sistema', 2, 8, 'ANDAMENTO', 6, 'BAIXA', 'DOCUMENTACAO', '2024-03-20'),
(51, '2024-02-28', 'Ajustar código do sistema', 'Ajustes no Sistema', 2, 8, 'CONCLUIDA', 6, 'MEDIA', 'MANUTENCAO', '2024-03-22'),
(52, '2024-02-29', 'Pesquisar como integrar com API externa', 'Testes de Integração', 2, 8, 'CONCLUIDA', 6, 'ALTA', 'PESQUISA', '2024-03-25'),
(53, '2024-03-01', 'Fazer pré apresentação do projeto para banca simulada', 'Testes de Carga', 2, 8, 'PENDENTE', 6, 'ALTA', 'APRESENTACAO', '2024-03-30'),
(54, '2024-03-02', 'Refatorar o código de backend', 'Refatoração de Backend', 2, 8, 'ANDAMENTO', 6, 'MEDIA', 'DESENVOLVIMENTO', '2024-04-05'),
(55, '2024-02-28', 'Definir escopo do sistema', 'Definição de Escopo', 2, 3, 'BACKLOG', 1, 'ALTA', 'PLANEJAMENTO', '2024-03-05'),
(56, '2024-03-01', 'Criar plano de testes para o sistema', 'Plano de Testes', 2, 3, 'BACKLOG', 1, 'MEDIA', 'PLANEJAMENTO', '2024-03-10'),
(57, '2024-03-02', 'Desenvolver documentação inicial', 'Documentação Inicial', 2, 3, 'BACKLOG', 1, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(58, '2024-02-28', 'Revisar arquitetura de IA', 'Revisão de Arquitetura IA', 2, 4, 'BACKLOG', 2, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(59, '2024-03-01', 'Integrar IA com novos dados', 'Integração com Novos Dados', 2, 4, 'BACKLOG', 2, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(60, '2024-03-02', 'Analisar resultados preliminares', 'Análise de Resultados', 2, 4, 'BACKLOG', 2, 'BAIXA', 'ESTUDO', '2024-03-15'),
(61, '2024-02-28', 'Definir protocolo de comunicação', 'Definição de Protocolo', 2, 5, 'BACKLOG', 3, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(62, '2024-03-01', 'Analisar requisitos de segurança', 'Análise de Segurança', 2, 5, 'BACKLOG', 3, 'MEDIA', 'ESTUDO', '2024-03-10'),
(63, '2024-03-02', 'Desenvolver plano de testes de rede', 'Plano de Testes de Rede', 2, 5, 'BACKLOG', 3, 'BAIXA', 'DOCUMENTACAO', '2024-03-15'),
(64, '2024-02-25', 'Desenvolver modelo de detecção de fraudes', 'Modelo de Detecção de Fraudes', 2, 6, 'BACKLOG', 4, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(65, '2024-02-26', 'Integrar modelo com sistema de pagamentos', 'Integração com Pagamentos', 2, 6, 'BACKLOG', 4, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(66, '2024-02-27', 'Pesquisar precisão do modelo de fraude', 'Teste de Precisão', 2, 6, 'BACKLOG', 4, 'BAIXA', 'PESQUISA', '2024-03-15'),
(67, '2024-02-25', 'Desenvolver funcionalidades de cadastro de atividades', 'Cadastro de Atividades', 2, 7, 'BACKLOG', 5, 'ALTA', 'DESENVOLVIMENTO', '2024-03-05'),
(68, '2024-02-26', 'Implementar funcionalidade de validação de horas', 'Validação de Horas', 2, 7, 'BACKLOG', 5, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(69, '2024-02-27', 'Desenvolver módulo de relatórios', 'Módulo de Relatórios', 2, 7, 'BACKLOG', 5, 'BAIXA', 'DESENVOLVIMENTO', '2024-03-15'),
(70, '2024-02-25', 'Analisar vulnerabilidades em redes sem fio', 'Análise de Vulnerabilidades', 2, 8, 'BACKLOG', 6, 'ALTA', 'ESTUDO', '2024-03-05'),
(71, '2024-02-26', 'Desenvolver estratégias de mitigação de riscos', 'Estratégias de Mitigação', 2, 8, 'BACKLOG', 6, 'MEDIA', 'DESENVOLVIMENTO', '2024-03-10'),
(72, '2024-02-27', 'Estudar implementação de soluções de segurança', 'Teste de Soluções de Segurança', 2, 8, 'BACKLOG', 6, 'BAIXA', 'ESTUDO', '2024-03-15')
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