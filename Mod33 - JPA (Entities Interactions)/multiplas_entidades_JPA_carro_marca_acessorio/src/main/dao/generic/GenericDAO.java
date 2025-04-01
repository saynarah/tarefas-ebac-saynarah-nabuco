package main.dao.generic;

import main.domain.Persistent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {


    @Override
    public T cadastrar(T entidade) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entidade);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entidade;
    }

    @Override
    public T buscarPorId(Class<T> classe, Long id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        T entidade = entityManager.find(classe,id);

        entityManager.close();
        entityManagerFactory.close();

        return entidade;

    }


}
