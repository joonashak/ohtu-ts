package ohtu.ts;

import java.sql.SQLException;
import java.util.List;

import ohtu.ts.dao.TypeDao;
import ohtu.ts.db.Database;
import ohtu.ts.domain.Type;

public class App {

    public static void main(String[] args) {
        Database db = new Database();
        try {
            TypeDao typeDao = new TypeDao(db, "Type");
            List<Type> types = typeDao.findAll();

            for (Type type : types) {
                System.out.println(type.getName());
            }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    }
}
