# Monolitos e Microsserviços

## Módulo 49 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Monolito
* Microsserviços
* Pilares da engenharia de software
* Escalabilidade
* Performance
* Disponibilidade
* Consistência
* Testabilidade


### Exercício 1 – Escalabilidade

Explique, em termos de Escalabilidade, as vantagens e desvantagens das arquiteturas de software de Monólitos e Microsserviços.

Monolítica:

Vantagens: Escalamento simples replicando toda a aplicação em servidores adicionais; ideal para cargas uniformes.
​Desvantagens: Escala tudo de uma vez, desperdiçando recursos se só uma parte precisar; torna-se ineficiente em crescimento.

Microsserviços:
Vantagens: Escalamento independente por serviço, otimizando recursos conforme demanda; alta granularidade.
Desvantagens: Complexidade em gerenciar múltiplos escalamentos; overhead de rede pode limitar em cenários extremos.
​

________________________________________________________________________________________________

### Exercício 2 - Disponibilidade

Explique, em termos de Disponibilidade, as vantagens e desvantagens das arquiteturas de software de Monólitos e Microsserviços.

Monolítica:

Vantagens: Implantação única facilita monitoramento centralizado; menos pontos de falha iniciais.
​Desvantagens: Falha única derruba tudo; downtime total em atualizações.

Microsserviços:

Vantagens: Isolamento de falhas preserva o sistema; redundância por serviço melhora tolerância.
Desvantagens: Dependências em cascata podem propagar falhas; latência de rede afeta resiliência.
​

________________________________________________________________________________________________


### Exercício 3 - Consistência

Explique, em termos de Consistência, as vantagens e desvantagens das arquiteturas de software de Monólitos e Microsserviços.

Monolítica:

Vantagens: Consistência forte e imediata via transações ACID em banco único; simples de implementar.
​Desvantagens: Engarrafamentos em locks de banco afetam todo o sistema; rigidez em cenários distribuídos.
​

Microsserviços:

Vantagens: Modelos flexíveis como eventual consistência por serviço; adapta a domínios variados.
​Desvantagens: Dificuldade em manter consistência forte distribuída (problema CAP); sagas/eventos complexos.
​

________________________________________________________________________________________________


### Exercício 4 - Performance

Explique, em termos de Performance, as vantagens e desvantagens das arquiteturas de software de Monólitos e Microsserviços.

Monolítica:

Vantagens: Chamadas internas rápidas sem overhead de rede; latência baixa em monolito bem otimizado.
​Desvantagens: Sobrecarga em apps grandes afeta performance global; gargalos propagam rápido.

Microsserviços:

Vantagens: Otimização por serviço com tech específica; paralelismo melhora throughput.
​Desvantagens: Overhead de rede e serialização reduz performance; latência acumulada em chains.


________________________________________________________________________________________________


### Exercício 5 - Testabilidade

Explique, em termos de Testabilidade, as vantagens e desvantagens das arquiteturas de software de Monólitos e Microsserviços.

Monolítica:

Vantagens: Testes de integração fáceis em um único codebase; ambiente unificado simplifica setups.
​Desvantagens: Testes lentos e frágeis devido ao acoplamento; difícil isolar módulos para testes unitários.
​

Microsserviços:

Vantagens: Testes isolados por serviço aceleram ciclos; fácil mockar dependências independentes.
​Desvantagens: Testes de integração complexos entre serviços; requer ferramentas extras para orquestração.
​