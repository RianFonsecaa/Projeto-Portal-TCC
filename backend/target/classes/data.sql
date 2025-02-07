INSERT INTO usuario (id, username, nome, email, senha, tipo_usuario, tipo_curso) 
VALUES (1, 'A', 'Alex', 'Alex@gmail.com', 'Alex123', 'PROFESSOR', NULL),
(2, 'L', 'Leandro', 'Leandro@gmail.com', 'Leandro123', 'COORDENADOR', 'ADS'),
(3, 'R', 'Rian', 'Rian@gmail.com', 'Rian123', 'ALUNO', 'ADS')
ON CONFLICT (id) DO NOTHING;