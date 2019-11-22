package ohtu.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ohtu.ts.db.Database;
import ohtu.ts.domain.Type;

/**
 * DAO for Type.java.
 * @author Joonas Häkkinen
 */
public class TypeDao extends Dao {
    
    public TypeDao(Database db, String tableName) throws SQLException {
        super(db, tableName);
    }

    public List<Type> findAll() throws SQLException {
        Connection conn = db.connect();
        List<Type> types = new ArrayList<>();

        String sql = "SELECT id, name FROM Type";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Type type = new Type(id, name);
            types.add(type);
        }

        closeAll(rs, stmt, conn);
        return types;
    }
}
