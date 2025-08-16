package br.com.saynab.vendas.online.ClienteService.usecase;

import org.springframework.stereotype.Service;

import br.com.saynab.vendas.online.ClienteService.domain.Cliente;
import br.com.saynab.vendas.online.ClienteService.repository.IClienteRepository;
import jakarta.validation.Valid;

@Service
public class CadastroCliente {
	
	private IClienteRepository clienteRepository;
	
	public CadastroCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrar(@Valid Cliente cliente) {
		return this.clienteRepository.insert(cliente);
		
	}
	
	public Cliente atualizar(@Valid Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void remover(String id) {
		this.clienteRepository.deleteById(id);
	}

}
