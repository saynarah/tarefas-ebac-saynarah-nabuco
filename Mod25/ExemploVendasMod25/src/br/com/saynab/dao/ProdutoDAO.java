package br.com.saynab.dao;
import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.domain.Produto;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {


    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {

    }
}
