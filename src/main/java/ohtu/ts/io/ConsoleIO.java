package ohtu.ts.io;

import java.util.Scanner;

/**
 *
 * @author ida
 */
public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
    @Override
    public int readInt(String val) {
        System.out.print(val);
        return Integer.parseInt(scanner.nextLine());
    }
    
    @Override
    public String readLine(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }
    
}
