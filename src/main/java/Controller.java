import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class    Controller {
    private Database database;

    public Controller() {
        database = new Database();
    }

    // TODO: 02/11/2022 Separate to UI and Controller.
    /*
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


    public String amountOfSuperheroes(ArrayList<Superhero> superheroes) {
        if (!superheroes.isEmpty()) {

        }
    }*/

    public int getDatabaseSize() {
        return database.getSize();
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }

    public void updateCheck() {
        database.updateCheck();
    }

    public ArrayList<Superhero> searchHeroName(String name) {
        return database.searchHeroName(name);
    }

    public ArrayList<Superhero> searchPrivateName(String name) {
        return database.searchPrivateName(name);
    }

    /*public void createSuperhero(){
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
        System.out.printf("Is %s human? (Yes/No): ", superhero.getHeroName());

        superhero.setIsHuman(readIsHuman());
        System.out.println("Enter the creation year of the superhero.");
        superhero.setCreationYear(parseAsInt());
        System.out.println("Enter the strength of the superhero as a decimal number. From 1 - 10000.");
        superhero.setStrength(parseAsDouble());
        database.addSuperhero(superhero);

        System.out.println("Edit stored:\n");
        System.out.println(superhero + "\n");
    }*/

    public void createSuperheroName(Superhero superhero, String name) {
        superhero.setHeroName(name);
    }

    public void createPrivateName(Superhero superhero, String name){
        superhero.setHeroName(name);
    }
    public void createSuperPower(Superhero superhero, String power){
        superhero.setSuperPower(power);
    }
    public void createIsHuman(Superhero superhero, boolean isHuman){
        superhero.setIsHuman(isHuman);
    }
    public void createCreationYear(Superhero superhero, int creationYear){
        superhero.setCreationYear(creationYear);
    }
    public void createStrength(Superhero superhero, double strength){
        superhero.setStrength(strength);
    }

    public Database getDatabase() {
        return database;
    }
}
