import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {
    private final String FILENAME = "Heroes.csv";
    private Database database;
/*
    public FileHandler(Database database) {
        this.database = database;
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

    public ArrayList<Superhero> readSuperheroDatabase(String fileName) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
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
                superheroList.add(superhero);
            }
            heroScanner.close();
            return superheroList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public void addSuperhero(ArrayList<Superhero> superheroes) {
        if (superheroes != null) {
            for (Superhero superhero : superheroes) {
                database.addSuperhero(superhero);
            }
        }
    }

    public void writeSuperheroDatabase(String fileName) {
        if(database.getHeroes() != readSuperheroDatabase(FILENAME)) {
            try {
                FileWriter Writer = new FileWriter(fileName);
                for (Superhero superhero : database.getHeroes()) {
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
    }
 */
}
