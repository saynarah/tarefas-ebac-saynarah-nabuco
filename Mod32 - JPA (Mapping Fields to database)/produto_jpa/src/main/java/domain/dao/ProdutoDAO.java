package main.java.domain.dao;

import main.java.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Produto cadastrarProduto(Produto produto) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Produto_JPA_mod32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;

    }
}
