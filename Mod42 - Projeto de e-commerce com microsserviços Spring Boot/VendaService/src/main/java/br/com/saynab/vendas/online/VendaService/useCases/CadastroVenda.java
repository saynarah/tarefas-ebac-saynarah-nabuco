package br.com.saynab.vendas.online.VendaService.useCases;

import java.math.BigDecimal;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import br.com.saynab.vendas.online.VendaService.domain.Produto;
import br.com.saynab.vendas.online.VendaService.domain.Venda;
import br.com.saynab.vendas.online.VendaService.domain.Venda.Status;
import br.com.saynab.vendas.online.VendaService.dto.VendaDTO;
import br.com.saynab.vendas.online.VendaService.exception.EntityNotFoundException;
import br.com.saynab.vendas.online.VendaService.repository.IVendaRepository;
import br.com.saynab.vendas.online.VendaService.services.ClienteService;
import br.com.saynab.vendas.online.VendaService.services.IProdutoService;
import jakarta.validation.Valid;

@Service
public class CadastroVenda {
	
	private IVendaRepository vendaRepository;
	
	private IProdutoService produtoService;
	
	private ClienteService clienteService;
	
	public CadastroVenda(IVendaRepository vendaRepository, IProdutoService produtoService, ClienteService clienteService) {
		this.vendaRepository = vendaRepository;
		this.produtoService = produtoService;
		this.clienteService = clienteService;
	}
	
	public Venda cadastrar(@Valid VendaDTO vendaDTO) {
		Venda venda = convertToDomain(vendaDTO,Status.INICIADA);
		validarCliente(venda.getClienteId());
		venda.recalcularValorTotalVenda();
		return this.vendaRepository.insert(venda);
	}
	
	private void validarCliente(String clienteId) {
		Boolean isCadastrado =
				this.clienteService.isClienteCadastrado(clienteId);
		if(!isCadastrado) {
			new EntityNotFoundException(Venda.class,"clienteId",clienteId);
		}
		
	}

	private Venda convertToDomain(@Valid VendaDTO vendaDTO, Status status) {
		return Venda.builder()
				.clienteId(vendaDTO.getClienteId())
				.codigo(vendaDTO.getCodigo())
				.dataVenda(vendaDTO.getDataVenda())
				.status(status)
				.valorTotal(BigDecimal.ZERO)
				.produtos(new HashSet<>())
				.build();
		
	}
	
	public Venda atualizar(@Valid Venda venda) {
		return this.vendaRepository.save(venda);
	}
	
	public Venda finalizar(String id) {
		Venda venda = buscarVenda(id);
		venda.validarStatus();
		venda.setStatus(Status.CONCLUIDA);
		return this.vendaRepository.save(venda);
	}
	
	public Venda cancelar(String id) {
		Venda venda = buscarVenda(id);
		venda.validarStatus();
		venda.setStatus(Status.CANCELADA);
		return this.vendaRepository.save(venda);
	}
	
	public Venda adicionarProduto(String id, String codigoProduto, Integer quantidade) {
		Venda venda = buscarVenda(id);
		Produto produto = buscarProduto(codigoProduto);
		venda.validarStatus();
		venda.adicionarProduto(produto, quantidade);
		return this.vendaRepository.save(venda);
	}
	
	public Venda removerProduto(String id, String codigoProduto, Integer quantidade) {
		Venda venda = buscarVenda(id);
		Produto produto = buscarProduto(codigoProduto);
		venda.validarStatus();
		venda.removerProduto(produto, quantidade);
		return this.vendaRepository.save(venda);
	}
	

	private Produto buscarProduto(String codigoProduto) {
		Produto produto = produtoService.findByCodigo(codigoProduto);
		if(produto == null) {
			throw new EntityNotFoundException(Produto.class,"codigo",codigoProduto);
		}
		return produto;
	}

	private Venda buscarVenda(String id) {
		return vendaRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException(Venda.class,"id",id));
	}

}
