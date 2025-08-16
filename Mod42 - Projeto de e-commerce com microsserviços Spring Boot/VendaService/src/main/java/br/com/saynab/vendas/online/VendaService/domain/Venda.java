package br.com.saynab.vendas.online.VendaService.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Document(collection = "venda")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Venda {
	
	public enum Status{
		INICIADA, CONCLUIDA, CANCELADA;
		
		public static Status getByName(String value) {
			for(Status status: Status.values()) {
				if(status.name().equals(value)) {
					return status;
				}
			}
			return null;
		}
	}

	@Id
	private String id;
	
	@NotNull
	@Size(min=2,max=10)
	@Indexed(unique=true,background=true)
	private String codigo;
	
	@NotNull
	private String clienteId;
	
	private Set<ProdutoQuantidade> produtos;
	
	private BigDecimal valorTotal;
	
	private Instant dataVenda;
	
	private Status status;
	
	public Venda() {
		produtos = new HashSet<>();
	}
	
	public void adicionarProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op = produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if(op.isPresent()) {
			ProdutoQuantidade prodQtd = op.get();
			prodQtd.adicionar(quantidade);
		} else {
			ProdutoQuantidade prod = ProdutoQuantidade.builder()
					.produto(produto)
					.valorTotal(BigDecimal.ZERO)
					.quantidade(0)
					.build();
			prod.adicionar(quantidade);
			produtos.add(prod);
		}
		recalcularValorTotalVenda();
	}

	public void recalcularValorTotalVenda() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for(ProdutoQuantidade prod : this.produtos) {
			valorTotal = valorTotal.add(prod.getValorTotal());
		}
		this.valorTotal = valorTotal;
		
	}

	public void validarStatus() {
		if(this.status== Status.CONCLUIDA || this.status == Status.CANCELADA) {
			throw new UnsupportedOperationException("Impossível alterar venda finalizada ou cancelada");
		}
		
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op = produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if(op.isPresent()) {
			ProdutoQuantidade prodQtd = op.get();
			if(prodQtd.getQuantidade()>quantidade) {
				prodQtd.remover(quantidade);
				recalcularValorTotalVenda();
			} else {
				produtos.remove(op.get());
				recalcularValorTotalVenda();
			}	
	
		}
	}
	
	public void removerTodosProdutos() {
		validarStatus();
		produtos.clear();
		valorTotal = BigDecimal.ZERO;
	}
	
	public Integer getQuantidadeTotalProdutos() {
		int result = produtos.stream()
				.reduce(0,(partialCountResult,prod)-> partialCountResult + prod.getQuantidade(),Integer:: sum);
		return result;
	}
	
	
}
