import java.util.Locale;
import java.util.Scanner;

public class Main {
    private boolean exit = false;
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Main main = new Main();
        Database database = new Database();
        main.menuOptions(database);
    }

    public void creationLoop(Database database) {
        while (!exit) {
            Superhero superhero = createSuperhero();
            database.addSuperhero(superhero);
            System.out.println("Would you like to save? yes or no?");
            String answer = scanner.nextLine();
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
                database.writeSuperheroDatabase(database.getFILENAME());
            }
        }
    }

    public Superhero createSuperhero() {
        Superhero superhero = new Superhero();
        return superhero;
    }

    public void menuOptions(Database database) {
        while (!exit) {
            System.out.println("Welcome to the superhero universe.\n1. Create new superhero.\n2. Print database.\n9. Exit.");
            String options = scanner.nextLine();
            switch (options) {
                case "1":
                    creationLoop(database);
                    break;
                case "2":
                    System.out.println(database);
                case "9":
                    exit = true;
                    break;
                default:
                    System.out.println("This input was not valid please try again.");
                    break;
            }
        }
    }
}
