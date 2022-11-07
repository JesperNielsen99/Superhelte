package datahandling;

public class Controller {
    private final Database database;
    private final FileHandler fileHandler;

    public Controller() {
        database = new Database();
        fileHandler = new FileHandler();
        readFileFromFileHandler();
    }

    public void createSuperhero() {
        database.createSuperhero();
    }

    public String getCurrentHeroToString() {
        return database.currentHeroToString();
    }
    public void setHeroName(String newHeroName) {
        database.setHeroName(newHeroName);
    }

    public void setPrivateName(String newPrivateName) {
        database.setPrivateName(newPrivateName);
    }

    public void setSuperPower(String newSuperPower) {
        database.setSuperPower(newSuperPower);
    }

    public boolean setCreationYear(int creationYear) {
        return database.setCreationYear(creationYear);
    }

    public void setIsHuman(boolean newIsHuman) {
        database.setIsHuman(newIsHuman);
    }

    public boolean setStrength(double newStrength) {
        return database.setStrength(newStrength);
    }

    public int getDatabaseSize() {
        return database.getSize();
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }

    public String updateCheck() {
        writeFileToFileHandler();
        return "Save complete.";
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

    public void setCurrentHero(int index) { database.setCurrentHero(index); }

    public String getCurrentHeroName() { return database.getCurrentHeroName(); }

    public String getCurrentHeroPrivateName() { return database.getCurrentPrivateName(); }

    public String getCurrentHeroSuperPower() { return database.getCurrentSuperPower(); }

    public int getCurrentHeroCreationYear() { return database.getCurrentCreationYear(); }

    public boolean getCurrentHeroIsHuman() { return database.getCurrentHeroIsHuman(); }

    public double getCurrentHeroStrength() { return database.getCurrentHeroStrength(); }

    public int getSearchResultSize() { return database.getSearchResultSize(); }
    public void endEdit() {
        database.emptySearchResult();
        database.removeCurrentHero();
    }
    public void endSearch() { database.emptySearchResult(); }

    public void readFileFromFileHandler() {
        database.readSuperheroDatabaseFromString(fileHandler.readSuperheroDatabase());
    }

    public void writeFileToFileHandler() {
        fileHandler.writeSuperheroDatabase(database.writeSuperheroDatabaseFromString());
    }

    public void sortByHeroName() {
        database.sortByHeroName();
    }

    public void sortByPrivateName() {
        database.sortByPrivateName();
    }

    public void sortByHumanity() {
        database.sortByHumanity();
    }

    public void sortByCreationYear() {
        database.sortByCreationYear();
    }

    public void sortByStrength() {
        database.sortByStrength();
    }

    public void sortByHeroNameReversed() {
        database.sortByHeroNameReversed();
    }

    public void sortByPrivateNameReversed() {
        database.searchPrivateNameReversed();
    }

    public void sortByHumanityReversed() {
        database.setIsHumanReversed();
    }

    public void sortByCreationYearReversed() {
        database.setCreationYearReversed();
    }

    public void sortByStrengthReversed() {
        database.sortByStrengthReversed();
    }

    public Database getDatabase() {
        return database;
    }
}
