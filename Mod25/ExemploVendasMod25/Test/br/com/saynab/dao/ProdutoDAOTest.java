package br.com.saynab.dao;

import br.com.saynab.domain.Produto;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    private Produto produto;

    public ProdutoDAOTest(){

        produtoDAO = new ProdutoDAOMock();
    }

    //sinalizar o que vai ser executado antes dos testes
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setNome("Televisão");
        produto.setCodigo(758L);

    }
    //Teste semelhante ao mostrado no ProdutoServiceTest, mas no produtoservice é testado a regra de negocio e aqui testa somente o dao
    @Test
    public void pesquisarCliente(){

        Produto produtoConsultado = produtoDAO.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);

    }

    @Test
    public void excluir(){
       produtoDAO.excluir(produto.getCodigo());

    }

    @Test
    public void cadastrar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoDAO.cadastrar(produto);
        Assert.assertTrue(retorno);

    }

    @Test
    public void alterar() throws TipoChaveNaoEncontradaException {
        produto.setNome("Televisão");
        produtoDAO.alterar(produto);
        Assert.assertEquals("Televisão",produto.getNome());
    }
}