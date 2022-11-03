import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class    Controller {
    private Database database;

    public Controller() {
        database = new Database();
    }

    // TODO: 02/11/2022 Separate to UI and Controller.
    public int chooseHero() {
        if (!database.searchResultIsEmpty()) {
            if (database.searchResultIsOne()) {
                database.setCurrentHero();
                System.out.println(database.getCurrentHero());
                return database.getCurrentHero();
                //return superheroes.get(0);
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

    public void setHeroName(int index, String newHeroName) {
        database.setHeroName(index, newHeroName);
    }

    public void setPrivateName(int index, String newPrivateName) {
        database.setPrivateName(index, newPrivateName);
    }

    public void setSuperpower(int index, String newSuperpower) {
        database.setSuperpower(index, newSuperpower);
    }

    public void setCreationYear(int index, int creationYear) {
        database.setCreationYear(index, creationYear);
    }

    public void setHeroName(int index, String newHeroName) {
        database.setHeroName(index, newHeroName);
    }

    public void setHeroName(int index, String newHeroName) {
        database.setHeroName(index, newHeroName);
    }

    public int getDatabaseSize() {
        return database.getSize();
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }

    public void updateCheck() {
        database.updateCheck();
    }

    public void searchHeroName(String name) {
        database.searchHeroName(name);
    }

    public void searchPrivateName(String name) {
        database.searchPrivateName(name);
    }

    public String searchResultToString() {
        return database.searchResultToString();
    }

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
