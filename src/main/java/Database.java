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

    public Superhero getSuperhero(int heroNumber) {
        return superheroes.get(heroNumber);
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
            if (superheroes.get(i).getHeroName().toLowerCase().contains(heroName.toLowerCase())){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        } else {
            System.out.printf("%s super heroes were found, that fit your search.\n", heroes);
        }
    }

    public void searchPrivateName(String privateName) {
        int heroes = 0;
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getPrivateName().toLowerCase().contains(privateName.toLowerCase())){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        } else {
            System.out.printf("%s super heroes were found, that fit your search.\n", heroes);
        }
    }

    public void searchRace(String race) {
        int heroes = 0;
        boolean properRace = false;
        for (int i = 0; i < superheroes.size(); i++) {
            if (superheroes.get(i).getRace().equalsIgnoreCase(race))  {
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
                properRace = true;
            } else if (superheroes.get(i).getRace().toLowerCase().contains(race.toLowerCase())){
                System.out.printf("%s: %s", i, superheroes.get(i));
                heroes++;
            }
        }
        if (heroes == 0) {
            System.out.println("No hero was found with this search.");
        } else if (heroes > 0 && properRace) {
            System.out.printf("There is %s superheroes of the race %s\n", heroes, race);
        }
    }

    public void updateSuperhero(Superhero superhero, int option) {
        Scanner heroScanner = new Scanner(System.in).useLocale(Locale.US);
        int heroInt = 0;
        String heroString = "";
        switch (option) {
            case 1:
                System.out.printf("Enter the new superhero name for %s", superhero.getHeroName());
                heroString = heroScanner.nextLine();
                superhero.setHeroName(heroString);
                break;
            case 2:
                System.out.printf("Enter the new private name for %s", superhero.getHeroName());
                heroString = heroScanner.nextLine();
                superhero.setPrivateName(heroString);
                break;
            case 3:
                System.out.printf("Enter a new super power name for %s", superhero.getHeroName());
                heroString = heroScanner.nextLine();
                superhero.addSuperPower(heroString);
                break;
            case 4:
                System.out.printf("Choose a superpower to remove from %s", superhero.getHeroName());
                superhero.presentSuperPowers();
                heroInt = heroScanner.nextInt();
                superhero.removeSuperPower(heroInt);
                System.out.println(superhero);
                break;
            case 5:
                System.out.printf("Enter a new race for %s", superhero.getHeroName());
                heroString = heroScanner.nextLine();
                superhero.setRace(heroString);
                break;
            case 6:
                System.out.printf("Enter a new strength for %s", superhero.getHeroName());
                double heroDouble = heroScanner.nextDouble();
                superhero.setStrength(heroDouble);
                break;
        }
    }

    public void getDatabaseNumbers() {
        for (int i = 0; i < superheroes.size(); i++) {
            String heroName = superheroes.get(i).getHeroName();
            String privateName = superheroes.get(i).getPrivateName();
            System.out.printf("%s: %s, %s\n", i, heroName, privateName);
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
