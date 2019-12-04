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
             
        try {
            Connection conn = db.connect();

            String sql = new StringBuilder()
                    .append("INSERT INTO ReadingTip")
                    .append("(type_id, title, author, isbn, url)")
                    .append("VALUES (?,?,?,?,?)")
                    .toString();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tip.getType().getId());
            stmt.setString(2, tip.getTitle());
            stmt.setString(3, tip.getAuthor());
            stmt.setString(4, tip.getIsbn());
            stmt.setString(5, tip.getUrl());

            stmt.executeUpdate();
            closeAll(stmt, conn);
        } catch(SQLException e) {
            throw new SQLException(new StringBuilder()
                    .append("Error in saving reading tip. ")
                    .append(e.getMessage())
                    .toString());
        }
        
    }
    
    public List<ReadingTip> findAll() throws SQLException {
        try {
            Connection conn = db.connect();
            List<ReadingTip> readingTips = new ArrayList<>();

            String sql = "SELECT id, type_id, title, author, isbn, url FROM ReadingTip";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ReadingTip tip = new ReadingTip(Types.find(rs.getInt("type_id")));
                tip.setId(rs.getInt("id"));
                tip.setTitle(rs.getString("title"));
                tip.setAuthor(rs.getString("author"));
                tip.setIsbn(rs.getString("isbn"));
                tip.setUrl(rs.getString("url"));
                readingTips.add(tip);
            }
            
            closeAll(rs, stmt, conn);
            return readingTips;
        } catch(SQLException e) {
            throw new SQLException(new StringBuilder()
                .append("Error in listing reading tips. ")
                .append(e.getMessage())
                .toString());
        }

    }
}
