package br.com.saynab.dao;

import br.com.saynab.domain.Cliente;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import br.com.saynab.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest(){

        clienteDAO = new ClienteDAOMock();
    }

    //sinalizar o que vai ser executado antes dos testes
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345612345L);
        cliente.setNome("Saynarah");
        cliente.setCidade("Fortaleza");
        cliente.setRua("Antonio Farias");
        cliente.setNumero_rua(47);
        cliente.setEstado("Ceará");
        cliente.setTel(753869758L);

        clienteDAO.cadastrar(cliente);
    }
  //Teste semelhante ao mostrado no ClienteServiceTest, mas no clienteservice é testado a regra de negocio e aqui testa somente o dao
    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void excluir(){
        clienteDAO.excluir(cliente.getCpf());

    }

    @Test
    public void cadastrar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);

    }

    @Test
    public void alterar() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Antonio Farias Lima");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Antonio Farias Lima",cliente.getNome());
    }
}



