#!/bin/bash

# ==============================================================================
# Script para Popular a API de Veículos com Dados Iniciais
# ==============================================================================
# Este script cria marcas, cores, clientes, modelos e veículos de exemplo
# ==============================================================================

BASE_URL="http://localhost:8080"

echo "╔════════════════════════════════════════════════════════════════╗"
echo "║      🚗 Populando API de Veículos - Dados Iniciais            ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""

# ==============================================================================
# CRIANDO MARCAS
# ==============================================================================

echo "🏭 Criando Marcas..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

echo "📝 Criando marca: Fiat"
MARCA1=$(curl -s -X POST "$BASE_URL/marcas" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Fiat"
}' | jq -r '.id')
echo "   ✅ Marca criada com ID: $MARCA1"
echo ""

echo "📝 Criando marca: Volkswagen"
MARCA2=$(curl -s -X POST "$BASE_URL/marcas" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Volkswagen"
}' | jq -r '.id')
echo "   ✅ Marca criada com ID: $MARCA2"
echo ""

echo "📝 Criando marca: Toyota"
MARCA3=$(curl -s -X POST "$BASE_URL/marcas" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Toyota"
}' | jq -r '.id')
echo "   ✅ Marca criada com ID: $MARCA3"
echo ""

# ==============================================================================
# CRIANDO CORES
# ==============================================================================

echo "🎨 Criando Cores..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

echo "📝 Criando cor: Preto"
COR1=$(curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Preto"
}' | jq -r '.id')
echo "   ✅ Cor criada com ID: $COR1"
echo ""

echo "📝 Criando cor: Branco"
COR2=$(curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Branco"
}' | jq -r '.id')
echo "   ✅ Cor criada com ID: $COR2"
echo ""

echo "📝 Criando cor: Prata"
COR3=$(curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Prata"
}' | jq -r '.id')
echo "   ✅ Cor criada com ID: $COR3"
echo ""

echo "📝 Criando cor: Vermelho"
COR4=$(curl -s -X POST "$BASE_URL/cores" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Vermelho"
}' | jq -r '.id')
echo "   ✅ Cor criada com ID: $COR4"
echo ""

# ==============================================================================
# CRIANDO CLIENTES
# ==============================================================================

echo "👥 Criando Clientes..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

echo "📝 Criando cliente: João Silva"
CLIENTE1=$(curl -s -X POST "$BASE_URL/clientes" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "João Silva",
  "celular": "(48) 99999-9999",
  "email": "joao@example.com",
  "dataCadastro": "2025-12-01"
}' | jq -r '.id')
echo "   ✅ Cliente criado com ID: $CLIENTE1"
echo ""

echo "📝 Criando cliente: Maria Santos"
CLIENTE2=$(curl -s -X POST "$BASE_URL/clientes" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Maria Santos",
  "celular": "(48) 98888-8888",
  "email": "maria@example.com",
  "dataCadastro": "2025-12-01"
}' | jq -r '.id')
echo "   ✅ Cliente criada com ID: $CLIENTE2"
echo ""

echo "📝 Criando cliente: Carlos Oliveira"
CLIENTE3=$(curl -s -X POST "$BASE_URL/clientes" \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Carlos Oliveira",
  "celular": "(48) 97777-7777",
  "email": "carlos@example.com",
  "dataCadastro": "2025-12-01"
}' | jq -r '.id')
echo "   ✅ Cliente criado com ID: $CLIENTE3"
echo ""

# ==============================================================================
# CRIANDO MODELOS
# ==============================================================================

echo "🚙 Criando Modelos..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

echo "📝 Criando modelo: Uno (Fiat)"
MODELO1=$(curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"descricao\": \"Uno\",
  \"marca\": {
    \"id\": $MARCA1
  }
}" | jq -r '.id')
echo "   ✅ Modelo criado com ID: $MODELO1"
echo ""

echo "📝 Criando modelo: Gol (Volkswagen)"
MODELO2=$(curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"descricao\": \"Gol\",
  \"marca\": {
    \"id\": $MARCA2
  }
}" | jq -r '.id')
echo "   ✅ Modelo criado com ID: $MODELO2"
echo ""

echo "📝 Criando modelo: Corolla (Toyota)"
MODELO3=$(curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"descricao\": \"Corolla\",
  \"marca\": {
    \"id\": $MARCA3
  }
}" | jq -r '.id')
echo "   ✅ Modelo criado com ID: $MODELO3"
echo ""

echo "📝 Criando modelo: Palio (Fiat)"
MODELO4=$(curl -s -X POST "$BASE_URL/modelos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"descricao\": \"Palio\",
  \"marca\": {
    \"id\": $MARCA1
  }
}" | jq -r '.id')
echo "   ✅ Modelo criado com ID: $MODELO4"
echo ""

# ==============================================================================
# CRIANDO VEÍCULOS
# ==============================================================================

echo "🚗 Criando Veículos..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

echo "📝 Criando veículo: ABC-1234 (Uno Preto)"
VEICULO1=$(curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"placa\": \"ABC-1234\",
  \"observacoes\": \"Veículo em bom estado\",
  \"motor\": {
    \"potencia\": 75,
    \"tipoCombustivel\": \"FLEX\"
  },
  \"cor\": {
    \"id\": $COR1
  },
  \"modelo\": {
    \"id\": $MODELO1
  },
  \"proprietario\": {
    \"id\": $CLIENTE1
  }
}" | jq -r '.id')
echo "   ✅ Veículo criado com ID: $VEICULO1"
echo "   🔧 Motor: 75cv FLEX"
echo ""

echo "📝 Criando veículo: XYZ-5678 (Gol Branco)"
VEICULO2=$(curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"placa\": \"XYZ-5678\",
  \"observacoes\": \"Revisão em dia\",
  \"motor\": {
    \"potencia\": 80,
    \"tipoCombustivel\": \"GASOLINA\"
  },
  \"cor\": {
    \"id\": $COR2
  },
  \"modelo\": {
    \"id\": $MODELO2
  },
  \"proprietario\": {
    \"id\": $CLIENTE2
  }
}" | jq -r '.id')
echo "   ✅ Veículo criado com ID: $VEICULO2"
echo "   🔧 Motor: 80cv GASOLINA"
echo ""

echo "📝 Criando veículo: DEF-9012 (Corolla Prata)"
VEICULO3=$(curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"placa\": \"DEF-9012\",
  \"observacoes\": \"Carro seminovo\",
  \"motor\": {
    \"potencia\": 154,
    \"tipoCombustivel\": \"FLEX\"
  },
  \"cor\": {
    \"id\": $COR3
  },
  \"modelo\": {
    \"id\": $MODELO3
  },
  \"proprietario\": {
    \"id\": $CLIENTE3
  }
}" | jq -r '.id')
echo "   ✅ Veículo criado com ID: $VEICULO3"
echo "   🔧 Motor: 154cv FLEX"
echo ""

echo "📝 Criando veículo: GHI-3456 (Palio Vermelho)"
VEICULO4=$(curl -s -X POST "$BASE_URL/veiculos" \
  -H 'Content-Type: application/json' \
  -d "{
  \"placa\": \"GHI-3456\",
  \"observacoes\": \"Primeiro veículo\",
  \"motor\": {
    \"potencia\": 85,
    \"tipoCombustivel\": \"GASOLINA\"
  },
  \"cor\": {
    \"id\": $COR4
  },
  \"modelo\": {
    \"id\": $MODELO4
  },
  \"proprietario\": {
    \"id\": $CLIENTE1
  }
}" | jq -r '.id')
echo "   ✅ Veículo criado com ID: $VEICULO4"
echo "   🔧 Motor: 85cv GASOLINA"
echo ""

# ==============================================================================
# RESUMO FINAL
# ==============================================================================

echo ""
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║                   ✅ DADOS POPULADOS COM SUCESSO!              ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""
echo "📊 Resumo:"
echo "   • Marcas criadas: 3"
echo "   • Cores criadas: 4"
echo "   • Clientes criados: 3"
echo "   • Modelos criados: 4"
echo "   • Veículos criados: 4"
echo ""
echo "🔍 Para visualizar os dados:"
echo "   curl http://localhost:8080/marcas | jq '.'"
echo "   curl http://localhost:8080/cores | jq '.'"
echo "   curl http://localhost:8080/clientes | jq '.'"
echo "   curl http://localhost:8080/modelos | jq '.'"
echo "   curl http://localhost:8080/veiculos | jq '.'"
echo ""
echo "📖 Acesse o H2 Console em:"
echo "   http://localhost:8080/h2-console"
echo ""
echo "Fim"
echo ""
echo "Autor: Andre Guilherme Barreto de Farias"
echo "Matrícula: 202111701842"
echo "TÉCNICO EM DESENVOLVIMENTO DE SISTEMAS [3010]/FLN - Técnico - Subsequente - Florianópolis"
echo ""
echo "================================================================="
echo ""
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║    💡 Execute agora o script de testes: ./test-api.sh         ║"
echo "╚════════════════════════════════════════════════════════════════╝"
