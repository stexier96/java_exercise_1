import java.util.Scanner;
import static java.lang.Boolean.FALSE;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Bienvenue");
        String str = null;
        Scanner entry = new Scanner(System.in);
        str = entry.next();
        while (str.equals("quit") == FALSE) {
            System.out.println(str + " Unknown command");
            entry = new Scanner(System.in);
            str = entry.next();
        }
    }
}
