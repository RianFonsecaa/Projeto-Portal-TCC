INSERT INTO tipousuario (id, descricao_tipo_usuario)
VALUES (1, 'Coordenação'), (2, 'Professor'), (3, 'Aluno')
ON CONFLICT (id) DO NOTHING;

INSERT INTO tipocurso (id, descricao_tipo_curso)
VALUES (1, 'ADS'), (2, 'Redes'), (3, 'Multimídia')
ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, username, nome, email, senha, tipo_usuario_id, tipo_curso_id) 
VALUES (1, 'A', 'Alex', 'Alex@gmail.com', 'Alex123', 2, NULL),
(2, 'L', 'Leandro', 'Leandro@gmail.com', 'Leandro123', 1, 1),
(3, 'R', 'Rian', 'Rian@gmail.com', 'Rian123', 3, 1)
ON CONFLICT (id) DO NOTHING;