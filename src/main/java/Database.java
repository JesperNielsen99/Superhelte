import java.io.*;
import java.util.*;

public class Database {
    private final ArrayList<Superhero> superheroes = new ArrayList<>();
    private ArrayList<Superhero> searchResult = new ArrayList<>();
    private final String FILENAME = "Heroes.csv";
    private FileHandler fileHandler;
    private Superhero currentHero;

    public Database() {
        fileHandler = new FileHandler();
        checkSuperheroDatabase();
        readSuperheroDatabase();
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void deleteSuperhero(int heroNumber) {
        superheroes.remove(heroNumber);
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void checkSuperheroDatabase() {
        fileHandler.checkSuperheroDatabase();
    }

    public void readSuperheroDatabase() {
        // TODO: 03/11/2022 evt. gøre at databasen skaber Superheroes istedet for at FileHandler gør det.
        for (Superhero superhero : fileHandler.readSuperheroDatabase()) {
            superheroes.add(superhero);
        }
    }

    public void readSuperheroDatabaseFromString() {
        String rawHeroData = fileHandler.readSuperheroDatabaseToString();
        for (int i = 0; i % 6 == 0; i++) {
            String[] heroDataArray = fileHandler.readSuperheroDatabaseToString().split(";", 6);
            Superhero superhero = new Superhero();
            superhero.setHeroName(heroDataArray[0]);
            superhero.setPrivateName(heroDataArray[1]);
            superhero.setSuperPower(heroDataArray[2]);
            superhero.setIsHuman(Boolean.parseBoolean(heroDataArray[3]));
            superhero.setCreationYear(Integer.parseInt(heroDataArray[4]));
            superhero.setStrength(Double.parseDouble(heroDataArray[5]));
            superheroes.add(superhero);
        }
    }

    public void writeSuperheroDatabase() {
        // TODO: 03/11/2022 evt. giv en string så den ikke har kendskab til superheroes.
        fileHandler.writeSuperheroDatabase(superheroes);
    }

    public void writeSuperheroDatabaseFromString() {
        StringBuilder heroData = new StringBuilder();
        for (Superhero superhero : superheroes) {
            heroData.append(superhero.getHeroName() + ";" + superhero.getPrivateName() + ";" +
                    superhero.getSuperPower() + ";" + superhero.getIsHuman() + ";" +
                    superhero.getCreationYear() + ";" + superhero.getStrength() + "\n");
        }
        fileHandler.writeSuperheroDatabaseFromString(heroData.toString());
    }

    public void searchHeroName(String heroName) {
        emptySearchResult();
        if (searchResult != null) {
            for (Superhero superhero : superheroes) {
                if (superhero.getHeroName().toLowerCase().contains(heroName.toLowerCase())) {
                    searchResult.add(superhero);
                    System.out.println(superhero);
                }
            }
            //System.out.printf("%s heroes were found with this search.\n\n", searchResult.size());
        }
    }

    public void searchPrivateName(String privateName) {
        emptySearchResult();
        if (searchResult != null) {
            for (Superhero superhero : superheroes) {
                if (superhero.getPrivateName().toLowerCase().contains(privateName.toLowerCase())) {
                    searchResult.add(superhero);
                    System.out.println(superhero);
                }
            }
            //System.out.printf("%s heroes were found with this search.\n\n", searchResult.size());
        }
    }

    public String currentHeroToString() {
        return currentHero.toString();
    }

    public void emptySearchResult() {
        searchResult.clear();
    }

    public String searchResultToString() {
        StringBuilder searchResultArray = new StringBuilder();
        for (int i = 0; i < searchResult.size(); i++) {
            searchResultArray.append(i+1 + ": " + searchResult.get(i));
        }
        searchResultArray.append(String.format("\n%s superheroes matched this search.\n", searchResult.size()));
        return searchResultArray.toString();
    }

    public void updateCheck() {
        //if (file != array) {
            writeSuperheroDatabase();
            System.out.println("Update Complete.");
        //}
    }

    public int getSize() {
        return superheroes.size();
    }

    public void setCurrentHero(int index) {
        currentHero = searchResult.get(index);
    }

    public String setHeroName(String newHeroName) {
        currentHero.setHeroName(newHeroName);
        return currentHeroToString();
    }

    public String setPrivateName(String newPrivateHero) {
        currentHero.setPrivateName(newPrivateHero);
        return currentHeroToString();
    }

    public String setSuperPower(String newSuperPower) {
        currentHero.addSuperPower(newSuperPower);
        return currentHeroToString();
    }

    public String setCreationYear(int newCreationYear) {
        currentHero.setCreationYear(newCreationYear);
        return currentHeroToString();
    }

    public String setIsHuman(boolean newIsHuman) {
        currentHero.setIsHuman(newIsHuman);
        return currentHeroToString();
    }

    public String setStrength(double newStrength) {
        if (currentHero.setStrength(newStrength)) {
            return currentHeroToString();
        } else {
            return String.format("%s is not a valid number. it has to be between 1 and 10000.");
        }
    }

    public String getCurrentHeroName() { return currentHero.getHeroName(); }
    public String getCurrentPrivateName() { return currentHero.getPrivateName(); }
    public String getCurrentSuperPower() { return currentHero.getSuperPower(); }
    public int getCurrentCreationYear() { return currentHero.getCreationYear(); }
    public boolean getCurrentHeroIsHuman() { return currentHero.getIsHuman(); }
    public double getCurrentHeroStrength() { return currentHero.getStrength(); }
    public int getSearchResultSize() {
        if (searchResult != null) {
            return searchResult.size();
        } else {
            return 0;
        }
    }



    public String toString() {
        if (superheroes.size() > 0) {
            StringBuilder databaseString = new StringBuilder();
            for (Superhero superhero : superheroes) {
                databaseString.append(superhero.toString());
            }
            return ("\nList of Superheroes: \n-----------------\n" + databaseString);
        } else {
            return "The database is empty.";
        }
    }
}
