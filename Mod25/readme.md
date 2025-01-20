# Projeto de Cadastro de Clientes (CRUD, Generics, Tests, TDD) 

## Módulo 25 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* JUnit
* Mock
* TDD
* Generics


### Funcionalidades

Funcionalidades de CRUD (create, read, update, delete) para um sistema de vendas (objetos: cliente e produto)
Realiza testes das camadas de service e de dao/repository orientados pela metodologia TDD (Test Driven Development).


### Principais passos:

1. Cria a estruturas dos testes (Camada Dao e Camada de Service) a serem realizados;
2. Num loop de execução e correção adiciona as classes e as interfaces necessárias - utilizando Generics para permitir uma generalização dos objetos. 
3. As classes 'ClienteDAO' e 'ProdutoDAO' disparam erros em cada um dos seus métodos (salvar,alterar,excluir,atualizar) representando que o BD não está configurado;
4. Cria uma classe 'ClienteDaoMock' e 'ProdutoDaoMock' não dependente do BD, para realizar os testes sobre os métodos;
5. Foram criadas quatro classes de testes, são elas:
    * ClienteServiceTest
    * ProdutoServiceTest
    * ClienteDAOTest
    * ProdutoDAOTest

 