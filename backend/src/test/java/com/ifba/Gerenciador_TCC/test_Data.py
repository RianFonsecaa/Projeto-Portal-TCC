import random
from faker import Faker
import datetime

faker = Faker()

test_data = {
    "email": {
        "para": "ifbanotificacao@gmail.com",
        "tipo": random.choice(["NOTIFICACAO", "ADVERTENCIA", "BOAS_VINDAS"]),
        "remetenteNotificacao": faker.email()
    },
    "notificacao": {
        "id": None,
        "usuarioId": 1,
        "projetoId": 1,
        "data": (datetime.datetime.now()).strftime("%Y-%m-%d")
    },
    "usuario": {
        "id": None,
        "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
        "nome": faker.name(),
        "email": faker.email(),
        "telefone": faker.phone_number(),
        "tipoUsuario": "ORIENTANDO",
        "tipoCurso": random.choice(["ADS", "REDES", "MULTIMIDIA"])
    },
    "tarefa": {
        "id": None,
        "codigo": "T" + str(random.randint(1000, 9999)),
        "projetoId": 1,
        "titulo": faker.sentence(nb_words=5),
        "descricao": faker.paragraph(),
        "status": random.choice(["BACKLOG", "PENDENTE", "ANDAMENTO", "CONCLUIDA"]),
        "prioridade": random.choice(["ALTA", "MEDIA", "BAIXA"]),
        "etapa": "Desenvolvimento",
        "classificacao": random.choice(["BIBLIOGRAFIA", "REDACAO", "DESENVOLVIMENTO", "MANUTENCAO", 
                                      "PESQUISA", "ESTUDO", "PLANEJAMENTO", "REVISAO", 
                                      "DOCUMENTACAO", "APRESENTACAO"]),
        "ultimaAtualizacaoEm": datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
        "ultimaAtualizacaoPor": faker.name(),
        "criacaoEm": datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
        "criacaoPor": faker.name(),
        "dataInicio": (datetime.datetime.now()).strftime("%Y-%m-%d"),
        "dataFim": (datetime.datetime.now() + datetime.timedelta(days=random.randint(7, 30))).strftime("%Y-%m-%d")
    }
}