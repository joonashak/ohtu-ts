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
    String author, isbn, title, url;

    public ReadingTip(Types type) {
        this.type = type;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String toString() {
        return new StringBuilder()
            .append(String.format("Tyyppi: %s, ", type.getName()))
            .append(String.format("Otsikko: %s", title))
            .toString();
    }
}
