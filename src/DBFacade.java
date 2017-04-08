import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JacKeTUs on 08.04.2017.
 */
public class DBFacade {
    private DBManager dbManager;
    private QueryManager queryManager;

    public DBFacade() {
        dbManager = new DBManager();
        queryManager = new QueryManager();
    }

    // Подключение к базе
    public Connection connectDB() throws SQLException {
        return dbManager.ConnectSQLiteDB();
    }

    // Получить все ресурсы
    public ResultSet getAllResources() throws SQLException {
        return dbManager.ExecQuery(queryManager.selectAll() + queryManager.orderBy());
    }

    // Получить все темы
    public ResultSet getThemes() throws SQLException {
        return dbManager.ExecQuery(queryManager.selectThemes() + queryManager.orderBy());
    }

    // Получить все типы
    public ResultSet getTypes() throws SQLException {
        return dbManager.ExecQuery(queryManager.selectTypes() + queryManager.orderBy());
    }

    // Простой поиск
    public ResultSet simpleSearch(String searchQuery) throws SQLException {
        return dbManager.ExecQuery(queryManager.simpleSearchResource(searchQuery));
    }
}
