package datahandling;

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
        Superhero superhero1 = new Superhero("lightning", "ibermand", "super speed", false, 2002, 99.93);
        Superhero superhero2 = new Superhero("inferno", "klaus", "super hot", true, 1930, 190.1);
        Superhero superhero3 = new Superhero("autostyler", "hans", "mekaniker", true, 1600, 55.15);
        database.addSuperhero(superhero1);
        database.addSuperhero(superhero2);
        database.addSuperhero(superhero3);
    }

    @Test
    void addSuperhero() {
        Superhero superhero = new Superhero();
        assertEquals(database.getSize(), 3);
        database.addSuperhero(superhero);
        assertTrue(database.getSize() > 3);
    }

    @Test
    void deleteSuperhero() {
        database.deleteSuperhero(1);
        assertEquals(database.getSize(), 2);
        database.deleteSuperhero(1);
        assertTrue(database.getSize() < 2);
    }


    @Test
    void sortByHeroName() {
        String expectedNameIndex0 = "autostyler";
        String expectedNameIndex2 = "lightning";
        assertFalse(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertFalse(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
        database.sortByHeroName();
        assertTrue(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertTrue(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
    }

    @Test
    void sortByPrivateName() {
        String expectedNameIndex0 = "hans";
        String expectedNameIndex2 = "klaus";
        assertFalse(database.getSuperheroes().get(0).getPrivateName() == expectedNameIndex0);
        assertFalse(database.getSuperheroes().get(2).getPrivateName() == expectedNameIndex2);
        database.sortByPrivateName();
        assertTrue(database.getSuperheroes().get(0).getPrivateName() == expectedNameIndex0);
        assertTrue(database.getSuperheroes().get(2).getPrivateName() == expectedNameIndex2);
    }

    @Test
    void sortByHumanity() {
        String expectedNameIndex0 = "inferno";
        String expectedNameIndex2 = "lightning";
        assertFalse(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertFalse(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
        database.sortByHumanity();
        assertTrue(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertTrue(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
    }

    @Test
    void sortByCreationYear() {
        String expectedNameIndex0 = "autostyler";
        String expectedNameIndex2 = "lightning";
        assertFalse(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertFalse(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
        database.sortByCreationYear();
        assertTrue(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertTrue(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
    }

    @Test
    void sortByStrength() {
        String expectedNameIndex0 = "autostyler";
        String expectedNameIndex2 = "inferno";
        assertFalse(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertFalse(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
        database.sortByStrength();
        assertTrue(database.getSuperheroes().get(0).getHeroName() == expectedNameIndex0);
        assertTrue(database.getSuperheroes().get(2).getHeroName() == expectedNameIndex2);
    }
//    @Test
//    void searchHeroName() {
//    }
//
//    @Test
//    void searchPrivateName() {
//    }
}