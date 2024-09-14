# VisionaryAI- api-mvc

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
- [H2 Database](http://h2database.com/html/main.html)
- [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
- [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)

- ## API Reference e endpoints

- #### Obter todas as empresas (findAll empresaDTO)

```http
  GET /empresas
```

#### Obter empresa por id (findById empresaDTO)

```http
  GET /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser buscado |

#### Gravar empresa (save)

```http
  POST /empresas
```

Body:

```json
{
    "cnpj": "12345678912345",
    "email": "exemplo@email.com",
    "nome": "Exemplo",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `cnpj`    | `String` | Cnpj da empresa a ser gravado   |
| `email`   | `String` | E-mail da empresa a ser gravado |
| `nome`   | `String` | Nome da empresa a ser gravado  |
| `situacao` | `String` | Situacao da empresa a ser gravado |

#### Atualizar empresa (update)

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
| `cnpj`    | `String` | Cnpj da empresa a ser gravado   |
| `email`   | `String` | E-mail da empresa a ser gravado |
| `nome`   | `String` | Nome da empresa a ser gravado  |
| `situacao` | `String` | Situacao da empresa a ser gravado  |

#### Excluir empresa (delete)

```http
  DELETE /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser excluído |
