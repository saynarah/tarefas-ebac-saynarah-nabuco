package br.com.saynab.dao.jpa;

import br.com.saynab.dao.jpa.generics.GenericJpaDAO;
import br.com.saynab.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }

}