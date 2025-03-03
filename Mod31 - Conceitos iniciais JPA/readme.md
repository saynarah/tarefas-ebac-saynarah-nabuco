# Por dentro do JPA

## Módulo 31 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* PostgreSQL
* JPA
* Hibernate


### Funcionalidades

Breve resumo sobre o JPA


### Principais passos:

Até o momento, foram apresentadas duas formas de tornar os dados persistentes conectados com um banco de dados: o uso do JDBC  e o uso de JPA Standards. De forma geral, os padrões do JPA facilitam o processo de acesso aos dados do banco, tendo em vista o uso de ORM (Object Relationship Mapping).

O uso do JDBC requer alguns passos mais primitivos de acesso ao banco de dados, como, por exemplo: carregar o driver de conexão, conectar o driver, criar a query de consulta usando SQL, executar a query e então processar os resultados retornados.

O JPA detém padrões que facilitam esse mapeamento e algumas ferramentas do mercado implementam esses padrões para que usemos nas aplicações. Uma dessas ferramentas é o Hibernate.

Ao usar anotações específicas para marcar os componentes, o Hibernate consegue assumir de forma mais simples o mapeamento entre as classes da aplicação e as tabelas correspondentes no banco de dados, diminuindo os passos do JDBC.

De forma geral, ao configurar o arquivo ‘properties’ e fazendo um bom mapeamento de entidades e de relacionamentos estamos caminhando para um bom uso dos padrões JPA.

### Referências:

* [Diferença entre JDBC, JPA + Hibernate e Spring Data JPA [Na Prática - Java 2023]] (https://www.youtube.com/watch?v=zkrsxvQ6Nro).

* [#17 Spring Data JPA] (https://www.youtube.com/watch?v=GkkcZXF-mD8)

* [Guia de Referência Hibernate] (https://www.devmedia.com.br/guia/hibernate/38312)

