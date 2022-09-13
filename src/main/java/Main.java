import java.util.Locale;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Main main = new Main();
        Database database = new Database();
        main.menuOptions(database);
    }

    public void creationLoop(Database database) {
        Superhero superhero = createSuperhero();
        database.addSuperhero(superhero);
        updateCheck(database);
    }

    public Superhero createSuperhero() {
        Superhero superhero = new Superhero();
        return superhero;
    }

    public void updateCheck(Database database) {
        System.out.println("Would you like to save? yes or no?");
        String answer = scanner.next();
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
            System.out.println("Updating the Database.");
            database.writeSuperheroDatabase(database.getFILENAME());
            System.out.println("Update Complete.");
        } else {
            System.out.println("The database will not be updates.");
        }
    }

    public void deleteDatabaseCheck(Database database) {
        System.out.println("Be careful you are about to delete the ENTIRE database.\nDo you wish to continue?");
        String answer = scanner.next();
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
            System.out.println("Are you sure you want to save and delete the database permanently?");
            answer = scanner.next();
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
                System.out.println("Deleting the Database.");
                database.clearDatabase();
                database.writeSuperheroDatabase(database.getFILENAME());
                System.out.println("Deletion Complete.");
            }
        } else {
            System.out.println("The database will not be updates.");
        }
    }

    public void menuOptions(Database database) {
        System.out.println("Welcome to the superhero universe.\n");
        while (true) {
            System.out.println("1. Create new superhero.\n2. Print database.\n3. Delete a superhero.\n8. Delete the entire database.\n9. Exit.");
            String options = scanner.next();
            switch (options) {
                case "1":
                    creationLoop(database);
                    break;
                case "2":
                    System.out.println(database);
                    break;
                case "3":
                    System.out.println("Enter the number of the superhero you want to delete.");
                    database.getDatabaseNumbers();
                    int heroNumber = scanner.nextInt();
                    database.deleteSuperhero(heroNumber);
                    updateCheck(database);
                    break;
                case "8":
                    deleteDatabaseCheck(database);
                    break;
                case "9":
                    System.exit(0);
                    break;
                default:
                    System.out.println("This input was not valid please try again.");
                    break;
            }
        }
    }
}
