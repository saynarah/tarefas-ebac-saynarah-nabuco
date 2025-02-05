# Conceitos de UNIQUE, PRIMARY KEY, FOREIGN KEY e SEQUENCES com PostgreSQL

## Módulo 28 - Especialista Back-end Java (EBAC)

### Palavras-chave

* SQL
* PostgreSQL
* DDL
* DML
* DQL
* PgAdmin4
* UNIQUE
* PRIMARY KEY
* FOREIGN KEY
* SEQUENCES
* JOIN


### Funcionalidades

Realiza a simulação de uma venda com dados de clientes e de produtos via PostgreSQL usando linguagem SQL.


### Principais passos:

1. Criação da tabela produto com os atributos id, nome e tamanho (arquivo do repositório: 1_create_table_produto_and_create_sequence.png)
2. Atribuição de CONSTRAINTS de primary key no atributo id e de check para o atributo tamanho (arquivo do repositório: 1_create_table_produto_and_create_sequence.png)
3. Criação da sequence para geração de id sequencial (arquivo do repositório: 1_create_table_produto_and_create_sequence.png)
4. Criação da tabela cliente com os atributos id, nome, cpf, cep e sexo (arquivo do repositório: 2_create_table_cliente_and_create_sequence.png)
5. Atribuição de CONSTRAINTS de primary key no atributo id e de check para o atributo sexo (arquivo do repositório: 2_create_table_cliente_and_create_sequence.png)
6. Criação da sequence para geração de id sequencial (arquivo do repositório: 2_create_table_cliente_and_create_sequence.png)
7. Criação da tabela venda com os atributos id, valor,date,id_cliente e id_produto (arquivo do repositório: 3_create_table_venda_and_create_sequence.png)
8. Atribuição de CONSTRAINTS de primary key no atributo id e de foreign key para os atributos id_cliente e id_produto (arquivo do repositório: 3_create_table_venda_and_create_sequence.png)
9. Criação da sequence para geração de id sequencial (arquivo do repositório: 3_create_table_venda_and_create_sequence.png)
10. Adição de dados na tabela de produtos (arquivo do repositório: 4_insert_products_in_the_product_table.png)
11. Adição de dados na tabela de clientes (arquivo do repositório: 5_insert_clients_in_the_client_table)
12. Simulação de uma venda (arquivo do repositório: 6_insert_record_into_venda_table.png)
13. Seleção dos dados com JOIN (arquivo do repositório: 7_select_with_joins.png)


