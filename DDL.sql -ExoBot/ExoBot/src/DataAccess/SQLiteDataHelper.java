package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:slite:database//ExaBot2k24.sqlite";
    private static Connection conn = null;
    //protected SQLDtaHelper(){}

    protected static synchronized Connection openconnection() throws Exception{
        try{
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
        }catch (SQLException e) {
            throw e ;
        }
        return conn;
    }
}
