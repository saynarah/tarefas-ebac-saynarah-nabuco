package saynab.com.category_meme_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "saynab.com.category_meme_service.userClient")
@EnableDiscoveryClient
@SpringBootApplication
public class CategoryMemeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryMemeServiceApplication.class, args);
	}

}
