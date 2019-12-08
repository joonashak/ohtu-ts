package ohtu.ts.domain;

/**
 * Model of a book-type ReadingTip.
 * @author Joonas Häkkinen
 */
public class Book extends ReadingTip {

    public Book(Integer id, String title, String author, String isbn) {
        super(Types.BOOK);
        setId(id);
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
    }

    public Book(String title, String author, String isbn) {
        this(null, title, author, isbn);
    }
}
