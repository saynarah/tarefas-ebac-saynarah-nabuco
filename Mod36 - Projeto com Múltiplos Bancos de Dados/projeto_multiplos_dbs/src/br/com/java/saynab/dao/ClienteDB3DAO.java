package br.com.java.saynab.dao;

import br.com.java.saynab.dao.generics.GenericDB3DAO;
import br.com.java.saynab.domain.mysql.Cliente2;

public class ClienteDB3DAO extends GenericDB3DAO<Cliente2, Long> implements IClienteDAO<Cliente2>{

    public ClienteDB3DAO() {
        super(Cliente2.class);
    }
}
