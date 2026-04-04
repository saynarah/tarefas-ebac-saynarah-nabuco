# System design

## Módulo 57 - Especialista Back-end Java (EBAC)

### Palavras-chave

* System Design
* Excalidraw
* Requisitos funcionais
* Requisitos não funcionais
* MVP


## Exercício 1 – Desenhe um encurtador de URLs

 Usando as técnicas que aprendemos no curso, faça o desenho de um sistema que seja capaz de encurtar URLs. Encurtadores de URLs são muito úteis para diminuir o tamanho de links ou URLs enormes e facilitam o compartilhamento dos mesmos. Leve em consideração os dois requisitos funcionais abaixo:

- Deve ser capaz de encurtar URLs de qualquer tamanho
- Deve ser capaz de gerar URLs encurtadas de forma única, ou seja, sem repetições nos encurtamentos!

Pense em seu desenho de forma a comportar um ou mais sistemas que consigam lidar com milhares de usuários e de URLs simultaneamente.

A resposta deste exercício deverá ser um diagrama tal quais os que vimos durante o curso. Caso precise de algum site gratuito para desenhar, o excalidraw.io é uma excelente opção.


_______________________________________________________________________________________

O arquivo 'system_design_1.png' contem o desenho proposto pelo exercício.

Descrição: 

- (1) - Usuário faz o request para encurtar o URL
- (2) - A aplicação acessa um Gateway para equilibrar as instâncias do serviço (3).
- (4) - As requisições de salvar as URLs encurtadas no banco de dados são postas numa fila.
- (5) - O consumidor da fila recebe os itens da fila.
- (6) - O consumidor envia cada item pra enviar pro database de URLs.
- (7) - O consumidor recebe de volta as informações da URL e envia para uma fila de notificação (8).
- (9) - O serviço de notificação recebe os itens da fila de notificação.
- (10) - O serviço de notificação retorna ao usuário a URL encurtada.