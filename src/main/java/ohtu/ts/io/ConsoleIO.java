package ohtu.ts.io;

import java.util.Scanner;

/**
 *
 * @author ida
 */
public class ConsoleIO implements IO {
    private Scanner scanner = new Scanner(System.in);
    
    public void print(String text) {
        System.out.println(text);
    }
    
    public int ReadInt(String val) {
        System.out.println(val);
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String ReadLine(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
    
}
