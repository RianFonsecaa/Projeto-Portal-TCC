import requests
import pytest
from test_Data import test_data


@pytest.mark.parametrize("endpoint, entity", [
    ("/api/usuarios", "usuario"),
    ("/api/notificacoes", "notificacao")
])

def test_post_json(endpoint, entity):
    url = f"http://localhost:8080{endpoint}"
    payload = test_data[entity]
    headers = {"Content-Type": "application/json"}
    response = requests.post(url, json=payload, headers=headers)     
    assert response.status_code in [200, 201], f"Erro no endpoint {endpoint} (POST JSON): {response.status_code} - {response.text}"