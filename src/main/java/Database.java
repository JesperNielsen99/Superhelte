import java.io.*;
import java.util.*;

public class Database {
    private final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US);
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
        updateCheck();
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

    public ArrayList<Superhero> searchHeroName(String heroName) {
        ArrayList<Superhero> heroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().toLowerCase().contains(heroName.toLowerCase())) {
                heroList.add(superhero);
                System.out.println(superhero);
            }
        }
        System.out.printf("%s heroes were found with this search.\n\n", heroList.size());
        return heroList;
    }

    public ArrayList<Superhero> searchPrivateName(String privateName) {
        ArrayList<Superhero> heroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getPrivateName().toLowerCase().contains(privateName.toLowerCase())) {
                heroList.add(superhero);
                System.out.println(superhero);
            }
        }
        System.out.printf("%s heroes were found with this search.\n\n", heroList.size());
        return heroList;
    }

    public ArrayList<Superhero> searchRace(String race) {
        ArrayList<Superhero> heroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getRace().toLowerCase().contains(race.toLowerCase())) {
                heroList.add(superhero);
                System.out.println(superhero);
            }
        }
        System.out.printf("%s heroes were found with this search.\n\n", heroList.size());
        return heroList;
    }

    public void updateCheck() {
        System.out.println("Updating the Database.");
        writeSuperheroDatabase(getFILENAME());
        System.out.println("Update Complete.");
    }

    public void deleteDatabaseCheck() {
        System.out.println("Be careful you are about to delete the ENTIRE database.\nDo you wish to continue?");
        String answer = SCANNER.next();
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
            System.out.println("Are you sure you want to save and delete the database permanently?");
            answer = SCANNER.next();
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("y") || answer.equals("Y")) {
                System.out.println("Deleting the Database.");
                clearDatabase();
                writeSuperheroDatabase(getFILENAME());
                System.out.println("Deletion Complete.");
            }
        } else {
            System.out.println("The database will not be updates.");
        }
        creationLoop();
    }

    public int getSize() {
        if (superheroes.size() > 0) {
            return superheroes.size();
        } else {
            return 0;
        }
    }

    public void creationLoop() {
        Superhero superhero = new Superhero();
        addSuperhero(superhero);
        updateCheck();
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
