package dao.generic.jdbc.dao.produto;

import domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrarProduto(Produto produto) throws Exception;

    public Integer atualizarProduto(Produto produto) throws Exception;

    public List<Produto> listarProdutos() throws Exception;

    public Produto buscarProdutoPorCodigo(Integer codigo) throws Exception;

    public Integer excluirProduto(Integer codigo) throws Exception;
}
