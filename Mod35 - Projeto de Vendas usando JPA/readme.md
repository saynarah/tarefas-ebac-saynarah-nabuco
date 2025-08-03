# Projeto de Cadastro de Clientes (CRUD, Generics, Tests, TDD) 

## Módulo 35 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* JUnit
* TDD
* Generics
* JPA


### Funcionalidades

Funcionalidades de CRUD (create, read, update, delete) para um sistema de vendas (objetos: cliente, produto e venda).
Realiza testes das camadas de dao/repository orientados pela metodologia TDD (Test Driven Development) implementando conceitos de JPA.


### Principais passos:

1. Configura o arquivo 'persistence.xml' dentro da pasta META-INF com as informações do drive, do banco de dados e credenciais de acesso.
2. Cria a interface IGenericJpaDAO com os principais métodos CRUD (create, read, update e delete);
3. Cria a classe de implementação GenericJpaDAO para a interface IGenericJpaDAO;
4. Cria as interfaces IClienteJpaDAO e IProdutoJpaDAO extendendo a interface genérica;
5. Cria as respectivas implementações, mas os métodos CRUD são lidados pela própria classe genérica;
6. Cria a interface IVendaJpaDAO extendendo de IGenericJpa, adicionando três novos métodos : finalizarVenda, cancelarVenda e consultarComCollection;
7. Cria a implementação VendaJpaDAO a partir da IVendaJpaDAO, adaptando o método de cadastrar e adicionando o método consultarComCollection;
8. Seguindo TDD, cria os testes de integração e, a partir deles, os métodos da classe de implementação ClienteJpaDAO são estruturados;
6. Testes de integração realizados para a entidade 'ClienteJpa': pesquisarCliente, salvarCliente, excluirCliente, alterarCliente e buscarTodos;
7. Testes de integração realizados para a entidade 'ProdutoJpa': pesquisarProduto, salvarProduto, excluirProduto, alterarProduto e buscarTodos;
8. Testes de integração realizados para a entidade 'Venda': pesquisar, salvar, cancelarVenda, adicionarMaisProdutosDiferentes, salvarVendaMesmoCodigoExistente, removerProduto, removerApensaUmProduto, removerTodosProdutos, finalizarVenda e tentarAdicionarProdutosVendaFinalizada;
