# Projeto de E-Commerce (Emulador com cliente, produto e registro de vendas)

## Módulo 30 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* JUnit
* Mock
* TDD
* Generics
* SQL
* PostgreSQL
* PgAdmin4
* Teste de Integração
* JDBC
* CRUD


### Funcionalidades

Funcionalidades de CRUD (create, read, update, delete) para um sistema de vendas (objetos: cliente, produto e venda).
Realiza testes das camadas de dao/repository orientados pela metodologia TDD (Test Driven Development).


### Principais passos:

1. Cria as tabelas TB_CLIENTE, TB_PRODUTO, TB_VENDA e TB_PRODUTO_QUANTIDADE;
2. As tabelas TB_CLIENTE e TB_PRODUTO guardam os atributos das entidades Cliente e Produto. A TB_VENDA está associado a um cliente e possui um atributo Set<Produtos> para registrar os produtos adicionados àquela venda. A TB_PRODUTO_QUANTIDADE registra a quantidade de cada um dos produtos adicionados dentro de uma venda.
3. Cria a entidade Cliente com seus atributos;
4. Cria a interface IClienteDAO com os métodos principais (cadastrar, atualizar, buscar, listar todos e deletar);
5. Seguindo TDD, cria os testes de integração e, a partir deles, os métodos da classe de implementação ClienteDAO são estruturados;
6. Testes de integração realizados para a entidade 'Cliente': cadastrarClienteTest, buscarClienteTest, excluirClienteTest, buscarTodosClientesTest e atualizarClienteTest;
7. O suíte de testes realizados com a entidade 'Cliente' é provado pelo arquivo 'testes_integracao_ClienteDAOTest.png' do diretório.
8. Os passos 1-5 são refletidos para a entidade Produto;
9. O suíte de testes realizados com a entidade 'Produto' é provado pelo arquivo 'testes_integracao_ProdutoDAOTest.png' do diretório.
10. Testes de integração realizados para a entidade 'Venda': salvarVendaTest, pesquisarVendaTest, removerProdutoVendaTest, removerQtdeProduto, adicionarMaisProdutosDiferentes, adicionarMaisProdutosDoMesmo e cancelarVendaTest.
11. O suíte de testes realizados com a entidade 'Venda' é provado pelo arquivo 'testes_integracao_VendaDAOTest.png' do diretório.