import requests
import pytest
from TestData import test_data
@pytest.mark.parametrize("endpoint, entity, method, use_json", [
    ("/api/email/enviar", "email", "POST", False),
    ("/api/notificacoes", "notificacao", "GET", False),
    ("/api/usuarios", "usuario", "GET", False),
    ("/api/usuarios", "usuario", "POST", True),
    ("/api/projetos", "projeto", "GET", False),
    #("/api/projetos", "projeto", "POST", True),
    ("/api/tarefas", "tarefa", "GET", False),
    ("/api/tarefas/atribuir", "tarefa", "POST", True)
])
def test_entidades(endpoint, entity, method, use_json):
    url = f"http://localhost:8080{endpoint}"
    
    try:
        if method == "GET":
            response = requests.get(url)
        elif method == "POST":
            payload = test_data[entity]
            headers = {"Content-Type": "application/json"} if use_json else {"Content-Type": "application/x-www-form-urlencoded"}
            response = requests.post(url, json=payload if use_json else None, data=None if use_json else payload, headers=headers)
        else:
            pytest.fail(f"Método {method} não suportado")
        
        expected_status = [200, 201] if method == "POST" else [200, 204]
        assert response.status_code in expected_status, f"Erro no endpoint {endpoint} ({method}): {response.status_code} - {response.text}"
    except Exception as e:
        pytest.fail(f"Exceção no teste do endpoint {endpoint} ({method}): {str(e)}", pytrace=False)