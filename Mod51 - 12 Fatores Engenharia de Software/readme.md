# Os 12 fatores de design de microsserviços

## Módulo 51 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Microsserviços
* CI/CD
* Deployment
* Twelve Factor


## Exercício 1 – Os 12 fatores

### Escolha três dos 12 fatores que estudamos em aula e explique, com suas palavras, por que eles são importantes para o desenvolvimento de microsserviços.

* (1º Fator) ​No design de microsserviços seguindo os 12 fatores, cada serviço deve possuir uma única base de código versionada. Esse princípio garante que cada microsserviço seja desenvolvido, testado e implantado de forma independente, permitindo que diferentes times trabalhem em paralelo sem interferência entre si. Essa separação aumenta a agilidade das entregas, reduz o acoplamento e facilita a automação de CI/CD.

* (5º Fator) O fator Build reforça a separação clara entre os estágios de build, release e execução. Essa separação garante que o código seja compilado apenas uma vez, que cada release seja imutável e que a execução não modifique o artefato. Em arquiteturas de microsserviços, isso melhora a manutenibilidade, facilita rollbacks e aumenta a confiabilidade dos pipelines de CI/CD.


* (10ª Fator) A paridade entre ambientes busca reduzir ao máximo as diferenças entre desenvolvimento, homologação e produção, considerando tempo, pessoas e ferramentas. Quanto menor esse gap, mais previsível e confiável se torna o processo de entrega. Em arquiteturas de microsserviços, essa paridade é essencial para garantir agilidade, reduzir falhas em produção e viabilizar pipelines de CI/CD eficientes.

________________________________________________________________________________________________

## Exercício 2 - CI/CD e serviços sem estado (stateless)

### Explique, com suas palavras, por que é importante desenvolver microsserviços sem estado (stateless) e porque isso pode influenciar diretamente nos mecanismos de CI/CD (integração e desenvolvimento contínuos). O que acontece se um serviço tiver estado e tivermos que matar uma de suas instâncias em produção?

* Microsserviços que não são stateless dificultam os mecanismos de CI/CD porque mantêm estado em memória, o que impede que instâncias sejam substituídas livremente durante deploys automáticos. Isso torna o processo de atualização mais arriscado, afeta a escalabilidade e dificulta rollbacks automáticos. Em arquiteturas de microsserviços, o modelo stateless permite que novas versões sejam implantadas, escaladas ou removidas sem impacto nas requisições, viabilizando pipelines de CI/CD rápidos, confiáveis e totalmente automatizados.