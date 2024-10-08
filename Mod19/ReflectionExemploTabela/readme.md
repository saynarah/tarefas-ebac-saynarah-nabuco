# Usando Reflections para imprimir o nome da tabela - informação salva via Annotation

## Módulo 19 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* Annotations
* Reflections


### Funcionalidades

Usuário pode usar a imprimir o parâmetro da anotação no console em tempo de execução.

### Principais passos:

1. Criar a annotation intitulada 'Tabela' - @interface;
2. Adicionar o método String nomeTabela() no corpo da anotação;
3. Criar uma classe que implemente a anotação e passe o nome da tabela. @Tabela(nomeTabela = "TabelaTeste").
4. Na classe principal 'Main' identifica a classe e através do getNomeTabela imprime o nome da Tabela.