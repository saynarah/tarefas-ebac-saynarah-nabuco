package br.com.saynab.vendas.online.VendaService.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.saynab.vendas.online.VendaService.domain.Produto;
import br.com.saynab.vendas.online.VendaService.domain.Venda;
import br.com.saynab.vendas.online.VendaService.dto.VendaDTO;
import br.com.saynab.vendas.online.VendaService.useCases.BuscaVenda;
import br.com.saynab.vendas.online.VendaService.useCases.CadastroVenda;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {
	
	private BuscaVenda buscaVenda;
	
	private CadastroVenda cadastroVenda;
	
	public VendaResource(BuscaVenda buscaVenda, CadastroVenda cadastroVenda) {
		this.buscaVenda = buscaVenda;
		this.cadastroVenda = cadastroVenda;
	}
	
	@GetMapping
	@Operation(summary = "Buscar vendas")
	public ResponseEntity<Page<Venda>> buscar(Pageable pageable){
		return ResponseEntity.ok(buscaVenda.buscar(pageable));
	}
	
	@PostMapping
	@Operation(summary = "Iniciar uma venda")
	public ResponseEntity<Venda> cadastrar(@RequestBody @Valid VendaDTO vendaDTO){
		return ResponseEntity.ok(cadastroVenda.cadastrar(vendaDTO));
	}
	
	@GetMapping(value="/{id}")
	@Operation(summary = "Busca uma venda pelo código")
	public ResponseEntity<Venda> buscarVendaPorCodigo(@RequestParam(value="codigo") String codigo){
		return ResponseEntity.ok(buscaVenda.buscarPorCodigo(codigo));
		
	}
	
	@PutMapping(value = "/{id}/{codigoProduto}/{quantidade}/addProduto")
	@Operation(summary = "Adiciona produtos a uma venda")
	public ResponseEntity<Venda> adicionarProduto(
			@PathVariable(name="id",required=true) String id,
			@PathVariable(name="codigoProduto",required=true) String codigoProduto,
			@PathVariable(name="quantidade",required=true) Integer quantidade){
		return ResponseEntity.ok(cadastroVenda.adicionarProduto(id,codigoProduto, quantidade));
		
	}
	
	
	
	

}
