# Usando Streams para filtrar nomes de uma lista - via Lambda Expressions

## Módulo 22 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* Streams
* Lamba Expressions


### Funcionalidades

Usuário fornece uma lista de nomes/gêneros e o software retorna a lista de nomes do gênero escolhido.

### Principais passos:

1. Solicita uma lista de nomes e gêneros (Formato: nome-F,nome2-M);
2. Transforma o input em uma lista List< String > através do método List.of(input.split(","));
3. Aplica o método stream().filter(nome -> nome.endsWith("f")) para filtrar o gênero.
4. Aplica o método .map(nome -> nome.substring(0, nome.length() - 2)); para imprimir no console somente a lista de nomes;
