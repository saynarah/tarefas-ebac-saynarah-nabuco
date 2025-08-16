package br.com.saynab.vendas.online.VendaService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.saynab.vendas.online.VendaService.repository")
public class MongoConfig {

}
