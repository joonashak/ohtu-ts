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

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Tyyppi: Kirja, ")
            .append(String.format("Otsikko: %s, ", title))
            .append(String.format("Kirjoittaja: %s, ", author))
            .append(String.format("ISBN: %s", isbn))
            .toString();
    }
}
