import dao.generic.jdbc.dao.cliente.ClienteDAO;
import dao.generic.jdbc.dao.cliente.IClienteDAO;
import domain.Cliente;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarClienteTest() throws Exception{

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Maria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad==1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals("Maria",clienteBD.getNome());
        assertEquals("10",clienteBD.getCodigo());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel==1);

    }

    @Test
    public void buscarClienteTest() throws Exception{

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Maria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad==1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getNome(),clienteBD.getNome());
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel==1);

    }

    @Test
    public void excluirClienteTest() throws Exception{

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Maria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad==1);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getNome(),clienteBD.getNome());
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel==1);

    }

    @Test
    public void buscarTodosClientesTest() throws Exception{

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Maria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad==1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("20");
        cliente2.setNome("Maria");
        Integer countCad2 = clienteDAO.cadastrar(cliente2);
        assertTrue(countCad2==1);

        List<Cliente> clientesBD = clienteDAO.buscarTodos();
        assertNotNull(clientesBD);
        assertEquals(2, clientesBD.size());


        int countDel = 0;
        for(Cliente clienteBD : clientesBD){
            clienteDAO.excluir(clienteBD);
            countDel++;
        }

        //verifica se excluiu tudo que foi criado
        assertEquals(clientesBD.size(),countDel);

        //faz a busca e verifica se retorna zero mesmo
        clientesBD = clienteDAO.buscarTodos();
        assertEquals(clientesBD.size(),0);

    }

    @Test
    public void atualizarClienteTest() throws Exception{

        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("13");
        cliente.setNome("João");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad==1);

        Cliente clienteBD = clienteDAO.buscar("13");
        assertNotNull(clienteBD);
        assertEquals(cliente.getNome(),clienteBD.getNome());
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());

        clienteBD.setNome("Gabriel");
        clienteBD.setCodigo("25");
        Integer countCad2 = clienteDAO.atualizar(clienteBD);
        assertTrue(countCad==1);

        Cliente clienteBD1 = clienteDAO.buscar("13");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.buscar("25");
        assertNotNull(clienteBD2);

        assertEquals(clienteBD.getId(),clienteBD2.getId());
        assertEquals(clienteBD.getNome(),clienteBD2.getNome());
        assertEquals(clienteBD.getCodigo(),clienteBD2.getCodigo());

        List<Cliente> lista = clienteDAO.buscarTodos();
        for(Cliente cli: lista){
            clienteDAO.excluir(cli);
        }
    }



}
