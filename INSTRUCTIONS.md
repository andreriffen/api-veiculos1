# INSTRUÇÕES: Mão na Massa 1 - API para Gerenciar Veículos

API REST desenvolvida com Spring Boot para gerenciamento de veículos, clientes, marcas, modelos e cores.

![Java 17+](https://img.shields.io/badge/Java%2017%2B-007396?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot 3.4.0](https://img.shields.io/badge/Spring%20Boot%203.4.0-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Maven 3.6+](https://img.shields.io/badge/Maven%203.6%2B-C71A36?style=flat-square&logo=apachemaven&logoColor=white)


        🔴 🟩🟩    __/\\\\\\\\\\\__/\\\\\\\\\\\\\\\_____/\\\\\\\\\\\__________/\\\\\\\\\_        
        🟩 🟩        _\/////\\\///__\/\\\///////////____/\\\/////////\\\_____/\\\////////__       
        🟩 🟩🟩      _____\/\\\_____\/\\\______________\//\\\______\///____/\\\/___________      
        🟩 🟩          _____\/\\\_____\/\\\\\\\\\\\_______\////\\\__________/\\\_____________     
                         _____\/\\\_____\/\\\///////___________\////\\\______\/\\\_____________    
                          _____\/\\\_____\/\\\_____________________\////\\\___\//\\\____________   
                            _____\/\\\_____\/\\\______________/\\\______\//\\\___\///\\\__________  
                             __/\\\\\\\\\\\_\/\\\_____________\///\\\\\\\\\\\/______\////\\\\\\\\\_ 
                              _\///////////__\///________________\///////////___________\/////////__
                              

> 📖 **[Acessar o sumário "README.md" →](README.md)**

- ⭐ **[Repositório GitHub ↗](https://github.com/andreriffen/api-veiculos1)**

- Acessar trecho do terminal [populando dados →](#-exemplo-de-execução)

- Acessar trecho do terminal [testando as endpoints →](#-exemplo-de-teste-após-inserção-de-dados)

---

> *Aluno:* **ANDRE GUILHERME BARRETO DE FARIAS**

> *Matrícula:* **202111701842**

> *Disciplina:* **Mão na Massa 1 - API para Gerenciar Veículos**

> *Curso:* **TÉCNICO EM DESENVOLVIMENTO DE SISTEMAS [3010]/FLN - Técnico - Subsequente - Florianópolis**

---

## 📑 Índice (Instruções de execução)

- [1. 🎯 Início Rápido](#1--início-rápido)
  - [1.1. Pré-requisitos](#11-pré-requisitos)
  - [1.2. Executando a Aplicação](#12-executando-a-aplicação)
- [2. 📡 Acessando a API](#2--acessando-a-api)
  - [2.1. H2 Console](#21-h2-console-recomendado)
  - [2.2. Testando com cURL](#22-testando-com-curl)
- [3. 🧪 Testando a API](#3--testando-a-api)
  - [3.1. População Automática](#31-população-automática-recomendado)
  - [3.2. Testes Manuais](#32-testes-manuais)
  - [3.3. Testando Endpoints Individuais](#33-testando-endpoints-individuais)
- [4. 📋 Endpoints Disponíveis](#4--endpoints-disponíveis)
- [5. 🏗️ Estrutura do Projeto](#5-️-estrutura-do-projeto)
- [6. 🛠️ Tecnologias Utilizadas](#6-️-tecnologias-utilizadas)
- [7. 📦 Build da Aplicação](#7--build-da-aplicação)
- [8. ⚙️ Configuração do Banco de Dados](#8-️-configuração-do-banco-de-dados)
- [9. 🐛 Resolução de Problemas](#9--resolução-de-problemas)
- [10. 📊 Modelo de Dados](#10--modelo-de-dados)
- [11. 🔗 Links Úteis](#11--links-úteis)
- [12. 🎬 **Exemplo de Execução (ENTREGA)**](#12--exemplo-de-execução)
- [13. 🧪 Exemplo de Teste Após Inserção de Dados](#13--exemplo-de-teste-após-inserção-de-dados)
- [14. 📜 Licença](#14--licença)
- [15. ☕ Autor @andreriffen](#15--autor)

---

## 1. 🎯 Início Rápido

### 1.1. Pré-requisitos

- **Java 17+** ![Java 17+](https://img.shields.io/badge/Java%2017%2B-007396?style=flat-square&logo=openjdk&logoColor=white)
- **Maven 3.6+** ![Maven 3.6+](https://img.shields.io/badge/Maven%203.6%2B-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
- **Spring Boot** ![Spring Boot 3.5.9](https://img.shields.io/badge/Spring%20Boot%203.5.9-6DB33F?style=flat-square&logo=springboot&logoColor=white)
- **curl** e **jq** (opcional, para testes)

---

### 1.2. Executando a Aplicação

1. **(Apenas na primeira execução)** ajuste as permissões dos scripts:
  ```bash
  chmod +x mvnw
  chmod +x startup.sh
  chmod +x populate-data.sh
  chmod +x test-api.sh
  ```

2. **Inicie a aplicação (opção recomendada):**
  ```bash
  ./startup.sh
  ```
  Esse script garante que o Java esteja configurado, compila o projeto (se necessário), verifica a porta 8080 e sobe o Spring Boot.

3. **Ou execute via Maven diretamente:**
  ```bash
  ./mvnw spring-boot:run
  ```
  No Windows:
  ```cmd
  mvnw.cmd spring-boot:run
  ```

4. **Aguarde a mensagem de inicialização:**
  ```
  Started ApiVeiculos1Application in X.XXX seconds
  ```

5. **A aplicação estará disponível em:** `http://localhost:8080`

---

## 2. 📡 Acessando a API

### 2.1. H2 Console (Recomendado)

Acesse o console do banco de dados em memória:
```
http://localhost:8080/h2-console
```

**Detalhes da Conexão:**
- JDBC URL: `jdbc:h2:mem:lavacao`
- Username: `sa`
- Password: *(deixe em branco)*

### 2.2. Testando com cURL

Você pode testar os endpoints diretamente via terminal:

```bash
# Listar todos os veículos
curl http://localhost:8080/veiculos

# Criar uma nova marca
curl -X POST http://localhost:8080/marcas \
  -H 'Content-Type: application/json' \
  -d '{"nome":"Fiat"}'
```

---

## 3. 🧪 Testando a API

### 3.1. População Automática (Recomendado)

Popule o banco de dados com dados de exemplo:

```bash
chmod +x populate-data.sh
./populate-data.sh
```

Este script cria:
- 3 marcas (Fiat, Volkswagen, Toyota)
- 4 cores (Preto, Branco, Prata, Vermelho)
- 3 clientes
- 4 modelos vinculados às marcas
- 4 veículos completos

### 3.2. Testes Manuais

Execute a suite completa de testes:

```bash
chmod +x test-api.sh
./test-api.sh
```

Este script testa todos os endpoints (POST, GET, PUT, DELETE) para todas as entidades.

### 3.3. Testando Endpoints Individuais

**Criar uma Marca:**
```bash
curl -X POST http://localhost:8080/marcas \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Fiat"
}'
```

**Listar Todas as Marcas:**
```bash
curl http://localhost:8080/marcas | jq '.'
```

**Criar uma Cor:**
```bash
curl -X POST http://localhost:8080/cores \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Preto"
}'
```

**Criar um Cliente:**
```bash
curl -X POST http://localhost:8080/clientes \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "João Silva",
  "celular": "(48) 99999-9999",
  "email": "joao@example.com",
  "dataCadastro": "2025-12-01"
}'
```

**Criar um Modelo:**
```bash
curl -X POST http://localhost:8080/modelos \
  -H 'Content-Type: application/json' \
  -d '{
  "descricao": "Uno",
  "marca": {
    "id": 1
  }
}'
```

**Criar um Veículo:**
```bash
curl -X POST http://localhost:8080/veiculos \
  -H 'Content-Type: application/json' \
  -d '{
  "placa": "ABC-1234",
  "observacoes": "Veículo em bom estado",
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
}'
```

---

## 4. 📋 Endpoints Disponíveis

### Marcas (`/marcas`)
- `POST /marcas` - Criar nova marca
- `GET /marcas` - Listar todas as marcas
- `GET /marcas/{id}` - Buscar marca por ID
- `PUT /marcas/{id}` - Atualizar marca
- `DELETE /marcas/{id}` - Deletar marca

### Cores (`/cores`)
- `POST /cores` - Criar nova cor
- `GET /cores` - Listar todas as cores
- `GET /cores/{id}` - Buscar cor por ID
- `PUT /cores/{id}` - Atualizar cor
- `DELETE /cores/{id}` - Deletar cor

### Clientes (`/clientes`)
- `POST /clientes` - Criar novo cliente
- `GET /clientes` - Listar todos os clientes
- `GET /clientes/{id}` - Buscar cliente por ID
- `PUT /clientes/{id}` - Atualizar cliente
- `DELETE /clientes/{id}` - Deletar cliente

### Modelos (`/modelos`)
- `POST /modelos` - Criar novo modelo
- `GET /modelos` - Listar todos os modelos
- `GET /modelos/{id}` - Buscar modelo por ID
- `PUT /modelos/{id}` - Atualizar modelo
- `DELETE /modelos/{id}` - Deletar modelo

### Veículos (`/veiculos`)
- `POST /veiculos` - Criar novo veículo
- `GET /veiculos` - Listar todos os veículos
- `GET /veiculos/{id}` - Buscar veículo por ID
- `PUT /veiculos/{id}` - Atualizar veículo
- `DELETE /veiculos/{id}` - Deletar veículo

---

## 5. 🏗️ Estrutura do Projeto

```
src/main/java/com/example/api_veiculos1/
├── model/          # Entidades JPA
│   ├── enums/
│   │   ├── ECategoria.java
│   │   └── ETipoCombustivel.java
│   ├── Motor.java (@Embeddable)
│   ├── Marca.java
│   ├── Cor.java
│   ├── Cliente.java
│   ├── Modelo.java
│   └── Veiculo.java
├── repository/     # Interfaces JpaRepository
│   ├── MarcaRepository.java
│   ├── CorRepository.java
│   ├── ClienteRepository.java
│   ├── ModeloRepository.java
│   └── VeiculoRepository.java
└── controller/     # Endpoints REST
    ├── MarcaController.java
    ├── CorController.java
    ├── ClienteController.java
    ├── ModeloController.java
    └── VeiculoController.java
```

---

## 6. 🛠️ Tecnologias Utilizadas

- **Spring Boot 3.5.9** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - ORM
- **H2 Database** - Banco de dados em memória
- **Lombok** - Redução de código boilerplate
- **Jakarta Bean Validation** - Validação de entrada
- **Maven** - Gerenciamento de dependências

**Arquitetura:** Simples 3 camadas - Model, Repository, Controller (sem DTOs ou Services, conforme especificação do exercício).

---

## 7. 📦 Build da Aplicação

### Criar arquivo JAR:
```bash
./mvnw clean package
```

O JAR será gerado em: `target/api-veiculos1-0.0.1-SNAPSHOT.jar`

### Executar o JAR:
```bash
java -jar target/api-veiculos1-0.0.1-SNAPSHOT.jar
```

---

## 8. ⚙️ Configuração do Banco de Dados

### Banco de Dados H2 (em memória) - Configuração Atual

```properties
spring.datasource.url=jdbc:h2:mem:lavacao
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### Banco de Dados MySQL (Opcional)

Para usar MySQL, atualize o `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/lavacao
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## 9. 🐛 Resolução de Problemas

**Porta 8080 já está em uso:**
```bash
# Encontrar processo usando porta 8080
lsof -i :8080
# Matar o processo
kill -9 <PID>
```

**Maven wrapper não executável:**
```bash
chmod +x mvnw
```

**jq não encontrado:**
```bash
# Ubuntu/Debian
sudo apt-get install jq

# macOS
brew install jq

# Ou omita jq dos comandos curl
curl http://localhost:8080/veiculos
```

**Erro de validação ao criar registros:**
- Verifique se todos os campos obrigatórios estão preenchidos
- Email deve ter formato válido
- Relacionamentos (@ManyToOne) devem referenciar IDs existentes

---

## 10. 📊 Modelo de Dados

### Diagrama de Classes

- 📊 [Visualizar Diagrama de Classes →](class-diagram.png)

### Relacionamentos:
- **Modelo** pertence a uma **Marca** (@ManyToOne)
- **Veículo** tem uma **Cor** (@ManyToOne)
- **Veículo** tem um **Modelo** (@ManyToOne)
- **Veículo** tem um **Proprietário** (Cliente) (@ManyToOne)
- **Veículo** possui um **Motor** (@Embedded)

---

## 11. 🔗 Links Úteis

- **[Sumário do Projeto](README.md)** - Visão geral e documentação completa
- **[Repositório GitHub](https://github.com/andreriffen/api-veiculos1)** - Código fonte completo

---

## 12. 🎬 Exemplo de Execução

Demonstração da execução do script `populate-data.sh` no ambiente de desenvolvimento:

```
@andreriffen ➜ /workspaces/api-veiculos1 (main) $ ./populate-data.sh
╔════════════════════════════════════════════════════════════════╗
║      🚗 Populando API de Veículos - Dados Iniciais            ║
╚════════════════════════════════════════════════════════════════╝

🏭 Criando Marcas...
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 Criando marca: Fiat
   ✅ Marca criada com ID: 1

📝 Criando marca: Volkswagen
   ✅ Marca criada com ID: 2

📝 Criando marca: Toyota
   ✅ Marca criada com ID: 3

🎨 Criando Cores...
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 Criando cor: Preto
   ✅ Cor criada com ID: 1

📝 Criando cor: Branco
   ✅ Cor criada com ID: 2

📝 Criando cor: Prata
   ✅ Cor criada com ID: 3

📝 Criando cor: Vermelho
   ✅ Cor criada com ID: 4

👥 Criando Clientes...
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 Criando cliente: João Silva
   ✅ Cliente criado com ID: 1

📝 Criando cliente: Maria Santos
   ✅ Cliente criada com ID: 2

📝 Criando cliente: Carlos Oliveira
   ✅ Cliente criado com ID: 3

🚙 Criando Modelos...
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 Criando modelo: Uno (Fiat)
   ✅ Modelo criado com ID: 1

📝 Criando modelo: Gol (Volkswagen)
   ✅ Modelo criado com ID: 2

📝 Criando modelo: Corolla (Toyota)
   ✅ Modelo criado com ID: 3

📝 Criando modelo: Palio (Fiat)
   ✅ Modelo criado com ID: 4

🚗 Criando Veículos...
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 Criando veículo: ABC-1234 (Uno Preto)
   ✅ Veículo criado com ID: 1
   🔧 Motor: 75cv FLEX

📝 Criando veículo: XYZ-5678 (Gol Branco)
   ✅ Veículo criado com ID: 2
   🔧 Motor: 80cv GASOLINA

📝 Criando veículo: DEF-9012 (Corolla Prata)
   ✅ Veículo criado com ID: 3
   🔧 Motor: 154cv FLEX

📝 Criando veículo: GHI-3456 (Palio Vermelho)
   ✅ Veículo criado com ID: 4
   🔧 Motor: 85cv GASOLINA


╔════════════════════════════════════════════════════════════════╗
║                   ✅ DADOS POPULADOS COM SUCESSO!              ║
╚════════════════════════════════════════════════════════════════╝

📊 Resumo:
   • Marcas criadas: 3
   • Cores criadas: 4
   • Clientes criados: 3
   • Modelos criados: 4
   • Veículos criados: 4

🔍 Para visualizar os dados:
   curl http://localhost:8080/marcas | jq '.'
   curl http://localhost:8080/cores | jq '.'
   curl http://localhost:8080/clientes | jq '.'
   curl http://localhost:8080/modelos | jq '.'
   curl http://localhost:8080/veiculos | jq '.'

📖 Acesse o H2 Console em:
   http://localhost:8080/h2-console

Fim

Autor: Andre Guilherme Barreto de Farias
Matrícula: 202111701842
TÉCNICO EM DESENVOLVIMENTO DE SISTEMAS [3010]/FLN - Técnico - Subsequente - Florianópolis

=================================================================

╔════════════════════════════════════════════════════════════════╗
║    💡 Execute agora o script de testes: ./test-api.sh         ║
╚════════════════════════════════════════════════════════════════╝
```

---

## 13. 🧪 Exemplo de Teste Após Inserção de Dados

Demonstração da execução do script `test-api.sh` no terminal:

```
@andreriffen ➜ /workspaces/api-veiculos1 (main) $ ./test-api.sh
🚀 Iniciando testes da API de Veículos...

🏭 ========== MARCAS ==========

➤ 1. POST /marcas - Criando Honda
{
  "id": 4,
  "nome": "Honda"
}

➤ 2. POST /marcas - Criando Chevrolet
{
  "id": 5,
  "nome": "Chevrolet"
}

➤ 3. GET /marcas - Listando todas as marcas
[
  {
    "id": 1,
    "nome": "Fiat"
  },
  {
    "id": 2,
    "nome": "Volkswagen"
  },
  {
    "id": 3,
    "nome": "Toyota"
  },
  {
    "id": 4,
    "nome": "Honda"
  },
  {
    "id": 5,
    "nome": "Chevrolet"
  }
]

➤ 4. GET /marcas/1 - Buscando marca por ID
{
  "id": 1,
  "nome": "Fiat"
}

➤ 5. PUT /marcas/1 - Atualizando marca
{
  "id": 1,
  "nome": "Fiat Automóveis"
}

🎨 ========== CORES ==========

➤ 6. POST /cores - Criando Azul
{
  "id": 5,
  "nome": "Azul"
}

➤ 7. POST /cores - Criando Verde
{
  "id": 6,
  "nome": "Verde"
}

➤ 8. GET /cores - Listando todas as cores
[
  {
    "id": 1,
    "nome": "Preto"
  },
  {
    "id": 2,
    "nome": "Branco"
  },
  {
    "id": 3,
    "nome": "Prata"
  },
  {
    "id": 4,
    "nome": "Vermelho"
  },
  {
    "id": 5,
    "nome": "Azul"
  },
  {
    "id": 6,
    "nome": "Verde"
  }
]

➤ 9. GET /cores/1 - Buscando cor por ID
{
  "id": 1,
  "nome": "Preto"
}

➤ 10. PUT /cores/1 - Atualizando cor
{
  "id": 1,
  "nome": "Preto Fosco"
}

👥 ========== CLIENTES ==========

➤ 11. POST /clientes - Criando Pedro Henrique
{
  "id": 4,
  "nome": "Pedro Henrique",
  "celular": "(48) 91111-1111",
  "email": "pedro@example.com",
  "dataCadastro": "2025-12-01"
}

➤ 12. POST /clientes - Criando Ana Paula
{
  "id": 5,
  "nome": "Ana Paula",
  "celular": "(48) 92222-2222",
  "email": "ana@example.com",
  "dataCadastro": "2025-12-01"
}

➤ 13. GET /clientes - Listando todos os clientes
[
  {
    "id": 1,
    "nome": "João Silva",
    "celular": "(48) 99999-9999",
    "email": "joao@example.com",
    "dataCadastro": "2025-12-01"
  },
  {
    "id": 2,
    "nome": "Maria Santos",
    "celular": "(48) 98888-8888",
    "email": "maria@example.com",
    "dataCadastro": "2025-12-01"
  },
  {
    "id": 3,
    "nome": "Carlos Oliveira",
    "celular": "(48) 97777-7777",
    "email": "carlos@example.com",
    "dataCadastro": "2025-12-01"
  },
  {
    "id": 4,
    "nome": "Pedro Henrique",
    "celular": "(48) 91111-1111",
    "email": "pedro@example.com",
    "dataCadastro": "2025-12-01"
  },
  {
    "id": 5,
    "nome": "Ana Paula",
    "celular": "(48) 92222-2222",
    "email": "ana@example.com",
    "dataCadastro": "2025-12-01"
  }
]

➤ 14. GET /clientes/1 - Buscando cliente por ID
{
  "id": 1,
  "nome": "João Silva",
  "celular": "(48) 99999-9999",
  "email": "joao@example.com",
  "dataCadastro": "2025-12-01"
}

➤ 15. PUT /clientes/1 - Atualizando cliente
{
  "id": 1,
  "nome": "João Silva Santos",
  "celular": "(48) 99999-0000",
  "email": "joao.santos@example.com",
  "dataCadastro": "2025-12-01"
}

🚙 ========== MODELOS ==========

➤ 16. POST /modelos - Criando Civic (Honda)
{
  "id": 5,
  "descricao": "Civic",
  "marca": {
    "id": 4,
    "nome": "Honda"
  }
}

➤ 17. POST /modelos - Criando Onix (Chevrolet)
{
  "id": 6,
  "descricao": "Onix",
  "marca": {
    "id": 5,
    "nome": "Chevrolet"
  }
}

➤ 18. GET /modelos - Listando todos os modelos
[
  {
    "id": 1,
    "descricao": "Uno",
    "marca": {
      "id": 1,
      "nome": "Fiat Automóveis"
    }
  },
  {
    "id": 2,
    "descricao": "Gol",
    "marca": {
      "id": 2,
      "nome": "Volkswagen"
    }
  },
  {
    "id": 3,
    "descricao": "Corolla",
    "marca": {
      "id": 3,
      "nome": "Toyota"
    }
  },
  {
    "id": 4,
    "descricao": "Palio",
    "marca": {
      "id": 1,
      "nome": "Fiat Automóveis"
    }
  },
  {
    "id": 5,
    "descricao": "Civic",
    "marca": {
      "id": 4,
      "nome": "Honda"
    }
  },
  {
    "id": 6,
    "descricao": "Onix",
    "marca": {
      "id": 5,
      "nome": "Chevrolet"
    }
  }
]

➤ 19. GET /modelos/1 - Buscando modelo por ID
{
  "id": 1,
  "descricao": "Uno",
  "marca": {
    "id": 1,
    "nome": "Fiat Automóveis"
  }
}

➤ 20. PUT /modelos/1 - Atualizando modelo
{
  "id": 1,
  "descricao": "Uno Vivace",
  "marca": {
    "id": 1,
    "nome": null
  }
}

🚗 ========== VEÍCULOS ==========

➤ 21. POST /veiculos - Criando JKL-7890 (Civic Azul)
{
  "id": 5,
  "placa": "JKL-7890",
  "observacoes": "Veículo importado",
  "motor": {
    "potencia": 150,
    "tipoCombustivel": "GASOLINA"
  },
  "cor": {
    "id": 5,
    "nome": null
  },
  "modelo": {
    "id": 5,
    "descricao": null,
    "marca": null
  },
  "proprietario": {
    "id": 4,
    "nome": null,
    "celular": null,
    "email": null,
    "dataCadastro": null
  }
}

➤ 22. POST /veiculos - Criando MNO-4567 (Onix Verde)
{
  "id": 6,
  "placa": "MNO-4567",
  "observacoes": "Carro zero km",
  "motor": {
    "potencia": 116,
    "tipoCombustivel": "FLEX"
  },
  "cor": {
    "id": 6,
    "nome": null
  },
  "modelo": {
    "id": 6,
    "descricao": null,
    "marca": null
  },
  "proprietario": {
    "id": 5,
    "nome": null,
    "celular": null,
    "email": null,
    "dataCadastro": null
  }
}

➤ 23. GET /veiculos - Listando todos os veículos
[
  {
    "id": 1,
    "placa": "ABC-1234",
    "observacoes": "Veículo em bom estado",
    "motor": {
      "potencia": 75,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 1,
      "nome": "Preto Fosco"
    },
    "modelo": {
      "id": 1,
      "descricao": "Uno Vivace",
      "marca": {
        "id": 1,
        "nome": "Fiat Automóveis"
      }
    },
    "proprietario": {
      "id": 1,
      "nome": "João Silva Santos",
      "celular": "(48) 99999-0000",
      "email": "joao.santos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 2,
    "placa": "XYZ-5678",
    "observacoes": "Revisão em dia",
    "motor": {
      "potencia": 80,
      "tipoCombustivel": "GASOLINA"
    },
    "cor": {
      "id": 2,
      "nome": "Branco"
    },
    "modelo": {
      "id": 2,
      "descricao": "Gol",
      "marca": {
        "id": 2,
        "nome": "Volkswagen"
      }
    },
    "proprietario": {
      "id": 2,
      "nome": "Maria Santos",
      "celular": "(48) 98888-8888",
      "email": "maria@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 3,
    "placa": "DEF-9012",
    "observacoes": "Carro seminovo",
    "motor": {
      "potencia": 154,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 3,
      "nome": "Prata"
    },
    "modelo": {
      "id": 3,
      "descricao": "Corolla",
      "marca": {
        "id": 3,
        "nome": "Toyota"
      }
    },
    "proprietario": {
      "id": 3,
      "nome": "Carlos Oliveira",
      "celular": "(48) 97777-7777",
      "email": "carlos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 4,
    "placa": "GHI-3456",
    "observacoes": "Primeiro veículo",
    "motor": {
      "potencia": 85,
      "tipoCombustivel": "GASOLINA"
    },
    "cor": {
      "id": 4,
      "nome": "Vermelho"
    },
    "modelo": {
      "id": 4,
      "descricao": "Palio",
      "marca": {
        "id": 1,
        "nome": "Fiat Automóveis"
      }
    },
    "proprietario": {
      "id": 1,
      "nome": "João Silva Santos",
      "celular": "(48) 99999-0000",
      "email": "joao.santos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 5,
    "placa": "JKL-7890",
    "observacoes": "Veículo importado",
    "motor": {
      "potencia": 150,
      "tipoCombustivel": "GASOLINA"
    },
    "cor": {
      "id": 5,
      "nome": "Azul"
    },
    "modelo": {
      "id": 5,
      "descricao": "Civic",
      "marca": {
        "id": 4,
        "nome": "Honda"
      }
    },
    "proprietario": {
      "id": 4,
      "nome": "Pedro Henrique",
      "celular": "(48) 91111-1111",
      "email": "pedro@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 6,
    "placa": "MNO-4567",
    "observacoes": "Carro zero km",
    "motor": {
      "potencia": 116,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 6,
      "nome": "Verde"
    },
    "modelo": {
      "id": 6,
      "descricao": "Onix",
      "marca": {
        "id": 5,
        "nome": "Chevrolet"
      }
    },
    "proprietario": {
      "id": 5,
      "nome": "Ana Paula",
      "celular": "(48) 92222-2222",
      "email": "ana@example.com",
      "dataCadastro": "2025-12-01"
    }
  }
]

➤ 24. GET /veiculos/1 - Buscando veículo por ID
{
  "id": 1,
  "placa": "ABC-1234",
  "observacoes": "Veículo em bom estado",
  "motor": {
    "potencia": 75,
    "tipoCombustivel": "FLEX"
  },
  "cor": {
    "id": 1,
    "nome": "Preto Fosco"
  },
  "modelo": {
    "id": 1,
    "descricao": "Uno Vivace",
    "marca": {
      "id": 1,
      "nome": "Fiat Automóveis"
    }
  },
  "proprietario": {
    "id": 1,
    "nome": "João Silva Santos",
    "celular": "(48) 99999-0000",
    "email": "joao.santos@example.com",
    "dataCadastro": "2025-12-01"
  }
}

➤ 25. PUT /veiculos/1 - Atualizando observações do veículo
{
  "id": 1,
  "placa": "ABC-1234",
  "observacoes": "Veículo com manutenção recente",
  "motor": {
    "potencia": 75,
    "tipoCombustivel": "FLEX"
  },
  "cor": {
    "id": 1,
    "nome": null
  },
  "modelo": {
    "id": 1,
    "descricao": null,
    "marca": null
  },
  "proprietario": {
    "id": 1,
    "nome": null,
    "celular": null,
    "email": null,
    "dataCadastro": null
  }
}

⚠️  ========== TESTES DE VALIDAÇÃO ==========

➤ 26. GET /marcas/999 - Buscando marca inexistente (deve retornar 404)

🗑️  ========== TESTES DE DELEÇÃO ==========

➤ 27. DELETE /veiculos/2 - Deletando veículo XYZ-5678

HTTP Status: 204

➤ 28. GET /veiculos - Verificando que o veículo foi deletado
[
  {
    "id": 1,
    "placa": "ABC-1234",
    "observacoes": "Veículo com manutenção recente",
    "motor": {
      "potencia": 75,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 1,
      "nome": "Preto Fosco"
    },
    "modelo": {
      "id": 1,
      "descricao": "Uno Vivace",
      "marca": {
        "id": 1,
        "nome": "Fiat Automóveis"
      }
    },
    "proprietario": {
      "id": 1,
      "nome": "João Silva Santos",
      "celular": "(48) 99999-0000",
      "email": "joao.santos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 3,
    "placa": "DEF-9012",
    "observacoes": "Carro seminovo",
    "motor": {
      "potencia": 154,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 3,
      "nome": "Prata"
    },
    "modelo": {
      "id": 3,
      "descricao": "Corolla",
      "marca": {
        "id": 3,
        "nome": "Toyota"
      }
    },
    "proprietario": {
      "id": 3,
      "nome": "Carlos Oliveira",
      "celular": "(48) 97777-7777",
      "email": "carlos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 4,
    "placa": "GHI-3456",
    "observacoes": "Primeiro veículo",
    "motor": {
      "potencia": 85,
      "tipoCombustivel": "GASOLINA"
    },
    "cor": {
      "id": 4,
      "nome": "Vermelho"
    },
    "modelo": {
      "id": 4,
      "descricao": "Palio",
      "marca": {
        "id": 1,
        "nome": "Fiat Automóveis"
      }
    },
    "proprietario": {
      "id": 1,
      "nome": "João Silva Santos",
      "celular": "(48) 99999-0000",
      "email": "joao.santos@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 5,
    "placa": "JKL-7890",
    "observacoes": "Veículo importado",
    "motor": {
      "potencia": 150,
      "tipoCombustivel": "GASOLINA"
    },
    "cor": {
      "id": 5,
      "nome": "Azul"
    },
    "modelo": {
      "id": 5,
      "descricao": "Civic",
      "marca": {
        "id": 4,
        "nome": "Honda"
      }
    },
    "proprietario": {
      "id": 4,
      "nome": "Pedro Henrique",
      "celular": "(48) 91111-1111",
      "email": "pedro@example.com",
      "dataCadastro": "2025-12-01"
    }
  },
  {
    "id": 6,
    "placa": "MNO-4567",
    "observacoes": "Carro zero km",
    "motor": {
      "potencia": 116,
      "tipoCombustivel": "FLEX"
    },
    "cor": {
      "id": 6,
      "nome": "Verde"
    },
    "modelo": {
      "id": 6,
      "descricao": "Onix",
      "marca": {
        "id": 5,
        "nome": "Chevrolet"
      }
    },
    "proprietario": {
      "id": 5,
      "nome": "Ana Paula",
      "celular": "(48) 92222-2222",
      "email": "ana@example.com",
      "dataCadastro": "2025-12-01"
    }
  }
]

✅ Testes concluídos!
```

---

### 14. 📜 Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

---


### 15. ☕ Autor

- 2025 ©️ - [**Andre Riffen**](https://andreriffen.github.io/resume) | [@andreriffen (Github)](https://github.com/andreriffen)
