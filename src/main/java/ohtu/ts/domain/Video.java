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
}
