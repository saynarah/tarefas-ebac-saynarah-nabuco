package br.com.saynab.dao;

import br.com.saynab.dao.generics.GenericDAO;
import br.com.saynab.domain.Cliente;
import br.com.saynab.domain.Persistente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente,Long > implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    //só puxa os métodos da GenericDAO, os demais metodos da GenericDAO são implementações da interface
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_CLIENTE");
        sb.append("(ID,NOME,CPF,TEL,RUA,NUMERO_RUA,CIDADE,ESTADO,EMAIL)");
        sb.append("VALUES (nextval('SQ_TB_CLIENTE_ID'),?,?,?,?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected void AdicionarParametrosInsert(PreparedStatement stm, Cliente entity) throws SQLException {
        stm.setString(1,entity.getNome());
        stm.setLong(2, entity.getCpf());
        stm.setLong(3, entity.getTel());
        stm.setString(4, entity.getRua());
        stm.setLong(5,entity.getNumero_rua());
        stm.setString(6, entity.getCidade());
        stm.setString(7, entity.getEstado());
        stm.setString(8, entity.getEmail());
    }

    @Override
    protected void AdicionarParametrosSelect(PreparedStatement stm, Long valor) throws SQLException {
        stm.setLong(1, valor);
    }

    @Override
    protected String getQueryExclusao() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_CLIENTE");
        sb.append(" WHERE CPF = ?");
        return sb.toString();
    }

    @Override
    protected void adicionarParametrosQueryExclusao(PreparedStatement stm, Long valor) throws SQLException {
        stm.setLong(1,valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_CLIENTE SET NOME = ?,");
        sb.append("CPF = ?");
        sb.append(",TEL = ?");
        sb.append(",RUA = ?");
        sb.append(",NUMERO_RUA = ?");
        sb.append(",CIDADE = ?");
        sb.append(",ESTADO = ?");
        sb.append(",EMAIL = ?");
        return sb.toString();

    }

    @Override
    protected void adicionarParametrosQueryAtualizacao(PreparedStatement stm, Cliente entity) throws SQLException {
        stm.setString(1, entity.getNome());
        stm.setLong(2, entity.getCpf());
        stm.setLong(3, entity.getTel());
        stm.setString(4, entity.getRua());
        stm.setLong(5, entity.getNumero_rua());
        stm.setString(6, entity.getCidade());
        stm.setString(7, entity.getEstado());
        stm.setString(8, entity.getEmail());
    }

}
