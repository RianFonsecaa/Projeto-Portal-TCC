import random
from faker import Faker

faker = Faker()

test_data = {
    "email": {
        "para": "ifbanotificacao@gmail.com",
        "tipo": random.choice(["NOTIFICACAO", "ADVERTENCIA", "BOAS_VINDAS"]),
        "remetenteNotificacao": faker.email()
    },
    "usuario": {
        "id": 20,
        "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
        "nome": "Nome",
        "email": "Email@gmail.com",
        "telefone": "75999999999",
        "tipoUsuario": "ORIENTANDO",
        "tipoCurso": "ADS"
    },
    "projeto":{
        "id": 20,
        "orientandoId": {
            "id": 5,
            "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
            "nome": "Pedro",
            "email": "Pedro@gmail.com",
            "telefone": "75999999999",
            "tipoUsuario": "ORIENTANDO",
            "tipoCurso": "REDES"
        },
        "orientadorId": {
            "id": 1,
            "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
            "nome": "Alex",
            "email": "Alex@gmail.com",
            "telefone": "75999999999",
            "tipoUsuario": "ORIENTADOR",
            "areaPesquisa": "Interligencia Artificial",
            "cargo": "Professor",
            "orientadorDisponivel": False,
            "projetosEmOrientacao": 3,
            "resumo": "Resumo"
        },
        "tituloProjeto": "Titulo",
        "descricaoProjeto": "Descricao",
        "dataCadastro": "2024-03-10",
        "dataUltimaAtualizacao": "2024-03-15",
        "horasOrientacao": 3,
        "progresso": 10,
        "tipoProjeto": "TCC",
        "tipoCurso": "REDES"
    },
    "tarefa": {
        "id": 50,
        "orientadorId": 4,
        "orientandoId": 5,
        "projetoId": 1,
        "nomeTarefa": "Nome da Tarefa",
        "descricao": "Descricao da Tarefa",
        "dataEnvio": "2024-03-10",
        "status": "PENDENTE",
        "prioridade": "ALTA",
        "classificacao": "DESENVOLVIMENTO",
        "prazo": "2024-03-15"
    }
}