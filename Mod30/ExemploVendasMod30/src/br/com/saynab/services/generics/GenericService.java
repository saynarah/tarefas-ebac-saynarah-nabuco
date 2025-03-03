package br.com.saynab.services.generics;

import br.com.saynab.dao.IClienteDAO;
import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.dao.generics.IGenericDAO;
import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.sql.SQLException;

public class GenericService<T extends Persistente,E extends Serializable> implements IGenericService<T,E> {

    protected IGenericDAO<T,E> entityDAO; //dependência

    public GenericService(IGenericDAO<T,E> entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        return entityDAO.cadastrar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException, SQLException {
        return entityDAO.consultar(valor);
    }

    @Override
    public void excluir(E valor) throws DAOException, SQLException {
        entityDAO.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        entityDAO.alterar(entity);

    }
}


    /*
    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);

    }

    @Override
    public Cliente consultar(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }
*/

