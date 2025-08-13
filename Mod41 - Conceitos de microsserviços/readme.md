# Conceituando Arquitetura de Microsserviços

## Módulo 41 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Microsserviços
* Arquitetura


### Funcionalidades

Breve resumo sobre Arquitetura de Microsserviços


### Principais passos:

Microsserviços é uma nomenclatura dada a um tipo de arquitetura de software que quebra a lógica de negócio em pequenas partes, ou seja, cada unidade é responsável por um único microsserviço.
Como cada unidade é responsável por uma parcela da lógica de negócio, é comum que, em grandes corporações, times diferentes possam gerenciar diferentes parcelas dessa lógica. Por exemplo, um time faz o gerenciamento da parte de pagamento de um e-commerce e o outro time faz o gerenciamento do cadastro de produtos e de clientes.

Além disso, a manutenção desse tipo de arquitetura é facilitada e permite que pequenas partes evoluam mais rápido que outras. Isso não seria possível numa arquitetura monolítica, pois todas as partes precisam evoluir juntas. Inclusive, pode ser aceito que cada microsserviço seja programado em linguagens diferentes e até com deploy em nuvens diferentes.

A implementação pode custar bem caro e, por isso, ela não representa a solução para todos os problemas de todas as empresas. Se a situação problema possui poucos usuários e poucas unidades de serviços, pode ser que o valor investido não compense.

Vale ressaltar que o número de microsserviços pode ficar bem complexo e, por isso, os engenheiros de software tentam controlar através da implementação de conteinerização, da orquestração de containers, da automação do pipeline, da captação de sistemas de mensageria assíncrona, do monitoramento da performance entre outros.

Por fim, essa arquitetura se mostra uma importante alternativa para garantir uma manutenção facilitada que acompanhe as diretrizes de evolução e escalabilidade de cada realidade de negócio.

### Referências:

* [Microservices Explained in 5 Minutes] (https://www.youtube.com/watch?v=lL_j7ilk7rc).

* [What Are Microservices Really All About?(And When Not To Use It)] (https://www.youtube.com/watch?v=lTAcCNbJ7KE)
