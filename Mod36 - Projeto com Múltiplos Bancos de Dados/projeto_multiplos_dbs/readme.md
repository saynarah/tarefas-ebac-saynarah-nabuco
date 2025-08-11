# Projeto de CRUD de Clientes em Múltiplos Banco de Dados

## Módulo 36 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* JUnit
* TDD
* Generics
* JPA
* Postgres
* MySQL


### Funcionalidades

Funcionalidades de CRUD (create, read, update, delete) com o uso de múltiplos banco de dados (Postgres e MySQL);
Realiza testes das camadas de dao/repository orientados pela metodologia TDD (Test Driven Development) implementando conceitos de JPA.


### Principais passos:

1. Configura o arquivo 'persistence.xml' dentro da pasta META-INF com as informações do drive, do banco de dados e credenciais de acesso. Cada banco de dados possui a sua unidade de persistência;
2. Cria a interface IGenericDAO com os principais métodos CRUD (create, read, update e delete);
3. Cria a classe de implementação GenericDAO para a interface IGenericDAO;
4. Cria uma classe abstrata GenericDB1DAO extendendo de GenericDAO. O construtor guarda o nome da unidade de persistência no banco Postgres.
5. Cria uma classe abstrata GenericDB2DAO extendendo também de GenericDAO. O construtor guarda o nome da unidade de persistência de um segundo banco de dados no Postgres;
6. Cria uma classe abstrata GenericDB3DAO extendendo novamente de GenericDAO. O construtor guarda o nome da unidade de persistência no banco MySQL;
7. Cria a interface IClienteDAO extendendo a interface genérica 'IGenericDAO';
8. Cria as respectivas implementações 'ClienteDB1DAO', 'ClienteDB2DAO' e 'ClienteDB3DAO', mas os métodos CRUD são lidados pela própria classe genérica. Cada uma dessas implementações extende da sua respectiva classe genérica. A 'ClienteDB1DAO' extende de 'GenericDB1DAO' e assim por diante.
9. Seguindo TDD, cria os testes de integração e, a partir deles, os métodos da classe de implementação (ClienteDB1DAO, ClienteDB2DAO e ClienteDB3DAO) são estruturados;
10. Testes de integração realizados para a entidade 'Cliente' usando dois banco de dados Postgres: pesquisarCliente, salvarCliente, excluirCliente, alterarCliente e buscarTodos. Esse suíte de testes se chama: 'Cliente2JpaDAO2BancosTest';
11. Testes de integração realizados para a entidade 'Cliente' usando dois banco de dados Postgres e um banco de dados Mysql: pesquisarCliente, salvarCliente, excluirCliente, alterarCliente e buscarTodos. Esse suíte de testes se chama: 'ClienteJpaDAO3BancosTest'.

