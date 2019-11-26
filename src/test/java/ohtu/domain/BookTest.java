package ohtu.domain;

import ohtu.ts.domain.Book;
import ohtu.ts.domain.Types;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Joonas Alanenpää
 */
public class BookTest {

    Book book;
    String bookString;

    @Before
    public void setUp() {
        book = new Book(1, "Koodauksen alkeet", "Mikko Mallikas", "978-232324234");
        bookString = new StringBuilder()
                .append("Tyyppi: Kirja, ")
                .append(String.format("Otsikko: %s, ", "Koodauksen alkeet"))
                .append(String.format("Kirjoittaja: %s, ", "Mikko Mallikas"))
                .append(String.format("ISBN: %s", "978-232324234")).toString();
    }

    @Test
    public void bookShouldBeCreated() {
        assertEquals("Mikko Mallikas", book.getAuthor());
        assertEquals("Koodauksen alkeet", book.getTitle());
        assertEquals("978-232324234", book.getIsbn());
        assertEquals(book.getType(), Types.BOOK);
    }

    @Test
    public void bookToStringIsWorking() {
        assertEquals(book.toString(), bookString);
    }
}
