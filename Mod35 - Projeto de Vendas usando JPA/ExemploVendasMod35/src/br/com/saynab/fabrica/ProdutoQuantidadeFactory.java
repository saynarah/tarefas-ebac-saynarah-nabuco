package br.com.saynab.fabrica;

import br.com.saynab.domain.jpa.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidadeJpa convert(ResultSet rs) throws SQLException {
        ProdutoJpa produto = ProdutoFactory.convert(rs);
        ProdutoQuantidadeJpa pq = new ProdutoQuantidadeJpa();
        pq.setProduto(produto);
        pq.setId(rs.getLong("ID"));
        pq.setQuantidade(rs.getInt("QUANTIDADE"));
        pq.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        return pq;
    }
}
