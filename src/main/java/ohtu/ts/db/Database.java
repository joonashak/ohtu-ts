package ohtu.ts.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;

/**
 * Provides database connection and automatic migration.
 * @author Joonas Häkkinen
 */
public class Database {
    
    private String path;
    private String dbFile;
    private File dir;  

    /**
     * Initialize the database and run migrations.
     */
    public Database(String database) {
        // Path to sqlite database file.
        path = System.getProperty("user.home").concat("/.ohtu-ts/");
        // Filename for database (with path)
        dbFile = path.concat(database);
        // Create asset directory if necessary.
        File dir = new File(path);
        dir.mkdir();

        // Run database migrations first.
        Flyway fw = Flyway.configure().dataSource("jdbc:sqlite:" + dbFile, null, null).load();
        fw.migrate();
    }
    
    public String getdbFile() {
        return dbFile;
    }
    
    /**
     * Connect to database.
     * @return Database Connection object.
     */
    public Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

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
