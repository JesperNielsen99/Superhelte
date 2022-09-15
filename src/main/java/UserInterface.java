import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);

    public UserInterface() {
    }

    public void menuOptions(Database database) {
        System.out.println("Welcome to the superhero universe.\n");
        if (database.getSize() != 0) {
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
                    case "1" -> database.creationLoop();
                    case "2" -> System.out.println(database);
                    case "3" -> {
                        System.out.println("""
                                1. Search by superhero name.
                                2. Search by private name of the superhero.
                                3. Search by race of the superhero.
                                8. Don't search anyway.
                                9. Exit the program.""");
                        options = SCANNER.next();
                        switch (options) {
                            case "1" -> {
                                System.out.println("Enter the superhero name to search for.");
                                options = SCANNER.next();
                                ArrayList<Superhero> heroList = database.searchHeroName(options);
                                searchLength(heroList);
                            }
                            case "2" -> {
                                System.out.println("Enter the private name of the superhero to search for.");
                                options = SCANNER.next();
                                ArrayList<Superhero> heroList = database.searchPrivateName(options);
                                searchLength(heroList);
                            }
                            case "3" -> {
                                System.out.println("Enter the Race of the superhero to search for.");
                                options = SCANNER.next();
                                ArrayList<Superhero> heroList = database.searchRace(options);
                                searchLength(heroList);
                            }
                            case "8" -> System.out.println("Returning to the main menu.\n");
                            case "9" -> System.exit(0);
                            default -> System.out.println("This input was not valid please try again.\n");
                        }
                    }
                    case "4" -> {
                        System.out.println("Enter the number of the superhero you want to update.");
                        database.getDatabaseNumbers();
                        int heroNumber = SCANNER.nextInt();
                        System.out.print("""
                                1. Update hero name.
                                2. Update private name.
                                3. Add super powers.
                                4. Remove Super powers.
                                5. Update race.
                                6. Update strength.""");
                        int heroAttribute = SCANNER.nextInt();
                        updateSuperhero(database.getSuperhero(heroNumber), heroAttribute);
                        database.updateCheck();
                    }
                    case "5" -> {
                        System.out.println("Enter the number of the superhero you want to delete.");
                        database.getDatabaseNumbers();
                        int heroNumber = SCANNER.nextInt();
                        database.deleteSuperhero(heroNumber);
                    }
                    case "8" -> database.deleteDatabaseCheck();
                    case "9" -> System.exit(0);
                    default -> System.out.println("This input was not valid please try again.\n");
                }
            }
        } else {
            System.out.println("You have no heroes in the database, please create a new one.");
            database.creationLoop();
        }
    }

    public void searchLength(ArrayList<Superhero> heroList) {
        if (heroList != null) {
            for (Superhero superhero: heroList) {
                System.out.println(superhero);
            }
            System.out.printf("%s heroes were found with this search.\n\n", heroList.size());
        } else {
            System.out.println("No hero was found with this search.\n\n");
        }
    }

    public void updateSuperhero(Superhero superhero, int option) {
        int heroInt;
        String heroString;
        switch (option) {
            case 1 -> {
                System.out.printf("Enter the new superhero name for %s: ", superhero.getHeroName());
                heroString = SCANNER.nextLine();
                superhero.setHeroName(heroString);
            }
            case 2 -> {
                System.out.printf("Enter the new private name for %s: ", superhero.getHeroName());
                heroString = SCANNER.nextLine();
                superhero.setPrivateName(heroString);
            }
            case 3 -> {
                System.out.printf("Enter a new super power name for %s: ", superhero.getHeroName());
                heroString = SCANNER.nextLine();
                superhero.addSuperPower(heroString);
            }
            case 4 -> {
                System.out.printf("Choose a superpower to remove from %s: ", superhero.getHeroName());
                superhero.presentSuperPowers();
                heroInt = SCANNER.nextInt();
                superhero.removeSuperPower(heroInt);
            }
            case 5 -> {
                System.out.printf("Enter a new race for %s: ", superhero.getHeroName());
                heroString = SCANNER.nextLine();
                superhero.setRace(heroString);
            }
            case 6 -> {
                System.out.printf("Enter a new strength for %s: ", superhero.getHeroName());
                double heroDouble = SCANNER.nextDouble();
                superhero.setStrength(heroDouble);
            }
        }
        System.out.println(superhero);
    }
}
