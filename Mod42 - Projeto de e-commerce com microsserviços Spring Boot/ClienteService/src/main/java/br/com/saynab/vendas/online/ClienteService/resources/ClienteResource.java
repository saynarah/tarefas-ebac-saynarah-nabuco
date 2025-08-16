package br.com.saynab.vendas.online.ClienteService.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.saynab.vendas.online.ClienteService.domain.Cliente;
import br.com.saynab.vendas.online.ClienteService.usecase.BuscaCliente;
import br.com.saynab.vendas.online.ClienteService.usecase.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	private BuscaCliente buscaCliente;
	
	private CadastroCliente cadastroCliente;
	
	@Autowired
	public ClienteResource(BuscaCliente buscaCliente, CadastroCliente cadastroCliente) {
		this.buscaCliente = buscaCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable){
		return ResponseEntity.ok(buscaCliente.buscar(pageable));
	}
	
	
	@GetMapping(value="isCadastrado/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value="id",required = true) String id){
		return ResponseEntity.ok(buscaCliente.isCadastrado(id));
		}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value="id",required = true) String id){
		return ResponseEntity.ok(buscaCliente.buscarPorId(id));
	}
		
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente){
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
		
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente){
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}
	
	@GetMapping(value="cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value="cpf",required = true) Long cpf){
		return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value="id") String id){
		cadastroCliente.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
	
	
}
