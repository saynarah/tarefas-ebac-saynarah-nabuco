package dao.generic.jdbc.dao.produto;

import dao.generic.jdbc.ConnectionFactory;
import domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrarProduto(Produto produto) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try{
            conexao = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = conexao.prepareStatement(sql);
            inserirParametros(stm,produto);
            return stm.executeUpdate();

        } catch(Exception e){
            throw e;
        } finally {
            closeConnection(conexao,stm,rs);

        }

    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs){
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();

            }
        } catch (SQLException e1) {
            e1.printStackTrace();

        }

    }


    private void inserirParametros(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1,produto.getNome());
        stm.setInt(2,produto.getCodigo());
    }

    private String getSqlInsert() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO TB_PRODUTO (ID,NOME,CODIGO) VALUES (nextval('SQ_PRODUTO_ID'),?,?)");
        return sql.toString();
    }

    @Override
    public Integer atualizarProduto(Produto produto) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try{
            conexao = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = conexao.prepareStatement(sql);
            inserirParametrosUpdate(stm,produto);
            Integer countUpdate = stm.executeUpdate();
            return countUpdate;

        }
        catch(Exception e){
            throw e;
        }
        finally{
            closeConnection(conexao,stm,rs);
        }

    }

    private void inserirParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setInt(1,produto.getCodigo());
        stm.setString(2,produto.getNome());
        stm.setLong(3,produto.getId());

    }

    private String getSqlUpdate() {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE TB_PRODUTO SET CODIGO = ?, NOME = ? WHERE ID = ?");
        return sql.toString();
    }

    @Override
    public List<Produto> listarProdutos() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();

        try{
            conexao = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("CODIGO"));
                produto.setNome(rs.getString("NOME"));
                produto.setId(rs.getLong("ID"));
                produtos.add(produto);

           }

        } catch(Exception e){
            throw e;
        }

        finally{
            closeConnection(conexao,stm,rs);
        }


        return produtos;
    }

    private String getSqlSelectAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM TB_PRODUTO");
        return sql.toString();
    }

    @Override
    public Produto buscarProdutoPorCodigo(Integer codigo) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            conexao = ConnectionFactory.getConnection();
            String sql = getSqlSelectId(codigo);
            stm = conexao.prepareStatement(sql);
            AdicionarParametros(stm,codigo);
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setId(rs.getLong("id"));

            }

        } catch (Exception e) {
            throw e;

        } finally {
            closeConnection(conexao, stm, rs);
        }
        return produto;
    }

    private void AdicionarParametros(PreparedStatement stm, Integer codigo) throws SQLException {
        stm.setInt(1,codigo);
    }


    private String getSqlSelectId(Integer codigo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM TB_PRODUTO WHERE CODIGO = ?");
        return sql.toString();
    }

    @Override
    public Integer excluirProduto(Integer codigo) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try{
            conexao = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = conexao.prepareStatement(sql);
            AdicionarParametrosDelete(stm,codigo);
            Integer countDel = stm.executeUpdate();
            return countDel;

        }
        catch(Exception e){
            throw e;
        }
        finally {
            closeConnection(conexao,stm,rs);
        }

    }

    private void AdicionarParametrosDelete(PreparedStatement stm, Integer codigo) throws SQLException {
        stm.setInt(1,codigo);
    }

    private String getSqlDelete() {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM TB_PRODUTO WHERE CODIGO = ?");
        return sql.toString();
    }
}
