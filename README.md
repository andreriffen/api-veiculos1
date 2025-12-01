# SUMÁRIO: Mão na Massa 1 - API para Gerenciar Veículos

API REST desenvolvida com Spring Boot para gerenciamento de veículos, clientes, marcas, modelos e cores.

![Java 17+](https://img.shields.io/badge/Java%2017%2B-007396?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot 3.4.0](https://img.shields.io/badge/Spring%20Boot%203.4.0-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Maven 3.6+](https://img.shields.io/badge/Maven%203.6%2B-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![Alpine Linux](https://img.shields.io/badge/Alpine%20Linux-0D597F?style=flat-square&logo=alpinelinux&logoColor=white)
![Codespaces Ready](https://img.shields.io/badge/Codespaces-Ready-success?style=flat-square&logo=github&logoColor=white)


        🔴 🟩🟩    __/\\\\\\\\\\\__/\\\\\\\\\\\\\\\_____/\\\\\\\\\\\__________/\\\\\\\\\_        
        🟩 🟩        _\/////\\\///__\/\\\///////////____/\\\/////////\\\_____/\\\////////__       
        🟩 🟩🟩      _____\/\\\_____\/\\\______________\//\\\______\///____/\\\/___________      
        🟩 🟩          _____\/\\\_____\/\\\\\\\\\\\_______\////\\\__________/\\\_____________     
                         _____\/\\\_____\/\\\///////___________\////\\\______\/\\\_____________    
                          _____\/\\\_____\/\\\_____________________\////\\\___\//\\\____________   
                            _____\/\\\_____\/\\\______________/\\\______\//\\\___\///\\\__________  
                             __/\\\\\\\\\\\_\/\\\_____________\///\\\\\\\\\\\/______\////\\\\\\\\\_ 
                              _\///////////__\///________________\///////////___________\/////////__

> ⚡ **[Acessar instruções "INSTRUCTIONS.md" →](INSTRUCTIONS.md)**

- ⭐ **[Repositório GitHub ↗](https://github.com/andreriffen/api-veiculos1)**

- Acessar trecho do terminal [populando dados →](INSTRUCTIONS.md#-exemplo-de-execução)

- Acessar trecho do terminal [testando as endpoints →](INSTRUCTIONS.md#-exemplo-de-teste-após-inserção-de-dados)

---

> *Aluno:* **ANDRE GUILHERME BARRETO DE FARIAS**

> *Matrícula:* **202111701842**

> *Disciplina:* **Mão na Massa 1 - API para Gerenciar Veículos**

> *Curso:* **TÉCNICO EM DESENVOLVIMENTO DE SISTEMAS [3010]/FLN - Técnico - Subsequente - Florianópolis**

> *Instituição:* **Instituto Federal de Santa Catarina (IFSC)**

> *Data:* **Dezembro de 2025**

---

## 📑 Índice (Sumário/Readme)

- [1. 📋 Descrição](#1--descrição)
- [2. 🎯 Objetivo](#2--objetivo)
- [3. 🏗️ Modelo de Dados](#3-️-modelo-de-dados)
  - [3.1. Entidade Marca](#31-entidade-marca)
  - [3.2. Entidade Cor](#32-entidade-cor)
  - [3.3. Entidade Cliente](#33-entidade-cliente)
  - [3.4. Entidade Modelo](#34-entidade-modelo)
  - [3.5. Entidade Veículo](#35-entidade-veículo)
  - [3.6. Motor (Embeddable)](#36-motor-embeddable)
  - [3.7. Enums](#37-enums)
- [4. 📡 Endpoints da API](#4--endpoints-da-api)
  - [4.1. Marcas](#41-marcas)
  - [4.2. Cores](#42-cores)
  - [4.3. Clientes](#43-clientes)
  - [4.4. Modelos](#44-modelos)
  - [4.5. Veículos](#45-veículos)
- [5. 🛠️ Tecnologias Utilizadas](#5-️-tecnologias-utilizadas)
- [6. 📂 Estrutura do Projeto](#6--estrutura-do-projeto)
- [7. ⚙️ Configuração](#7-️-configuração)
- [8. 🚀 Como Executar](#8--como-executar)
- [9. 📦 Build e Distribuição](#9--build-e-distribuição)
- [10. 📝 Entrega da Atividade](#10--entrega-da-atividade)
- [11. 🔗 Links Úteis](#11--links-úteis)
- [12. 📜 Licença](#12--licença)
- [13. ☕ Autor @andreriffen](#13--autor)

---

## 1. 📋 Descrição

Este projeto implementa uma API REST completa para gerenciar um **sistema de lavação de veículos**, incluindo operações CRUD (Create, Read, Update, Delete) para cinco entidades principais:

- **Veículos**: Gerenciamento de veículos com motor, cor, modelo e proprietário
- **Clientes**: Cadastro e controle de clientes/proprietários
- **Marcas**: Registro de marcas de veículos
- **Modelos**: Modelos de veículos vinculados às marcas
- **Cores**: Cadastro de cores disponíveis


## 2. 🎯 Objetivo

Desenvolver uma API REST utilizando Spring Boot, seguindo boas práticas de desenvolvimento como:

- Arquitetura em camadas simples (Controller, Repository, Model)
- Endpoints REST para operações CRUD diretas nos controladores
- Validação de dados com Jakarta Bean Validation
- Uso de Lombok para redução de código boilerplate
- Persistência com JPA/Hibernate

**Nota:** Este projeto mantém uma arquitetura simplificada de 3 camadas conforme especificação do exercício, sem uso de DTOs ou camada de serviço.

---

## 3. 🏗️ Modelo de Dados

### 3.1. Entidade Marca

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | Integer | Identificador único |
| nome | String | Nome da marca |

### 3.2. Entidade Cor

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | Integer | Identificador único |
| nome | String | Nome da cor |

### 3.3. Entidade Cliente

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | Integer | Identificador único |
| nome | String | Nome do cliente |
| celular | String | Número de celular |
| email | String | E-mail do cliente (validado) |
| dataCadastro | LocalDate | Data de cadastro |

### 3.4. Entidade Modelo

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | Integer | Identificador único |
| descricao | String | Descrição do modelo |
| marca | Marca | Marca do modelo (@ManyToOne) |

### 3.5. Entidade Veículo

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| id | Integer | Identificador único |
| placa | String | Placa do veículo |
| observacoes | String | Observações sobre o veículo |
| motor | Motor | Dados do motor (@Embedded) |
| cor | Cor | Cor do veículo (@ManyToOne) |
| modelo | Modelo | Modelo do veículo (@ManyToOne) |
| proprietario | Cliente | Proprietário do veículo (@ManyToOne) |

### 3.6. Motor (Embeddable)

| Atributo | Tipo | Descrição |
|----------|------|-----------|
| potencia | int | Potência do motor em cv |
| tipoCombustivel | ETipoCombustivel | Tipo de combustível (enum) |

### 3.7. Enums

**ECategoria:**
- `PEQUENO`
- `MEDIO`
- `GRANDE`
- `MOTO`
- `PADRAO`

**ETipoCombustivel:**
- `GASOLINA`
- `ETANOL`
- `FLEX`
- `DIESEL`
- `GNV`
- `OUTRO`

---

## 4. 📡 Endpoints da API

### 4.1. Marcas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/marcas` | Criar nova marca |
| GET | `/marcas` | Listar todas as marcas |
| GET | `/marcas/{id}` | Buscar marca por ID |
| PUT | `/marcas/{id}` | Atualizar marca |
| DELETE | `/marcas/{id}` | Deletar marca |

### 4.2. Cores

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/cores` | Criar nova cor |
| GET | `/cores` | Listar todas as cores |
| GET | `/cores/{id}` | Buscar cor por ID |
| PUT | `/cores/{id}` | Atualizar cor |
| DELETE | `/cores/{id}` | Deletar cor |

### 4.3. Clientes

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/clientes` | Criar novo cliente |
| GET | `/clientes` | Listar todos os clientes |
| GET | `/clientes/{id}` | Buscar cliente por ID |
| PUT | `/clientes/{id}` | Atualizar cliente |
| DELETE | `/clientes/{id}` | Deletar cliente |

### 4.4. Modelos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/modelos` | Criar novo modelo |
| GET | `/modelos` | Listar todos os modelos |
| GET | `/modelos/{id}` | Buscar modelo por ID |
| PUT | `/modelos/{id}` | Atualizar modelo |
| DELETE | `/modelos/{id}` | Deletar modelo |

### 4.5. Veículos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/veiculos` | Criar novo veículo |
| GET | `/veiculos` | Listar todos os veículos |
| GET | `/veiculos/{id}` | Buscar veículo por ID |
| PUT | `/veiculos/{id}` | Atualizar veículo |
| DELETE | `/veiculos/{id}` | Deletar veículo |

---

## 5. 🛠️ Tecnologias Utilizadas

- **Spring Boot**: Framework principal
- **Spring Data JPA**: Persistência de dados
- **Hibernate**: ORM
- **Lombok**: Redução de código boilerplate
- **Jakarta Bean Validation**: Validação de dados
- **H2 Database** ou **MySQL**: Banco de dados
- **Maven**: Gerenciamento de dependências

---

## 6. 📂 Estrutura do Projeto

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

- [Visualizar Diagrama de Classes →](class-diagram.png)


---

## 7. ⚙️ Configuração

### Banco de Dados H2 (em memória)

```properties
spring.datasource.url=jdbc:h2:mem:lavacao
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

### Banco de Dados MySQL

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api_lavacao
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## 8. 🚀 Como Executar

1. Clone o repositório
2. Configure o banco de dados no `application.properties` (H2 já configurado por padrão)
3. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse a API através de `http://localhost:8080`
5. Acesse o console H2 em: `http://localhost:8080/h2-console`

### 🎯 Scripts Prontos para Teste

**Popular banco com dados iniciais**:
```bash
chmod +x populate-data.sh
./populate-data.sh
```

**Executar suite completa de testes**:
```bash
chmod +x test-api.sh
./test-api.sh
```

---

## 9. 📦 Build e Distribuição

Para gerar o arquivo JAR executável:

```bash
./mvnw clean package
```

O arquivo será gerado em: `target/api-veiculos1-0.0.1-SNAPSHOT.jar`

Para executar o JAR:

```bash
java -jar target/api-veiculos1-0.0.1-SNAPSHOT.jar
```

---

## 10. 📝 Entrega da Atividade

A entrega deve conter:

1. Projeto completo compactado
2. Script SQL do banco de dados (se usar MySQL)
3. Documento com screenshots das requisições aos endpoints e explicações dos resultados

### Screenshots para Entrega:

- 🎬 [Exemplo de execução: populando dados →](INSTRUCTIONS.md#-exemplo-de-execução)
- 🧪 [Exemplo de execução: testando endpoints →](INSTRUCTIONS.md#-exemplo-de-teste-após-inserção-de-dados)

### ✅ Requisitos Técnicos Atendidos

✅ Uso de Spring Boot e Jakarta Persistence API (JPA)  
✅ Configuração e uso do banco de dados H2 ou MySQL  
✅ Mapeamento Objeto-Relacional (ORM) entre as classes e as tabelas do banco  
✅ Implementação de todos os repositórios necessários  
✅ Endpoints REST para todas as operações CRUD  
✅ Documentação completa do código com JavaDocs  
✅ Scripts de população de dados e testes automatizados  

---

## 11. 🔗 Links Úteis

- **[Instruções de Execução](INSTRUCTIONS.md)** - Guia passo a passo para executar o projeto
- **[Repositório GitHub](https://github.com/andreriffen/api-veiculos1)** - Código fonte completo

---

### 12. 📜 Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

---


### 13. ☕ Autor

- 2025 ©️ - [**Andre Riffen**](https://andreriffen.github.io/resume) | [@andreriffen (Github)](https://github.com/andreriffen)
