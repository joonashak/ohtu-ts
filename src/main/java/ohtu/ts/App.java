package ohtu.ts;

import java.util.Arrays;

import ohtu.ts.db.Database;
import ohtu.ts.io.ConsoleIO;
import ohtu.ts.services.ReadingTipService;
import ohtu.ts.ui.Terminal;
import ohtu.ts.ui.TextUI;

public class App {

    public static void main(String[] args) {
        /**
         * If run with --migrate handle, run database migrations and quit.
         * This is a quick fix to suppress Flyway logging output which would
         * otherwise pollute the console continuosly.
         */
        if (Arrays.asList(args).contains("--migrate")) {
            Database db = new Database();
            db.migrate();
            System.exit(0);
        }

        Terminal t = new Terminal();
        // t.testMe();
        new TextUI(new ConsoleIO(), new ReadingTipService(), new Terminal()).run();
    }
}
