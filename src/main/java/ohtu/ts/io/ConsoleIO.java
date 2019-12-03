package ohtu.ts.io;

import java.util.Scanner;

/**
 *
 * @author ida
 * @author Arttu
 */
public class ConsoleIO implements IO {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public int readInt(String val) {
        print(val);
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String readLine(String text) {
        print(text);
        return scanner.nextLine();
    }

}
