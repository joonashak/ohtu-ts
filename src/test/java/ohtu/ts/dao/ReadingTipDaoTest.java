package ohtu.ts.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ohtu.ts.db.Database;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author ida
 */
public class ReadingTipDaoTest {

    private ReadingTipDao dao;
    private Database db;

    public ReadingTipDaoTest() {
    }

    @Before
    public void setUp() throws SQLException {

        db = new Database();

        try {
            dao = new ReadingTipDao(db);
        } catch (SQLException e) {
            throw new SQLException(new StringBuilder()
                    .append("Error in setting up ReadingTipDao. ")
                    .append(e.getMessage())
                    .toString());
        }

    }
    
    @Test
    public void findAllSavedReadingTipsThatAreBookAndVideo() throws SQLException {
        ReadingTip book = new ReadingTip(Types.find(1));
        book.setTitle("booktitle");
        book.setAuthor("bookauthor");
        book.setIsbn("isbn");
        
        ReadingTip video = new ReadingTip(Types.find(2));
        video.setTitle("videotitle");
        video.setUrl("url");
        
        List<ReadingTip> tips = new ArrayList<>();
        tips.add(book);
        tips.add(video);
        
        dao.save(book);
        dao.save(video);
        
        //to-do: equals() for readingtip
        //assertEquals(tips, dao.findAll());
    }

    @After
    public void tearDown() {
        //delete testdb file
        db.getDbFile().delete();
    }

}
