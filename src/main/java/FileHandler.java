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

    public void newFileIfFileNotFound() {
        try {
            File newFile = new File(FILENAME);
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> readSuperheroDatabase() {
        try {
            File file = new File(FILENAME);
            Scanner heroScanner = new Scanner(file).useLocale(Locale.US);
            ArrayList<String> heroData = new ArrayList<>();
            while (heroScanner.hasNextLine()) {
                heroData.add(heroScanner.nextLine());
            }
            heroScanner.close();
            return heroData;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            newFileIfFileNotFound();
            e.printStackTrace();
            return null;
        }
    }

    public void writeSuperheroDatabase(String heroData) {
        try {
            newFileIfFileNotFound(); // In case you delete the file as you run the program.
            FileWriter Writer = new FileWriter(FILENAME);
            Writer.write(heroData);
            Writer.close();
            System.out.println("Successfully saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
