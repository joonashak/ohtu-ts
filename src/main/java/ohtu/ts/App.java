package ohtu.ts;

import ohtu.ts.io.ConsoleIO;
import ohtu.ts.services.ReadingTipService;
import ui.TextUI;

public class App {

    public static void main(String[] args) {

        new TextUI(new ConsoleIO(), new ReadingTipService()).run();

        /*
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
         */
    }
}
