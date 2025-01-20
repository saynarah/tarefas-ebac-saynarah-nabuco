package br.com.saynab.services;

import br.com.saynab.dao.IClienteDAO;
import br.com.saynab.services.generics.GenericService;

public class ClienteService extends GenericService implements IClienteService {

    private IClienteDAO clienteDAO; //dependência

    //Construtor
    public ClienteService(IClienteDAO clienteDAO){ //vou fornecer a implementação como parametro
        super(clienteDAO);
    }


}
