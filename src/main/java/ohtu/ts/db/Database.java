package ohtu.ts.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.flywaydb.core.Flyway;

public class Database {
    Connection conn;
    // Path to sqlite database file.
    String path = System.getProperty("user.home").concat("/.ohtu-ts/");
    // Filename for database.
    String dbFile = path.concat("main.db");

    /**
     * Initialize a connection to the database.
     */
    public Database() {
        // Create asset directory if necessary.
        File dir = new File(path);
        dir.mkdir();

        // Run database migrations first.
        Flyway fw = Flyway.configure().dataSource("jdbc:sqlite:" + dbFile, null, null).load();
        fw.migrate();

        // Connect to the database.
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

            if (this.conn == null) {
                System.out.println("*** ERROR while connecting to database. Program will quit.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Get database Connection object to interface with the db.
     * @return Database Connection object.
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Close this Database connection.
     */
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            System.out.println("*** ERROR while closing database connection.");
            System.exit(1);
        }
    }
}
