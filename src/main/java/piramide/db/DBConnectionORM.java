package piramide.db;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DBConnectionORM {
    private static DBConnectionORM dbConnectionORM = null;
    private ConnectionSource connection = null;
    public DBConnectionORM() throws SQLException {
        String user = "admin";
        String password = "admin";
        String host = "192.168.1.44";
        String port = "3306";
        String database = "comidas";
        connection = new JdbcConnectionSource("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }
    public static ConnectionSource getInstance() throws  SQLException{
        if (dbConnectionORM == null){
            dbConnectionORM = new DBConnectionORM();
        }
        return dbConnectionORM.connection;
    }
}
