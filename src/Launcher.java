import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Launcher {

    public static void main(String[] args) throws IOException {

        System.out.println("Bienvenue");
        String str = null;
        int i = 0;
        do {
            System.out.println("Veuillez entrer une commande");
            Scanner entry = new Scanner(System.in);
            str = entry.next();

            if (str.equals("freq") == TRUE) {
                System.out.println("Indiquez le chemin du fichier a analyser");
                entry = new Scanner(System.in);
                String path = entry.next();
                try {
                    java.nio.file.Files.readString(Paths.get(path));
                }
                catch(Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                    break;
                }
                System.out.println("Analyse du fichier " + path);
                String texte = java.nio.file.Files.readString(Paths.get(path))
                        .replaceAll("(,)", "")
                        .replaceAll("\\.", "")
                        .toLowerCase();

                String[] texteTab = texte.split(" ");

                Map<String,Long> mots=  Arrays
                        .stream(texteTab)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

                Map<String ,Long> freq3 =
                        mots.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .limit(3)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                System.out.println(freq3);
                //sortedList.forEach(System.out::println);
            }

            else if (str.equals("fibo") == TRUE) {
                System.out.println("Commencer par quel nombre?");
                entry = new Scanner(System.in);
                i = entry.nextInt();

                int a=0,b = 1, fibo = 0;
                for (int j = 1; j < i; j++){
                    fibo = a + b;
                    a = b;
                    b = fibo;
                }
                System.out.println("Fibo a l'indice " + i + " = " + fibo);
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
