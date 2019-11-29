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
}
