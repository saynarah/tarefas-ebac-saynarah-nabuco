package br.com.saynab.vendas.online.ClienteService.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.saynab.vendas.online.ClienteService.domain.Cliente;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente,String>{
	
	Optional<Cliente> findByCpf(Long cpf);

}
