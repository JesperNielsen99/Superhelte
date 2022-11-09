package datasource;

import datahandling.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import superhero.Superhero;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    FileHandler fileHandler;
    ArrayList<Superhero> superheroes;

    @BeforeEach
    public void setup() {
        fileHandler = new FileHandler();
        superheroes = new ArrayList<>();
        Superhero superhero1 = new Superhero("lightning", "hans", "super speed", true, 2002, 99.93);
        Superhero superhero2 = new Superhero("inferno", "klaus", "super hot", true, 1930, 190.1);
        superheroes.add(superhero1);
        superheroes.add(superhero2);
    }

    @Test
    void readSuperheroDatabase() {
        assertNotNull(fileHandler.readSuperheroDatabase());
    }

    @Test
    void writeSuperheroDatabase() {
        StringBuilder heroData = new StringBuilder();
        fileHandler.writeSuperheroDatabase(heroData.toString());
    }
}