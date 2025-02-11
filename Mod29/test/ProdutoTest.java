import dao.generic.jdbc.dao.produto.IProdutoDAO;
import dao.generic.jdbc.dao.produto.ProdutoDAO;
import domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarProdutotest() throws Exception {


     Produto produto = new Produto();
     produtoDAO = new ProdutoDAO();

     produto.setCodigo(12);
     produto.setNome("Televisão");
     Integer countCad = produtoDAO.cadastrarProduto(produto);
        assertEquals(1, (int) countCad);

     Produto produtoDB = produtoDAO.buscarProdutoPorCodigo(produto.getCodigo());
     assertNotNull(produtoDB);
     assertEquals(produto.getCodigo(), produtoDB.getCodigo());
     assertEquals(produto.getNome(), produtoDB.getNome());

     Integer countDel = produtoDAO.excluirProduto(produto.getCodigo());
        assertEquals(1, (int) countDel);


    }

    @Test
    public void buscarProdutotest() throws Exception {


        Produto produto = new Produto();
        produtoDAO = new ProdutoDAO();

        produto.setCodigo(12);
        produto.setNome("Televisão");
        Integer countCad = produtoDAO.cadastrarProduto(produto);
        assertEquals(1, (int) countCad);

        Produto produtoDB = produtoDAO.buscarProdutoPorCodigo(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluirProduto(produto.getCodigo());
        assertEquals(1, (int) countDel);


    }

    @Test
    public void ExcluirProdutotest() throws Exception {


        Produto produto = new Produto();
        produtoDAO = new ProdutoDAO();

        produto.setCodigo(12);
        produto.setNome("Televisão");
        Integer countCad = produtoDAO.cadastrarProduto(produto);
        assertEquals(1, (int) countCad);

        Produto produtoDB = produtoDAO.buscarProdutoPorCodigo(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluirProduto(produto.getCodigo());
        assertEquals(1, (int) countDel);


    }
    @Test
    public void AtualizarProdutotest() throws Exception {

        Produto produto = new Produto();
        produtoDAO = new ProdutoDAO();

        produto.setCodigo(15);
        produto.setNome("Sofá");
        Integer countCad = produtoDAO.cadastrarProduto(produto);
        assertEquals(1, (int) countCad);

        Produto produtoDB = produtoDAO.buscarProdutoPorCodigo(produto.getCodigo());
        Assert.assertNotNull(produtoDB);

        Produto produtoNovo = new Produto();
        produtoNovo.setCodigo(16);
        produtoNovo.setNome("Quadro");
        produtoNovo.setId(produtoDB.getId());
        Integer countUpd = produtoDAO.atualizarProduto(produtoNovo);
        assertEquals(1, (int) countUpd);

        Produto produtoDB2 = produtoDAO.buscarProdutoPorCodigo(produtoNovo.getCodigo());
        Assert.assertNotNull(produtoDB2);

        assertEquals(produtoNovo.getCodigo(), produtoDB2.getCodigo());
        assertEquals(produtoNovo.getNome(), produtoDB2.getNome());

        Integer countDel = produtoDAO.excluirProduto(produtoDB2.getCodigo());
        assertEquals(1, (int) countDel);

    }

    @Test
    public void ListarProdutosTest() throws Exception {

        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo(1);
        produto1.setNome("Livro");
        Integer countCad = produtoDAO.cadastrarProduto(produto1);
        assertEquals(1, (int) countCad);

        Produto produto2 = new Produto();
        produto2.setCodigo(2);
        produto2.setNome("Caderno");
        Integer countCad2 = produtoDAO.cadastrarProduto(produto2);
        assertEquals(1, (int) countCad2);

        List<Produto> produtos = produtoDAO.listarProdutos();
        assertEquals(2, produtos.size());

        assertEquals(produtos.get(0).getCodigo(),produto1.getCodigo());
        assertEquals(produtos.get(0).getNome(),produto1.getNome());

        assertEquals(produtos.get(1).getCodigo(),produto2.getCodigo());
        assertEquals(produtos.get(1).getNome(),produto2.getNome());

        Integer countDel = produtoDAO.excluirProduto(produto1.getCodigo());
        assertEquals(1, (int) countDel);

        Integer countDel2 = produtoDAO.excluirProduto(produto2.getCodigo());
        assertEquals(1, (int) countDel2);

    }

    }

