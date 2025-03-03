package br.com.saynab.dao;

import br.com.saynab.dao.generics.IGenericDAO;
import br.com.saynab.domain.Venda;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.sql.SQLException;

public interface IVendaDAO extends IGenericDAO<Venda,String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException, SQLException;
}
