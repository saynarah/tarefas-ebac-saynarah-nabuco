package br.com.saynab.jpa;

import br.com.saynab.dao.jpa.*;
import br.com.saynab.domain.jpa.ClienteJpa;
import br.com.saynab.domain.jpa.ProdutoJpa;
import br.com.saynab.domain.jpa.VendaJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class VendaJpaDAOTest {

    private ClienteJpa cliente;
    private ProdutoJpa produto;
    private Random rd;


    private IClienteJpaDAO clienteJpaDAO;
    private IProdutoJpaDAO produtoJpaDAO;
    private IVendaJpaDAO vendaJpaDAO;
    private IVendaJpaDAO vendaExclusaoJpaDAO;

    public VendaJpaDAOTest() {
        this.vendaJpaDAO = new VendaJpaDAO();
        this.clienteJpaDAO = new ClienteJpaDAO();
        this.produtoJpaDAO = new ProdutoJpaDAO();
        vendaExclusaoJpaDAO = new VendaExclusaoJpaDAO();
        rd = new Random();
    }

    @Before
    public void init() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("A1",BigDecimal.TEN);
    }

    @After
    public void end() throws DAOException, SQLException, TableException {
        excluirVendas();
        excluirProdutos();
        clienteJpaDAO.excluir(this.cliente);
    }

    @Test
    public void pesquisar() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        VendaJpa venda = criarVenda("A1");
        VendaJpa vendaJpa = vendaJpaDAO.cadastrar(venda);
        Assert.assertNotNull(vendaJpa);

        VendaJpa vendaConsultada = vendaJpaDAO.consultar(venda.getId());
        Assert.assertTrue(vendaConsultada.getCodigo().equals(venda.getCodigo()));

    }

    @Test
    public void salvar() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {

        VendaJpa venda = criarVenda("A2");
        VendaJpa vendaJpa = vendaJpaDAO.cadastrar(venda);
        Assert.assertNotNull(vendaJpa);

        Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        Assert.assertTrue(venda.getStatus().equals(VendaJpa.Status.INICIADA));

        VendaJpa vendaConsultada = vendaJpaDAO.consultar(venda.getId());
        Assert.assertTrue(vendaConsultada.getId() != null);
        Assert.assertTrue(vendaConsultada.getCodigo().equals(venda.getCodigo()));
    }

    @Test
    public void cancelarVenda() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        VendaJpa venda = criarVenda("A3");
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        Assert.assertNotNull(retorno);
        Assert.assertNotNull(venda);
        Assert.assertEquals(venda.getCodigo(),retorno.getCodigo());

        retorno.setStatus(VendaJpa.Status.CANCELADA);
        vendaJpaDAO.cancelarVenda(venda);

        VendaJpa vendaConsultada = vendaJpaDAO.consultar(venda.getId());
        Assert.assertEquals(vendaConsultada.getCodigo(),retorno.getCodigo());
        Assert.assertEquals(vendaConsultada.getStatus(),VendaJpa.Status.CANCELADA);

    }


    //Teste 04 da venda
    @Test
    public void adicionarMaisProdutosDoMesmo() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A4";
        VendaJpa venda = criarVenda(codigoVenda);
        assertNotNull(venda);

        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        assertNotNull(retorno);
        assertEquals(codigoVenda, venda.getCodigo());

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(produto,1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));

    }


    @Test
    public void adicionarMaisProdutosDiferentes() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A5";
        String codigoProduto = "A5";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);

        Assert.assertNotNull(retorno);
        Assert.assertNotNull(venda);
        assertEquals(venda.getCodigo(),retorno.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoProduto, BigDecimal.valueOf(50));
        Assert.assertNotNull(prod);
        Assert.assertEquals(codigoProduto,prod.getCodigo());

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod,1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        Assert.assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));

    }


    @Test(expected = DAOException.class)
    public void salvarVendaMesmoCodigoExistente() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        VendaJpa venda = criarVenda("A6");
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        assertNotNull(retorno);

        VendaJpa retorno1 = vendaJpaDAO.cadastrar(venda);
        assertNull(retorno1);
        assertEquals(venda.getStatus(), VendaJpa.Status.INICIADA);
    }

    @Test
    public void removerProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A7";
        String codigoProduto = "A7";
        VendaJpa venda = criarVenda(codigoVenda);;
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);

        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(venda.getCodigo(),retorno.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoProduto, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoProduto,prod.getCodigo());

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));


        vendaConsultada.removerProduto(prod,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));


    }

    @Test
    public void removerApenasUmProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A8";
        String codigoProduto = "A8";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        Assert.assertNotNull(retorno);
        assertNotNull(venda);
        Assert.assertEquals(codigoVenda,venda.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoProduto, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoProduto,prod.getCodigo());

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

        vendaConsultada.removerProduto(prod,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));

    }

    @Test
    public void removerTodosProdutos() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A9";
        String codigoProduto = "A9";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        Assert.assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda,retorno.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoProduto, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoProduto,prod.getCodigo());

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));


        vendaConsultada.removerTodosProdutos();
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
        assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.ZERO));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));

    }

    @Test
    public void finalizarVenda() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A10";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda,retorno.getCodigo());


        venda.setStatus(VendaJpa.Status.CONCLUIDA);
        vendaJpaDAO.finalizarVenda(venda);

        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        assertEquals(venda.getCodigo(),vendaConsultada.getCodigo());
        assertEquals(VendaJpa.Status.CONCLUIDA,vendaConsultada.getStatus());

    }


    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutosVendaFinalizada() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A11";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaJpaDAO.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda,retorno.getCodigo());

        venda.setStatus(VendaJpa.Status.CONCLUIDA);
        vendaJpaDAO.finalizarVenda(venda);


        VendaJpa vendaConsultada = vendaJpaDAO.consultarComCollection(venda.getId());
        assertEquals(venda.getCodigo(),vendaConsultada.getCodigo());
        assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus());

        vendaConsultada.adicionarProduto(this.produto,1);

    }


    private VendaJpa criarVenda(String codigo) {
        VendaJpa venda = new VendaJpa();
        venda.setCodigo(codigo);
        venda.setStatus(VendaJpa.Status.INICIADA);
        venda.setCliente(this.cliente);
        venda.adicionarProduto(this.produto,2);
        venda.setDataVenda(Instant.now());
        return venda;

    }


    private void excluirProdutos() throws DAOException, TableException, SQLException {
        Collection<ProdutoJpa> list = this.produtoJpaDAO.buscarTodos();
        list.forEach( prod -> {
            try{
                this.produtoJpaDAO.excluir(prod);
            }
            catch(DAOException | SQLException e){
                e.printStackTrace();
            }
        });
    }

    private void excluirVendas() throws DAOException, TableException, SQLException {
        Collection<VendaJpa> list = this.vendaExclusaoJpaDAO.buscarTodos();
        list.forEach( prod -> {
            try{
                this.vendaExclusaoJpaDAO.excluir(prod);
            }
            catch(DAOException | SQLException e){
                e.printStackTrace();
            }
        });
    }

    private void excluirProdutosQuantidadeTabela() {
    }

    private ClienteJpa cadastrarCliente() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        ClienteJpa clienteTest = new ClienteJpa();
        clienteTest.setNome("Cliente Test");
        clienteTest.setNome("Cliente Test");
        clienteTest.setCpf(rd.nextLong());
        clienteTest.setTel(741852963L);
        clienteTest.setEnd("Rua teste");
        clienteTest.setNumero(45);
        clienteTest.setCidade("Fortaleza");
        clienteTest.setEstado("Ceará");
        clienteJpaDAO.cadastrar(clienteTest);
        return clienteTest;
    }

    private ProdutoJpa cadastrarProduto(String codigo, BigDecimal valor) throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        ProdutoJpa produtoTest = new ProdutoJpa();
        produtoTest.setNome("Produto Test");
        produtoTest.setCodigo(codigo);
        produtoTest.setDescricao("Produto Test");
        produtoTest.setValor(valor);
        produtoJpaDAO.cadastrar(produtoTest);
        return produtoTest;
    }
}
