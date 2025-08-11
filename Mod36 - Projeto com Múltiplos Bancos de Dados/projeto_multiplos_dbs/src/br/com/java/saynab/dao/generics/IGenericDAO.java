package br.com.java.saynab.dao.generics;

import br.com.java.saynab.domain.Persistente;
import br.com.java.saynab.exceptions.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

public interface IGenericDAO<T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    public void excluir(T entity) throws DAOException, SQLException;

    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException, SQLException;

    public Collection<T> buscarTodos() throws DAOException, SQLException, TableException;

}
