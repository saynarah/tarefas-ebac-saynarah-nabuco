package br.com.saynab.jpa;


import br.com.saynab.dao.jpa.IProdutoJpaDAO;
import br.com.saynab.dao.jpa.ProdutoJpaDAO;
import br.com.saynab.domain.jpa.ProdutoJpa;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ProdutoJpaDAOTest {

        private IProdutoJpaDAO produtoJpaDAO;

        private Random rd;

        public ProdutoJpaDAOTest() {
            this.produtoJpaDAO = new ProdutoJpaDAO();
            rd = new Random();
        }

        @After
        public void end() throws DAOException, TableException, SQLException {
            Collection<ProdutoJpa> list = produtoJpaDAO.buscarTodos();
            list.forEach(cli -> {
                try {
                    produtoJpaDAO.excluir(cli);

                } catch (DAOException | SQLException exception){
                    exception.printStackTrace();

                }
            });
        }

        @Test
        public void pesquisarProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
            ProdutoJpa produto = criarProduto("A1");
            produtoJpaDAO.cadastrar(produto);

            ProdutoJpa produtoConsultado = produtoJpaDAO.consultar(produto.getId());
            Assert.assertNotNull(produtoConsultado);
        }


        @Test
        public void salvarProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
            ProdutoJpa produto = criarProduto("A2");
            ProdutoJpa retorno = produtoJpaDAO.cadastrar(produto);
            Assert.assertNotNull(retorno);

            ProdutoJpa produtoConsultado = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNotNull(produtoConsultado);

            produtoJpaDAO.excluir(produto);

            ProdutoJpa produtoConsultado1 = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNull(produtoConsultado1);
        }

        @Test
        public void excluirProduto() throws DAOException, SQLException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
            ProdutoJpa produto = criarProduto("A3");
            ProdutoJpa retorno = produtoJpaDAO.cadastrar(produto);
            Assert.assertNotNull(retorno);

            ProdutoJpa produtoConsultado = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNotNull(produtoConsultado);

            produtoJpaDAO.excluir(produto);

            ProdutoJpa produtoConsultado1 = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNull(produtoConsultado1);

        }

        @Test
        public void alterarProduto() throws MaisDeUmRegistroException, DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
            ProdutoJpa produto = criarProduto("A4");
            ProdutoJpa retorno = produtoJpaDAO.cadastrar(produto);
            Assert.assertNotNull(retorno);

            ProdutoJpa produtoConsultado = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNotNull(produtoConsultado);

            produto.setNome("Nome alterado");
            ProdutoJpa produtoAlterado = produtoJpaDAO.alterar(produto);
            Assert.assertNotNull(produtoAlterado);
            Assert.assertNotEquals(produtoConsultado.getNome(), produtoAlterado.getNome());

            produtoJpaDAO.excluir(retorno);
            ProdutoJpa produtoConsultadoAposExclusao = produtoJpaDAO.consultar(retorno.getId());
            Assert.assertNull(produtoConsultadoAposExclusao);

        }

        @Test
        public void buscarTodosProdutos() throws DAOException, TableException, SQLException, TipoChaveNaoEncontradaException {
            ProdutoJpa produto = criarProduto("A6");
            Assert.assertNotNull(produto);

            ProdutoJpa produtocadastrado1 = produtoJpaDAO.cadastrar(produto);


            ProdutoJpa produto2 = criarProduto("A7");
            Assert.assertNotNull(produto2);

            ProdutoJpa produtocadastrado2 = produtoJpaDAO.cadastrar(produto2);

            Collection<ProdutoJpa> list = produtoJpaDAO.buscarTodos();
            assertTrue(list != null);
            assertTrue(list.size() == 2);

            list.forEach(cli -> {
                try {
                    produtoJpaDAO.excluir(cli);
                } catch (DAOException | SQLException e) {
                    e.printStackTrace();
                }
            });

            Collection<ProdutoJpa> listConsultada = produtoJpaDAO.buscarTodos();
            assertTrue(listConsultada.isEmpty());
            assertTrue(listConsultada.size() == 0);


        }

    private ProdutoJpa criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        ProdutoJpa produto = new ProdutoJpa();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        return produto;
    }


}


