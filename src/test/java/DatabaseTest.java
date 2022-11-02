import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
        /*Superhero superhero1 = new Superhero("Superman", "Clark kent", "Kryptonian");
        Superhero superhero2 = new Superhero("Spiderman", "Peter Parker", "Human");
        Superhero superhero3 = new Superhero("Batman", "Bruce Wayne", "Human");
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

    @Test
    void searchHeroName() {
        assertEquals(database.searchHeroName("Superman").get(0).getHeroName(), "Superman");
    }

    @Test
    void searchPrivateName() {
        assertEquals(database.searchPrivateName("Bruce Wayne").get(0).getHeroName(), "Batman");
    }
}