package br.com.saynab.dao.jpa;

import br.com.saynab.dao.jpa.generics.GenericJpaDAO;
import br.com.saynab.domain.jpa.VendaJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.sql.SQLException;

public class VendaExclusaoJpaDAO extends GenericJpaDAO<VendaJpa, Long> implements IVendaJpaDAO {

    public VendaExclusaoJpaDAO() {
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws DAOException, TipoChaveNaoEncontradaException, SQLException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaJpa consultarComCollection(Long id) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }
}
