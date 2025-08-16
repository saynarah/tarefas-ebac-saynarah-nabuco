# Projeto de e-commerce com microsserviços Spring Boot

## Módulo 42 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Microsserviços
* Arquitetura
* Spring Boot
* Mongo DB


### Funcionalidades

Integração de microsserviços de um e-commerce (cliente, produto e venda).


### Principais passos:

1. Criar o projeto base para cada microsserviço pelo (https://start.spring.io);
2. Adicionar as seguintes dependências para o projeto ConfigServer: Config Server, Spring Web, Spring Boot DevTools e Lombok;
3. Adicionar as seguintes dependências para os projetos dos microsserviços Cliente, Produto e Venda: Spring Data MongoDB, Spring Web, Validation, Config Client, OpenFeign, Spring Boot DevTools, Lombok, Spring Doc e Boostrap;

#### Projeto ConfigServer:
4. Configura o application.properties do ConfigServer;
5. Adiciona as configurações dos arquivos cliente-service.yml, produto-service e venda-service ao diretório "\ConfigServer\src\main\resources\config";
6. Adiciona anotações a classe ConfigServerApplication.

#### Projeto ClienteService:
7. Configura o application.properties do ClienteService;
8. Adiciona anotações a classe ClienteServiceApplication;
9. Cria a entidade Cliente dentro do pacote 'domain';
10. Cria a interface IClienteRepository extendendo de MongoRepository dentro do pacote 'repository';
11. Cria as classes 'BuscaCliente' e 'CadastroCliente' dentro do pacote 'usecase'; Ambas as classes recebem a anotação @Service;
12. Cria os pacotes 'ErrorHandling' e 'Exception' para tratar e lidar com as exceções dos métodos;
13. Cria as classes 'MongoConfig' , 'OpenAPIConfig' e 'ValidatorConfig' no pacote 'config' para setar as configurações do projeto. As classes aqui citadas recebem a anotação @Configuration;
14. Cria a classe 'ClienteResource' dentro do pacote 'resources' para o RestController dos métodos. Os seguintes endpoints estão disponíveis: GET (isCadastrado, buscarPorId e buscar), POST(cadastrar), PUT(atualizar) e DELETE(remover).


#### Projeto ProdutoService:
15. Os passos 7 ao 14 se repetem para o projeto ProdutoService.

#### Projeto VendaService:
16. Configura o application.properties do VendaService;
17. Adiciona anotações a classe VendaServiceApplication;
18. Cria a entidade Venda, Produto e ProdutoQuantidade dentro do pacote 'domain';
19. Cria a classe VendaDTO dentro do pacote 'dto';
20. Cria a interface IVendaRepository extendendo de MongoRepository dentro do pacote 'repository';
21. Cria as classes 'BuscaVenda' e 'CadastroVenda' dentro do pacote 'usecase'; Ambas as classes recebem a anotação @Service;
22. Cria os pacotes 'ErrorHandling' e 'Exception' para tratar e lidar com as exceções dos métodos;
23. Cria as classes 'MongoConfig' , 'RestTemplateConfig' e 'ValidatorConfig' no pacote 'config' para setar as configurações do projeto. As classes aqui citadas recebem a anotação @Configuration;
24. Cria a interface 'IProdutoService' e as classes 'ClienteService', RestRequest e RestUtils dentro do pacote 'services';
25. Cria a classe 'VendaResource' dentro do pacote 'resources' para o RestController dos métodos. Os seguintes endpoints estão disponíveis: GET (buscar, buscarVendaPorCodigo), POST(cadastrar) e PUT(adicionarProduto).

