package ohtu.ts;

import ohtu.ts.io.ConsoleIO;
import ohtu.ts.services.ReadingTipService;
import ohtu.ts.ui.Terminal;
import ohtu.ts.ui.TextUI;

public class App {

    public static void main(String[] args) {

        Terminal t = new Terminal();
        t.testMe();
        new TextUI(new ConsoleIO(), new ReadingTipService(), new Terminal()).run();
    }
}
