package br.com.saynab.vendas.online.VendaService.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.saynab.vendas.online.VendaService.domain.Produto;

@FeignClient(name = "produto", url= "${application.produtoService.endpointConsultarProduto}")
public interface IProdutoService {

	@RequestMapping(method = RequestMethod.GET,value="/{codigo}", produces = "application/json", headers= "application/json")
	Produto findByCodigo(@RequestParam("codigo") String codigo);
	

}
