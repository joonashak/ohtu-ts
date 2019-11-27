/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ohtu.ts.domain.Book;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class TextUI {

    private final IO io;
    private final ReadingTipService rtService;

    ////  Commands:
    private static final String COM_ADD = "lisää";
    private static final String COM_LIST = "listaa";
    private static final String COM_EXIT = "lopeta";

    public TextUI(IO io, ReadingTipService rtService) {
        this.io = io;
        this.rtService = rtService;
    }

    public String askCommand(IO io) {
        String command = io.readLine("Valitse komento: "
                + Stream.of(COM_ADD, COM_LIST, COM_EXIT).collect(Collectors.joining(", ")));
        return command;
    }

    public String askType(IO io) {
        String type = io.readLine("Valitse lukuvinkin tyyppi: Kirja");
        return type;
    }

    public Book askBookDetails(IO io) {
        String author = io.readLine("kirjailija: ");
        String isbn = io.readLine("isbn: ");
        String title = io.readLine("otsikko: ");
        Book book = new Book(1, title, author, isbn);
        return book;
    }

    public void run() {
        while (true) {
            String command = askCommand(io);

            switch (command) {
                case COM_ADD: {
                    if (!commandAdd()) {
                        // something wrong
                    }
                    break;
                }
                case COM_LIST: {
                    if (!commandList()) {
                        // something wrong
                    }
                    break;
                }
                case COM_EXIT: {
                    return;
                }
                default:
                    // Run something in case of wrong command etc.
                    break;
            }
        }
    }

    private boolean commandAdd() {
        String type = askType(io);

        if (type.equals("Kirja")) {
            Book book = askBookDetails(io);
            rtService.saveBook(book);
            io.print("Lukuvinkki lisätty: " + book.toString());
        }
        return true;
    }

    private boolean commandList() {
        List<ReadingTip> tips = rtService.listTips();
        if (tips.isEmpty()) {
            io.print("Lukuvinkkejä ei ole vielä lisätty.");
        }
        for (ReadingTip tip : tips) {
            io.print(tip.toString());
        }
        return true;
    }
}
