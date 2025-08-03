package br.com.saynab.dao.jpa;

import br.com.saynab.dao.jpa.generics.GenericJpaDAO;
import br.com.saynab.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa,Long> implements IProdutoJpaDAO{

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }
}
