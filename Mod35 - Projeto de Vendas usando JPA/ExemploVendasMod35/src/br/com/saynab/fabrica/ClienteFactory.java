package br.com.saynab.fabrica;

import br.com.saynab.domain.jpa.ClienteJpa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static ClienteJpa convert(ResultSet rs) throws SQLException {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setCpf(rs.getLong(("CPF")));
        cliente.setTel(rs.getLong(("TEL")));
        cliente.setEnd(rs.getString(("RUA")));
        cliente.setNumero(rs.getInt(("NUMERO_RUA")));
        cliente.setCidade(rs.getString(("CIDADE")));
        cliente.setEstado(rs.getString(("ESTADO")));
        return cliente;

    }

}
