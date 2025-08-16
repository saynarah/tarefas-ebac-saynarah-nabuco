package br.com.saynab.vendas.online.ProdutoService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.saynab.vendas.online.ProdutoService.domain.Produto;
import br.com.saynab.vendas.online.ProdutoService.domain.Produto.Status;
import br.com.saynab.vendas.online.ProdutoService.useCase.BuscaProduto;
import br.com.saynab.vendas.online.ProdutoService.useCase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/produto")
public class ProdutoResource {
	
	private BuscaProduto buscaProduto;
	
	private CadastroProduto cadastroProduto;
	
	
	@Autowired
	public ProdutoResource(BuscaProduto buscaProduto,CadastroProduto cadastroProduto) {
		this.buscaProduto = buscaProduto;
		this.cadastroProduto = cadastroProduto;
	}
	
	
	@GetMapping
	@Operation(summary = "Busca uma lista paginada de produtos")
	public ResponseEntity<Page<Produto>> buscar(Pageable pageable){
		return ResponseEntity.ok(buscaProduto.buscar(pageable));
		
	}
	
	@GetMapping(value="/status/{status}")
	@Operation(summary = "Busca uma lista paginada de produtos com status específico")
	public ResponseEntity<Page<Produto>> buscarPorStatus(Pageable pageable,@PathVariable(value = "status", required = true) Status status){
		return ResponseEntity.ok(buscaProduto.buscar(pageable, status));
		
	}
	
	@GetMapping(value = "/{codigo}")
	@Operation(summary = "Busca um produto pelo codigo")
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable(value = "codigo", required = true) String codigo){
		return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
		
	}
	
	@PostMapping
	@Operation(summary = "Cadastra um produto")
	public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto){
		return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
		
	}
	
	@PutMapping
	@Operation(summary = "Atualiza um produto")
	public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto){
		return ResponseEntity.ok(cadastroProduto.atualizar(produto));
		
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um produto pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id){
		cadastroProduto.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
	
	
	
	
	

}
