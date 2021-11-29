import java.util.Scanner;
import static java.lang.Boolean.FALSE;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Bienvenue");
        Scanner entry = new Scanner(System.in);
        String str = entry.next();
        if (str.equals("quit") == FALSE){
            System.out.println(str + " Unknown command");
        }
    }
}
