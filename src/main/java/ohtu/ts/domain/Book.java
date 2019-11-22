package ohtu.ts.domain;

/**
 * Model of a book-type ReadingTip.
 * @author Joonas Häkkinen
 */
public class Book extends ReadingTip {

    public Book(int id, String title, String author, String isbn) {
        super(id, Types.BOOK, author, isbn, title);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Tyyppi: Kirja")
            .append(String.format("Otsikko: %s", title))
            .append(String.format("Kirjoittaja: %s", author))
            .append(String.format("ISBN: %s", isbn))
            .toString();
    }
}
