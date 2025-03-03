package br.com.saynab.fabrica;

import br.com.saynab.domain.Produto;
import br.com.saynab.domain.ProdutoQuantidade;
import br.com.saynab.domain.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
        Produto produto = ProdutoFactory.convert(rs);
        ProdutoQuantidade pq = new ProdutoQuantidade();
        pq.setProduto(produto);
        pq.setId(rs.getLong("ID"));
        pq.setQuantidade(rs.getInt("QUANTIDADE"));
        pq.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        return pq;
    }
}
