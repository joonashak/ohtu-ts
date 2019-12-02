package ohtu.ts.ui;

import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;

public class BookTipUI implements TipUI {

    @Override
    public ReadingTip getTipFromUser(IO io) {

        String title = io.readLine("Otsikko: ");
        String writer = io.readLine("Kirjoittaja: ");
        String isbn = io.readLine("ISBN: ");
        return new Book(title, writer, isbn);
    }
}
