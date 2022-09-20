import java.util.*;

public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private String race;
    private int creationYear;
    private double strength;

    public Superhero() {
        System.out.println("Enter the hero name of the superhero if there is any. Else write Null.");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String heroName = scanner.nextLine();
        setHeroName(heroName);
        System.out.println("Enter the private name of the superhero if there is any. Else write Null.");
        String privateName = scanner.nextLine();
        setPrivateName(privateName);
        System.out.println("Enter the super power of the superhero.");
        String superPower = scanner.nextLine();
        setSuperPower(superPower);
        System.out.println("Enter the race of the superhero.");
        String race = scanner.next();
        setRace(race);
        System.out.println("Enter the creation year of the superhero.");
        setCreationYear(parseAsInt(scanner));
        System.out.println("Enter the strength of the superhero as a decimal number. From 1 - 10000.");
        setStrength(parseAsDouble(scanner));
    }

    public Superhero(String privateName) {
        this.privateName = privateName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        if (!heroName.equals("Null")) {
            this.heroName = heroName;
        } else {
            this.heroName = "";
        }
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void addSuperPower(String superPower) {
        this.superPower += superPower;
    }

    public void removeSuperPower(int superPower) {
        String[] powers = getSuperPower().split("((?<=\\.))");
        String power = powers[superPower].replace(powers[superPower], "");
        powers[superPower] = power;
        StringBuilder superPowers = new StringBuilder();
        for (String pow : powers) {
            superPowers.append(pow);
        }
        setSuperPower(superPowers.toString());
        presentSuperPowers();
    }

    public void presentSuperPowers() {
        String[] powers = getSuperPower().split("\\.");
        for (int i = 0; i < powers.length; i++) {
            System.out.printf("%s: %s\n", i, powers[i]);
        }
        System.out.println("\n");
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        if (strength < 10000 || strength > -10000) {
            if (strength < 1 && strength != 0) {
                this.strength = strength * -1;
            } else {
                this.strength = strength;
            }
        } else {
            this.strength = 0;
        }
    }

    public int parseAsInt(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            try {
                int integer = Integer.parseInt(scanner.nextLine());
                exit = true;
                return integer;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
        return 0;
    }

    public double parseAsDouble(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            try {
                double number = Double.parseDouble(scanner.nextLine());
                exit = true;
                return number;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number. Please re-enter it.");
            }
        }
        return 0;
    }

    public String toString() {
        String printSuperhero;
        if (!heroName.equals("")) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nRace: %s\nStrength: %s\n==============================",
            heroName, privateName, superPower,creationYear,race,strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nRace: %s\nStrength: %s\n==============================",
                    privateName, superPower,creationYear,race,strength);
        }
        return printSuperhero;
    }
}
