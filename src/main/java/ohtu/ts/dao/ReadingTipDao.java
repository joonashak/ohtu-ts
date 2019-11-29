package ohtu.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ohtu.ts.db.Database;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;

/**
 * DAO for ReadingTip.java.
 *
 * @author Joonas Häkkinen
 */
public class ReadingTipDao extends Dao {

    public ReadingTipDao(Database db) throws SQLException {
        super(db, "ReadingTip");
    }

    /**
     * Insert new ReadingTip into database.
     *
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
    
    public List<ReadingTip> findAll() throws SQLException {
        Connection conn = db.connect();
        List<ReadingTip> readingTips = new ArrayList<>();
        
        String sql = "SELECT id, type_id, title, author, isbn FROM ReadingTip";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Types type = null;
            int id = rs.getInt("id"); 
            int type_id = rs.getInt("type_id");
            if (type_id == Types.BOOK.getId()) {
                type = Types.BOOK;
            }
            String title = rs.getString("title");
            String author = rs.getString("author");
            String isbn = rs.getString("isbn");
            ReadingTip tip = new ReadingTip(id, type, author, isbn, title);
            readingTips.add(tip);
        }
        closeAll(rs, stmt, conn);
        return readingTips;
    }
}
