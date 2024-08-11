package saynab.com.br.dao;

import saynab.com.br.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public Cliente excluir(Long cpf);

    public Cliente alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
