package datahandling;

import java.util.*;

import comparators.*;
import superhero.Superhero;

public class Database {
    private final ArrayList<Superhero> superheroes = new ArrayList<>();
    private final ArrayList<Superhero> searchResult = new ArrayList<>();
    private Superhero currentHero;

    public Database() {
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void deleteSuperhero(int heroNumber) {
        superheroes.remove(heroNumber);
    }

    public void readSuperheroDatabaseFromString(ArrayList<String> heroDataInput) {
        for (String s : heroDataInput) {
            String[] heroDataArray = s.split(";");
            Superhero superhero = new Superhero();
            superhero.setHeroName(heroDataArray[0]);
            superhero.setPrivateName(heroDataArray[1]);
            superhero.setSuperPower(heroDataArray[2]);
            superhero.setIsHuman(Boolean.parseBoolean(heroDataArray[3]));
            superhero.setCreationYear(Integer.parseInt(heroDataArray[4]));
            superhero.setStrength(Double.parseDouble(heroDataArray[5]));
            superheroes.add(superhero);
        }
    }

    public String writeSuperheroDatabaseFromString() {
        StringBuilder heroData = new StringBuilder();
        for (Superhero superhero : superheroes) {
            heroData.append(String.format("%s;%s;%s;%s;%s;%s", superhero.getHeroName(),
                    superhero.getPrivateName(), superhero.getSuperPower(), superhero.getIsHuman(),
                    superhero.getCreationYear(), superhero.getStrength())).append("\n");
        }
        return heroData.toString();
    }

    public void searchHeroName(String heroName) {
        emptySearchResult();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().toLowerCase().contains(heroName.toLowerCase())) {
                searchResult.add(superhero);
            }
        }
    }

    public void searchPrivateName(String privateName) {
        emptySearchResult();
        for (Superhero superhero : superheroes) {
            if (superhero.getPrivateName().toLowerCase().contains(privateName.toLowerCase())) {
                searchResult.add(superhero);
            }
        }
    }

    public String currentHeroToString() {
        return currentHero.toString();
    }

    public void emptySearchResult() {
        searchResult.clear();
    }

    public void removeCurrentHero() {
        currentHero = null;
    }

    public String searchResultToString() {
        StringBuilder searchResultArray = new StringBuilder();
        for (int i = 0; i < searchResult.size(); i++) {
            searchResultArray.append(String.format("%s)\n%s", i + 1, searchResult.get(i)));
        }
        searchResultArray.append(String.format("\n%s superheroes matched this search.\n", searchResult.size()));
        return searchResultArray.toString();
    }

    public int getSize() {
        return superheroes.size();
    }

    public void setCurrentHero(int index) {
        currentHero = searchResult.get(index);
    }

    public void createSuperhero() {
        currentHero = new Superhero();
        superheroes.add(currentHero);
    }

    public void setHeroName(String newHeroName) {
        currentHero.setHeroName(newHeroName);
    }

    public void setPrivateName(String newPrivateHero) {
        currentHero.setPrivateName(newPrivateHero);
    }

    public void setSuperPower(String newSuperPower) {
        currentHero.setSuperPower(newSuperPower);
    }

    public boolean setCreationYear(int newCreationYear) {
        return currentHero.setCreationYear(newCreationYear);
    }

    public void setIsHuman(boolean newIsHuman) {
         currentHero.setIsHuman(newIsHuman);
    }

    public boolean setStrength(double newStrength) {
        return currentHero.setStrength(newStrength);
    }

    public String getCurrentHeroName() {
        return currentHero.getHeroName();
    }

    public String getCurrentPrivateName() {
        return currentHero.getPrivateName();
    }

    public String getCurrentSuperPower() {
        return currentHero.getSuperPower();
    }

    public int getCurrentCreationYear() {
        return currentHero.getCreationYear();
    }

    public boolean getCurrentHeroIsHuman() {
        return currentHero.getIsHuman();
    }

    public double getCurrentHeroStrength() {
        return currentHero.getStrength();
    }

    public int getSearchResultSize() {
        return searchResult.size();
    }

    public void sortByHeroName() {
        Collections.sort(superheroes, new HeroNameComparator());
    }

    public void sortByPrivateName() {
        Collections.sort(superheroes, new PrivateNameComparator());
    }

    public void sortByHumanity() {
        Collections.sort(superheroes, new IsHumanComparator().reversed());
    }

    public void sortByCreationYear() {
        Collections.sort(superheroes, new CreationYearComparator());
    }

    public void sortByStrength() {
        Collections.sort(superheroes, new StrengthComparator());
    }

    public void sortByHeroNameReversed() {
        Collections.sort(superheroes, new StrengthComparator().reversed());
    }

    public void searchPrivateNameReversed() {
        Collections.sort(superheroes, new PrivateNameComparator().reversed());
    }

    public void sortIsHumanReversed() {
        Collections.sort(superheroes, new IsHumanComparator().reversed());
    }

    public void sortCreationYearReversed() {
        Collections.sort(superheroes, new CreationYearComparator().reversed());
    }

    public void sortByStrengthReversed() {
        Collections.sort(superheroes, new StrengthComparator().reversed());
    }

    public void sortByTwoAttributes(Comparator primaryComparator, Comparator secondaryComparator) {
        Collections.sort(superheroes, primaryComparator.thenComparing(secondaryComparator));
    }

    public String toString() {
        if (superheroes.size() > 0) {
            StringBuilder databaseString = new StringBuilder();
            for (Superhero superhero : superheroes) {
                databaseString.append(superhero.toString());
            }
            return ("\nList of Superheroes: \n-----------------\n" + databaseString);
        } else {
            return "The database is empty.";
        }
    }
}
