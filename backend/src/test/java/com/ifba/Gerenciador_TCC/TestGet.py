import requests
import pytest

@pytest.mark.parametrize("endpoint", [
    "/api/notificacoes",
    "/api/usuarios",
    "/api/projetos",
    "/api/tarefas"
])

def test_get(endpoint):
    url = f"http://localhost:8081{endpoint}"
    try:
        response = requests.get(url)
    except Exception as e:
        pytest.fail(f"Exceção no teste do endpoint {endpoint} (GET): {str(e)}", pytrace=False)
        
    assert response.status_code in [200, 204], f"Erro no endpoint {endpoint} (GET): {response.status_code} - {response.text}"