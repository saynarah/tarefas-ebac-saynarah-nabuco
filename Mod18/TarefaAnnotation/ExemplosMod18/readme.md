# Usando Annotations para registrar o nome de uma tabela 

## Módulo 18 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* Annotations


### Funcionalidades

Usuário pode usar a anotação para guardar o nome de uma tabela atrelada a uma classe.

### Principais passos:

1. Criar a annotation intitulada 'Tabela' - @interface;
2. Adicionar o método String nomeTabela() no corpo da anotação;
2. Criar uma classe que implemente a anotação e passe o nome da tabela. @Tabela(nomeTabela = "TabelaTeste").