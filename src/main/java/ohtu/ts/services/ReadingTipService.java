package ohtu.ts.services;

import java.sql.SQLException;
import java.util.List;
import ohtu.ts.dao.ReadingTipDao;
import ohtu.ts.db.Database;
import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;

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
        try {
            rtDao.save(book);
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
        }
    }

    public void save(ReadingTip tip) {
        try {
            rtDao.save(tip);
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        }
    }

    public List<ReadingTip> listTips() {
        try {
            List<ReadingTip> tips = rtDao.findAll();
            return tips;
        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e);
        }
        return null;
    }

    public ReadingTip find(int id) {
        try {
            ReadingTip rt = rtDao.findById(id);
            return rt;
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
            return null;
        }
    }
}
