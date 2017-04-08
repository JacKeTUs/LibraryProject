package libSource;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by JacKeTUs on 07.04.2017.
 */
public class DBManager {

    private Connection dbConnection;
    private Statement dbStatement;

    public DBManager() {};

    public Connection ConnectSQLiteDB() throws SQLException {
        Connection c = null;

        dbConnection = DriverManager.getConnection("jdbc:sqlite:D:/LABS/6s/LIB/lib/db/db.sqlite3");
        dbStatement = dbConnection.createStatement();

        System.out.println("Database was opened!");
        return getConnection();
    }

    public Connection getConnection() {
        return dbConnection;
    }

    public Statement getStatement() {
        return dbStatement;
    }

    public ResultSet ExecQuery(String query_str) throws SQLException {
        return dbStatement.executeQuery(query_str);
    }
}
