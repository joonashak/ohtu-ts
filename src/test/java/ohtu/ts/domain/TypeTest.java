package ohtu.ts.domain;

import ohtu.ts.domain.Type;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Joonas
 */
public class TypeTest {

    Type linkki;

    @Before
    public void setUp() {
        linkki = new Type(5, "url");
    }
    
    @Test
    public void typeGetNameMethodWorks() {
        assertEquals(linkki.getName(), "url");
    }
}
