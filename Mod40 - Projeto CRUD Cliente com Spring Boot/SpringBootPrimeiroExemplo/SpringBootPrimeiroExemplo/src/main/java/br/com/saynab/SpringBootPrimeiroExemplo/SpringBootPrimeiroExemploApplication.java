package br.com.saynab.SpringBootPrimeiroExemplo;

import br.com.saynab.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import br.com.saynab.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.saynab.repository")
@EntityScan("br.com.saynab.*")
@ComponentScan(basePackages = "br.com.saynab")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

	public static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Spring Boot Test");
		cliente.setCpf(12345678945L);
		cliente.setTel(8595858585L);
		cliente.setEnd("End test");
		cliente.setNumero(47);
		cliente.setCidade("São Paulo");
		cliente.setEstado("SP");
		return cliente;
	}
}
