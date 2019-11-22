package ohtu.ts;

import java.sql.SQLException;
import java.util.List;

import ohtu.ts.dao.ReadingTipDao;
import ohtu.ts.dao.TypeDao;
import ohtu.ts.db.Database;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Type;
import ohtu.ts.domain.Types;

public class App {

    public static void main(String[] args) {
        Database db = new Database();
        try {
            // Test getting reading tip types.
            TypeDao typeDao = new TypeDao(db, "Type");
            List<Type> types = typeDao.findAll();

            for (Type type : types) {
                System.out.println(type.getName());
            }

            // Test writing new book tip.
            ReadingTipDao rtDao = new ReadingTipDao(db);
            rtDao.save(
                new ReadingTip(
                    null,
                    Types.BOOK,
                    "kirjailija",
                    "isbn-1234",
                    "kirjan nimi"
            ));
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
        }
        
    }
}
