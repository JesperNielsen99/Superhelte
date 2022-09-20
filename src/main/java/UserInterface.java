import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);

    public UserInterface() {
        Database database = new Database();
        menuOptions(database);
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
                try {
                    String options = SCANNER.next();
                    switch (options) {
                        case "1" -> database.creationLoop();
                        case "2" -> System.out.println(database);
                        case "3" -> searchForHero(database);
                        case "4" -> {
                            Superhero hero = chooseHero(searchForHero(database));
                            System.out.print("""
                                    1. Update hero name.
                                    2. Update private name.
                                    3. Add super powers.
                                    4. Remove Super powers.
                                    5. Update race.
                                    6. Update strength.""");
                            updateSuperhero(hero, parseAsInt());
                            database.updateCheck();
                        }
                        case "5" -> {
                            System.out.println("Enter the number of the superhero you want to delete.");
                            searchForHero(database);
                            database.deleteSuperhero(parseAsInt());
                        }
                        case "8" -> database.deleteDatabaseCheck();
                        case "9" -> System.exit(0);
                        default -> System.out.println("Invalid input please enter a number between 1-5, 8 or 9\n");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input please enter a number between 1-5, 8 or 9\n");
                }
            }
        } else {
            System.out.println("You have no heroes in the database, please create a new one.");
            database.creationLoop();
        }
    }

    public void updateSuperhero(Superhero superhero, int option) {
        String heroString;
        try {
            switch (option) {
                case 1 -> {
                    System.out.printf("Enter the new superhero name for %s: ", superhero.getHeroName());
                    heroString = SCANNER.nextLine();
                    heroString = SCANNER.nextLine();
                    superhero.setHeroName(heroString);
                }
                case 2 -> {
                    System.out.printf("Enter the new private name for %s: ", superhero.getHeroName());
                    heroString = SCANNER.nextLine();
                    heroString = SCANNER.nextLine();
                    superhero.setPrivateName(heroString);
                }
                case 3 -> {
                    System.out.printf("Enter a new super power name for %s: ", superhero.getHeroName());
                    heroString = SCANNER.nextLine();
                    heroString = SCANNER.nextLine();
                    superhero.addSuperPower(heroString);
                }
                case 4 -> {
                    System.out.printf("Choose a superpower to remove from %s: ", superhero.getHeroName());
                    superhero.presentSuperPowers();
                    superhero.removeSuperPower(parseAsInt());
                }
                case 5 -> {
                    System.out.printf("Enter a new race for %s: ", superhero.getHeroName());
                    heroString = SCANNER.nextLine();
                    heroString = SCANNER.nextLine();
                    superhero.setRace(heroString);
                }
                case 6 -> {
                    System.out.printf("Enter a new strength for %s: ", superhero.getHeroName());
                    superhero.setStrength(parseAsDouble());
                }
                default -> System.out.println("Invalid input please enter a number between 1-6\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input please enter a number between 1-6\n");
        }
        System.out.println(superhero);
    }

    public int parseAsInt() {
        boolean exit = false;
        while (!exit) {
            try {
                int integer = Integer.parseInt(SCANNER.nextLine());
                exit = true;
                return integer;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
        return 0;
    }

    public double parseAsDouble() {
        boolean exit = false;
        while (!exit) {
            try {
                double number = Double.parseDouble(SCANNER.nextLine());
                exit = true;
                return number;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
        return 0;
    }

    public ArrayList<Superhero> searchForHero(Database database) {
        System.out.println("""
                                1. Search by superhero name.
                                2. Search by private name of the superhero.
                                3. Search by race of the superhero.
                                8. Don't search anyway.
                                9. Exit the program.""");
        String options = SCANNER.next();
        switch (options) {
            case "1" -> {
                System.out.println("Enter the superhero name to search for.");
                options = SCANNER.next();
                return database.searchHeroName(options);
            }
            case "2" -> {
                System.out.println("Enter the private name of the superhero to search for.");
                options = SCANNER.next();
                return database.searchPrivateName(options);
            }
            case "3" -> {
                System.out.println("Enter the Race of the superhero to search for.");
                options = SCANNER.next();
                return database.searchRace(options);
            }
            case "8" -> {
                System.out.println("Returning to the main menu.\n");
                return null;
            }
            case "9" -> {
                System.exit(0);
                return null;
            }
            default -> {
                System.out.println("This input was not valid please try again.\n");
                return null;
            }
        }
    }

    public Superhero chooseHero(ArrayList<Superhero> superheroes) {
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
                    int heroNumber = parseAsInt();
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
}
