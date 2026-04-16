package saynab.com.memes_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"saynab.com.memes_service.servers.userClient", "saynab.com.memes_service.servers.categoryClient"})
@EnableDiscoveryClient
@SpringBootApplication
public class MemesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemesServiceApplication.class, args);
	}

}
