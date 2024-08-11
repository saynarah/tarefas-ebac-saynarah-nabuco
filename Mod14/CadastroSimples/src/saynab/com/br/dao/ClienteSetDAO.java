package saynab.com.br.dao;

import saynab.com.br.domain.Cliente;

import java.util.Collection;
import java.util.*;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO(Set<Cliente> set) {
        this.set = new HashSet<>();
    }

    @Override
        public Boolean cadastrar(Cliente cliente) {
        //Set.add não deixa adicionar duplicado (usa o equals e hashCode), então não precisa do condicional para verificar se já existe dentro do map
        return this.set.add(cliente);

        }

        @Override
        public Cliente excluir(Long cpf) {
            //Busca o clienteCadastrado no map através da key cpf (cpf é fornecido)
            Cliente clienteEncontrado = null;
            for(Cliente cliente: this.set) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteEncontrado = cliente;
                    break;
                }
            }

            if(clienteEncontrado != null){
                this.set.remove(clienteEncontrado);
            }
            return clienteEncontrado;
        }

        @Override
        public Cliente alterar(Cliente cliente) {
        //verifica se o cliente está contido dentro do set
            if(this.set.contains(cliente)){
                //procura o cliente dentro do set
                for (Cliente clienteAlterado : this.set) {
                    //testa se cada cliente do set até chegar o cliente fornecido
                    if (clienteAlterado.equals(cliente)) {
                        //pega o valor do cliente e coloca no clienteAlterado
                        clienteAlterado.setNome(cliente.getNome());
                        clienteAlterado.setCpf(cliente.getCpf());
                        clienteAlterado.setRua(cliente.getRua());
                        clienteAlterado.setNumero_rua(cliente.getNumero_rua());
                        clienteAlterado.setCidade(cliente.getCidade());
                        clienteAlterado.setEstado(cliente.getEstado());
                        return clienteAlterado;

                    }
                }

            }
    return null;
    }


        @Override
        public Cliente consultar(Long cpf) {
            for (Cliente clienteConsultado : this.set) {
                if (clienteConsultado.getCpf().equals(cpf)) {
                    return clienteConsultado;
                }

            }
            return null;
        }

        @Override
        public Collection<Cliente> buscarTodos() {
            return this.set;
        }

}
