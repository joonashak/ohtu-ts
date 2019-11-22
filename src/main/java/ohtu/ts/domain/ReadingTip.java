package ohtu.ts.domain;

/**
 * Model of a reading tip.
 * Type-specific models (e.g., Book) should extend this class and specify,
 * which fields are in use. This class includes all possible fields.
 * @author Joonas Häkkinen
 */
public class ReadingTip {
    Integer id;
    Types type;
    String author, isbn, title;

    public ReadingTip(
        Integer id,
        Types type,
        String author,
        String isbn,
        String title
    ) {
        this.id = id;
        this.type = type;
        this.author = author;
        this.isbn = isbn;
        this.title = title;
    }

    // Default getters and setters:

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
}
