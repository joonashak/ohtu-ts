package ohtu.ts.ui;

import ohtu.ts.domain.Blog;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;

/**
 *
 * @author Joonas
 */
public class BlogTipUI implements TipUI {
    @Override
    public ReadingTip getTipFromUser(IO io) {
        return new Blog(
                io.readLine("Otsikko: "),
                io.readLine("Kirjoittaja: "),
                io.readLine("URL: ")
        );
    }

    @Override
    public String toString(ReadingTip rt) {
        return new StringBuilder()
            .append(String.format("ID:  %s\n", rt.getId()))
            .append("Tyyppi:  Video\n")
            .append(String.format("Otsikko:  %s\n", rt.getTitle()))
            .append(String.format("URL:  %s", rt.getUrl()))
            .toString();
    }
}