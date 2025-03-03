package br.com.saynab.fabrica;

import br.com.saynab.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoFactory {

    public static Produto convert(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId(rs.getLong("ID_Produto"));
        produto.setDescricao(rs.getString("DESCRICAO"));
        produto.setCodigo(rs.getString("CODIGO"));
        produto.setNome(rs.getString("NOME"));
        produto.setValor(rs.getBigDecimal("VALOR"));
        produto.setCategoria(rs.getString("CATEGORIA"));
        return produto;
    }
}
