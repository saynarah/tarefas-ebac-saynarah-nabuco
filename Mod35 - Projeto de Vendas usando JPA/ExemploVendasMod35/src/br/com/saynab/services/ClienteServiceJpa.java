package br.com.saynab.services;


import br.com.saynab.dao.jpa.IClienteJpaDAO;
import br.com.saynab.services.jpa.generics.GenericServiceJpa;

public class ClienteServiceJpa extends GenericServiceJpa implements IClienteServiceJpa {

    private IClienteJpaDAO clienteDAO; //dependência

    //Construtor
    public ClienteServiceJpa(IClienteJpaDAO clienteDAO){ //vou fornecer a implementação como parametro
        super(clienteDAO);
    }


}
