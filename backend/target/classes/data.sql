INSERT INTO usuario (id, username, nome, email, senha, tipo_usuario, tipo_curso) 
VALUES (1, 'A', 'Alex', 'Alex@gmail.com', 'Alex123', 'PROFESSOR', NULL),
(2, 'L', 'Leandro', 'Leandro@gmail.com', 'Leandro123', 'COORDENADOR', 'ADS'),
(3, 'R', 'Rian', 'Rian@gmail.com', 'Rian123', 'ALUNO', 'ADS')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.reuniao (id, data_reuniao, descricao, id_usuario, nome_reuniao)
VALUES (1, '2024-02-01', 'Reunião inicial da 4° sprint', 1, 'Sprint 4'),
(2, '2024-02-07', 'Revisão da 4° sprint', 3, 'Acompanhamento de Sprint')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.tarefa (id, data_envio, data_fim, descricao, nome_tarefa, usuario_id)
VALUES (1, '2024-02-10', '2024-02-20', 'Finalizar a mockagem das classes', 'Mock das Classes', 1),
(2, '2024-02-11', '2024-02-25', 'Desenvolver a API de notificação', 'Desenvolvimento da API', 2)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.quadro_demandas (id, demandas_atribuidas, demandas_em_andamento,
demandas_resolvidas) VALUES (1, 10, 5, 3), (2, 15, 7, 5)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.tcc (id, data_entrega, data_inicio, descricao,
status, titulo, quadro_demandas_id) VALUES 
(1, '2024-06-30', '2024-01-15', 'Desenvolvimento de um sistema web para gestão de tccs', 'True', 'Sistema Web para Gestão Acadêmica', 1),
(2, '2024-07-15', '2024-02-01', 'Aplicação de inteligência artificial na detecção de doenças', 'False', 'IA para Diagnóstico Médico', 2)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.projeto (id, data_cadastro, descricao_projeto, id_aluno, id_professor,
id_tcc, titulo_projeto, data_ultima_atualizacao, horas_orientacao, progresso,
tipo_curso, tipo_projeto, aluno_id, orientador_id, tcc_id) VALUES 
(1, '2024-02-10', 'Desenvolvimento de um sistema web para gestão de tccs', 3, 1, 1,
'Sistema de Gestão Acadêmica TCC', '2024-02-10', 10, 50, 'ADS', 'TCC', 3, 2, 1),
(2, '2024-02-10', 'Aplicação de inteligência artificial na detecção de doenças', 2, 1, 2,
'Aplicação de IA em diagnósticos médicos', '2024-02-10', 15, 70, 'REDES', 'ARTIGO', 2, 1, 2)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.documento (id, data_envio, descricao, nome_documento,
tipo_documento, url_arquivo, projeto_id, documento_id) VALUES 
(1, '2024-02-10', 'Ata da Reunião', 'reunião.docx', 'DOCX', 'https://gerenciadortcc.com/reuniao.docx', 1, 1),
(2, '2024-02-10', 'Relatório final', 'relatorio.pdf', 'PDF', 'https://gerenciadortcc/relatorio.pdf', 2, 2)
ON CONFLICT (id) DO NOTHING;