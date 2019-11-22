package ohtu.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ohtu.ts.db.Database;
import ohtu.ts.domain.ReadingTip;

/**
 * DAO for ReadingTip.java.
 * @author Joonas Häkkinen
 */
public class ReadingTipDao extends Dao {
    
    public ReadingTipDao(Database db) throws SQLException {
        super(db, "ReadingTip");
    }

    /**
     * Insert new ReadingTip into database.
     * @param tip ReadingTip to be inserted.
     * @throws SQLException
     */
    public void save(ReadingTip tip) throws SQLException {
        Connection conn = db.connect();

        String sql = new StringBuilder()
            .append("INSERT INTO ReadingTip")
            .append("(type_id, title, author, isbn)")
            .append("VALUES (?,?,?,?)")
            .toString();
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, tip.getType().getId());
        stmt.setString(2, tip.getTitle());
        stmt.setString(3, tip.getAuthor());
        stmt.setString(4, tip.getIsbn());

        stmt.executeUpdate();
        closeAll(stmt, conn);
    }
}
