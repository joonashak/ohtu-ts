package ohtu.ts.dao;


import java.sql.SQLException;
import java.util.List;
import ohtu.ts.db.Database;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
import static org.hamcrest.CoreMatchers.containsString;
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
        db.migrate();
        
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
    public void findAllReadingTipsThatAreSavedToDB() throws SQLException {
        ReadingTip book = new ReadingTip(Types.find(1));
        book.setTitle("booktitle");
        book.setAuthor("bookauthor");
        book.setIsbn("isbn");
        
        ReadingTip video = new ReadingTip(Types.find(2));
        video.setTitle("videotitle");
        video.setUrl("url");
        
        dao.save(book);
        dao.save(video);        
        List<ReadingTip> tips = dao.findAll();
                
        assertThat(tips.get(0).toString(), containsString(book.getTitle()));
        assertThat(tips.get(1).toString(), containsString(video.getTitle()));
    }
    
    @Test
    public void findAllGivesEmptyListWhenNoTipsAreAddedToDB() throws SQLException { 
        assertEquals(dao.findAll().size(), 0);
    }

    @After
    public void tearDown() {
        //delete testdb file
        db.getDbFile().delete();
    }

}
