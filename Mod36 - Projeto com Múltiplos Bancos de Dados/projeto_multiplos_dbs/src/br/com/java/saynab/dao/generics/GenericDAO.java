package br.com.java.saynab.dao.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.java.saynab.domain.Persistente;
import br.com.java.saynab.exceptions.*;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {

    private Class<T> persistenteClass;

    protected EntityManager entityManager;

    protected EntityManagerFactory entityManagerFactory;

    private String persistenceUnitName;

    private static final String PERSISTENCE_UNIT_NAME = "Postgres1";

    public GenericDAO(Class<T> persistenteClass, String persistenceUnitName) {
        this.persistenteClass = persistenteClass;
        this.persistenceUnitName = persistenceUnitName;
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
    public Collection<T> buscarTodos() throws DAOException, SQLException, TableException {
        openConnection();
        List<T> list = entityManager.createQuery(getSelectSql(),this.persistenteClass).getResultList();
        closeConnection();
        return list;
    }

    protected void openConnection(){
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

    }


    protected void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
    }

    private String getPersistenceUnitName() {
        if(persistenceUnitName != null && !"".equals(persistenceUnitName)){
            return persistenceUnitName;
        } else {
            return PERSISTENCE_UNIT_NAME;
        }

    }

    private String getSelectSql(){
        StringBuilder select = new StringBuilder();
        select.append("SELECT obj FROM ");
        select.append(this.persistenteClass.getSimpleName());
        select.append(" obj");
        return select.toString();
        //SELECT obj FROM tabela obj (alias)
    }
}
