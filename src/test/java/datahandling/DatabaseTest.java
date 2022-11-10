package datahandling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superhero.Superhero;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database database;

    @BeforeEach
    public void setup() {
        database = new Database();
        database.getSuperheroes().clear();
        Superhero superhero1 = new Superhero("lightning", "ibermand", "super speed", false, 2002, 99.93);
        Superhero superhero2 = new Superhero("inferno", "klaus", "super hot", true, 1930, 190.1);
        Superhero superhero3 = new Superhero("autostyler", "hans", "mechanic", true, 1600, 55.15);
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

        assertNotSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);

        database.sortByHeroName();

        assertSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);
    }

    @Test
    void sortByPrivateName() {
        String expectedNameIndex0 = "hans";
        String expectedNameIndex2 = "klaus";

        assertNotSame(database.getSuperheroes().get(0).getPrivateName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(0).getPrivateName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(2).getPrivateName(), expectedNameIndex2);

        database.sortByPrivateName();

        assertSame(database.getSuperheroes().get(0).getPrivateName(), expectedNameIndex0);
        assertSame(database.getSuperheroes().get(2).getPrivateName(), expectedNameIndex2);
    }

    @Test
    void sortByHumanity() {
        String expectedNameIndex0 = "inferno";
        String expectedNameIndex2 = "lightning";

        assertNotSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);

        database.sortByHumanity();

        assertSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);
    }

    @Test
    void sortByCreationYear() {
        String expectedNameIndex0 = "autostyler";
        String expectedNameIndex2 = "lightning";

        assertNotSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);

        database.sortByCreationYear();

        assertSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);
    }

    @Test
    void sortByStrength() {
        String expectedNameIndex0 = "autostyler";
        String expectedNameIndex2 = "inferno";

        assertNotSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertNotSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);

        database.sortByStrength();

        assertSame(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0);
        assertSame(database.getSuperheroes().get(2).getHeroName(), expectedNameIndex2);
    }

    @Test
    void sortByTwoAttributesHeroPlusIsHuman() {
        Superhero superhero = new Superhero("autostyler", "hans", "mechanic", false, 1600, 55.15);
        database.addSuperhero(superhero);
        String expectedNameIndex0And1 = "autostyler";

        assertFalse(database.getSuperheroes().get(0).getIsHuman()
                && Objects.equals(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0And1));

        assertFalse(!database.getSuperheroes().get(1).getIsHuman()
                && Objects.equals(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0And1));

        database.sortByTwoAttributes(0, 2, false);

        assertTrue(!database.getSuperheroes().get(0).getIsHuman()
                && Objects.equals(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0And1));

        assertTrue(database.getSuperheroes().get(1).getIsHuman()
                && Objects.equals(database.getSuperheroes().get(0).getHeroName(), expectedNameIndex0And1));

    }

    @Test
    void sortByTwoAttributesPrivatePlusStrength() {
        String expectedNameIndex0 = "hans";
        String expectedNameIndex2 = "klaus";

        assertFalse(Objects.equals(database.getSuperheroes().get(0).getPrivateName(), expectedNameIndex0)
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(0).getStrength() < database.getSuperheroes().get(1).getStrength()));

        assertFalse(Objects.equals(database.getSuperheroes().get(2).getPrivateName(), expectedNameIndex2)
                && (!Objects.equals(database.getSuperheroes().get(2).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() > database.getSuperheroes().get(1).getStrength()));

        database.sortByTwoAttributes(1, 3, false);

        assertTrue(Objects.equals(database.getSuperheroes().get(0).getPrivateName(), expectedNameIndex0)
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(0).getStrength() < database.getSuperheroes().get(1).getStrength()));

        assertTrue(Objects.equals(database.getSuperheroes().get(2).getPrivateName(), expectedNameIndex2)
                && (!Objects.equals(database.getSuperheroes().get(2).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() > database.getSuperheroes().get(1).getStrength()));
    }

    @Test
    void sortByTwoAttributesIsHumanPlusStrengthReversed() {
        assertFalse(database.getSuperheroes().get(0).getIsHuman()
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() < database.getSuperheroes().get(1).getStrength()));

        assertFalse(!database.getSuperheroes().get(2).getIsHuman()
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() > database.getSuperheroes().get(1).getStrength()));

        database.sortByTwoAttributes(2, 4, true);

        assertTrue(database.getSuperheroes().get(0).getIsHuman()
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() > database.getSuperheroes().get(1).getStrength()));

        assertTrue(!database.getSuperheroes().get(2).getIsHuman()
                && (!Objects.equals(database.getSuperheroes().get(0).getHeroName(), database.getSuperheroes().get(1).getHeroName())
                || database.getSuperheroes().get(2).getStrength() > database.getSuperheroes().get(1).getStrength()));
    }

    @Test
    void writeSuperheroDatabaseFromString() {
        String isArrayNull = database.writeSuperheroDatabaseToString();
        assertNotNull(isArrayNull);
    }

    @Test
    void writeSuperheroDatabaseFromStringPrecise() {
        String actualString = database.writeSuperheroDatabaseToString();
        StringBuilder expectedStringBuilder = new StringBuilder();
        expectedStringBuilder.append("lightning;ibermand;super speed;false;2002;99.93\n");
        expectedStringBuilder.append("inferno;klaus;super hot;true;1930;190.1\n");
        expectedStringBuilder.append("autostyler;hans;mechanic;true;1600;55.15\n");
        String expectedString = expectedStringBuilder.toString();
        assertEquals(actualString, expectedString);
    }

    @Test
    void readSuperheroDatabasetoString() {
        ArrayList<String> heroDataInput = new ArrayList<>();
        for (Superhero superhero : database.getSuperheroes()) {
            heroDataInput.add(superhero.toStringTest());
        }
        database.getSuperheroes().clear();
        assertTrue(database.getSuperheroes().isEmpty());
        database.readSuperheroDatabaseFromString(heroDataInput);
        assertTrue(database.getSize() > 0);
    }
}