package br.com.saynab.dao;

import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Produto;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    private Produto produto;

    public ProdutoDAOTest(){

        produtoDAO = new ProdutoDAO();
    }

    @After
    public void end() throws DAOException, TableException, SQLException {
        Collection<Produto> list = produtoDAO.buscarTodos();
        list.forEach(cli -> {
            try {
                produtoDAO.excluir(cli.getCodigo());

            } catch (DAOException | SQLException exception){
                exception.printStackTrace();

            }
        });
    }



    //Teste semelhante ao mostrado no ProdutoServiceTest, mas no produtoservice é testado a regra de negocio e aqui testa somente o dao
    @Test
    public void pesquisarProdutoTest() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {

    Produto produto = new Produto();
    produto.setNome("garrafa");
    produto.setDescricao("Garrafa pra academia");
    produto.setCodigo("12");
    produto.setValor(BigDecimal.valueOf(50D));
    produto.setCategoria("Acessório");
    produtoDAO.cadastrar(produto);

    Produto produtoConsultado = produtoDAO.consultar("12");
    Assert.assertNotNull(produtoConsultado);

    produtoDAO.excluir(produto.getCodigo());

    Produto produtoConsultado2 = produtoDAO.consultar("12");
    Assert.assertNull(produtoConsultado2);


    }

    @Test
    public void excluirProdutoTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {

        Produto produto = new Produto();
        produto.setNome("garrafa");
        produto.setDescricao("Garrafa pra academia");
        produto.setCodigo("12");
        produto.setValor(BigDecimal.valueOf(50D));
        produto.setCategoria("Acessório");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar("12");
        Assert.assertNotNull(produtoConsultado);

        produtoDAO.excluir(produto.getCodigo());

        Produto produtoConsultado2 = produtoDAO.consultar("12");
        Assert.assertNull(produtoConsultado2);

    }

    @Test
    public void cadastrarProdutoTest() throws TipoChaveNaoEncontradaException, DAOException, SQLException, MaisDeUmRegistroException, TableException {
        Produto produto = new Produto();
        produto.setNome("garrafa");
        produto.setDescricao("Garrafa pra academia");
        produto.setCodigo("12");
        produto.setValor(BigDecimal.valueOf(50D));
        produto.setCategoria("Acessório");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar("12");
        Assert.assertNotNull(produtoConsultado);

        produtoDAO.excluir(produto.getCodigo());

        Produto produtoConsultado2 = produtoDAO.consultar("12");
        Assert.assertNull(produtoConsultado2);

    }

    @Test
    public void alterarProdutoTest() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
        Produto produto = new Produto();
        produto.setNome("garrafa");
        produto.setDescricao("Garrafa pra academia");
        produto.setCodigo("12");
        produto.setValor(BigDecimal.valueOf(50D));
        produto.setCategoria("Acessório");
        produtoDAO.cadastrar(produto);

        Produto produtoConsultado = produtoDAO.consultar("12");
        Assert.assertNotNull(produtoConsultado);

        produto.setNome("televisão");
        produto.setDescricao("equipamento para assistir filme");

        produtoDAO.alterar(produto);

        Produto produtoAntigo = produtoDAO.consultar("12");
        Assert.assertEquals(produtoAntigo.getNome(), "televisão");
        Assert.assertEquals(produtoAntigo.getDescricao(), "equipamento para assistir filme");

        produtoDAO.excluir(produto.getCodigo());

        Produto produtoDeleted = produtoDAO.consultar(produto.getCodigo());
        Assert.assertNull(produtoDeleted);
    }

    @Test
    public void buscarTodosProdutosTest() throws DAOException, SQLException, TipoChaveNaoEncontradaException, TableException, MaisDeUmRegistroException {

        Produto produto1 = new Produto();
        produto1.setNome("garrafa");
        produto1.setDescricao("Garrafa pra academia");
        produto1.setCodigo("12");
        produto1.setValor(BigDecimal.valueOf(50D));
        produto1.setCategoria("Acessório");
        produtoDAO.cadastrar(produto1);

        Assert.assertNotNull(produto1);

        Produto produto2 = new Produto();
        produto2.setNome("sofa");
        produto2.setDescricao("Item de decoração");
        produto2.setCodigo("15");
        produto2.setValor(BigDecimal.valueOf(1200D));
        produto2.setCategoria("Mobília");
        produtoDAO.cadastrar(produto2);

        Assert.assertNotNull(produto2);

        List<Produto> lista = (List<Produto>) produtoDAO.buscarTodos();
        Assert.assertEquals(lista.size(),2);

        for(int i=0;i<lista.size();i++){
            produtoDAO.excluir(lista.get(i).getCodigo());
            Produto produtoConsultado = produtoDAO.consultar(lista.get(i).getCodigo());
            Assert.assertNull(produtoConsultado);
        }

        List<Produto> lista2 = (List<Produto>) produtoDAO.buscarTodos();
        Assert.assertEquals(lista2.size(),0);




    }
}