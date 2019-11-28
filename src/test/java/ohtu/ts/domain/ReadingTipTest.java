package ohtu.ts.domain;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Joonas
 */
public class ReadingTipTest {
    
    ReadingTip tip;
    
    @Before
    public void setUp() {
        tip = new ReadingTip(12, null, "Jarno Virtanen", "123-23402420", "Testauksen tekemistä");
    }
    
    @Test
    public void ReadingTipGetIdMethodWorks() {
        assertEquals(tip.getId().intValue(), 12);
    }
    
    @Test
    public void ReadingTipSetIdMethodWorks() {
        tip.setId(45);
        assertEquals(tip.getId().intValue(), 45);
    }
    
    @Test
    public void ReadingTipSetAuthorMethodWorks() {
        tip.setAuthor("David Thomas");
        assertEquals(tip.getAuthor(), "David Thomas");
    }
    
    @Test
    public void ReadingTipSetIsbnMethodWorks() {
        tip.setIsbn("553-343430043323");
        assertEquals(tip.getIsbn(), "553-343430043323");
    }
    
    @Test
    public void ReadingTipSetTitleMethodWorks() {
        tip.setTitle("Coding in 2019");
        assertEquals(tip.getTitle(), "Coding in 2019");
    }
    
    @Test
    public void ReadingTipSetTypeMethodWorks() {
        tip.setType(Types.BOOK);
        assertEquals(tip.getType(), Types.BOOK);
    }
}
