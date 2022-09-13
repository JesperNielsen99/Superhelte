import java.io.*;
import java.util.*;

public class Database {
    private final List<Superhero> superheroes;
    private final String FILENAME = "Heroes.txt";

    public Database() {
        superheroes = new ArrayList<>();
        checkSuperheroDatabase(FILENAME);
        readSuperheroDatabase(FILENAME);
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void deleteSuperhero(int heroNumber) {
        superheroes.remove(heroNumber);
    }

    public void clearDatabase() {
        superheroes.clear();
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
                String[] superheroes = heroScanner.nextLine().split(",");
                Superhero superhero = new Superhero(null);
                switch (superheroes.length) {
                    case (5) -> {
                        superhero.setPrivateName(superheroes[0]);
                        superhero.setSuperPower(superheroes[1]);
                        superhero.setRace(superheroes[2]);
                        superhero.setCreationYear(Integer.parseInt(superheroes[3]));
                        superhero.setStrength(Double.parseDouble(superheroes[4]));
                    }
                    case (6) -> {
                        superhero.setHeroName(superheroes[0]);
                        superhero.setPrivateName(superheroes[1]);
                        superhero.setSuperPower(superheroes[2]);
                        superhero.setRace(superheroes[3]);
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
                Writer.write(superhero.getHeroName() + "," + superhero.getPrivateName() + "," +
                        superhero.getSuperPower() + "," + superhero.getRace() + "," +
                        superhero.getCreationYear() + "," + superhero.getStrength() + "\n");
            }
            Writer.close();
            System.out.println("Successfully saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void searchHeroName(String heroName) {
        int heroes = 0;
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getHeroName().equals(heroName)){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }
    public void searchPartHeroName(String heroName) {
        int heroes = 0;
        int heroNameLength = heroName.length();
        for (int i = 0; i < superheroes.size(); i++) {
            String partHeroName = superheroes.get(i).getHeroName().substring(0,heroNameLength);
            if (partHeroName.equalsIgnoreCase(heroName.substring(0,heroNameLength))){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }
    public void searchPrivateName(String privateName) {
        int heroes = 0;
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getPrivateName().equals(privateName)){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }
    public void searchPartPrivateName(String privateName) {
        int heroes = 0;
        int privateNameLength = privateName.length();
        for (int i = 0; i < superheroes.size(); i++) {
            String partPrivateName = superheroes.get(i).getPrivateName().substring(0,privateNameLength);
            if (partPrivateName.equalsIgnoreCase(privateName.substring(0,privateNameLength))){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }

    public void searchRace(String race) {
        int heroes = 0;
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getRace().equals(race)){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }

    public void searchPartRace(String race) {
        int heroes = 0;
        int raceLength = race.length();
        for (int i = 0; i < superheroes.size(); i++) {
            String partRace = superheroes.get(i).getRace().substring(0,raceLength);
            if (partRace.equalsIgnoreCase(race.substring(0,raceLength))){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        }
    }

    public void getDatabaseNumbers() {
        for (int i = 0; i < superheroes.size(); i++) {
            String heroName = superheroes.get(i).getHeroName();
            String privateName = superheroes.get(i).getPrivateName();
            System.out.printf("%s: %s, %s", i, heroName, privateName);
        }
    }

    public String getDatabaseString() {
        if (superheroes.size() > 0) {
            StringBuilder databaseString = new StringBuilder();
            for (Superhero superhero : superheroes) {
                databaseString.append(superhero.toString());
            }
            return databaseString.toString();
        } else {
            return "The database is empty.";
        }
    }

    public String toString() {
        return ("\nList of Superheroes: \n-----------------\n" + getDatabaseString());
    }
}
