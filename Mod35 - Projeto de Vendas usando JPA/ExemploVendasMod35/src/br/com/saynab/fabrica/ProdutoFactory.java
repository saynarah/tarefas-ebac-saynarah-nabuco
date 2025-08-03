package br.com.saynab.fabrica;

import br.com.saynab.domain.jpa.ProdutoJpa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoFactory {

    public static ProdutoJpa convert(ResultSet rs) throws SQLException {
        ProdutoJpa produto = new ProdutoJpa();
        produto.setId(rs.getLong("ID_Produto"));
        produto.setDescricao(rs.getString("DESCRICAO"));
        produto.setCodigo(rs.getString("CODIGO"));
        produto.setNome(rs.getString("NOME"));
        produto.setValor(rs.getBigDecimal("VALOR"));
        return produto;
    }
}
