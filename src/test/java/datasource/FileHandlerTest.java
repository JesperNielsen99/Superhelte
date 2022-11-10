package datasource;

import datahandling.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import superhero.Superhero;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    FileHandler fileHandler;
    ArrayList<Superhero> superheroes;

    @BeforeEach
    public void setup() {
        fileHandler = new FileHandler();
        superhero1 = new Superhero("sA", "pA", "supA", true, 1111, 1.1);
        superhero2 = new Superhero("sB", "pB", "supB", false, 2222, 2.2);
    }

    @Test
    void readSuperheroDatabase() {
        //arrange
        ArrayList<String> expectedData = new ArrayList<>();
        expectedData.add(superhero1.toStringTest());
        expectedData.add(superhero2.toStringTest());

        //act
        ArrayList <String> actualData = fileHandler.readSuperheroDatabase();

        //assert
        assertEquals(actualData, expectedData);
    }

    @Test
    void writeSuperheroDatabase() {
        // arrange
        String superhero1String = superhero1.toStringTest();
        String superhero2String = superhero2.toStringTest();
        String expectedData = superhero1String + '\n' + superhero2String + '\n';

        //act
        fileHandler.writeSuperheroDatabase(expectedData);

        //assert
        ArrayList<String> testArray = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("Heroes.csv")).useLocale(Locale.US);
            while (scanner.hasNextLine()) {
                testArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {}

        StringBuilder actualData = new StringBuilder();
        for(String string : testArray) {
            actualData.append(string);
            actualData.append("\n");
        }
        assertEquals(expectedData, actualData.toString());
    }
}