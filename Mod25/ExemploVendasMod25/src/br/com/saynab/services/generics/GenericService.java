package br.com.saynab.services.generics;

import br.com.saynab.dao.IClienteDAO;
import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.dao.generics.IGenericDAO;
import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

public class GenericService implements IGenericService {

    private IGenericDAO entityDAO; //dependência

    public GenericService(IGenericDAO entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public Boolean cadastrar(Persistente entity) throws TipoChaveNaoEncontradaException {
        return entityDAO.cadastrar(entity);
    }

    @Override
    public Persistente consultar(Long valor) {
        return entityDAO.consultar(valor);
    }

    @Override
    public void excluir(Long valor) {
        entityDAO.excluir(valor);
    }

    @Override
    public void alterar(Persistente entity) throws TipoChaveNaoEncontradaException {
        entityDAO.alterar(entity);

    }
}


    /*
    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);

    }

    @Override
    public Cliente consultar(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }
*/

