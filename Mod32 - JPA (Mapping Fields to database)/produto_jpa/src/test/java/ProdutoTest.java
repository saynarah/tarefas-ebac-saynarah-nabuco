package test.java;

import main.java.domain.Produto;
import main.java.domain.dao.IProdutoDAO;
import main.java.domain.dao.ProdutoDAO;
import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    public ProdutoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrarProdutoTest(){
        Produto produto = new Produto();
        produto.setCodigo("a10");
        produto.setNome("garrafa");
        produto.setDescricao("garrafa térmica");

        Produto produtoCriado = produtoDAO.cadastrarProduto(produto);
        Assert.assertNotNull(produtoCriado);

    }
}
