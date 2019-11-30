package ohtu.ts.domain;

/**
 * Model of a video-type ReadingTip.
 * @author Joonas Häkkinen
 */
public class Video extends ReadingTip {

    public Video(Integer id, String title, String url) {
        super(Types.VIDEO);
        setId(id);
        setTitle(title);
        setUrl(url);
    }

    public Video(String title, String url) {
        this(null, title, url);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Tyyppi: Video, ")
            .append(String.format("Otsikko: %s, ", title))
            .append(String.format("URL: %s", url))
            .toString();
    }
}
