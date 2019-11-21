package ohtu.ts.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Path to sqlite database file.
    String path = System.getProperty("user.home").concat("/.ohtu-ts/");
    String dbFile = path.concat("main.db");

    public Database() {
        // Create asset directory if necessary.
        File dir = new File(path);
        dir.mkdir();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile)) {
            if (conn != null) {
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
