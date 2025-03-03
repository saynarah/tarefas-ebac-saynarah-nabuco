package br.com.saynab.dao;

import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.ProdutoQuantidade;
import br.com.saynab.domain.Venda;
import br.com.saynab.exception.DAOException;
import br.com.saynab.exception.MaisDeUmRegistroException;
import br.com.saynab.exception.TableException;
import br.com.saynab.exception.TipoChaveNaoEncontradaException;
import br.com.saynab.fabrica.ProdutoQuantidadeFactory;
import br.com.saynab.fabrica.VendaFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class VendaDAO extends GenericDAO<Venda,String> implements IVendaDAO {


    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try{
            conexao = getConnection();
            String sql = "UPDATE TB_VENDA SET STATUS_VENDA = ? WHERE ID = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1,Venda.Status.CANCELADA.name());
            stm.setLong(2,venda.getId());
            stm.executeUpdate();
        }
        catch(SQLException e){
            throw new DAOException("Erro ao atualizar status da Venda", e);
        }
        finally {
            closeConnection(conexao,stm,rs);
        }

    }

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    public void atualiarDados(Venda entity, Venda entityCadastrado) {

    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_VENDA ");
        query.append("(ID,CODIGO,ID_CLIENTE_FK,VALOR_TOTAL,DATA_VENDA,STATUS_VENDA)");
        query.append("VALUES (nextval('sq_tb_venda_id'),?,?,?,?,?)");
        return query.toString();
    }

    @Override
    protected void AdicionarParametrosInsert(PreparedStatement stm, Venda entity) throws SQLException {
        stm.setString(1, entity.getCodigo());
        stm.setLong(2,entity.getCliente().getId());
        stm.setBigDecimal(3,entity.getValorTotal());
        stm.setTimestamp(4,Timestamp.from(entity.getData_venda()));
        stm.setString(5,entity.getStatus().name());
    }

    @Override
    protected void AdicionarParametrosSelect(PreparedStatement stm, String valor) throws SQLException {

    }

    @Override
    protected String getQueryExclusao() {
        return "";
    }

    @Override
    protected void adicionarParametrosQueryExclusao(PreparedStatement stm, String valor) throws SQLException {

    }

    @Override
    protected String getQueryAtualizacao() {
        return "";
    }

    @Override
    protected void adicionarParametrosQueryAtualizacao(PreparedStatement stm, Venda entity) throws SQLException {

    }

    @Override
    public Boolean cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException, SQLException {
        Connection conexao = null;
        PreparedStatement stm = null;

        try{
            conexao = getConnection();
            String sql = getQueryInsercao();
            stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            AdicionarParametrosInsert(stm,entity);
            int rowsAffected = stm.executeUpdate();

            if(rowsAffected > 0) {
                try (ResultSet rs = stm.getGeneratedKeys()){
                    if (rs.next()) {
                        entity.setId(rs.getLong(1));
                    }
                }

                    for (ProdutoQuantidade prod : entity.getProdutos()) {
                        stm = conexao.prepareStatement(getQueryInsercaoProdQuantidade(), Statement.RETURN_GENERATED_KEYS);
                        setParametrosQueryInsercaoProdQuantidade(stm, prod, entity);
                        rowsAffected = stm.executeUpdate();
                    }
                    return true;

                }
            } catch (SQLException e) {
                    throw new DAOException("Erro cadastrando o objeto", e);
            } finally {
                    closeConnection(conexao, stm, null);
                }
        return false;
            }


        public String getQueryInsercaoProdQuantidade(){
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_PRODUTO_QUANTIDADE");
        query.append("(ID,ID_PRODUTO_FK,ID_VENDA_FK,QUANTIDADE,VALOR_TOTAL)");
        query.append("VALUES (nextval('sq_tb_produto_quantidade_id'),?,?,?,?)");
        return query.toString();
        }

        public void setParametrosQueryInsercaoProdQuantidade(PreparedStatement stm, ProdutoQuantidade prod,Venda entity) throws SQLException {
        stm.setLong(1, prod.getProduto().getId());
        stm.setLong(2, entity.getId());
        stm.setInt(3, prod.getQuantidade());
        stm.setBigDecimal(4, prod.getValorTotal());
        }


        @Override
        public Venda consultar(String codigo) throws MaisDeUmRegistroException, TableException, DAOException, SQLException {
        Connection conexao = null;
        PreparedStatement stm = null;

        try{
            conexao = getConnection();
            String sql = getBaseSelect();
            stm = conexao.prepareStatement(sql);
            setParametrosQuerySelect(stm,codigo); //acredito que é uma forma de puxar o consultar do VendaDAO e não do GenericDao
            ResultSet rs = stm.executeQuery();

            if(rs.next()) {
                Venda venda = VendaFactory.convert(rs);
                buscarAssociacaoVendaProdutos(conexao,venda);
                return venda;
            }

        }
        catch (SQLException e) {
            throw new DAOException("Erro ao consultar o objeto", e);

        }
        finally {
            closeConnection(conexao, stm, null);
        }
        return null;
    }

    private void setParametrosQuerySelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1,codigo);
    }

    private void buscarAssociacaoVendaProdutos(Connection conexao, Venda venda) throws DAOException, SQLException {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            StringBuilder query = new StringBuilder();
            query.append("SELECT PQ.ID,PQ.QUANTIDADE,PQ.VALOR_TOTAL,");
            query.append("P.ID AS ID_PRODUTO,P.CODIGO,P.NOME,P.DESCRICAO,P.VALOR,P.CATEGORIA ");
            query.append("FROM TB_PRODUTO_QUANTIDADE PQ ");
            query.append("INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO_FK ");
            query.append(" WHERE PQ.ID_VENDA_FK = ?");

            stm = conexao.prepareStatement(query.toString());
            stm.setLong(1, venda.getId());
            rs = stm.executeQuery();

            Set<ProdutoQuantidade> produtos = new HashSet<>();
            while (rs.next()) {
                ProdutoQuantidade produto = ProdutoQuantidadeFactory.convert(rs);
                produtos.add(produto);
            }
            venda.setProdutos(produtos);
            venda.recalcularValorTotalVenda();

        }catch(SQLException e){
            throw new DAOException("ERRO CONSULTANDO O OBJETO",e);
        }finally {
            closeConnection(conexao,stm,rs);
        }
    }

    private String getBaseSelect() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT V.ID AS ID_VENDA, V.CODIGO, V.ID_CLIENTE_FK, V.VALOR_TOTAL, V.DATA_VENDA, V.STATUS_VENDA,");
        query.append("C.ID AS ID_CLIENTE, C.NOME, C.CPF, C.TEL, C.RUA, C.NUMERO_RUA, C.CIDADE, C.ESTADO, C.EMAIL ");
        query.append("FROM TB_VENDA V INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE_FK = C.ID ");
        query.append("WHERE V.CODIGO = ?;");
        return query.toString();
    }

}
