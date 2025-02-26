import requests
import pytest
from TestData import test_data


@pytest.mark.parametrize("endpoint, entity", [
    ("/api/email/enviar", "email"),
])

def test_post_data(endpoint, entity):
    url = f"http://localhost:8081{endpoint}"
    payload = test_data[entity]
    headers = {"Content-Type": "application/x-www-form-urlencoded"}
    try:
        response = requests.post(url, data=payload, headers=headers)
    except Exception as e:
        pytest.fail(f"Exceção no teste do endpoint {endpoint} (POST Data): {str(e)}", pytrace=False)
        
    assert response.status_code in [200, 201], f"Erro no endpoint {endpoint} (POST Data): {response.status_code} - {response.text}"