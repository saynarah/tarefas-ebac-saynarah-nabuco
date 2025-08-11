import br.com.java.saynab.domain.mysql.Cliente2;
import br.com.java.saynab.exceptions.DAOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.java.saynab.dao.ClienteDB1DAO;
import br.com.java.saynab.dao.ClienteDB2DAO;
import br.com.java.saynab.dao.IClienteDAO;
import br.com.java.saynab.domain.Cliente;
import br.com.java.saynab.exceptions.TipoChaveNaoEncontradaException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Cliente2JpaDAO2BancosTest {


    private IClienteDAO<Cliente> clienteDB1DAO;

    private IClienteDAO<Cliente> clienteDB2DAO;

    private Random rd;

    public Cliente2JpaDAO2BancosTest() {
        this.clienteDB1DAO = new ClienteDB1DAO();
        this.clienteDB2DAO = new ClienteDB2DAO();
        rd = new Random();
    }

    @After
    public void end() throws SQLException {
        Collection<Cliente> list = clienteDB1DAO.buscarTodos();
        excluirDB1(list);

        list = clienteDB2DAO.buscarTodos();
        excluirDB2(list);
    }

    private void excluirDB1(Collection<Cliente> list) {
        list.forEach(cli -> {
            try{
                clienteDB1DAO.excluir(cli);
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        });


    }

    private void excluirDB2(Collection<Cliente> list){
        list.forEach(cli -> {
            try{
                clienteDB2DAO.excluir(cli);
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        });
    }


    @Test
    public void pesquisarCliente() throws SQLException, TipoChaveNaoEncontradaException {
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);
    }

    @Test
    public void salvarCliente() throws SQLException, TipoChaveNaoEncontradaException {
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

    }

    @Test
    public void excluirCliente() throws SQLException, TipoChaveNaoEncontradaException {
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDB1DAO.excluir(cliente);
        Cliente clienteConsultado2 = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado2);

        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado3 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado3);

        clienteDB2DAO.excluir(cliente);

        Cliente clienteConsultado4 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado4);


    }

    @Test
    public void alterarCliente() throws SQLException, TipoChaveNaoEncontradaException {
        //DB1
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setNome("Fabrício");
        cliente.setEstado("Rio de Janeiro");
        clienteDB1DAO.alterar(cliente);

        Cliente clienteConsultado2 = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertEquals(clienteConsultado2.getNome(),"Fabrício");
        Assert.assertEquals(clienteConsultado2.getEstado(),"Rio de Janeiro");

        //DB2

        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado3 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado3);

        cliente.setNome("Saynarah");
        cliente.setEstado("São Paulo");
        clienteDB2DAO.alterar(cliente);

        Cliente clienteConsultado4 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertEquals(clienteConsultado4.getNome(),"Saynarah");
        Assert.assertEquals(clienteConsultado4.getEstado(),"São Paulo");

    }

    @Test
    public void buscarTodos() throws SQLException, TipoChaveNaoEncontradaException {
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);
        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        Cliente cliente2 = criarCliente();
        clienteDB1DAO.cadastrar(cliente2);
        Cliente clienteConsultado2 = clienteDB1DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado2);

        Collection<Cliente> lista = clienteDB1DAO.buscarTodos();
        assertTrue(lista != null);
        assertTrue(lista.size() == 2);

        cliente.setId(null);
        cliente2.setId(null);

        clienteDB2DAO.cadastrar(cliente);
        Cliente clienteConsultado3 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado3);

        clienteDB2DAO.cadastrar(cliente2);
        Cliente clienteConsultado4 = clienteDB2DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado4);

        lista = clienteDB2DAO.buscarTodos();
        Assert.assertTrue(lista != null);
        Assert.assertTrue(lista.size() == 2);

    }



    private Cliente criarCliente(){
        Cliente clienteTest = new Cliente();
        clienteTest.setNome("Cliente Test");
        clienteTest.setCpf(rd.nextLong());
        clienteTest.setTel(741852963L);
        clienteTest.setEnd("Rua teste");
        clienteTest.setNumero(45);
        clienteTest.setCidade("Fortaleza");
        clienteTest.setEstado("Ceará");
        return clienteTest;

    }

}
