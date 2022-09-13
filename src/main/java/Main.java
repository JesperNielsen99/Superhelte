import java.util.Locale;
import java.util.Scanner;

public class Main {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);

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
        return new Superhero();
    }

    public void updateCheck(Database database) {
        System.out.println("Would you like to save? yes or no?");
        String answer = SCANNER.next();
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
        String answer = SCANNER.next();
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
            System.out.println("Are you sure you want to save and delete the database permanently?");
            answer = SCANNER.next();
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
            System.out.println("""
                    1. Create new superhero.
                    2. Print database.
                    3. Search for a superhero\s
                    4. Update superhero.
                    5. Delete a superhero.
                    8. Delete the entire database.
                    9. Exit.""");
            String options = SCANNER.next();
            switch (options) {
                case "1":
                    creationLoop(database);
                    break;
                case "2":
                    System.out.println(database);
                    break;
                case "3"://Add searching for private name, creation year and race.
                    System.out.println("""
                            1. Search by the full superhero name.
                            2. Search by part of the superhero name.
                            3. Search by the full private name of the superhero.
                            4. Search by part of the private name of the superhero.
                            5. Search by full race of the superhero.
                            6. Search by part of the race of the superhero.
                            8. Don't search anyway.
                            9. Exit.""");
                    options = SCANNER.next();
                    switch (options) {
                        case "1" -> {
                            System.out.println("Enter the superhero name to search for.");
                            options = SCANNER.next();
                            database.searchHeroName(options);
                        }
                        case "2" -> {
                            System.out.println("Enter part of the superhero name to search for.");
                            options = SCANNER.next();
                            database.searchPartHeroName(options);
                        }
                        case "3" -> {
                            System.out.println("Enter the private name of the superhero to search for.");
                            options = SCANNER.next();
                            database.searchPrivateName(options);
                        }
                        case "4" -> {
                            System.out.println("Enter part of the private name of the superhero to search for.");
                            options = SCANNER.next();
                            database.searchPartPrivateName(options);
                        }
                        case "5" -> {
                            System.out.println("Enter the Race of the superhero to search for.");
                            options = SCANNER.next();
                            database.searchRace(options);
                        }
                        case "6" -> {
                            System.out.println("Enter part of the Race of the superhero to search for.");
                            options = SCANNER.next();
                            database.searchPartRace(options);
                        }
                        case "8" -> System.out.println("Returning to the main menu.\n");
                        case "9" -> System.exit(0);
                        default -> System.out.println("This input was not valid please try again.\n");
                    }
                    break;
                case "4":
                    //Add an update feature for a superhero's parameters.
                    break;
                case "5":
                    System.out.println("Enter the number of the superhero you want to delete.");
                    database.getDatabaseNumbers();
                    int heroNumber = SCANNER.nextInt();
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
                    System.out.println("This input was not valid please try again.\n");
                    break;
            }
        }
    }
}
