package br.com.saynab.dao;

import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Produto;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ProdutoDAOMock implements IProdutoDAO {
    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(Long valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return List.of();
    }
}
