# Teste de EndPoint com Python

## Para rodar o teste primeiro instale as dependências se elas não estiverem instaladas:
- Pytest: 'pip install pytest requests' ou 'pip install pytest requests --user' o segundo deve ser usado se ocorrer erro de permissão.
- Faker: 'pip install faker' ou 'pip install faker' --user o segundo deve ser usado se ocorrer erro de permissão
## Depois no caminho da pasta de testes use 'python -m pytest Test(tipo).py' enquanto o servidor estiver rodando. Exemplos:
- Caminho: backend\src\test\java\com\ifba\Gerenciador_TCC>
- 'python -m pytest' Para executar todas as classes que começam com test_
- 'python -m pytest TestGet.py'
- 'python -m pytest TestPostData.py'
- 'python -m pytest TestPostJson.py'