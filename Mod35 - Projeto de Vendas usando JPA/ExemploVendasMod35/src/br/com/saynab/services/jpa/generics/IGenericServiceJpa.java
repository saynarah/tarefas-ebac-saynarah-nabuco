package br.com.saynab.services.jpa.generics;

import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

public interface IGenericServiceJpa <T extends Persistente,E extends Serializable> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    /**
     * Método para excluir um registro do banco de dados
     */
    public void excluir(T entity) throws DAOException, SQLException;

    /**
     * Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     */
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException, SQLException;

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     */
    public Collection<T> buscarTodos() throws DAOException, SQLException, TableException;

}