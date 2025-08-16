package br.com.saynab.vendas.online.ProdutoService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.saynab.vendas.online.ProdutoService.repository")
public class MongoConfig {

}
