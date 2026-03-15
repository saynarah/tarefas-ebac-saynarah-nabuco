# Mensageria, Logs e Métricas e Consistência Eventual

## Módulo 53,54 e 55 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Microsserviços
* API
* Springboot
* Rest
* Mensageria
* Kafka
* RabbitMQ
* CAP
* Consistência Forte
* Consistência Eventual

## Exercício 1 – Consistência forte e consistência eventual

### Explique, com suas palavras, a diferença entre as consistências forte e eventual. Consegue pensar em um exemplo de quando usar cada uma? Em que tipo de sistemas?

* A partir do conceito CAP (Consistency, availability e Partitioning), um sistema é desenhado para atender, no máximo, 2 das 3 características acima citadas. Como é inerente de um sistema em microsserviços o seu particionamento em vários elementos pela rede, restam duas opções de sistemas: o CP (consistency + partitioning) e o AP (availability + partitioning). 

No CP, a consistência é mais importante do que a disponibilidade, ou seja, é preferível entregar um dado mais fidedigno do que um dado em menor latência, por exemplo. 

No AP, a disponibilidade é mais importante do que a consistência, ou seja, é melhor entregar um dado com algum nível de descolamento com o dado mais atualizado do que um dado entregue em maior latência.

Um exemplo de CP seria informar ao usuário o seu saldo de pagamento atualizado para garantir que ele execute as suas operações de transações seguintes baseado num dado mais assertivo.

Um exemplo de AP seria a visualização dos posts de amigos nas redes sociais. Exige algum limite aceitável de delay para ver os posts a medida que são postados.

Cada um tem seus prós e contras e vale entender qual modelo se encaixa melhor para o seu negócio.

________________________________________________________________________________________________

## Exercício 2 - Filas e eventos

### Explique, com suas palavras, qual a diferença entre eventos de dados e eventos de aplicação. Quando você usaria um ou outro?

* Os eventos de negócio são lançados sem ser amarrados à modelagem das entidades da base de dados e servem para dar uma visibilidade mais geral do que está ocorrendo na aplicação. O nível de detalhe pode ser menor e mais direto ao ponto. Uma transação de pagamento aconteceu e o evento lança informações chave da aplicação sem precisar detalhar quais tabelas foram afetadas por aquele evento, por exemplo.

* Os eventos de aplicação são lançados com um nível de detalhes maior e traz consigo informações da base de dados. Esses ajudam a dar visiblidade da aplicação dentro do contexto fronteiriço.

________________________________________________________________________________________________

## Exercício 3 - Observabilidade

### Explique, com suas palavras, quais são as métricas mais importantes que um microsserviço deve emitir e por quê.

Latência da requisição = importante para monitorar se o tempo de resposta da requisição estar nos limites acordados com o usuário ou para cobrar o sistema de nuvem provedor.
Uso de memória da aplicação = importante para garantir a saúde da aplicação.
Quantidade de requisições num determinado período de tempo = importante para alertar sobre sobrecarga no sistema e a necessidade de escalar ou não horizontalmente.
