package br.com.saynab;

import br.com.saynab.dao.ClienteDAOMock;
import br.com.saynab.dao.IClienteDAO;
import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Persistente;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import br.com.saynab.services.ClienteService;
import br.com.saynab.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTeste {

    private IClienteService clienteService; //dependência adicionada

    private Cliente cliente;

    public ClienteServiceTeste() {
        //para testar o clienteService, eu preciso fornecer o DAO, mas como não tenho acesso ao bd e preciso testar isoladamento, eu crio um mock do DAO e passo como parâmetro
        IClienteDAO clienteDAO = new ClienteDAOMock();
        clienteService = new ClienteService(clienteDAO);
    }

    //sinalizar o que vai ser executado antes dos testes
    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12345612345L);
        cliente.setNome("Saynarah");
        cliente.setCidade("Fortaleza");
        cliente.setRua("Antonio Farias");
        cliente.setNumero_rua(47);
        cliente.setEstado("Ceará");
        cliente.setTel(753869758L);


    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException {

        Persistente clienteConsultado = clienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }


    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Antonio Farias Lima");
        clienteService.alterar(cliente);
        Assert.assertEquals("Antonio Farias Lima", cliente.getNome());
    }
}
