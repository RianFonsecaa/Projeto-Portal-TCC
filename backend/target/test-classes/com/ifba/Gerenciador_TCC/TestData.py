from faker import Faker

faker = Faker()

test_data = {
    "email": {
        "para": "ifbanotificacao@gmail.com",
        "tipo": "NOTIFICACAO",
        "remetenteNotificacao": faker.email()
    },
    "usuario": {
        "nome": "Teste",
        "email": "teste@email.com",
        "senha": "teste123",
        "tipoUsuario": "ORIENTANDO"
    },
   # "projeto":{
   #     "id": 5,
   #     "orientandoId": 3,
   #     "orientadorId": 1,
   #     "tituloProjeto": "Aplicação de IA em diagnósticos",
   #     "descricaoProjeto": "Aplicação de inteligência artificial na detecção de problemas",
   #     "dataCadastro": "2024-02-10",
   #     "dataUltimaAtualizacao": "2024-02-25",
   #     "horasOrientacao": 15,
   #     "progresso": 70,
   #     "tipoProjeto": "ARTIGO",
   #     "tipoCurso": "REDES"
   # },
    "tarefa": {
        "id": 4,
        "orientadorId": 2,
        "orientandoId": 3,
        "projetoId": 2,
        "idDocumento": "null",
        "nomeTarefa": "Desenvolvimento da IA",
        "descricao": "Desenvolver a IA de Teste",
        "dataEnvio": "2024-02-11",
        "dataFim": "2024-02-22",
        "status": "ANDAMENTO",
        "prioridade": "MEDIA",
        "classificacao": "PESQUISA",
        "alerta": "true",
        "prazo": "2024-02-27"
    }
}