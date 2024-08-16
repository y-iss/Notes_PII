package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class FAEcuaFaunaDataHelper {
    private static final String DB_PATH_CONNECTION = "jdbc:sqlite:DataBase//FAEcuaFauna.sqlite"; 
    private static Connection conn = null;

    protected static synchronized Connection openConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DB_PATH_CONNECTION);
        }
        return conn;
    }

    protected static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

