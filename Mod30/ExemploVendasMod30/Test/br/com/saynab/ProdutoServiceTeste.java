package br.com.saynab;
import br.com.saynab.dao.IProdutoDAO;
import br.com.saynab.dao.ProdutoDAO;
import br.com.saynab.domain.Persistente;
import br.com.saynab.domain.Produto;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import br.com.saynab.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ProdutoServiceTeste {

    private ProdutoService produtoService; //dependência adicionada

    private Produto produto;

    public ProdutoServiceTeste() {
        //para testar o produtoservice, eu preciso fornecer o DAO, mas como não tenho acesso ao bd e preciso testar isoladamento, eu crio um mock do DAO e passo como parâmetro
        IProdutoDAO produtoDAO = new ProdutoDAO();
        produtoService = new ProdutoService(produtoDAO);
    }

    //sinalizar o que vai ser executado antes dos testes
    @Before
    public void init(){
        produto = new Produto();
        produto.setNome("Televisão");
        produto.setCodigo("758");
    }

    @Test
    public void pesquisarProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, DAOException, TableException, SQLException {

        Persistente produtoConsultado = produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);

    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);

    }

    @Test
    public void excluirProduto() throws DAOException, SQLException {
        produtoService.excluir(produto.getCodigo());
    }


    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        produto.setNome("Televisão");
        produtoService.alterar(produto);
        Assert.assertEquals("Televisão", produto.getNome());
    }
}
