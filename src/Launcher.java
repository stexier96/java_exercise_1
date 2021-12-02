import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

// Interface====================================================================
interface Command {
    public String name();
    public boolean run(Scanner sc);
}

class quit implements Command {

    @Override
    public String name() {
        return "quit";
    }
    @Override
    public boolean run(Scanner sc) {
        return true;
    }
}
class fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner sc) {
        try {
            System.out.println("Commencer par quel nombre?");
            Scanner entry = new Scanner(System.in);
            int i = entry.nextInt();
            int a=0,b = 1, fibo = 0;
            if (i == 0){
                fibo = 0;
            }
            else if (i == 1){
                fibo = 1;
            }
            else {
                for (int j = 1; j < i; j++) {
                    fibo = a + b;
                    a = b;
                    b = fibo;
                }
            }
            System.out.println("Fibo a l'indice " + i + " = " + fibo);
            return true;
        }
        catch(Exception e){
            System.out.println(e.getClass().getSimpleName());
            return false;
        }
    }
}

class freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner sc) {
        try {
            System.out.println("Indiquez le chemin du fichier a analyser");
            Scanner entry = new Scanner(System.in);
            String path = entry.next();
            try {
                java.nio.file.Files.readString(Paths.get(path));
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
            System.out.println("Analyse du fichier " + path);
            String texte = java.nio.file.Files.readString(Paths.get(path))
                    .replaceAll("(,)", "")
                    .replaceAll("\\.", "")
                    .toLowerCase();

            String[] texteTab = texte.split(" ");

            Map<String, Long> mots = Arrays
                    .stream(texteTab)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Map<String, Long> freq3 =
                    mots.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            System.out.println(freq3);
            return true;
        }
        catch(Exception e){
            System.out.println("Unreadable file : " + e.getClass().getSimpleName());
            return false;
        }
    }
}

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
