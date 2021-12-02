import java.io.IOException;

import java.util.*;

public class Launcher {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome");
        List<Command> commandList = new LinkedList<Command>();
        commandList.add(new freq());
        commandList.add(new fibo());
        commandList.add(new quit());

        boolean bool = false;
        String str;
        do {
            System.out.println("Veuillez entrer une commande");
            Scanner sc = new Scanner(System.in);
            int i = 0;
            str = sc.next();
            for (Command command : commandList) {
                if (command.name().compareTo(str) == 0) {
                    bool = command.run(sc);
                    i = 1;
                    break;
                }
            }
            if (!bool){
                System.out.println("Unknown command");
            }

        } while (bool == false);

    }
}
