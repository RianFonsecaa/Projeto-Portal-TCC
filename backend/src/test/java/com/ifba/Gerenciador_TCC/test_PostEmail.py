import requests
import pytest
from test_Data import test_data


@pytest.mark.parametrize("endpoint, entity", [
    ("/api/email/enviar", "email"),

])

def test_post_data(endpoint, entity):
    url = f"http://localhost:8080{endpoint}"
    payload = test_data[entity]
    headers = {"Content-Type": "application/x-www-form-urlencoded"}
    response = requests.post(url, data=payload, headers=headers)   
    assert response.status_code in [200, 201], f"Erro no endpoint {endpoint} (POST Data): {response.status_code} - {response.text}"