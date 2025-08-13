# Conceitos Iniciais de Spring Boot

## Módulo 40 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* Maven
* Pom.xml
* Spring Boot
* Postgres


### Funcionalidades

CRUD para manipulação de Clientes com o uso de Spring Boot e Postgres

Criação de um projeto Maven com o uso do Spring Initializr para criar o projeto Spring Boot base.



### Principais passos:

1. Cria o projeto Maven com o Spring Initializr preenchendo as principais informações e adicionando as seguintes dependências: Spring Data JPA, Lombok, Spring Boot DevTools, Spring Boot Actuator e Spring Web.
2. Adiciona manualmente ao arquivo pom.xml a dependência do Postgres;
3. Configura o arquivo application.properties com as configurações de acesso ao banco;
4. Cria a classe Cliente com os seus respectivos atributos;
5. Cria a interface IClienteRepository extendendo da classe CrudRepository (principais métodos de salvar e criar já inseridos);
6. Adiciona um cliente de exemplo através da classe de Inicialização 'SpringBootPrimeiroExemploApplication';

 