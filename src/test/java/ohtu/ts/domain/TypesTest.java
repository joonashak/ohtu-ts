package ohtu.ts.domain;

import ohtu.ts.domain.Types;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas
 */
public class TypesTest {
    
    @Test
    public void typesGetIdMethodWorks() {
        assertEquals(Types.BOOK.getId(), 1);
    }
    
    @Test
    public void typesGetNameMethodWorks() {
        assertEquals(Types.BOOK.getName(), "Kirja");
    }
    
    @Test
    public void typesFindMethodWorks() {
        assertEquals(Types.find(1).getId(), 1);
        assertEquals(Types.find(1).getName(), "Kirja");
        
        assertEquals(Types.find(2).getId(), 2);
        assertEquals(Types.find(2).getName(), "Video");
        
        assertEquals(Types.find(0), null);
    }
}
