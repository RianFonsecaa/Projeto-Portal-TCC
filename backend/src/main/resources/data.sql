INSERT INTO usuario (id, nome, email, senha, tipo_usuario)
VALUES (1, 'Alex', 'Alex@gmail.com', 'Alex123', 'ORIENTADOR'),
(2, 'Leandro', 'Leandro@gmail.com', 'Leandro123', 'COORDENADOR'),
(3, 'Rian', 'Rian@gmail.com', 'Rian123', 'ORIENTANDO')
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.tarefa (id, data_envio, prazo, descricao, nome_tarefa, orientador_id, orientando_id)
VALUES (1, '2024-02-10', '2024-02-20', 'Finalizar a mockagem das classes', 'Mock das Classes', 1 , 2),
(2, '2024-02-11', '2024-02-25', 'Desenvolver a API de notificação', 'Desenvolvimento da API', 2, 3)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.quadro_demandas (id, demandas_atribuidas, demandas_em_andamento,
demandas_resolvidas) VALUES (1, 10, 5, 3), (2, 15, 7, 5)
ON CONFLICT (id) DO NOTHING;

INSERT INTO public.projeto (id, data_cadastro, descricao_projeto, id_aluno, id_professor,
id_tcc, titulo_projeto, data_ultima_atualizacao, horas_orientacao, progresso,
tipo_curso, tipo_projeto, orientando_id, orientador_id) VALUES
(1, '2024-02-10', 'Desenvolvimento de um sistema web para gestão de tccs', 3, 1, 1,
'Sistema de Gestão Acadêmica TCC', '2024-02-10', 10, 50, 'ADS', 'TCC', 3, 2),
(2, '2024-02-10', 'Aplicação de inteligência artificial na detecção de doenças', 2, 1, 2,
'Aplicação de IA em diagnósticos médicos', '2024-02-10', 15, 70, 'REDES', 'ARTIGO', 2, 1)
ON CONFLICT (id) DO NOTHING;
