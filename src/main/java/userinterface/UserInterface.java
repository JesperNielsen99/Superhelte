package userinterface;
import datahandling.Controller;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);
    private final Controller controller;

    public UserInterface() {
        controller = new Controller();
    }

    public void menuOptions() {
        System.out.println("Welcome to the superhero universe.\n");
        if (controller.getDatabaseSize() == 0) {
            System.out.println("You have no heroes in the database, please create a new one.");
            createSuperhero();
        } else {
            while (true) {
                System.out.println("""
                        1. Create new superhero.
                        2. Print database.
                        3. Search for a superhero.
                        4. Edit superhero.
                        5. Delete a superhero.
                        9. Exit.""");
                String options = SCANNER.next();
                switch (options) {
                    case "1" -> createSuperhero();
                    case "2" -> viewAndSortSuperheroes();
                    case "3" -> printSearch();
                    case "4" -> editSuperhero();
                    case "5" -> deleteSuperhero();
                    case "9" -> exitAndSave();
                    default -> System.out.println("Invalid input please enter a number between 1-5, 8 or 9\n");
                }
            }
        }
    }


    public void exitAndSave() {
        System.out.println("Saving Superheroes");
        System.out.println(controller.updateCheck());
        System.exit(0);
    }

    public void deleteSuperhero() {
        String heroesPresented = searchForHero();
        System.out.println(searchForHero());
        System.out.print("Enter the number of the superhero you want to delete: ");
        int heroIndex = parseAsInt() - 1;
        while (heroIndex > controller.getSearchResultSize() - 1) {
            System.out.println(heroesPresented);
            System.out.print("Enter the number of the superhero you want to delete: ");
            heroIndex = parseAsInt() - 1;
        }
        controller.deleteSuperhero(heroIndex);
    }

    public void editSuperhero() {
        String heroesPresented = searchForHero();
        System.out.println(heroesPresented);
        if (controller.getSearchResultSize() > 0) {
            if (controller.getSearchResultSize() > 1) {
                System.out.print("Type the number of the hero to edit: ");
                int heroIndex = parseAsInt() - 1;
                while (heroIndex > controller.getSearchResultSize() - 1) {
                    System.out.println(heroesPresented);
                    System.out.print("Type the number of the hero to edit: ");
                    heroIndex = parseAsInt() - 1;
                }
                controller.setCurrentHero(heroIndex);
            } else {
                controller.setCurrentHero(0);
            }
            System.out.printf("You are currently editing: %s\n", controller.getCurrentHeroName());
            boolean exit = true;
            while (exit) {
                System.out.println("""
                        1. Update hero name.
                        2. Update private name.
                        3. Update super powers.
                        4. Update Creation year.
                        5. Update humanity.
                        6. Update strength.
                        7. Update everything.
                        9. End updating.""");
                exit = updateSuperhero(parseAsInt());
            }
        }
    }

    public boolean updateSuperhero(int option) {
        String heroString;
        switch (option) {
            case 1 -> {
                System.out.printf("Enter the new superhero name for %s: ", controller.getCurrentHeroName());
                heroString = SCANNER.nextLine();
                controller.setHeroName(heroString);
                System.out.println(controller.getCurrentHeroToString());
            }
            case 2 -> {

                System.out.printf("Enter the new private name for %s: ", controller.getCurrentHeroPrivateName());
                heroString = SCANNER.nextLine();
                controller.setPrivateName(heroString);
                System.out.println(controller.getCurrentHeroToString());
            }
            case 3 -> {
                System.out.printf("Enter a new super power for %s: ", controller.getCurrentHeroName());
                heroString = SCANNER.nextLine();
                controller.setSuperPower(heroString);
                System.out.println(controller.getCurrentHeroToString());
            }
            case 4 -> {
                System.out.printf("Enter a new creation year for %s: ", controller.getCurrentHeroName());
                boolean legalYear = controller.setCreationYear(parseAsInt());
                while (!legalYear) {
                    System.out.printf("Invalid creation year Enter a year before %s: ", LocalDateTime.now().getYear());
                    legalYear = controller.setCreationYear(parseAsInt());
                }
                System.out.println(controller.getCurrentHeroToString());
            }
            case 5 -> {
                System.out.printf("Is %s human? (Yes/No): ", controller.getCurrentHeroName());
                controller.setIsHuman(readIsHuman());
                System.out.println(controller.getCurrentHeroToString());
            }
            case 6 -> {
                System.out.printf("Enter a new strength for %s: ", controller.getCurrentHeroName());
                boolean legalStrength = controller.setStrength(parseAsDouble());
                while (!legalStrength) {
                    System.out.print("Enter the strength of the superhero as a decimal number. From 1 - 10000: ");
                    legalStrength = controller.setStrength(parseAsDouble());
                }
                System.out.println(controller.getCurrentHeroToString());
            }
            case 7 -> {
                System.out.println("Type new data and press ENTER. If you do not wish to edit data press Enter.");

                System.out.println("Superhero name: " + controller.getCurrentHeroName());
                String newSuperheroName = SCANNER.nextLine();
                if (!newSuperheroName.isEmpty()) {
                    controller.setHeroName(newSuperheroName);
                    System.out.println(controller.getCurrentHeroName());
                }

                System.out.println("Civilian name: " + controller.getCurrentHeroPrivateName());
                String newCivilianName = SCANNER.nextLine();
                if (!newCivilianName.isEmpty()) {
                    controller.setPrivateName(newCivilianName);
                    System.out.println(controller.getCurrentHeroPrivateName());
                }

                System.out.println("Superpower: " + controller.getCurrentHeroSuperPower());
                String newSuperpower = SCANNER.nextLine();
                if (!newSuperpower.isEmpty()) {
                    controller.setSuperPower(newSuperpower);
                    System.out.println(controller.getCurrentHeroSuperPower());
                }

                System.out.println("Creation Year: " + controller.getCurrentHeroCreationYear());
                String newCreationYear = SCANNER.nextLine();
                if (!newCreationYear.isEmpty()) {
                    boolean legalYear = controller.setCreationYear(Integer.parseInt(newCreationYear));
                    ;
                    while (!legalYear) {
                        System.out.printf("Invalid creation year Enter a year before %s: ", LocalDateTime.now().getYear());
                        legalYear = controller.setCreationYear(parseAsInt());
                    }
                    System.out.println(controller.getCurrentHeroCreationYear());
                }

                System.out.println("Is human: " + controller.getCurrentHeroIsHuman());
                String newIsHuman = SCANNER.nextLine();
                if (!newIsHuman.isEmpty()) {
                    controller.setIsHuman(Boolean.parseBoolean(newIsHuman));
                    System.out.println(controller.getCurrentHeroIsHuman());
                }

                System.out.println("Strength: " + controller.getCurrentHeroStrength());
                String newStrength = SCANNER.nextLine();
                if (!newStrength.isEmpty()) {
                    boolean legalStrength = controller.setStrength(Double.parseDouble(newStrength));
                    while (!legalStrength) {
                        System.out.print("Enter the strength of the superhero as a decimal number. From 1 - 10000: ");
                        legalStrength = controller.setStrength(parseAsDouble());
                    }
                    System.out.println(controller.getCurrentHeroStrength());
                }
                System.out.println(controller.getCurrentHeroToString());
            }
            case 9 -> {
                controller.endEdit();
                return false;
            }
            default -> System.out.println("Invalid input please enter a number between 1-7\n");
        }
        return true;
    }

    public void printSearch() {
        System.out.println(searchForHero());
        controller.endSearch();
    }

    public String searchForHero() {
        System.out.println("""
                1. Search by superhero name.
                2. Search by private name of the superhero.
                9. Don't search anyway.""");
        String options;
        switch (parseAsInt()) {
            case 1 -> {
                System.out.println("Enter the superhero name to search for.");
                options = SCANNER.next();
                controller.searchHeroName(options);
                return controller.searchResultToString();
            }
            case 2 -> {
                System.out.println("Enter the private name of the superhero to search for.");
                options = SCANNER.next();
                controller.searchPrivateName(options);
                controller.searchResultToString();
                return controller.searchResultToString();
            }
            case 9 -> {
                return "Returning to the main menu.\n";
            }
            default -> {
                return "This input was not valid please try again.\n";
            }
        }
    }

    public void viewAndSortSuperheroes() {
        System.out.println("""
                1. Don't sort.
                2. Sort by another attribute.
                3. Sort by two attributes.
                9. Don't view anyway.""");
        switch (parseAsInt()) {
            case 1 -> {
                System.out.println(controller.getDatabase());
            }
            case 2 -> {
                System.out.println("Choose your sorting type.");
                System.out.println("""
                        1. A-Z / 0-9.
                        2. Z-A / 9-0.""");
                switch (parseAsInt()) {
                    case 1 -> {
                        System.out.println("""
                                1. Superhero name.
                                2. Private name.
                                3. Humanity.
                                4. Creation year.
                                5. Strength.
                                9. Don't sort anyway.""");
                        switch (parseAsInt()) {
                            case 1 -> {
                                controller.sortByHeroName();
                            }
                            case 2 -> {
                                controller.sortByPrivateName();
                            }
                            case 3 -> {
                                controller.sortByHumanity();
                            }
                            case 4 -> {
                                controller.sortByCreationYear();
                            }
                            case 5 -> {
                                controller.sortByStrength();
                            }
                            case 9 -> {
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("""
                                1. Superhero name.
                                2. Private name.
                                3. Humanity.
                                4. Creation year.
                                5. Strength.
                                9. Don't sort anyway.""");
                        switch (parseAsInt()) {
                            case 1 -> {
                                controller.sortByHeroNameReversed();
                            }
                            case 2 -> {
                                controller.sortByPrivateNameReversed();
                            }
                            case 3 -> {
                                controller.sortByHumanityReversed();
                            }
                            case 4 -> {
                                controller.sortByCreationYearReversed();
                            }
                            case 5 -> {
                                controller.sortByStrengthReversed();
                            }
                            case 9 -> {
                            }
                        }
                    }
                }
                System.out.println(controller.getDatabase());
            }

            case 3 -> {
                System.out.println("Select which primary sort to use.");
                int primaryIndex = setComparatorIndex();
                System.out.println("Select which secondary sort to use.");
                int secondaryIndex = setComparatorIndex();
                while (secondaryIndex == primaryIndex) {
                    System.out.println("You can't sort by the same parameters.\nPlease select another secondary sort.");
                    secondaryIndex = setComparatorIndex();
                }
                System.out.println("""
                        1. A-Z / 0-9.
                        2. Z-A / 9-0""");
                switch (parseAsInt()) {
                    case 1 -> {
                        controller.sortByTwoAttributes(primaryIndex, secondaryIndex, false);
                    }
                    case 2 -> {
                        controller.sortByTwoAttributes(primaryIndex, secondaryIndex, true);
                    }
                    default -> {

                    }
                }
                System.out.println(controller.getDatabase());
            }
            case 9 -> {
            }
            default -> {
                System.out.println("This input was not valid please try again.\n");
            }
        }
    }

    public int setComparatorIndex() {
        System.out.println("""
                1. Hero Name.
                2. Private name.
                3. Humanity.
                4. Creation year.
                5. Strength.""");
        int index = parseAsInt();
        while (index < 1 || index > 5) {
            System.out.println("Invalid number. \nPlease select a number from 1-5.");
            index = parseAsInt();
        }
        return index - 1;
    }

    public void createSuperhero() {
        controller.createSuperhero();
        System.out.print("Enter the hero name of the superhero if there is any. Else press the enter key: ");
        String scannerBugFix = SCANNER.nextLine();
        SCANNER.nextLine();
        controller.setHeroName(scannerBugFix);

        System.out.print("Enter the private name of the superhero if there is any. Else press the enter key: ");
        controller.setPrivateName(SCANNER.nextLine());

        System.out.print("Enter the super power of the superhero: ");
        controller.setSuperPower(SCANNER.nextLine());

        System.out.printf("Is %s human? (Yes/No): ", controller.getCurrentHeroName());
        controller.setIsHuman(readIsHuman());

        System.out.print("Enter the creation year of the superhero: ");
        boolean legalYear = controller.setCreationYear(parseAsInt());
        while (!legalYear) {
            System.out.printf("Invalid creation year Enter a year before %s: ", LocalDateTime.now().getYear());
            legalYear = controller.setCreationYear(parseAsInt());
        }

        System.out.print("Enter the strength of the superhero as a decimal number. From 1 - 10000: ");
        boolean legalStrength = controller.setStrength(parseAsDouble());
        while (!legalStrength) {
            System.out.print("Enter the strength of the superhero as a decimal number. From 1 - 10000: ");
            legalStrength = controller.setStrength(parseAsDouble());
        }

        System.out.println("Edit stored:\n");
        System.out.println(controller.getCurrentHeroToString() + "\n");
    }

    public int parseAsInt() {
        while (true) {
            try {
                int parsedInt = Integer.parseInt(SCANNER.next());
                SCANNER.nextLine();
                return parsedInt;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
    }

    public double parseAsDouble() {
        while (true) {
            try {
                double parsedDouble = Double.parseDouble(SCANNER.next());
                SCANNER.nextLine();
                return parsedDouble;
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
        return answer.equalsIgnoreCase("yes");
    }
}
