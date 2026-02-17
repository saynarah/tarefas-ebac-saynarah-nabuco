# Contêineres e Microsserviços

## Módulo 50 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Contêineres
* Microsserviços
* Docker
* Kubernetes
* Docker
* VM
* CI/CD
* Deployment


## Exercício 1 – Contêineres e microsserviços

### Explique, com suas palavras, a diferença entre contêineres e microsserviços. Extra: é possível subir microsserviços em uma máquina virtual? Justifique sua resposta.

* Os microsserviços são um paradigma arquitetural e os contêineres são meios para implementar este paradigma.É possível executar microsserviços diretamente em máquinas virtuais. No entanto, o uso de contêineres é mais indicado, pois eles permitem inicialização mais rápida, melhor padronização do ambiente e maior facilidade de escalabilidade. Além disso, a maturidade das ferramentas de orquestração, como o Kubernetes, torna o gerenciamento de múltiplos microsserviços mais eficiente. ​

________________________________________________________________________________________________

## Exercício 2 - Integração contínua

### Explique, com suas palavras, por que os desenvolvedores precisam fazer merge frequente de suas mudanças de código para que a integração contínua funcione adequadamente.

* Ao se ter uma cultura de fazer merges frequentes, os blocos a serem mergeados tendem a ser menores e diminuir a aparição de conflitos com a branch principal.​ Além disso, há menos chaveamento de contexto, dado que os desenvolvedores são alertados de mudanças tão logo eles quebram o build e podem consertar os problemas antes de ir para uma nova tarefa

________________________________________________________________________________________________


## Exercício 3 - Entrega contínua

### Explique, com suas palavras, por que é necessário ter uma cobertura abrangente de testes para que a prática de entrega contínua funcione.


* ​Cada mudança que passa por todos os estágios do seu pipeline de produção é entregue aos usuários finais. Não há intervenção humana e somente os testes podem prevenir que algo seja entregue em produção. Com uma boa cobertura de testes, não precisa ter receio de mandar algo pra produção.

________________________________________________________________________________________________


## Exercício 4 - Implantação contínua

### Explique, com suas palavras, as diferenças entre entrega contínua e implantação contínua.


* A entrega contínua é uma extensão da integração contínua e garante que o software esteja sempre em um estado pronto para ser implantado, com todas as etapas de build e testes automatizadas até ambientes de staging. No entanto, a implantação em produção ainda depende de uma decisão manual. Já a implantação contínua automatiza também o deploy em produção, fazendo com que toda mudança que passe pelo pipeline seja disponibilizada automaticamente para os usuários, sem intervenção humana.

