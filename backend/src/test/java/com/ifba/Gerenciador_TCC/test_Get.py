import requests
import pytest

@pytest.mark.parametrize("endpoint", [
    "/api/notificacoes",
    "/api/notificacoes/rian@gmail.com",
    "/api/notificacoes/nao-visualizadas/quantidade/rian@gmail.com",
    "/api/usuarios",
    "/api/usuarios/1",
    "/api/usuarios/dados/1",
    "/api/projetos/1",
    "/api/projetos/orientador/1",
    "/api/projetos/info-projeto-orientando/3",
    "/api/projetos/info-projeto-orientador/1",
    "/documentos"
])

def test_get(endpoint):
    url = f"http://localhost:8080{endpoint}"
    response = requests.get(url)   
    assert response.status_code in [200, 204], f"Erro no endpoint {endpoint} (GET): {response.status_code} - {response.text}"