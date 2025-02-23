from faker import Faker

faker = Faker()

test_data = {
    "email": {
        "para": "ifbanotificacao@gmail.com",
        "assunto": faker.sentence(nb_words=2),
        "tipo": "NOTIFICACAO",
        "remetenteNotificacao": faker.email()
    },
    "tarefa": {
        "nomeTarefa": faker.sentence(nb_words=3),
        "prazo": "2024-02-27",
        "dataEnvio": "2025-02-25",
        "descricao": faker.text(),
        "orientadorId": 1,
        "orientandoId": 2
    },
    "usuario": {
        "nome": "Teste",
        "email": "teste@email.com",
        "senha": "teste123",
        "tipoUsuario": "ORIENTANDO"
    },
}