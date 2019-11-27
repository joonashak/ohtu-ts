package ohtu.ts.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;

import ohtu.ts.utils.Configuration;

/**
 * Provides database connection and automatic migration.
 * @author Joonas Häkkinen
 */
public class Database {
    // Path to sqlite database file.
    String path = System.getProperty("user.home").concat("/.ohtu-ts/");
    // Filename for database (with path).
    Configuration config = new Configuration();
    String dbFile = config.getDbFile();

    // Connection string for database driver.
    String connStr = new StringBuilder("jdbc:sqlite:")
            .append(path)
            .append(dbFile)
            .toString();

    /**
     * Initialize the database and run migrations.
     */
    public Database() {
        // Create asset directory if necessary.
        File dir = new File(path);
        dir.mkdir();

        // Run database migrations first.
        Flyway fw = Flyway.configure().dataSource(connStr, null, null).load();
        fw.migrate();
    }

    /**
     * Connect to database.
     * @return Database Connection object.
     */
    public Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connStr);

            if (conn == null) {
                System.out.println("*** ERROR while connecting to database. Program will quit.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return conn;
    }
}
