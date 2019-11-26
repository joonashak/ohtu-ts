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
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;
import ohtu.ts.utils.Configuration;

public class App {
    
    private IO io;
    private ReadingTipService rtService;
    
    public App(IO io, ReadingTipService rtService) {
        this.io = io;
        this.rtService = rtService;
    }
    
    
    public String askCommand(IO io) {
        String command = io.readLine("Valitse komento: lisää");
        return command;
    }
        
    
    public String askType(IO io) {
        String type = io.readLine("Valitse lukuvinkin tyyppi: Kirja");
        return type;
    }
    
    
    public Book askBookDetails(IO io) {
        String author = io.readLine("kirjailija: ");
        String isbn = io.readLine("isbn: ");
        String title = io.readLine("otsikko: ");       
        Book book = new Book(1, title, author, isbn);
        return book;
    }
    

    
    public void run() {
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
        
        new App(new ConsoleIO(), new ReadingTipService()).run();

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
