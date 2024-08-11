/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Domain.Cliente;
import java.util.Collection;

/**
 *
 * @author Saynarah Nabuco
 */
public interface ICliente {
    
    public Boolean cadastrar(Cliente cliente);

    public Cliente excluir(Long cpf);

    public Cliente alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
