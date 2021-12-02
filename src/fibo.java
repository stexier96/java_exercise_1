import java.util.Scanner;

public class fibo implements Command{
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
