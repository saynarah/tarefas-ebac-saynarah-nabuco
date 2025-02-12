package dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection con;

    private ConnectionFactory(Connection con) {

    }

    public static Connection getConnection() throws SQLException {
        if(con == null){
            con = initConnection();
        }
        else if (con != null && con.isClosed()){
            con = initConnection();
        }
        return con;
    }

    private static Connection initConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/project_03","postgres","77375885");

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
