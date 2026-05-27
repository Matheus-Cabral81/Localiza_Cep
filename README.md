# URL Shortener API

API REST desenvolvida com Java e Spring Boot para encurtamento de URLs, permitindo gerar links curtos, consultar URLs cadastradas e realizar redirecionamentos automáticos.

---

## Funcionalidades

- Criar URLs encurtadas
- Buscar URL pelo código curto
- Listar todas as URLs cadastradas
- Redirecionar automaticamente para a URL original
- Tratamento global de exceções
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

---

## Estrutura do projeto

```bash
src/main/java/com/Shortener/Url
│
├── controller     # Endpoints REST
├── service        # Regras de negócio
├── repository     # Comunicação com banco de dados
├── model          # Entidade JPA
├── dto            # Objetos de Request/Response
├── exception      # Tratamento de exceções
```

---

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Matheus-Cabral81/URL-Shortener-API.git
```

### 2. Acesse a pasta do projeto

```bash
cd URL-Shortener-API
```

### 3. Execute a aplicação

Execute a classe:

```java
UrlApplication.java
```

Ou pelo terminal:

```bash
./mvnw spring-boot:run
```

---

## Banco de dados H2

O projeto utiliza banco de dados H2 em memória.

### Console H2

```bash
http://localhost:8080/h2-console
```

### Configurações

```bash
JDBC URL: jdbc:h2:mem:urldb
User Name: sa
Password:
```

---

# Endpoints da API

## Criar URL encurtada

### POST `/api/urls`

### Body

```json
{
  "urlOriginal": "https://google.com"
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "urlOriginal": "https://google.com",
  "urlCurta": "a1b2c3d4",
  "geradoEm": "2026-05-27T20:30:00"
}
```

---

## Buscar URL pelo código

### GET `/api/urls/{codigo}`

Exemplo:

```bash
GET /api/urls/a1b2c3d4
```

---

## Listar todas URLs

### GET `/api/urls`

---

## Redirecionar URL

### GET `/api/urls/redirect/{codigo}`

Exemplo:

```bash
GET /api/urls/redirect/a1b2c3d4
```

A API retorna um redirecionamento HTTP `302 FOUND` para a URL original.

---

## Testando com Postman

### Criar URL

- Método: `POST`
- URL:

```bash
http://localhost:8080/api/urls
```

### Body → raw → JSON

```json
{
  "urlOriginal": "https://youtube.com"
}
```

---

## Buscar URL

- Método: `GET`

```bash
http://localhost:8080/api/urls/{codigo}
```

---

## Redirecionar URL

- Método: `GET`

```bash
http://localhost:8080/api/urls/redirect/{codigo}
```

---

# Tratamento de erros

A aplicação possui tratamento global de exceções utilizando `@RestControllerAdvice`.

### Exemplo de erro

```json
{
  "timestamp": "2026-05-27T20:40:00",
  "status": 404,
  "error": "Not Found",
  "message": "URL não encontrada abc123"
}
```

---

# Melhorias futuras

- Validação de URLs
- Swagger/OpenAPI
- PostgreSQL
- Docker
- Deploy em nuvem
- Expiração de links
- Contador de acessos
- Testes unitários

---

# Autor

Matheus Cabral

Desenvolvedor Backend | Java | Spring Boot | APIs REST
