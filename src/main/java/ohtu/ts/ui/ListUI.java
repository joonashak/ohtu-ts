package ohtu.ts.ui;

import java.util.List;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;

/**
 * TextUI component for browsing ReadingTips.
 *
 * @author Joonas Häkkinen
 */
public class ListUI {

    // Default terminal size settings (width, height).
    private int[] defaultTermDims = new int[]{60, 24};

    private IO io;
    private List<ReadingTip> readingTips;
    private int[] terminalDims;
    private ReadingTipService service;
    private TerminalWrapper terminal;

    /**
     * Initialize the browsing interface.
     *
     * @param io input/output service.
     * @param terminal Terminal instance for list dimensions.
     */
    public ListUI(IO io, TerminalWrapper terminal) {
        this.io = io;
        this.service = new ReadingTipService();
        this.readingTips = service.listTips();
        this.terminal = terminal;
        try {
            this.terminalDims = terminal.getCommandLineDimensions();
        } catch (Exception e) {
            io.print("\n\n*** WARNING: Using default terminal size.\n\n");
            this.terminalDims = defaultTermDims;
        }
    }

    /**
     * Show this UI component.
     */
    public void show() {
        while (true) {
            listTips();
            int cmd = getCommandFromUser();

            // Exit from ListUI on command -1.
            if (cmd == -1) {
                return;
            }

            // Show details view on valid ReadingTip id.
            try {
                DetailsUI dui = new DetailsUI(cmd);
                io.print(dui.toString());

                if (service.find(cmd).getType() != Types.VIDEO && service.find(cmd).getType() != Types.BLOG) {
                    io.readLine("\n\nPaina ENTER palataksesi listaukseen\n ");
                    continue;
                }
                String s = io.readLine("\n\nPaina ENTER palataksesi listaukseen tai "
                        + "syötä \"b\" ja sitten ENTER avataksesi urlin selaimella\n>> ");
                if (s.equals("b")) {
                    new Browser(service.find(cmd).getUrl(),
                            terminal).launch();
                }
            } catch (Exception e) {
                io.print("\nLukuvinkkiä ei löytynyt, tarkasta ID:\n\n");
            }
        }
    }

    private void listTips() {
        // Handle empty db.
        if (readingTips.isEmpty()) {
            io.print("\nLukuvinkkejä ei löytynyt.\n");
            return;
        }

        // Create and display formatted list of all tips.
        Table table = new Table(terminalDims[0], terminalDims[1]);
        table.setHeaders("Id", "Type", "Title");
        int w = terminalDims[0] / 5;
        table.setColumnWidths(w, w, 3 * w);

        for (ReadingTip tip : readingTips) {
            table.addRow(
                    tip.getId().toString(),
                    tip.getType().getName(),
                    tip.getTitle()
            );
        }

        io.print(table.toString());
    }

    private Integer getCommandFromUser() {
        String cmd = io.readLine("\nAnna ID tai paina ENTER palataksesi:\n>> ");

        // Enter (empty string) is -1.
        if (cmd.length() == 0) {
            return -1;
        }

        // Otherwise return only on integer.
        try {
            return Integer.parseInt(cmd);
        } catch (Exception e) {
            return getCommandFromUser();
        }
    }
}
