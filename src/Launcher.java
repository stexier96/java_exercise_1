import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Bienvenue");
        String str = null;
        int i = 0;
        do {
            System.out.println("Veuillez entrer une commande");
            Scanner entry = new Scanner(System.in);
            str = entry.next();

            if (str.equals("fibo") == TRUE) {
                System.out.println("Commencer par quel nombre?");
                entry = new Scanner(System.in);
                i = entry.nextInt();

                int a=0,b = 1, fibo = 0;
                for (int j = 1; j < i; j++){
                    fibo = a + b;
                    a = b;
                    b = fibo;
                }
                System.out.println("Fibo à l'indice " + i + " = " + fibo);
            }

            else if (str.equals("quit") == TRUE){
                System.out.println("Exiting program");
            }

            else {
                System.out.println(str + " Unknown command, try again");
            }

        } while (str.equals("quit") == FALSE);

    }
}
