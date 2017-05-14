package libSource.Database;
import libSource.BaseSource;
import libSource.Database.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArchiveFacade {

    private DBManager dbManager;
    private QueryManager queryManager;

    public ArchiveFacade() {
        dbManager = new DBManager();
        queryManager = new QueryManager();
    }

    // Подключение к базе
    public Connection connectDB() throws SQLException {
        return dbManager.ConnectSQLiteDB();
    }

    public void addToArchive(BaseSource src, String Description) {
        return;
    }

    public ResultSet getArchiveFromSource(BaseSource src) {
        return null;
    }


}
