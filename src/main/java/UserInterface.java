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
                            int heroIndex = controller.chooseHero();
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
                                exit = updateSuperhero(heroIndex, parseAsInt());
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

    public boolean updateSuperhero(int index, int option) {
        String heroString;
        try {
            switch (option) {
                case 1 -> {
                    //System.out.printf("Enter the new superhero name for %s: ", controller.getCurrentHeroName());
                    heroString = SCANNER.nextLine();
                    controller.setHeroName(index, heroString);
                //.setHeroName(heroString);
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
                    superhero.removeSuperPower(parseAsInt());
                }
                case 5 -> {
                    System.out.printf("Is %s human? (Yes/No): ", superhero.getHeroName());
                    superhero.setIsHuman(readIsHuman());
                }
                case 6 -> {
                    System.out.printf("Enter a new strength for %s: ", superhero.getHeroName());
                    double newStrength = parseAsDouble();
                    if (superhero.setStrength(newStrength)) {
                        System.out.println(String.format("%s, has gotten a new strength score of %s", superhero.getHeroName(), newStrength));
                    } else {
                        System.out.println(String.format("%s is not a valid number. it has to be between 1 and 10000."));
                    }
                }
                case 7 -> {
                    System.out.println("Type new data and press ENTER. If you do not wish to edit data press Enter.");

                    System.out.println("Superhero name: " + superhero.getHeroName());
                    String newSuperheroName = SCANNER.nextLine();
                    if (!newSuperheroName.isEmpty()) {
                        superhero.setHeroName(newSuperheroName);
                    }

                    System.out.println("Civilian name: " + superhero.getPrivateName());
                    String newCivilianName = SCANNER.nextLine();
                    if (!newCivilianName.isEmpty()) {
                        superhero.setPrivateName(newCivilianName);
                    }

                    System.out.println("Superpower: " + superhero.getSuperPower());
                    String newSuperpower = SCANNER.nextLine();
                    if (!newSuperpower.isEmpty()) {
                        superhero.setSuperPower(newSuperpower);
                    }

                    System.out.printf("Choose a superpower to remove from %s: ", superhero.getHeroName());
                    superhero.presentSuperPowers();
                    String removeSuperpower = SCANNER.nextLine();
                    if (!removeSuperpower.isEmpty()) {
                        superhero.removeSuperPower(Integer.parseInt(removeSuperpower));
                    }

                    System.out.println("Creation Year: " + superhero.getCreationYear());
                    String newCreationYear = SCANNER.nextLine();
                    if (!newCreationYear.isEmpty()) {
                        superhero.setCreationYear(Integer.parseInt(newCreationYear));
                    }

                    System.out.println("Is human: " + superhero.printIsHuman());
                    String newIsHuman = SCANNER.nextLine();
                    if (!newIsHuman.isEmpty()) {
                        superhero.setIsHuman(Boolean.parseBoolean(newIsHuman));
                    }

                    System.out.println("Strength: " + superhero.getStrength());
                    String newStrength = SCANNER.nextLine();
                    if (!newStrength.isEmpty()) {
                        superhero.setStrength(Double.parseDouble(newStrength));
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
        System.out.println(superhero);
        return true;
    }

    public void searchForHero() {
        System.out.println("""
                1. Search by superhero name.
                2. Search by private name of the superhero.
                8. Don't search anyway.
                9. Exit the program.""");

        String options = SCANNER.next();
        switch (options) {
            case "1" -> {
                System.out.println("Enter the superhero name to search for.");
                options = SCANNER.next();
                controller.searchHeroName(options);
                System.out.println(controller.searchResultToString());
            }
            case "2" -> {
                System.out.println("Enter the private name of the superhero to search for.");
                options = SCANNER.next();
                controller.searchPrivateName(options);
                System.out.println(controller.searchResultToString());
            }
            case "8" -> {
                System.out.println("Returning to the main menu.\n");
            }
            case "9" -> {
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
