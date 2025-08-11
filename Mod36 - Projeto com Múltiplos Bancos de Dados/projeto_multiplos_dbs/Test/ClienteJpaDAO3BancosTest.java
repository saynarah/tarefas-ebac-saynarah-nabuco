import br.com.java.saynab.dao.ClienteDB1DAO;
import br.com.java.saynab.dao.ClienteDB2DAO;
import br.com.java.saynab.dao.ClienteDB3DAO;
import br.com.java.saynab.dao.IClienteDAO;
import br.com.java.saynab.domain.Cliente;
import br.com.java.saynab.domain.mysql.Cliente2;
import br.com.java.saynab.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

public class ClienteJpaDAO3BancosTest {

    private IClienteDAO<Cliente> clienteDB1DAO;
    private IClienteDAO<Cliente> clienteDB2DAO;
    private IClienteDAO<Cliente2> clienteDB3DAO;

    private Random rd;

    public ClienteJpaDAO3BancosTest() {
        this.clienteDB1DAO = new ClienteDB1DAO();
        this.clienteDB2DAO = new ClienteDB2DAO();
        this.clienteDB3DAO = new ClienteDB3DAO();
        rd = new Random();
    }

    @After
    public void end() throws SQLException {
        Collection<Cliente> list = clienteDB1DAO.buscarTodos();
        excluirDB1(list);

        list = clienteDB2DAO.buscarTodos();
        excluirDB2(list);

        Collection<Cliente2> list2 = clienteDB3DAO.buscarTodos();
        excluirDB3(list2);
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

    private void excluirDB2(Collection<Cliente> list) {
        list.forEach(cli -> {
            try{
                clienteDB2DAO.excluir(cli);
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        });


    }

    private void excluirDB3(Collection<Cliente2> list) {
        list.forEach(cli -> {
            try{
                clienteDB3DAO.excluir(cli);
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

        Cliente2 cliente2 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente2);

        Cliente2 clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);
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

        Cliente2 cliente2 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente2);

        Cliente2 clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);
    }

    @Test
    public void excluirCliente() throws SQLException, TipoChaveNaoEncontradaException {
        //DB1
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteDB1DAO.excluir(cliente);
        clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado);

        //DB2
        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

        clienteDB2DAO.excluir(cliente);
        clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNull(clienteConsultado2);

        //DB3
        Cliente2 cliente2 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente2);

        Cliente2 clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);

        clienteDB3DAO.excluir(cliente2);
        clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertNull(clienteConsultado3);
    }

    @Test
    public void alterarCliente() throws SQLException, TipoChaveNaoEncontradaException {
        //DB1
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setNome("Fabrício");
        cliente.setEstado("Espírito Santo");
        clienteDB1DAO.alterar(cliente);

        clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertEquals(clienteConsultado.getNome(),"Fabrício");
        Assert.assertEquals(clienteConsultado.getEstado(),"Espírito Santo");

        //DB2
        cliente.setId(null);
        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

        cliente.setNome("Saynarah");
        cliente.setEstado("Bahia");
        clienteDB2DAO.alterar(cliente);

        clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertEquals(clienteConsultado2.getNome(),"Saynarah");
        Assert.assertEquals(clienteConsultado2.getEstado(),"Bahia");

        //DB3
        Cliente2 cliente2 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente2);

        Cliente2 clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado3);

        cliente2.setNome("Fabrício");
        cliente2.setEstado("Espírito Santo");
        clienteDB3DAO.alterar(cliente2);

        clienteConsultado3 = clienteDB3DAO.consultar(cliente2.getId());
        Assert.assertEquals(clienteConsultado3.getNome(),"Fabrício");
        Assert.assertEquals(clienteConsultado3.getEstado(),"Espírito Santo");

    }

    @Test
    public void buscarTodos() throws SQLException, TipoChaveNaoEncontradaException {
        //DB1
        Cliente cliente = criarCliente();
        clienteDB1DAO.cadastrar(cliente);

        Cliente clienteConsultado = clienteDB1DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);

        Cliente cliente2 = criarCliente();
        clienteDB1DAO.cadastrar(cliente2);

        clienteConsultado = clienteDB1DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado);

        Collection<Cliente> lista = clienteDB1DAO.buscarTodos();
        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.size() == 2);

        //DB2
        cliente.setId(null);
        cliente2.setId(null);

        clienteDB2DAO.cadastrar(cliente);

        Cliente clienteConsultado2 = clienteDB2DAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado2);

        clienteDB2DAO.cadastrar(cliente2);

        clienteConsultado2 = clienteDB2DAO.consultar(cliente2.getId());
        Assert.assertNotNull(clienteConsultado2);

        lista = clienteDB2DAO.buscarTodos();
        Assert.assertNotNull(lista);
        Assert.assertTrue(lista.size() == 2);

        //DB3
        Cliente2 cliente3 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente3);

        Cliente2 clienteConsultado3 = clienteDB3DAO.consultar(cliente3.getId());
        Assert.assertNotNull(clienteConsultado3);

        Cliente2 cliente4 = criarCliente2();
        clienteDB3DAO.cadastrar(cliente4);

        clienteConsultado3 = clienteDB3DAO.consultar(cliente4.getId());
        Assert.assertNotNull(clienteConsultado3);

        Collection<Cliente2> lista2 = clienteDB3DAO.buscarTodos();
        Assert.assertNotNull(lista2);
        Assert.assertTrue(lista2.size() == 2);


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

    private Cliente2 criarCliente2(){
        Cliente2 clienteTest = new Cliente2();
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
