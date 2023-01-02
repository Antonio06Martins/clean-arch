<h1>Projeto em Arquitetura limpa</h1> 

<p align="center">
  <img src="https://img.shields.io/static/v1?label=spring&message=framework&color=green&style=for-the-badge&logo=SPRING"/>
  <img src="http://img.shields.io/static/v1?label=Spring&message=3.0.1&color=red&style=for-the-badge&logo=spring"/>
  <img src="https://img.shields.io/static/v1?label=&message=WebFlux&color=gray&style=for-the-badge&logo=WebFlux"/>
  <img src="https://img.shields.io/static/v1?label=&message=Docker&color=gray&style=for-the-badge&logo=Docker"/>
  <img src="https://img.shields.io/static/v1?label=&message=JAVA-17&color=brightgreen&style=for-the-badge&logo=WebFlux"/>
  <img src="https://img.shields.io/static/v1?label=&message=MongoDb&color=green&style=for-the-badge&logo=WebFlux"/>
  <img src="http://img.shields.io/static/v1?label=TESTES&message=%3E1&color=GREEN&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge"/>
</p>


### Tópicos

[Descrição do projeto](#descrição-do-projeto)

[Funcionalidades](#funcionalidades)

[Pré-requisitos](#pré-requisitos)

[Como rodar a aplicação](#como-rodar-a-aplicação)

[Observações](#observações)


## Descrição do projeto

<p align="justify">
  A aplicação aqui em desenvolvimento tem o objetivo fixar conhecimento em arquitetura limpa. 
</p>

## Funcionalidades

* A sua função é de salvar um novo usuario com nome, cpf, endereço(rua,cidade,estado) e uma flag para validar o cpf enviada via kafka para simular outra aplicação consumindo e enviando novamente para aplicação validando ou não o cpf.


## Pré-requisitos

* [Docker](https://docs.docker.com/get-docker/)
* [JAVA](https://www.java.com/pt-BR/)
* [MAVEN](https://maven.apache.org/)


## Como rodar a aplicação:

* No terminal, clone o projeto:
```
git clone  https://github.com/Antonio06Martins/clean-arch
```

* Com o Docker iniciado:
```
docker-compose up -d
```

## Observações
* Utilizar o WireMock para simular a api que recupera o endereço passando o cep para consulta.
* Link para baixar o [WireMock](https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-jre8-standalone/2.35.0/wiremock-jre8-standalone-2.35.0.jar).
* Rodar o seguinte comando no terminal para iniciar o [WireMock](https://wiremock.org/). 
```jsonpath
java -jar wiremock-jre8-standalone-2.35.0.jar --port 8082
```
* Em seguida vai ser criada duas pastas uma <span style="color:red">_files</span> e a outra <span style="color:red">mappings</span> onde vamos definir a resposta que queremos para a chamada no endpoint.

```json
{
  "request": {
    "method": "GET",
    "url": "/addresses/38400000"
  },
  "response": {
    "status": 200,
    "headers": {
      "Content-Type": "application/json"
    },
    "jsonBody": {
      "street": "Rua Clean Architecture",
      "city": "Joinville",
      "state": "Santa Catarina"
    }
  }
}
```

* Para consultar o topico e produzir mensagens vamos utilizar o [UI for Apache Kafka](https://github.com/provectus/kafka-ui#-ui-for-apache-kafka).
* Sendo acessado no endereço.
```jsregexp
http://localhost:8085/
```
* Exemplo de json para postar no topico.

```json
{
  "id":"63b235f02850e61daaf754fe",
  "name":"Antonio Martins",
  "zipCode":"38400001",
  "cpf":"06432680000",
  "isValidCpf":true
}
```

* Algumas evoluções devem ser feitas no decorrer do estudo.
* Como adicionar Swagger.
* Adicionar Client para consumir outra API com web-flux.
* Adicionar consumer e producer com Kafka-stream.
* Adicionar Prometheus para metricas e Jaeger para rastreamento da aplicação.


* Material de Apoio:

  [Descomplicando a Clean Architecture](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)

  [Clean Architecture Example with Java and Spring Boot](https://medium.com/swlh/clean-architecture-java-spring-fea51e26e00)

  [Descomplicando Clean Architecture NA PRÁTICA](https://www.udemy.com/course/descomplicando-clean-architecture-na-pratica/)
