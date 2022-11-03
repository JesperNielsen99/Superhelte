import java.io.*;
import java.util.*;

public class Database {
    private final ArrayList<Superhero> superheroes = new ArrayList<>();
    private final String FILENAME = "Heroes.csv";
    private FileHandler fileHandler;
    private ArrayList<Superhero> searchResult = new ArrayList<>();
    private Superhero currentHero;

    public Database() {
        fileHandler = new FileHandler(this);
        checkSuperheroDatabase(FILENAME);
        readSuperheroDatabase(FILENAME);
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

    public void checkSuperheroDatabase(String fileName) {
        try {
            File myObj = new File(fileName);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readSuperheroDatabase(String fileName) {
        try {
            File file = new File(fileName);
            Scanner heroScanner = new Scanner(file).useLocale(Locale.US);
            while (heroScanner.hasNextLine()) {
                String[] superheroes = heroScanner.nextLine().split(";");
                Superhero superhero = new Superhero();
                switch (superheroes.length) {
                    case (5) -> {
                        superhero.setPrivateName(superheroes[0]);
                        superhero.setSuperPower(superheroes[1]);
                        superhero.setIsHuman(parseAsBoolean(superheroes[2]));
                        superhero.setCreationYear(Integer.parseInt(superheroes[3]));
                        superhero.setStrength(Double.parseDouble(superheroes[4]));
                    }
                    case (6) -> {
                        superhero.setHeroName(superheroes[0]);
                        superhero.setPrivateName(superheroes[1]);
                        superhero.setSuperPower(superheroes[2]);
                        superhero.setIsHuman(Boolean.parseBoolean(superheroes[3]));
                        superhero.setCreationYear(Integer.parseInt(superheroes[4]));
                        superhero.setStrength(Double.parseDouble(superheroes[5]));
                    }
                }
                addSuperhero(superhero);
            }
            heroScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeSuperheroDatabase(String fileName) {
        try {
            FileWriter Writer = new FileWriter(fileName);
            for (Superhero superhero : superheroes) {
                Writer.write(superhero.getHeroName() + ";" + superhero.getPrivateName() + ";" +
                        superhero.getSuperPower() + ";" + superhero.getIsHuman() + ";" +
                        superhero.getCreationYear() + ";" + superhero.getStrength() + "\n");
            }
            Writer.close();
            System.out.println("Successfully saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void searchHeroName(String heroName) {
        if (searchResult != null) {
            for (Superhero superhero : superheroes) {
                if (superhero.getHeroName().toLowerCase().contains(heroName.toLowerCase())) {
                    searchResult.add(superhero);
                    System.out.println(superhero);
                }
            }
            System.out.printf("%s heroes were found with this search.\n\n", searchResult.size());
        }
    }

    public void searchPrivateName(String privateName) {
        if (searchResult != null) {
            for (Superhero superhero : superheroes) {
                if (superhero.getPrivateName().toLowerCase().contains(privateName.toLowerCase())) {
                    searchResult.add(superhero);
                    System.out.println(superhero);
                }
            }
            System.out.printf("%s heroes were found with this search.\n\n", searchResult.size());
        }
    }

    public String currentHeroToString() {
        return currentHero.toString();
    }

    public void emptySearchResult() {
        searchResult.clear();
    }

    public String searchResultToString() {
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < searchResult.size(); i++) {
            array.append(i+1 + ": " + searchResult.get(i));
        }
        return array.toString();
    }

    public boolean searchResultIsEmpty() {
        return searchResult.isEmpty();
    }

    public boolean searchResultIsOne() {
        if (searchResult.size() == 1) {
            return true;
        }
        return false;
    }

    public void updateCheck() {
        //if (file != array) {
            writeSuperheroDatabase(FILENAME);
            System.out.println("Update Complete.");
        //}
    }

    public int getSize() {
        return superheroes.size();
    }

    public ArrayList<Superhero> getHeroes() {
        return superheroes;
    }

    public boolean parseAsBoolean(String isHuman) {
        if (isHuman.equalsIgnoreCase("yes")){
            return true;
        } else {
            return false;
        }
    }

    public String setHeroName(int index, String newHeroName) {
        currentHero = searchResult.get(index);
        currentHero.setHeroName(newHeroName);
        return currentHeroToString();
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
