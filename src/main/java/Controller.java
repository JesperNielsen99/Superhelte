import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {

/*
    public Controller() {
        Database database = new Database();
        FileHandler fileHandler = new FileHandler();
    }

    public Superhero chooseHero(ArrayList<Superhero> superheroes, Scanner SCANNER) {
        if (superheroes.size() != 0) {
            if (superheroes.size() == 1) {
                System.out.println(superheroes.get(0));
                return superheroes.get(0);
            } else {
                for (int i = 0; i < superheroes.size(); i++) {
                    System.out.printf("%s: %s, %s\n", i, superheroes.get(i).getHeroName(), superheroes.get(i).getPrivateName());
                }
                System.out.printf("%s heroes were found with this search.\n\n", superheroes.size());
                while (true) {
                    int heroNumber = parseAsInt(SCANNER);
                    if (heroNumber < superheroes.size() && heroNumber >= 0) {
                        System.out.println(superheroes.get(heroNumber));
                        return superheroes.get(heroNumber);
                    } else {
                        System.out.println("This input was not valid. Enter a new value between 0 and " + (superheroes.size()-1));
                    }
                }
            }
        }
        System.out.println("No heroes was found with this search.\n\n");
        return null;
    }

    public void creationLoop(Database database, Scanner SCANNER){
        Superhero superhero = new Superhero();
        System.out.println("Enter the hero name of the superhero if there is any. Else write Null.");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String heroName = scanner.nextLine();
        superhero.setHeroName(heroName);
        System.out.println("Enter the private name of the superhero if there is any. Else write Null.");
        String privateName = scanner.nextLine();
        superhero.setPrivateName(privateName);
        System.out.println("Enter the super power of the superhero.");
        String superPower = scanner.nextLine();
        superhero.setSuperPower(superPower);
        System.out.println("Enter the race of the superhero.");
        String race = scanner.next();
        superhero.setRace(race);
        System.out.println("Enter the creation year of the superhero.");
        superhero.setCreationYear(parseAsInt(SCANNER));
        System.out.println("Enter the strength of the superhero as a decimal number. From 1 - 10000.");
        superhero.setStrength(parseAsDouble(SCANNER));
        database.addSuperhero(superhero);
        updateCheck(database);
    }

    public void updateCheck(Database database) {
        database.writeSuperheroDatabase(database.getFILENAME());
        System.out.println("Update Complete.");
    }

    public boolean deleteDatabaseCheck(Database database, Scanner SCANNER) {
        System.out.println("Be careful you are about to delete the ENTIRE database.\nDo you wish to continue?");
        String answer = SCANNER.next();
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
            System.out.println("Are you sure you want to save and delete the database permanently?");
            answer = SCANNER.next();
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
                System.out.println("Deleting the Database.");
                database.getHeroes().clear();
                database.writeSuperheroDatabase(database.getFILENAME());
                System.out.println("Deletion Complete.");
                return true;
            }
        } else {
            System.out.println("The database will not be updates.");
            return false;
        }
        return false;
    }



    public int parseAsInt(Scanner SCANNER) {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
    }

    public double parseAsDouble(Scanner SCANNER) {
        while (true) {
            try {
                return Double.parseDouble(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
    }
*/
}
