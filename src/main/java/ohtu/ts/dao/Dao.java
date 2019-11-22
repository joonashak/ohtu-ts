package ohtu.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ohtu.ts.db.Database;

/**
 * General Database Access Object. Object-specific DAO's should extend this class.
 * @author Joonas
 */
class Dao {
  Database db;

  public Dao(Database db, String tableName) throws SQLException {
    this.db = db;
  }

  public static void closeAll(PreparedStatement stmt, Connection connection)
      throws SQLException {
    stmt.close();
    connection.close();
  }

  public static void closeAll(ResultSet rs, PreparedStatement stmt,
      Connection connection)
      throws SQLException {
    rs.close();
    closeAll(stmt, connection);
  }
}
