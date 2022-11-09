import datahandling.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superhero.Superhero;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
        /*superhero.Superhero superhero1 = new superhero.Superhero("Superman", "Clark kent", "Kryptonian");
        superhero.Superhero superhero2 = new superhero.Superhero("Spiderman", "Peter Parker", "Human");
        superhero.Superhero superhero3 = new superhero.Superhero("Batman", "Bruce Wayne", "Human");
        database.getHeroes().add(superhero1);
        database.getHeroes().add(superhero2);
        database.getHeroes().add(superhero3);*/
    }

    @Test
    void addSuperhero() {
        Superhero superhero = new Superhero();
        database.addSuperhero(superhero);
        assertTrue(database.getSize() > 0);
    }

    @Test
    void deleteSuperhero() {
        database.deleteSuperhero(1);
        assertEquals(database.getSize(), 2);
    }

//    @Test
//    void searchHeroName() {
//    }
//
//    @Test
//    void searchPrivateName() {
//    }
}