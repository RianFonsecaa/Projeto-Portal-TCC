/* Tipos de Usuario */
INSERT INTO tipousuario (id, descricao_tipo_usuario) VALUES (1, 'Coordenação')
ON CONFLICT (id) DO NOTHING;
INSERT INTO tipousuario (id, descricao_tipo_usuario) VALUES (2, 'Professor')
ON CONFLICT (id) DO NOTHING;
INSERT INTO tipousuario (id, descricao_tipo_usuario) VALUES (3, 'Aluno')
ON CONFLICT (id) DO NOTHING;

/* Tipos de Curso */
INSERT INTO tipocurso (id, descricao_tipo_curso) VALUES (1, 'ADS')
ON CONFLICT (id) DO NOTHING;
INSERT INTO tipocurso (id, descricao_tipo_curso) VALUES (2, 'Redes')
ON CONFLICT (id) DO NOTHING;
INSERT INTO tipocurso (id, descricao_tipo_curso) VALUES (3, 'Multimídia')
ON CONFLICT (id) DO NOTHING;

/* Usuarios */
INSERT INTO usuario (id, nome, email, senha, tipo_usuario_id, tipo_curso_id) 
VALUES (1, 'Alex', 'Alex@gmail.com', 'Alex123', 2, NULL)
ON CONFLICT (id) DO NOTHING;
INSERT INTO usuario (id, nome, email, senha, tipo_usuario_id, tipo_curso_id) 
VALUES (2, 'Leandro', 'Leandro@gmail.com', 'Leandro123', 1, 1)
ON CONFLICT (id) DO NOTHING;
INSERT INTO usuario (id, nome, email, senha, tipo_usuario_id, tipo_curso_id) 
VALUES (3, 'Rian', 'Rian@gmail.com', 'Rian123', 3, 1)
ON CONFLICT (id) DO NOTHING;