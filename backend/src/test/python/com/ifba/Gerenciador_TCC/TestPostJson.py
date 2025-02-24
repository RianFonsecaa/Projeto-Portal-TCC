import requests
import pytest
from TestData import test_data


@pytest.mark.parametrize("endpoint, entity", [
    ("/api/usuarios", "usuario"),
    #("/api/projetos", "projeto"),
    ("/api/tarefas/atribuir", "tarefa")
])

def test_post_json(endpoint, entity):
    url = f"http://localhost:8080{endpoint}"
    payload = test_data[entity]
    headers = {"Content-Type": "application/json"}
    try:
        response = requests.post(url, json=payload, headers=headers)
    except Exception as e:
        pytest.fail(f"Exceção no teste do endpoint {endpoint} (POST JSON): {str(e)}", pytrace=False)
        
    assert response.status_code in [200, 201], f"Erro no endpoint {endpoint} (POST JSON): {response.status_code} - {response.text}"