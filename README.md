# Consulta Localiza CEP API

API REST desenvolvida com Java e Spring Boot para consulta de CEPs utilizando a API ViaCEP, permitindo buscar informações de endereço, armazenar histórico de consultas e tratar exceções globalmente.

---

## Funcionalidades

- Buscar endereço por CEP
- Integração com API ViaCEP
- Armazenar histórico de consultas
- Listar CEPs consultados
- Tratamento global de exceções
- Validação de CEP
- Banco de dados H2 em memória

---

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Maven
- ViaCEP API

---

## Estrutura do projeto

```bash
src/main/java/Consulta/Localiza/Cep
│
├── controller     # Endpoints REST
├── service        # Regras de negócio
├── repository     # Comunicação com banco de dados
├── model          # Entidade JPA
├── dto            # Objetos de resposta
├── client         # Consumo da API ViaCEP
├── exception      # Tratamento de exceções
```

---

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
```

### 2. Acesse a pasta do projeto

```bash
cd NOME-DO-REPOSITORIO
```

### 3. Execute a aplicação

Execute a classe:

```java
CepApplication.java
```

Ou pelo terminal:

```bash
./mvnw spring-boot:run
```

---

# Banco de dados H2

O projeto utiliza banco de dados H2 em memória.

## Console H2

```bash
http://localhost:8080/h2-console
```

## Configurações

```bash
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

---

# Endpoints da API

## Buscar CEP

### GET `/api/cep/{cep}`

Exemplo:

```bash
GET /api/cep/01001000
```

### Exemplo de resposta

```json
{
  "id": 1,
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "estado": "São Paulo",
  "regiao": "Sudeste",
  "ibge": "3550308",
  "ddd": "11",
  "siafi": "7107",
  "consultadoEm": "2026-05-27T20:30:00"
}
```

---

## Listar histórico de consultas

### GET `/api/cep/historico`

Exemplo:

```bash
GET /api/cep/historico
```

---

# Testando com Postman

## Buscar CEP

- Método: `GET`

```bash
http://localhost:8080/api/cep/01001000
```

---

## Buscar histórico

- Método: `GET`

```bash
http://localhost:8080/api/cep/historico
```

---

# Tratamento de erros

A aplicação possui tratamento global de exceções utilizando `@RestControllerAdvice`.

## Exemplo de CEP inválido

```json
{
  "timestamp": "2026-05-27T20:40:00",
  "status": 400,
  "error": "Invalid CEP",
  "message": "CEP inválido: 12A45B78"
}
```

---

## Exemplo de CEP não encontrado

```json
{
  "timestamp": "2026-05-27T20:41:00",
  "status": 404,
  "error": "Not Found",
  "message": "CEP não encontrado: 99999999"
}
```

---

# Melhorias futuras

- Swagger/OpenAPI
- PostgreSQL
- Docker
- Deploy em nuvem
- Cache de consultas
- Testes unitários
- Validação avançada de CEP
- Monitoramento com Spring Actuator

---

# API utilizada

ViaCEP

```bash
https://viacep.com.br/
```

---

# Autor

Matheus Cabral

Desenvolvedor Backend | Java | Spring Boot | APIs REST
