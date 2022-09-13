import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Database {
    private List<Superhero> superheroes;
    private static String FILENAME = "Heroes.txt";
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public Database() {
        superheroes = new ArrayList<>();
        checkSuperheroDatabase(FILENAME);
        readSuperheroDatabase(FILENAME);
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void addSuperheroes(List<Superhero> superheroes) {
        for (int i = 0; i < superheroes.size(); i++) {
            this.superheroes.add(superheroes.get(i));
        }
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
                    case (5):
                        superhero.setPrivateName(superheroes[0]);
                        superhero.setSuperPower(superheroes[1]);
                        superhero.setRace(superheroes[2]);
                        superhero.setCreationYear(Integer.parseInt(superheroes[3]));
                        superhero.setStrength(Double.parseDouble(superheroes[4]));
                        break;
                    case (6):
                        superhero.setHeroName(superheroes[0]);
                        superhero.setPrivateName(superheroes[1]);
                        superhero.setSuperPower(superheroes[2]);
                        superhero.setRace(superheroes[3]);
                        superhero.setCreationYear(Integer.parseInt(superheroes[4]));
                        superhero.setStrength(Double.parseDouble(superheroes[5]));
                        break;
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
            for (int i = 0; i < superheroes.size(); i++) {
                Writer.write(superheroes.get(i).getHeroName() + "," + superheroes.get(i).getPrivateName() + "," +
                        superheroes.get(i).getSuperPower() + "," + superheroes.get(i).getRace() + "," +
                        superheroes.get(i).getCreationYear() + "," + superheroes.get(i).getStrength() + "\n");
            }
            Writer.close();
            System.out.println("Successfully saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void getDatabaseNumbers() {
        for (int i = 0; i < superheroes.size(); i++) {
            String heroName = superheroes.get(i).getHeroName();
            String privateName = superheroes.get(i).getPrivateName();
            System.out.println(String.format("%s: %s, %s", i, heroName, privateName));
        }
    }

    public String getDatabaseString() {
        if (superheroes.size() > 0) {
            String databaseString = "";
            for (int i = 0; i < superheroes.size(); i++) {
                databaseString += superheroes.get(i).toString();
            }
            return databaseString;
        } else {
            return "The database is empty.";
        }
    }

    public String toString() {
        String printSuperheroes = "\nList of Superheroes: \n-----------------\n" + getDatabaseString();
        return printSuperheroes;
    }
}
