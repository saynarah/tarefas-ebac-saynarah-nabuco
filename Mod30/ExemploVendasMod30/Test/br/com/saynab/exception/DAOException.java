package br.com.saynab.exception;

import java.sql.SQLException;

public class DAOException extends Exception {

    public DAOException(String erroExcluindoObjeto, SQLException e) {
    }
}


