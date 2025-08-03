package br.com.saynab.services;

import br.com.saynab.dao.jpa.IProdutoJpaDAO;
import br.com.saynab.services.jpa.generics.GenericServiceJpa;

public class ProdutoServiceJpa extends GenericServiceJpa implements IProdutoServiceJpa {

    private IProdutoJpaDAO produtoDAO;

    public ProdutoServiceJpa(IProdutoJpaDAO produtoDAO) {

        super(produtoDAO);
    }
}
