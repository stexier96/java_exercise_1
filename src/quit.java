import java.util.Scanner;

public class quit implements Command{
    @Override
    public String name() {
        return "quit";
    }
    @Override
    public boolean run(Scanner sc) {
        return true;
    }
}
