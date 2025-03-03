package br.com.saynab.dao;

import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Produto;
import br.com.saynab.domain.ProdutoQuantidade;
import br.com.saynab.domain.Venda;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import static br.com.saynab.dao.ConnectionFactory.getConnection;
import static org.junit.Assert.*;

public class VendaDAOTest {

    private Cliente cliente;
    private Produto produto;


    private IClienteDAO clienteDAO;
    private IProdutoDAO produtoDAO;
    private IVendaDAO vendaDAO;

    public VendaDAOTest() {
        vendaDAO = new VendaDAO();
        clienteDAO = new ClienteDAO();
        produtoDAO = new ProdutoDAO();
    }

    @Before
    public void init() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("45", BigDecimal.TEN);
    }


    @After
    public void end() throws DAOException, SQLException, TableException {
        excluirProdutosQuantidadeTabela();
        excluirVendas();
        excluirProdutos();
        clienteDAO.excluir(this.cliente.getCpf());
    }

    private void excluirProdutos() throws DAOException, TableException, SQLException {
        Collection<Produto> list = this.produtoDAO.buscarTodos();
        for (Produto produto : list) {
            this.produtoDAO.excluir(produto.getCodigo());
        }

    }
    
    //Teste 01 da venda
    @Test
    public void pesquisarVendaTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Venda venda = criarVenda("A1");
        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        Venda vendaConsultada = vendaDAO.consultar(venda.getCodigo());
        Assert.assertNotNull(vendaConsultada);

        Assert.assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());

    }

    //Teste 02 da venda
    @Test
    public void salvarVendaTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Venda venda = criarVenda("A2");
        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(100)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));

        Venda vendaConsultada = vendaDAO.consultar(venda.getCodigo());
        assertTrue(vendaConsultada.getId() != null);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());

    }

    //Teste 03 da venda
    @Test
    public void cancelarVendaTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        String codigoVenda = "A3";
        Venda venda = criarVenda(codigoVenda);
        assertNotNull(venda);

        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        assertEquals(codigoVenda, venda.getCodigo());

        vendaDAO.cancelarVenda(venda);

        Venda vendaConsultada = vendaDAO.consultar(codigoVenda);
        assertEquals(vendaConsultada.getCodigo(),codigoVenda);

        assertEquals(vendaConsultada.getStatus(), Venda.Status.CANCELADA);

    }

    //Teste 04 da venda
    @Test
    public void adicionarMaisProdutosDoMesmo() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
        String codigoVenda = "A4";
        Venda venda = criarVenda(codigoVenda);
        assertNotNull(venda);

        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        assertEquals(codigoVenda, venda.getCodigo());

        Venda vendaConsultada = vendaDAO.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(produto,1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Venda.Status.INICIADA));


    }

    //Teste 05 da venda
    @Test
    public void adicionarMaisProdutosDiferentes() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        String codigoVenda = "A5";
        Venda venda = criarVenda(codigoVenda);
        assertNotNull(venda);

        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        assertEquals(codigoVenda, venda.getCodigo());

        //criar um novo produto
        Produto produto2 = new Produto();
        produto2.setNome("Produto 2");
        produto2.setDescricao("Produto 2");
        produto2.setValor(BigDecimal.valueOf(10));
        produto2.setCodigo("47");
        produto2.setCategoria("Categoria 2");
        Boolean retorno2 = produtoDAO.cadastrar(produto2);
        assertTrue(retorno2);

        Venda vendaConsultada = vendaDAO.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(produto2,1);
        assertNotNull(vendaConsultada);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(110).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(Venda.Status.INICIADA));

    }
/*
    @Test(expected = DAOException.class)
    public void salvarVendaMesmoCodigoExistente() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A6");
        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);

        Boolean retorno1 = vendaDAO.cadastrar(venda);
        assertTrue(retorno1);
        assertEquals(venda.getStatus(), Venda.Status.INICIADA);
    }
*/
    @Test
    public void removerQtdeProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Venda venda = criarVenda("A7");
        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);
        Integer quantidadeAntes = venda.getQuantidadeTotalProdutos();

        Long codigo_produto = 45l;
        Produto produtoConsultado = produtoDAO.consultar("45");

        venda.removerProduto(produtoConsultado,1);
        Integer quantidadeDepois = venda.getQuantidadeTotalProdutos();

        assertEquals(BigDecimal.valueOf(quantidadeAntes).subtract(BigDecimal.valueOf(quantidadeDepois)),BigDecimal.valueOf(1));


    }

    @Test
    public void removerProdutoVendaTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Venda venda = criarVenda("A8");
        Boolean retorno = vendaDAO.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(venda.getCodigo(), "A8");

        Produto produto = cadastrarProduto("49",BigDecimal.valueOf(50));
        assertNotNull(produto);
        assertEquals(produto.getCodigo(),"49");

        Venda vendaConsultada = vendaDAO.consultar("A8");
        vendaConsultada.adicionarProduto(produto,1);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(150).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

        vendaConsultada.removerProduto(produto,1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));

    }


    private Venda criarVenda(String codigo) {
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setData_venda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(this.produto,2);
        return venda;


    }


    private void excluirProdutosQuantidadeTabela() throws DAOException {
        String sqlProd = ("DELETE FROM TB_PRODUTO_QUANTIDADE");
        executeDelete(sqlProd);

    }

    private void excluirVendas() throws DAOException {
        String sqlProd = ("DELETE FROM TB_VENDA");
        executeDelete(sqlProd);

    }

    private void executeDelete(String sql) throws DAOException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            conn = getConnection();
            stm = conn.prepareStatement(sql);
            stm.execute();
        }
        catch(SQLException e){
            throw new DAOException("ERRO EXCLUINDO OBJETO",e);
        }
        finally {
            closeConnection(conn,stm,rs);
            
        }
    }

    private void closeConnection(Connection conn, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (conn != null && !stm.isClosed()) {
                conn.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private Produto cadastrarProduto(String codigo, BigDecimal valor) throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        Produto produto = new Produto();
        produto.setNome("Produto 1");
        produto.setDescricao("Produto 1");
        produto.setValor(BigDecimal.valueOf(50));
        produto.setCodigo(codigo);
        produto.setCategoria("Categoria 1");
        produtoDAO.cadastrar(produto);
        return produto;

    }

    private Cliente cadastrarCliente() throws DAOException, SQLException, TipoChaveNaoEncontradaException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setRua("Rua test");
        cliente.setEstado("SP");
        cliente.setNumero_rua(1234);
        cliente.setTel(1199999999L);
        cliente.setEmail("rodrigo@email.com");
        clienteDAO.cadastrar(cliente);
        return cliente;
    }

    protected Connection getConnection() throws DAOException {
        try {
            return ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new DAOException("ERRO ABRINDO CONEXAO COM BANCO DE DADOS ", e);
        }
    }



}
