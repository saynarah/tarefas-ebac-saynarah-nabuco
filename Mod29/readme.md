# CRUD de Cliente e de Produto com Testes de Integração ao PostgreSQL

## Módulo 29 - Especialista Back-end Java (EBAC)

### Palavras-chave

* SQL
* PostgreSQL
* PgAdmin4
* IntelliJ
* Java
* TDD
* Teste de Integração
* JDBC
* CRUD


### Funcionalidades

Realiza um CRUD para as entidades Cliente e Produto, agregando testes de integração com o Banco de Dados.


### Principais passos:

1. Cria as entidades Cliente com seus atributos;
2. Cria a interface IClienteDAO com os métodos principais (cadastrar, atualizar, buscar, listar todos e deletar);
3. Seguindo TDD, cria os testes de integração e, a partir deles, os métodos da classe de implementação ClienteDAO são estruturados;
4. Testes de integração realizados para a entidade 'Cliente': cadastrarClienteTest, buscarClienteTest, excluirClienteTest, buscarTodosClientesTest e atualizarClienteTest;
5. O suíte de testes realizados com a entidade 'Cliente' é provado pelo arquivo 'clientTests_5_tests_passed_print.png' do diretório.
6. Os passos 1-5 são refletidos para a entidade Produto;
7. O suíte de testes realizados com a entidade 'Produto' é provado pelo arquivo 'productTests_5_tests_passed_print.png' do diretório.
