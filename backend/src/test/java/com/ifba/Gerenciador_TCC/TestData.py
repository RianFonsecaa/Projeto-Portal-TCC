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
        "id": 20,
        "usuarioId": 1,
        "projetoId": 1,
        "data": "2024-03-10"
    },
    "usuario": {
        "id": 20,
        "senha": "$2y$10$Zi2DIVYzxXYmmNvtGJE9WOd7HtWMUz4jXAFz5UUTY4XAiOrnT7uue",
        "nome": "Nome",
        "email": "Email@gmail.com",
        "telefone": "75999999999",
        "tipoUsuario": "ORIENTANDO",
        "tipoCurso": "ADS"
    }
}