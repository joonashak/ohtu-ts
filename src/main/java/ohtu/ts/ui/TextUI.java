/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.util.List;
import ohtu.ts.domain.Book;
import ohtu.ts.domain.Commands;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>, Joonas Häkkinen
 */
public class TextUI {

    private final IO io;
    private final ReadingTipService rtService;

    public TextUI(IO io, ReadingTipService rtService) {
        this.io = io;
        this.rtService = rtService;
    }

    public int askCommand(IO io) {
        StringBuilder prompt = new StringBuilder("\nAnna haluamasi komennon numero:\n");

        for (Commands cmd : Commands.values()) {
            prompt.append(String.format("    %s.  %s\n", cmd.getCode(), cmd.getTooltip()));
        }

        prompt.append("\n>> ");
        return io.readInt(prompt.toString());
    }

    public String askType(IO io) {
        String type = io.readLine("Valitse lukuvinkin tyyppi: Kirja");
        return type;
    }

    public Book askBookDetails(IO io) {
        String author = io.readLine("kirjailija: ");
        String isbn = io.readLine("isbn: ");
        String title = io.readLine("otsikko: ");
        Book book = new Book(title, author, isbn);
        return book;
    }

    public void run() {
        while (true) {
            Commands cmd = Commands.find(askCommand(io));

            switch (cmd) {
                case ADD: {
                    if (!commandAdd()) {
                        // something wrong
                    }
                    break;
                }
                case LIST_ALL: {
                    if (!commandList()) {
                        // something wrong
                    }
                    break;
                }
                case QUIT: {
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
