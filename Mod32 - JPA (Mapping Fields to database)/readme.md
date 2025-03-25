#  JPA (Mapping Fields to database)

## Módulo 32 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* PostgreSQL
* JPA
* Hibernate
* SQL
* Persistence


### Funcionalidades

1. Cadastrar Produto no banco de dados PostgreSQL, usando JPA Hibernate para mapear os atributos com a tabela no BD.


### Principais passos:

1. Adicionar as bibliotecas do Postgres e do Hibernate ao Build Path do projeto;
2. Criação do dataset 'produto_mod32' no postgreSQL (Arquivo: pasta 'Prints' do repositório > 1_database_with_no_tables_created);
3. Configurar o arquivo 'persistence.xml' com o nome do dataset criado e as credenciais de acesso (aqui foram deixadas credenciais aleatórias);
4. Adiciona as anotações (@Column, @Id e @GeneratedValue) aos atributos da classe Produto e (@Entity, @Table) a própria classe Produto;
5. Baseado na metodologia TDD, estrutura primeiro o test de cadastro e depois a classeDao;
6. Realiza o teste 'cadastroProdutoTest'(Arquivo: pasta 'Prints' do repositório > 2_table_and_sequence_created);
7. Consulta a tabela 'Produto' (Arquivo: pasta 'Prints' do repositório > 3_produto_teste_cadastrado)


### Licenças:

* Apache 2.0