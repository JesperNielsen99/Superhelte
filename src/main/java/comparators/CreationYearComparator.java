package comparators;

import superhero.Superhero;
import java.util.Comparator;

public class CreationYearComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return Integer.compare(s1.getCreationYear(), s2.getCreationYear());
    }
}
