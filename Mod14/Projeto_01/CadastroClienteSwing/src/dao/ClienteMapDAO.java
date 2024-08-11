/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Domain.Cliente;
import java.util.*;

/**
 *
 * @author Saynarah Nabuco
 */
public class ClienteMapDAO implements ICliente {

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
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(),clienteCadastrado);

        return clienteCadastrado;
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
