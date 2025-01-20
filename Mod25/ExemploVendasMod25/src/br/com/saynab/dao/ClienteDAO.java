package br.com.saynab.dao;

import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Persistente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    //só puxa os métodos da GenericDAO, os demais metodos da GenericDAO são implementações da interface
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    /*
    @Override
    public Boolean salvar(Cliente cliente) {
    return true;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return null;
    }


    @Override
    public void alterarCliente(Cliente cliente) {

    }

    public void excluirCliente(Long cpf){

    }
    */

}
