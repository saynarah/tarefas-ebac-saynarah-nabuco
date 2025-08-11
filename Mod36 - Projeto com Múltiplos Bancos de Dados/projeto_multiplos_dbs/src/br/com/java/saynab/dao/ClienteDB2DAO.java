package br.com.java.saynab.dao;

import br.com.java.saynab.dao.generics.GenericDB2DAO;
import br.com.java.saynab.domain.Cliente;

public class ClienteDB2DAO extends GenericDB2DAO<Cliente,Long> implements IClienteDAO<Cliente> {

    public ClienteDB2DAO() {
        super(Cliente.class);
    }
}
