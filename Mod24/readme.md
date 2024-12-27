# Usando Mock para Fazer Testes 

## Módulo 24 - Especialista Back-end Java (EBAC)

### Palavras-chave

* IntelliJ IDE
* Java
* JUnit
* Mock
* TDD


### Funcionalidades

Realizar testes de métodos utilizando Mock das classes Dao e orientados pela metodologia TDD (Test Driven Development).

### Principais passos:

1. Cria a estruturas dos testes a serem realizados;
2. Num loop de execução e correção adiciona as classes e as interfaces necessárias;
3. A classe 'ContratoDao' dispara erros em cada um dos seus métodos (salvar,alterar,excluir,atualizar) representando que o BD não está configurado;
4. Cria uma classe 'ContratoDaoMock', não dependente do BD, para realizar os testes sobre os métodos;
5. Cada método vai ser testado duas vezes, por exemplo: 'testandoMetodoAtualizar' e 'esperandoErroMetodoAtualizar'. O 'testandoMetodoAtualizar' testa recebendo a classe 'ContratoDaoMock' como input;
6. Realiza os 8 testes (2 para cada um dos 4 Métodos).