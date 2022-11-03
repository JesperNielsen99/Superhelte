import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);
    private Controller controller;

    public UserInterface() {
        controller = new Controller();
        menuOptions();
    }

    public void menuOptions() {
        System.out.println("Welcome to the superhero universe.\n");
        if (controller.getDatabaseSize() != 0) {
            while (true) {
                System.out.println("""
                        1. Create new superhero.
                        2. Print database.
                        3. Search for a superhero.
                        4. Edit superhero.
                        5. Delete a superhero.
                        9. Exit.""");
                try {
                    String options = SCANNER.next();
                    switch (options) {
                        case "1" -> creationLoop();
                        case "2" -> System.out.println(controller.getDatabase());
                        case "3" -> searchForHero();
                        case "4" -> {
                            searchForHero();
                            if (controller.getSearchResultSize() > 0) {
                                System.out.print("Type the number of the hero to edit: ");
                                int heroIndex = parseAsInt() - 1;
                                // TODO: 03/11/2022 Fails when out of bounds. Make Hamza fix 
                                while (heroIndex < controller.getSearchResultSize()) {
                                    heroIndex = parseAsInt();
                                    controller.setCurrentHero(heroIndex);
                                }
                                System.out.printf("You are currently editing: %s\n", controller.getCurrentHeroName());
                                boolean exit = true;
                                while (exit) {
                                    System.out.println("""
                                            1. Update hero name.
                                            2. Update private name.
                                            3. Add super powers.
                                            4. Remove Super powers.
                                            5. Update humanity.
                                            6. Update strength.
                                            7. Update everything.
                                            8. End updating.""");
                                    exit = updateSuperhero(parseAsInt());
                                }
                            }
                        }
                        case "5" -> {
                            System.out.println("Enter the number of the superhero you want to delete.");
                            searchForHero();
                            controller.deleteSuperhero(parseAsInt());
                        }
                        case "9" -> {
                            System.out.println("Saving Superheroes");
                            controller.updateCheck();
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid input please enter a number between 1-5, 8 or 9\n");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input please enter a number between 1-5, 8 or 9\n");
                }
            }
        } else {
            System.out.println("You have no heroes in the database, please create a new one.");
            creationLoop();
        }
    }

    public boolean updateSuperhero(int option) {
        String heroString;
        try {
            switch (option) {
                case 1 -> {
                    System.out.printf("Enter the new superhero name for %s: ", controller.getCurrentHeroName());
                    heroString = SCANNER.nextLine();
                    controller.setHeroName(heroString);
                }
                case 2 -> {

                    System.out.printf("Enter the new private name for %s: ", controller.getCurrentHeroPrivateName());
                    heroString = SCANNER.nextLine();
                    controller.setPrivateName(heroString);
                }
                case 3 -> {
                    System.out.printf("Enter a new super power for %s: ", controller.getCurrentHeroSuperPower());
                    heroString = SCANNER.nextLine();
                    controller.setSuperPower(heroString);
                }
                case 4 -> {
                    System.out.printf("Enter a new creation year for %s: ", controller.getCurrentHeroCreationYear());
                    controller.setCreationYear(parseAsInt());
                }
                case 5 -> {
                    System.out.printf("Is %s human? (Yes/No): ", controller.getCurrentHeroIsHuman());
                    controller.setIsHuman(readIsHuman());
                }
                case 6 -> {
                    System.out.printf("Enter a new strength for %s: ", controller.getCurrentHeroName());
                    double newStrength = parseAsDouble();
                    controller.setStrength(newStrength);

                }
                case 7 -> {
                    System.out.println("Type new data and press ENTER. If you do not wish to edit data press Enter.");

                    System.out.println("Superhero name: " + controller.getCurrentHeroName());
                    String newSuperheroName = SCANNER.nextLine();
                    if (!newSuperheroName.isEmpty()) {
                        System.out.println(controller.setHeroName(newSuperheroName));
                    }

                    System.out.println("Civilian name: " + controller.getCurrentHeroPrivateName());
                    String newCivilianName = SCANNER.nextLine();
                    if (!newCivilianName.isEmpty()) {
                        System.out.println(controller.setPrivateName(newCivilianName));
                    }

                    System.out.println("Superpower: " + controller.getCurrentHeroSuperPower());
                    String newSuperpower = SCANNER.nextLine();
                    if (!newSuperpower.isEmpty()) {
                        System.out.println(controller.setSuperPower(newSuperpower));
                    }

                    System.out.println("Creation Year: " + controller.getCurrentHeroCreationYear());
                    String newCreationYear = SCANNER.nextLine();
                    if (!newCreationYear.isEmpty()) {
                        System.out.println(controller.setCreationYear(Integer.parseInt(newCreationYear)));
                    }

                    System.out.println("Is human: " + controller.getCurrentHeroIsHuman());
                    String newIsHuman = SCANNER.nextLine();
                    if (!newIsHuman.isEmpty()) {
                        System.out.println(controller.setIsHuman(Boolean.parseBoolean(newIsHuman)));
                    }

                    System.out.println("Strength: " + controller.getCurrentHeroStrength());
                    String newStrength = SCANNER.nextLine();
                    if (!newStrength.isEmpty()) {
                        System.out.println(controller.setStrength(Double.parseDouble(newStrength)));
                    }
                }
                case 8 -> {
                    return false;
                }
                default -> System.out.println("Invalid input please enter a number between 1-7\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input please enter a number between 1-7\n");
        }
        return true;
    }

    public void searchForHero() {
        System.out.println("""
                1. Search by superhero name.
                2. Search by private name of the superhero.
                8. Don't search anyway.
                9. Exit the program.""");

        String options = null;
        switch (parseAsInt()) {
            case 1 -> {
                System.out.println("Enter the superhero name to search for.");
                options = SCANNER.next();
                controller.searchHeroName(options);
                System.out.println(controller.searchResultToString());
            }
            case 2 -> {
                System.out.println("Enter the private name of the superhero to search for.");
                options = SCANNER.next();
                controller.searchPrivateName(options);
                controller.searchResultToString();
                System.out.println(controller.searchResultToString());
            }
            case 8 -> {
                System.out.println("Returning to the main menu.\n");
            }
            case 9 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("This input was not valid please try again.\n");
            }
        }
    }

    public void creationLoop() {
        Superhero superhero = new Superhero();
        System.out.println("Enter the hero name of the superhero if there is any. Else write Null.");
        controller.createSuperheroName(superhero, SCANNER.nextLine());

        System.out.println("Enter the private name of the superhero if there is any. Else write Null.");
        controller.createPrivateName(superhero, SCANNER.nextLine());

        System.out.println("Enter the super power of the superhero.");
        controller.createSuperPower(superhero, SCANNER.nextLine());

        System.out.printf("Is %s human? (Yes/No): ", superhero.getHeroName());
        controller.createIsHuman(superhero, readIsHuman());

        System.out.println("Enter the creation year of the superhero.");
        controller.createCreationYear(superhero, parseAsInt());

        System.out.println("Enter the strength of the superhero as a decimal number. From 1 - 10000.");
        controller.createStrength(superhero, parseAsDouble());

        System.out.println("Edit stored:\n");
        System.out.println(superhero + "\n");
    }

    public int parseAsInt() {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
    }

    public double parseAsDouble() {
        while (true) {
            try {
                return Double.parseDouble(SCANNER.next());
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
    }

    public boolean readIsHuman() {
        String answer = SCANNER.next();
        while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
            System.out.println("You Typed: " + answer + "\nPlease type 'yes' or 'no'");
            answer = SCANNER.nextLine();
        }
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }
}
