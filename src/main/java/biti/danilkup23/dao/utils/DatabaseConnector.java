package biti.danilkup23.dao.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "db.url";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC driver not found. Add sqlite-jdbc.jar to classpath", e);
            // TODO: add crash message
        }
        initDatabase();
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(PropertiesUtil.getProperty(URL));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initDatabase() {
        File currentDir = new File(System.getProperty("user.dir"));
        File dataDirectory = new File(currentDir, "src/main/java/biti/danilkup23/data");

        if (!dataDirectory.isDirectory()) {
            dataDirectory.mkdirs();
        }
        try(var statement = getConnection().createStatement()) {
            statement.execute(SQLQueries.TABLE_BOOKS.getQuery());
            statement.execute(SQLQueries.TABLE_USERS.getQuery());
            statement.execute(SQLQueries.TABLE_ENTRIES.getQuery());
            statement.execute(SQLQueries.FOREIGN_KEY.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
