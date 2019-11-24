package ohtu.ts.services;

import java.sql.SQLException;
import ohtu.ts.dao.ReadingTipDao;
import ohtu.ts.db.Database;
import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;

/**
 *
 * @author ida
 */
public class ReadingTipService {
    private ReadingTipDao rtDao;
    private Database db;
      
    
    public ReadingTipService() {
        db = new Database();
        try {
            rtDao = new ReadingTipDao(db);
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
        }
    }

    
    
    public void saveBook(Book book) {        
        String author = book.getAuthor();
        String isbn = book.getIsbn();
        String title = book.getTitle();
        Types type = book.getType();
        
        try {            
            rtDao.save(
                new ReadingTip(
                    null,
                    Types.BOOK,
                    author,
                    isbn,
                    title
            ));
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
        }
    }
}
