package br.com.saynab.dao;

import br.com.saynab.domain.Cliente;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest(){

        clienteDAO = new ClienteDAO();
    }

    @After
    public void end() throws DAOException, TableException, SQLException {
        Collection<Cliente> list = clienteDAO.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDAO.excluir(cli.getCpf());

            } catch (DAOException | SQLException exception){
                exception.printStackTrace();

            }
        });
    }


  //Teste semelhante ao mostrado no ClienteServiceTest, mas no clienteservice é testado a regra de negocio e aqui testa somente o dao
    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException, SQLException {

        Cliente cliente = new Cliente();
        cliente.setCpf(12875612345L);
        cliente.setNome("Saynarah");
        cliente.setCidade("Fortaleza");
        cliente.setRua("Antonio Farias");
        cliente.setNumero_rua(47);
        cliente.setEstado("Carea");
        cliente.setTel(753869758L);
        cliente.setEmail("saynarah@email.com");
        clienteDAO.cadastrar(cliente);


        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente.getCpf());

    }

    @Test
    public void excluir() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {

        Cliente cliente = new Cliente();
        cliente.setCpf(12875612345L);
        cliente.setNome("Saynarah");
        cliente.setCidade("Fortaleza");
        cliente.setRua("Antonio Farias");
        cliente.setNumero_rua(47);
        cliente.setEstado("Carea");
        cliente.setTel(753869758L);
        cliente.setEmail("saynarah@email.com");
        clienteDAO.cadastrar(cliente);


        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void cadastrar() throws TipoChaveNaoEncontradaException, DAOException, SQLException, MaisDeUmRegistroException, TableException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12875612345L);
        cliente.setNome("Saynarah");
        cliente.setCidade("Fortaleza");
        cliente.setRua("Antonio Farias");
        cliente.setNumero_rua(47);
        cliente.setEstado("Carea");
        cliente.setTel(753869758L);
        cliente.setEmail("saynarah@email.com");
        clienteDAO.cadastrar(cliente);


        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDAO.excluir(cliente.getCpf());


    }

    @Test
    public void alterar() throws TipoChaveNaoEncontradaException, DAOException, SQLException, MaisDeUmRegistroException, TableException {

        Cliente cliente = new Cliente();
        cliente.setCpf(75386942159L);
        cliente.setNome("Jessica");
        cliente.setCidade("Campina Grande");
        cliente.setRua("Santos Dumont");
        cliente.setNumero_rua(65);
        cliente.setEstado("Paraiba");
        cliente.setTel(7538697685L);
        cliente.setEmail("saynarah@email.com");
        clienteDAO.cadastrar(cliente);

        Cliente clienteCreated = clienteDAO.consultar(75386942159L);
        Assert.assertNotNull(clienteCreated);

        cliente.setNome("Maria Rosa");
        cliente.setCidade("João Pessoa");
        clienteDAO.alterar(cliente);

        Cliente clienteAntigo = clienteDAO.consultar(75386942159L);
        Assert.assertEquals("Maria Rosa", clienteAntigo.getNome());
        Assert.assertEquals("João Pessoa", clienteAntigo.getCidade());

        clienteDAO.excluir(clienteAntigo.getCpf());

        Cliente clienteDeleted = clienteDAO.consultar(75386942159L);
        Assert.assertNull(clienteDeleted);

    }

    @Test
    public void buscarTodosTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, TableException, MaisDeUmRegistroException {

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(44576612345L);
        cliente1.setNome("Jonatas");
        cliente1.setCidade("Sao Paulo");
        cliente1.setRua("Roberto Marinho");
        cliente1.setNumero_rua(4700);
        cliente1.setEstado("Sao Paulo");
        cliente1.setTel(75373839L);
        cliente1.setEmail("jonatas@email.com");
        clienteDAO.cadastrar(cliente1);

        Assert.assertNotNull(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf(12875612345L);
        cliente2.setNome("Saynarah");
        cliente2.setCidade("Fortaleza");
        cliente2.setRua("Antonio Farias");
        cliente2.setNumero_rua(47);
        cliente2.setEstado("Carea");
        cliente2.setTel(753869758L);
        cliente2.setEmail("saynarah@email.com");
        clienteDAO.cadastrar(cliente2);

       Assert.assertNotNull(cliente2);

       List<Cliente> lista = (List<Cliente>) clienteDAO.buscarTodos();
       Assert.assertEquals(lista.size(),2);

       for(int i=0;i<lista.size();i++){
           clienteDAO.excluir(lista.get(i).getCpf());
           Cliente clienteconsultado = clienteDAO.consultar(lista.get(i).getCpf());
           Assert.assertNull(clienteconsultado);
        }

        List<Cliente> lista2 = (List<Cliente>) clienteDAO.buscarTodos();
        Assert.assertEquals(lista2.size(),0);

    }

}



