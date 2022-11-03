import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private Database database;

    public Controller() {
        database = new Database();
    }

    public String setHeroName(String newHeroName) {
        return database.setHeroName(newHeroName);
    }

    public String setPrivateName(String newPrivateName) { return database.setPrivateName(newPrivateName); }

    public String setSuperPower(String newSuperPower) {
        return database.setSuperPower(newSuperPower);
    }

    public String setCreationYear(int creationYear) {
        return database.setCreationYear(creationYear);
    }

    public String setIsHuman(boolean newIsHuman) {
        return database.setIsHuman(newIsHuman);
    }

    public String setStrength(double newStrength) {
        return database.setStrength(newStrength);
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

    public void createPrivateName(Superhero superhero, String name) {
        superhero.setHeroName(name);
    }

    public void createSuperPower(Superhero superhero, String power) {
        superhero.setSuperPower(power);
    }

    public void createIsHuman(Superhero superhero, boolean isHuman) {
        superhero.setIsHuman(isHuman);
    }

    public void createCreationYear(Superhero superhero, int creationYear) {
        superhero.setCreationYear(creationYear);
    }

    public void createStrength(Superhero superhero, double strength) {
        superhero.setStrength(strength);
    }
    public void setCurrentHero(int index) { database.setCurrentHero(index); }
    public String getCurrentHeroName() { return database.getCurrentHeroName(); }
    public String getCurrentHeroPrivateName() { return database.getCurrentPrivateName(); }
    public String getCurrentHeroSuperPower() { return database.getCurrentSuperPower(); }
    public int getCurrentHeroCreationYear() { return database.getCurrentCreationYear(); }
    public boolean getCurrentHeroIsHuman() { return database.getCurrentHeroIsHuman(); }
    public double getCurrentHeroStrength() { return database.getCurrentHeroStrength(); }
    public int getSearchResultSize() { return database.getSearchResultSize(); }

    public Database getDatabase() {
        return database;
    }
}
