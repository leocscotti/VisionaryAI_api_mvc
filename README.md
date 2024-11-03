# VisionaryAI

Projeto de API RESTful + MVC para o challenge sprint 3.

## Integrantes

### Leonardo Cordeiro Scotti- RM550769

### Gabriel de Andrade Baltazar- RM550870

### Enzo Ross Gallone- RM551754

### Vinicius de Araujo Camargo- RM99494

### Pedro Gomes Fernandes- RM551480


## Tecnologias

- [Java 21](https://docs.oracle.com/en/java/javase/21/)
- [GraalVM](https://www.graalvm.org/)
- [Gradle](https://gradle.org/)
- [Thymeleaf](https://www.thymeleaf.org/index.html)
- [Spring Boot 3.3.2](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
- [Spring Web Starter](https://docs.spring.io/spring-boot/reference/web/index.html)
- [Spring Validation Starter](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
- [Spring HATEOAS](https://docs.spring.io/spring-hateoas/docs/current/reference/html/)
- [Springdoc OpenAPI + Swagger](https://springdoc.org/)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [JWT](https://jwt.io/introduction)
- [Spring AI](https://spring.io/projects/spring-ai)
- [H2 Database](http://h2database.com/html/main.html)
- [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
- [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)

- ## API Reference e endpoints

- #### Obter todas as empresas 

```http
  GET /empresas
```

#### Obter empresa por id 

```http
  GET /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser buscado |

- #### Gravar empresa 

```http
  POST /empresas
```

Body:

```json
{
     "cnpj": "12345678900123",
    "email": "plusoft@email.com",
    "nome": "Plusoft",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `cnpj`    | `String` | Cnpj da empresa a ser gravado   |
| `email`   | `String` | E-mail da empresa a ser gravado |
| `nome`   | `String` | Nome da empresa a ser gravado  |
| `situacao` | `String` | Situacao da empresa a ser gravado |

- #### Atualizar empresa 

```http
  PUT /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser atualizado |

Body:

```json
{
    "cnpj": "12345678900123",
    "email": "plusoft@email.com",
    "nome": "Plusoft",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                          |
|:----------|:---------|:-----------------------------------|
| `cnpj`    | `String` | Cnpj da empresa a ser atualizado   |
| `email`   | `String` | E-mail da empresa a ser atualizado |
| `nome`   | `String` | Nome da empresa a ser atualizada  |
| `situacao` | `String` | Situacao da empresa a ser atualizada  |

- #### Excluir empresa 

```http
  DELETE /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser excluído |



- #### Obter todas as cidades

```http
  GET /cidades
```

- #### Obter cidade por id 

```http
  GET /cidades/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da cidade a ser buscado |

- #### Gravar cidade

```http
  POST /cidades
```

Body:

```json
{
     "nome": "São Paulo",
     "uf": "SP"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`   | `String` | Nome da cidade a ser gravado  |
| `uf` | `String` | UF (Unidade da Federação) da cidade a ser gravado |

- #### Atualizar cidade

```http
  PUT /cidades/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da cidade a ser atualizado |

Body:

```json
{
     "nome": "São Paulo",
     "uf": "SP"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`   | `String` | Nome da cidade a ser atualizado  |
| `uf` | `String` | UF (Unidade da Federação) da cidade a ser atualizado |

- #### Excluir cidade

```http
  DELETE /cidades/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da cidade a ser excluído |


## Link do vídeo explicativo 

https://www.youtube.com/watch?v=6-tVU684k1o
