package br.com.saynab.jpa;

import br.com.saynab.dao.jpa.ClienteJpaDAO;
import br.com.saynab.dao.jpa.IClienteJpaDAO;
import br.com.saynab.domain.jpa.ClienteJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClienteJpaDAOTest {

    private IClienteJpaDAO clienteJpaDAO;

    private Random rd;

    public ClienteJpaDAOTest() {
        this.clienteJpaDAO = new ClienteJpaDAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException, TableException, SQLException {
        Collection<ClienteJpa> list = clienteJpaDAO.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteJpaDAO.excluir(cli);

            } catch (DAOException | SQLException exception){
                exception.printStackTrace();

            }
        });
    }

    @Test
    public void pesquisarCliente() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        clienteJpaDAO.cadastrar(cliente);

        ClienteJpa clienteConsultado = clienteJpaDAO.consultar(cliente.getId());
        Assert.assertNotNull(clienteConsultado);
    }


    @Test
    public void salvarCliente() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteJpaDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteJpaDAO.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);
    }

    @Test
    public void excluirCliente() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteJpaDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        clienteJpaDAO.excluir(cliente);

        ClienteJpa clienteConsultado1 = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNull(clienteConsultado1);

    }

    @Test
    public void alterarCliente() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
        ClienteJpa cliente = criarCliente();
        ClienteJpa retorno = clienteJpaDAO.cadastrar(cliente);
        Assert.assertNotNull(retorno);

        ClienteJpa clienteConsultado = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNotNull(clienteConsultado);

        cliente.setNome("Nome alterado");
        ClienteJpa clienteAlterado = clienteJpaDAO.alterar(cliente);
        Assert.assertNotNull(clienteAlterado);
        Assert.assertNotEquals(clienteConsultado.getNome(), clienteAlterado.getNome());

        clienteJpaDAO.excluir(retorno);
        ClienteJpa clienteConsultadoAposExclusao = clienteJpaDAO.consultar(retorno.getId());
        Assert.assertNull(clienteConsultadoAposExclusao);

    }

    @Test
    public void buscarTodos() throws DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
        ClienteJpa cliente = criarCliente();
        Assert.assertNotNull(cliente);

        ClienteJpa clientecadastrado1 = clienteJpaDAO.cadastrar(cliente);


        ClienteJpa cliente2 = criarCliente();
        Assert.assertNotNull(cliente2);

        ClienteJpa clientecadastrado2 = clienteJpaDAO.cadastrar(cliente2);

        Collection<ClienteJpa> list = clienteJpaDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteJpaDAO.excluir(cli);
            } catch (DAOException | SQLException e) {
                e.printStackTrace();
            }
        });

        Collection<ClienteJpa> listConsultada = clienteJpaDAO.buscarTodos();
        assertTrue(listConsultada.isEmpty());
        assertTrue(listConsultada.size() == 0);


    }

    private ClienteJpa criarCliente() {
        ClienteJpa clienteTest = new ClienteJpa();
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
