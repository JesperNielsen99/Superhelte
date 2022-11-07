package comparators;

import superhero.Superhero;

import java.util.Comparator;

public class IsHumanComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return Boolean.compare(s1.getIsHuman(), s2.getIsHuman());
    }
}
