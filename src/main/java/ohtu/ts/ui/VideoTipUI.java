package ohtu.ts.ui;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Video;
import ohtu.ts.io.IO;

public class VideoTipUI implements TipUI {
    @Override
    public ReadingTip getTipFromUser(IO io) {
        return new Video(io.readOneLine("Otsikko: "), io.readOneLine("URL: "));
    }
}