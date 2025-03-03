package br.com.saynab.dao;
import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.domain.Produto;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ProdutoDAO extends GenericDAO<Produto,String> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {

    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO");
        sb.append("(ID,CODIGO,NOME,DESCRICAO,VALOR,CATEGORIA)");
        sb.append("VALUES (nextval('SQ_TB_PRODUTO_ID'),?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected void AdicionarParametrosInsert(PreparedStatement stm, Produto entity) throws SQLException {
        stm.setString(1,entity.getCodigo());
        stm.setString(2,entity.getNome());
        stm.setString(3,entity.getDescricao());
        stm.setBigDecimal(4,entity.getValor());
        stm.setString(5,entity.getCategoria());
    }

    @Override
    protected void AdicionarParametrosSelect(PreparedStatement stm, String valor) throws SQLException {
        stm.setString(1,valor);
    }

    @Override
    protected String getQueryExclusao() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_PRODUTO");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    @Override
    protected void adicionarParametrosQueryExclusao(PreparedStatement stm, String valor) throws SQLException {
        stm.setString(1,valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO SET NOME = ?,");
        sb.append("CODIGO = ?");
        sb.append(",DESCRICAO = ?");
        sb.append(",VALOR = ?");
        sb.append(",CATEGORIA = ?");
        return sb.toString();
    }

    @Override
    protected void adicionarParametrosQueryAtualizacao(PreparedStatement stm, Produto entity) throws SQLException {
        stm.setString(1,entity.getNome());
        stm.setString(2,entity.getCodigo());
        stm.setString(3,entity.getDescricao());
        stm.setBigDecimal(4,entity.getValor());
        stm.setString(5,entity.getCategoria());
    }
}
