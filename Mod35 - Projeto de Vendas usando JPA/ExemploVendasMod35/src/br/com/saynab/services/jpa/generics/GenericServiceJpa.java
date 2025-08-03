package br.com.saynab.services.jpa.generics;

import br.com.saynab.dao.jpa.generics.IGenericJpaDAO;
import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

public abstract class GenericServiceJpa<T extends Persistente, E extends Serializable> implements IGenericServiceJpa<T, E> {

    protected IGenericJpaDAO<T,E> dao;

    public GenericServiceJpa(IGenericJpaDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException, SQLException {
        return this.dao.consultar(valor);
    }

    @Override
    public void excluir(T entity) throws DAOException, SQLException {
        this.dao.excluir(entity);

    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        return this.dao.alterar(entity);

    }

    @Override
    public Collection<T> buscarTodos() throws DAOException, TableException, SQLException {
        return this.dao.buscarTodos();
    }
}
