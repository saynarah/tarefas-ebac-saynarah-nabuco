package br.com.saynab.dao.jpa;

import br.com.saynab.dao.jpa.generics.GenericJpaDAO;
import br.com.saynab.domain.jpa.ClienteJpa;
import br.com.saynab.domain.jpa.ProdutoJpa;
import br.com.saynab.domain.jpa.VendaJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;

public class VendaJpaDAO extends GenericJpaDAO<VendaJpa,Long> implements IVendaJpaDAO{

    public VendaJpaDAO() {
        super(VendaJpa.class);
    }


    @Override
    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        super.alterar(venda);

    }

    @Override
    public void cancelarVenda(VendaJpa venda) throws DAOException, TipoChaveNaoEncontradaException, SQLException {
        super.alterar(venda);

    }

    @Override
    public void excluir(VendaJpa entity) throws DAOException{
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }


    public VendaJpa cadastrar(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        try {
            openConnection();
            entity.getProdutos().forEach(prod -> {
                ProdutoJpa prodJpa = entityManager.merge(prod.getProduto());
                prod.setProduto(prodJpa);
            });

            ClienteJpa clienteJpa = entityManager.merge(entity.getCliente());
            entity.setCliente(clienteJpa);

            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        }
        catch (Exception e) {
            throw new DAOException("ERRO SALVANDO VENDA",e);
        }
    }


    @Override
    public VendaJpa consultarComCollection(Long id) {
        openConnection();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<VendaJpa> query = builder.createQuery(VendaJpa.class);
        Root<VendaJpa> root = query.from(VendaJpa.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<VendaJpa> tpQuery = entityManager.createQuery(query);
        VendaJpa venda = tpQuery.getSingleResult();
        closeConnection();
        return venda;
    }
}
