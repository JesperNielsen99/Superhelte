package comparators;

import superhero.Superhero;

import java.util.Comparator;

public class SuperComparator implements Comparator<Superhero> {
    private String direction = "Ascending";
    private String primarySort;

    public SuperComparator(String primarySort) {
        this.primarySort = primarySort;
    }

    public void setDirection(String direction) {
        if (direction.equalsIgnoreCase("Ascending") || direction.equalsIgnoreCase("Descending")) {
            this.direction = direction;
        }
    }

    public void setPrimarySort(String primarySort) {
        this.primarySort = primarySort;
    }

    @Override
    public int compare(Superhero s1, Superhero s2) {
        int result = 0;
        switch (primarySort) {
            case "HeroName" -> {
                result = s1.getHeroName().compareTo(s2.getHeroName());
            }
            case "PrivateName" -> {
                result = s1.getPrivateName().compareTo(s2.getPrivateName());
            }
            case "Humanity" -> {
                result = Boolean.compare(s1.getIsHuman(), s2.getIsHuman());
            }
            case "CreationYear" -> {
                result = Integer.compare(s1.getCreationYear(), s2.getCreationYear());
            }
            case "Strength" -> {
                result = Double.compare(s1.getStrength(), s2.getStrength());
            }
        }
        return result;
    }
}
