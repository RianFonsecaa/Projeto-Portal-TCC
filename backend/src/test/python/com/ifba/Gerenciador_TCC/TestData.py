from faker import Faker

faker = Faker()

test_data = {
    "email": {
        "para": "ifbanotificacao@gmail.com",
        "assunto": faker.sentence(nb_words=2),
        "tipo": "NOTIFICACAO",
        "remetenteNotificacao": faker.email()
    },
}