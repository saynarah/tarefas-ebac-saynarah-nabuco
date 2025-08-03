package br.com.saynab.dao.jpa;

import br.com.saynab.dao.jpa.generics.IGenericJpaDAO;
import br.com.saynab.domain.jpa.VendaJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.sql.SQLException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa,Long> {

    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    public void cancelarVenda(VendaJpa venda) throws DAOException, TipoChaveNaoEncontradaException, SQLException;

    public VendaJpa consultarComCollection(Long id);
}
