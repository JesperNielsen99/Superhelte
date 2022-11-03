import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {
    private final String FILENAME = "Heroes.csv";

    public FileHandler() {
    }

    public void checkSuperheroDatabase() {
        try {
            File myObj = new File(FILENAME);
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Superhero> readSuperheroDatabase() {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        try {
            File file = new File(FILENAME);
            Scanner heroScanner = new Scanner(file).useLocale(Locale.US);
            while (heroScanner.hasNextLine()) {
                String[] superheroes = heroScanner.nextLine().split(",");
                Superhero superhero = new Superhero();
                    superhero.setHeroName(superheroes[0]);
                    superhero.setPrivateName(superheroes[1]);
                    superhero.setSuperPower(superheroes[2]);
                    superhero.setIsHuman(Boolean.parseBoolean(superheroes[3]));
                    superhero.setCreationYear(Integer.parseInt(superheroes[4]));
                    superhero.setStrength(Double.parseDouble(superheroes[5]));
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

    public void writeSuperheroDatabase(ArrayList<Superhero> superheroes) {
        //if(database.getHeroes() != readSuperheroDatabase(FILENAME)) {
            try {
                FileWriter Writer = new FileWriter(FILENAME);
                for (Superhero superhero : superheroes) {
                    Writer.write(superhero.getHeroName() + "," + superhero.getPrivateName() + "," +
                            superhero.getSuperPower() + "," + superhero.getIsHuman() + "," +
                            superhero.getCreationYear() + "," + superhero.getStrength() + "\n");
                }
                Writer.close();
                System.out.println("Successfully saved to file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        //}
    }
}
