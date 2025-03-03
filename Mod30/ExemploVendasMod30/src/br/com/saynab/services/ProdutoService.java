package br.com.saynab.services;

import br.com.saynab.dao.IProdutoDAO;
import br.com.saynab.dao.generics.IGenericDAO;
import br.com.saynab.services.generics.GenericService;

public class ProdutoService extends GenericService implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO) {

        super(produtoDAO);
    }
}
