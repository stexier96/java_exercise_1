import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class freq implements Command{
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
