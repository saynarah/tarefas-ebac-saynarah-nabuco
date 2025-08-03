package br.com.saynab.dao.jpa.generics;

import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static org.postgresql.core.ConnectionFactory.openConnection;

public class GenericJpaDAO<T extends Persistente, E extends Serializable > implements IGenericJpaDAO<T,E>{

    private Class<T> persistenteClass;

    protected EntityManager entityManager;

    protected EntityManagerFactory entityManagerFactory;

    public GenericJpaDAO(Class<T> persistenteClass){
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException, SQLException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();

    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException, SQLException {
        openConnection();
        T entity = entityManager.find(this.persistenteClass, valor);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public Collection buscarTodos() throws DAOException, SQLException, TableException {
        openConnection();
        List<T> list = entityManager.createQuery(getSelectSql(),this.persistenteClass).getResultList();
        closeConnection();
        return list;
    }

    private String getSelectSql() {
        StringBuilder select = new StringBuilder();
        select.append("SELECT obj FROM ");
        select.append(this.persistenteClass.getSimpleName());
        select.append(" obj");
        return select.toString();
    }

    protected void openConnection(){
        entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

    }


    protected void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
    }

}
