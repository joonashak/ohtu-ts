package ohtu.ts;

import java.sql.SQLException;
import java.util.List;

import ohtu.ts.dao.ReadingTipDao;
import ohtu.ts.dao.TypeDao;
import ohtu.ts.db.Database;
import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Type;
import ohtu.ts.domain.Types;
import ohtu.ts.io.ConsoleIO;
import ohtu.ts.services.ReadingTipService;

public class App {
    
    
    public String askCommand(ConsoleIO io) {
        String command = io.ReadLine("Valitse komento: lisää");
        return command;
    }
        
    
    public String askType(ConsoleIO io) {
        String type = io.ReadLine("Valitse lukuvinkin tyyppi: Kirja");
        return type;
    }
    
    
    public Book askBookDetails(ConsoleIO io) {
        String author = io.ReadLine("kirjailija: ");
        String isbn = io.ReadLine("isbn: ");
        String title = io.ReadLine("otsikko: ");       
        Book book = new Book(1, title, author, isbn);
        return book;
    }
    

    
    public void run() {
        ReadingTipService rtService = new ReadingTipService();
        ConsoleIO io = new ConsoleIO();
        String command = askCommand(io);
        
        if (command.equals("lisää")) {
            String type = askType(io);
            
            if (type.equals("Kirja")) {
                Book book = askBookDetails(io);
                rtService.saveBook(book);
                io.print("Lukuvinkki lisätty: " + book.toString());
            }
            
        }

        
        
    }
              
    

    public static void main(String[] args) {
        
        new App().run();
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
