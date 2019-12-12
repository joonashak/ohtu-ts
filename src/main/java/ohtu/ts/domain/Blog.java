package ohtu.ts.domain;

/**
 *
 * @author Joonas
 */
public class Blog extends ReadingTip {

    public Blog(Integer id, String title, String author, String url) {
        super(Types.BLOG);
        setId(id);
        setTitle(title);
        setAuthor(author);
        setUrl(url);
    }

    public Blog(String title, String author, String url) {
        this(null, title, author, url);
    }
}

