package piramide.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQL {


    private static DBConnectionSQL dbConnectionSQL = null;
    private Connection connection = null;
    private DBConnectionSQL() throws SQLException{
        String user = "admin";
        String password = "admin";
        String host = "192.168.1.44";
        String port = "3306";
        String database = "comidas";

        connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }
    public static Connection getInstance() throws SQLException{
        if (dbConnectionSQL == null){
            dbConnectionSQL = new  DBConnectionSQL();
        }
        return dbConnectionSQL.connection;
    }
}
