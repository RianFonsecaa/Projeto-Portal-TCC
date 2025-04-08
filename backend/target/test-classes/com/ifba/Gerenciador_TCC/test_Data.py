import random
from faker import Faker

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
        "data": "2024-03-10"
    },
    "usuario": {
        "id": None,
        "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
        "nome": faker.name(),
        "email": faker.email(),
        "telefone": faker.phone_number(),
        "tipoUsuario": "ORIENTANDO",
        "tipoCurso": "ADS"
    }
}