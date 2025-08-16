package br.com.saynab.vendas.online.VendaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RefreshScope
@EnableFeignClients
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class VendaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaServiceApplication.class, args);
	}

}
