package ohtu.ts.ui;

import java.util.List;
import ohtu.ts.domain.ReadingTip;
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;

/**
 * TextUI component for browsing ReadingTips.
 */
public class ListUI {
    // Default terminal size settings (width, height).
    private int[] defaultTermDims = new int[] { 60, 24 };

    private IO io;
    private List<ReadingTip> readingTips;
    private int[] terminalDims;

    /**
     * Initialize the browsing interface.
     * @param io input/output service.
     * @param terminal Terminal instance for list dimensions.
     */
    public ListUI(IO io, Terminal terminal) {
        this.io = io;

        ReadingTipService service = new ReadingTipService();
        readingTips = service.listTips();

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

            // TODO: remove
            io.print("annoit id:n " + cmd + "\n\n");
        }
    }

    private void listTips() {
        // Handle empty db.
        if (readingTips.size() == 0) {
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
        String cmd = io.readLine("Anna ID tai paina ENTER palataksesi:\n>> ");

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
