import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Main main = new Main();
        Superhero superhero = new Superhero();
        main.addSuperheroes(superhero);
        main.printSuperhero(superhero);
    }

    public void addSuperheroes(Superhero superhero) {
        //Superhero superhero = new Superhero();
        System.out.println("Enter the superhero name of the superhero if there is any. Else write Null.");
        String superheroName = scanner.nextLine();
        superhero.setHeroName(superheroName);
        System.out.println("Enter the private name of the superhero if there is any. Else write Null.");
        String privateName = scanner.nextLine();
        superhero.setPrivateName(privateName);
        System.out.println("Enter the super power of the superhero.");
        String superPower = scanner.nextLine();
        superhero.setSuperPower(superPower);
        System.out.println("Enter the race of the superhero.");
        String race = scanner.nextLine();
        superhero.setRace(race);
        System.out.println("Enter the creation year of the superhero.");
        int creationYear = scanner.nextInt();
        superhero.setCreationYear(creationYear);
        System.out.println("Enter the strength of the superhero as a decimal number. From 1 - 10000.");
        double strength = scanner.nextDouble();
        superhero.setStrength(strength);
    }

    /*public void printSuperheroes(Database database) {
        System.out.printf(database);
    }*/

    public void printSuperhero (Superhero superhero) {
        System.out.printf(superhero.toString());
    }
}
