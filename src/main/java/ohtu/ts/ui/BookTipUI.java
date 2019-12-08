package ohtu.ts.ui;

import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;

public class BookTipUI implements TipUI {

    @Override
    public ReadingTip getTipFromUser(IO io) {
        return new Book(
                io.readLine("Otsikko: "),
                io.readLine("Kirjoittaja: "),
                io.readLine("ISBN: ")
        );
    }

    @Override
    public String toString(ReadingTip rt) {
        return new StringBuilder()
            .append(String.format("ID:  %s\n", rt.getId()))
            .append("Tyyppi:  Kirja\n")
            .append(String.format("Otsikko:  %s\n", rt.getTitle()))
            .append(String.format("Kirjoittaja:  %s\n", rt.getAuthor()))
            .append(String.format("ISBN:  %s", rt.getIsbn()))
            .toString();
    }
}
