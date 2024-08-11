package saynab.com.br.dao;

import saynab.com.br.domain.Cliente;

import java.util.Collection;
import java.util.*;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())){
            return false;
        }

        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente excluir(Long cpf) {
        //Busca o clienteCadastrado no map através da key cpf (cpf é fornecido)
        if(map.containsKey(cpf)) {
            Cliente clienteCadastrado = map.get(cpf);
            map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
            return clienteCadastrado;
        }
        return null;
    }

    @Override
    public Cliente alterar(Cliente cliente) {
        //é fornecido o cliente, a partir do cliente, eu busco o cliente pelo cpf dele no map - o 'cliente' vai ter as informações novas
        Cliente clienteAlterado = map.get(cliente.getCpf());
        clienteAlterado.setNome(cliente.getNome());
        clienteAlterado.setCpf(cliente.getCpf());
        clienteAlterado.setRua(cliente.getRua());
        clienteAlterado.setNumero_rua(cliente.getNumero_rua());
        clienteAlterado.setCidade(cliente.getCidade());
        clienteAlterado.setEstado(cliente.getEstado());
        return clienteAlterado;
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
