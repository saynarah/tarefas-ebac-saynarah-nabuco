package br.com.saynab.services.generics;

import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.sql.SQLException;

public interface IGenericService <T extends Persistente,E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    public T consultar(E valor) throws MaisDeUmRegistroException, DAOException, TableException, SQLException;

    public void excluir(E valor) throws DAOException, SQLException;

    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;
}
