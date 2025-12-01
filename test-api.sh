#!/bin/bash

# ==============================================================================
# Script de Testes da API de Veículos
# ==============================================================================

BASE_URL="http://localhost:8080"

echo "🚀 Iniciando testes da API de Veículos..."
echo ""

# ==============================================================================
# TESTES DE MARCAS
# ==============================================================================

echo "🏭 ========== MARCAS =========="
echo ""

echo "➤ 1. POST /marcas - Criando Honda"
curl -s -X POST "$BASE_URL/marcas" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Honda"
}' | jq '.'
echo ""

echo "➤ 2. POST /marcas - Criando Chevrolet"
curl -s -X POST "$BASE_URL/marcas" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Chevrolet"
}' | jq '.'
echo ""

echo "➤ 3. GET /marcas - Listando todas as marcas"
curl -s "$BASE_URL/marcas" | jq '.'
echo ""

echo "➤ 4. GET /marcas/1 - Buscando marca por ID"
curl -s "$BASE_URL/marcas/1" | jq '.'
echo ""

echo "➤ 5. PUT /marcas/1 - Atualizando marca"
curl -s -X PUT "$BASE_URL/marcas/1" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Fiat Automóveis"
}' | jq '.'
echo ""

# ==============================================================================
# TESTES DE CORES
# ==============================================================================

echo "🎨 ========== CORES =========="
echo ""

echo "➤ 6. POST /cores - Criando Azul"
curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Azul"
}' | jq '.'
echo ""

echo "➤ 7. POST /cores - Criando Verde"
curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Verde"
}' | jq '.'
echo ""

echo "➤ 8. GET /cores - Listando todas as cores"
curl -s "$BASE_URL/cores" | jq '.'
echo ""

echo "➤ 9. GET /cores/1 - Buscando cor por ID"
curl -s "$BASE_URL/cores/1" | jq '.'
echo ""

echo "➤ 10. PUT /cores/1 - Atualizando cor"
curl -s -X PUT "$BASE_URL/cores/1" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Preto Fosco"
}' | jq '.'
echo ""

# ==============================================================================
# TESTES DE CLIENTES
# ==============================================================================

echo "👥 ========== CLIENTES =========="
echo ""

echo "➤ 11. POST /clientes - Criando Pedro Henrique"
curl -s -X POST "$BASE_URL/clientes" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Pedro Henrique",
  "celular": "(48) 91111-1111",
  "email": "pedro@example.com",
  "dataCadastro": "2025-12-01"
}' | jq '.'
echo ""

echo "➤ 12. POST /clientes - Criando Ana Paula"
curl -s -X POST "$BASE_URL/clientes" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Ana Paula",
  "celular": "(48) 92222-2222",
  "email": "ana@example.com",
  "dataCadastro": "2025-12-01"
}' | jq '.'
echo ""

echo "➤ 13. GET /clientes - Listando todos os clientes"
curl -s "$BASE_URL/clientes" | jq '.'
echo ""

echo "➤ 14. GET /clientes/1 - Buscando cliente por ID"
curl -s "$BASE_URL/clientes/1" | jq '.'
echo ""

echo "➤ 15. PUT /clientes/1 - Atualizando cliente"
curl -s -X PUT "$BASE_URL/clientes/1" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "João Silva Santos",
  "celular": "(48) 99999-0000",
  "email": "joao.santos@example.com",
  "dataCadastro": "2025-12-01"
}' | jq '.'
echo ""

# ==============================================================================
# TESTES DE MODELOS
# ==============================================================================

echo "🚙 ========== MODELOS =========="
echo ""

echo "➤ 16. POST /modelos - Criando Civic (Honda)"
curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d '{
  "descricao": "Civic",
  "marca": {
    "id": 4
  }
}' | jq '.'
echo ""

echo "➤ 17. POST /modelos - Criando Onix (Chevrolet)"
curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d '{
  "descricao": "Onix",
  "marca": {
    "id": 5
  }
}' | jq '.'
echo ""

echo "➤ 18. GET /modelos - Listando todos os modelos"
curl -s "$BASE_URL/modelos" | jq '.'
echo ""

echo "➤ 19. GET /modelos/1 - Buscando modelo por ID"
curl -s "$BASE_URL/modelos/1" | jq '.'
echo ""

echo "➤ 20. PUT /modelos/1 - Atualizando modelo"
curl -s -X PUT "$BASE_URL/modelos/1" \
  -H 'Content-Type: application/json' \
  -d '{
  "descricao": "Uno Vivace",
  "marca": {
    "id": 1
  }
}' | jq '.'
echo ""

# ==============================================================================
# TESTES DE VEÍCULOS
# ==============================================================================

echo "🚗 ========== VEÍCULOS =========="
echo ""

echo "➤ 21. POST /veiculos - Criando JKL-7890 (Civic Azul)"
curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d '{
  "placa": "JKL-7890",
  "observacoes": "Veículo importado",
  "motor": {
    "potencia": 150,
    "tipoCombustivel": "GASOLINA"
  },
  "cor": {
    "id": 5
  },
  "modelo": {
    "id": 5
  },
  "proprietario": {
    "id": 4
  }
}' | jq '.'
echo ""

echo "➤ 22. POST /veiculos - Criando MNO-4567 (Onix Verde)"
curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d '{
  "placa": "MNO-4567",
  "observacoes": "Carro zero km",
  "motor": {
    "potencia": 116,
    "tipoCombustivel": "FLEX"
  },
  "cor": {
    "id": 6
  },
  "modelo": {
    "id": 6
  },
  "proprietario": {
    "id": 5
  }
}' | jq '.'
echo ""

echo "➤ 23. GET /veiculos - Listando todos os veículos"
curl -s "$BASE_URL/veiculos" | jq '.'
echo ""

echo "➤ 24. GET /veiculos/1 - Buscando veículo por ID"
curl -s "$BASE_URL/veiculos/1" | jq '.'
echo ""

echo "➤ 25. PUT /veiculos/1 - Atualizando observações do veículo"
curl -s -X PUT "$BASE_URL/veiculos/1" \
  -H 'Content-Type: application/json' \
  -d '{
  "placa": "ABC-1234",
  "observacoes": "Veículo com manutenção recente",
  "motor": {
    "potencia": 75,
    "tipoCombustivel": "FLEX"
  },
  "cor": {
    "id": 1
  },
  "modelo": {
    "id": 1
  },
  "proprietario": {
    "id": 1
  }
}' | jq '.'
echo ""

# ==============================================================================
# TESTES DE VALIDAÇÃO E ERROS
# ==============================================================================

echo "⚠️  ========== TESTES DE VALIDAÇÃO =========="
echo ""

echo "➤ 26. GET /marcas/999 - Buscando marca inexistente (deve retornar 404)"
curl -s "$BASE_URL/marcas/999" | jq '.'
echo ""

# ==============================================================================
# TESTES DE DELEÇÃO
# ==============================================================================

echo "🗑️  ========== TESTES DE DELEÇÃO =========="
echo ""

echo "➤ 27. DELETE /veiculos/2 - Deletando veículo XYZ-5678"
curl -s -X DELETE "$BASE_URL/veiculos/2" -w "\nHTTP Status: %{http_code}\n"
echo ""

echo "➤ 28. GET /veiculos - Verificando que o veículo foi deletado"
curl -s "$BASE_URL/veiculos" | jq '.'
echo ""

echo "✅ Testes concluídos!"
