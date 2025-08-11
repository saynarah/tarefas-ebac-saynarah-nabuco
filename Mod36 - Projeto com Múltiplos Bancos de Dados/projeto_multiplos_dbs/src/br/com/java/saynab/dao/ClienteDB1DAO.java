package br.com.java.saynab.dao;

import br.com.java.saynab.dao.generics.GenericDB1DAO;
import br.com.java.saynab.domain.Cliente;

public class ClienteDB1DAO extends GenericDB1DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDB1DAO() {
        super(Cliente.class);
    }
}
