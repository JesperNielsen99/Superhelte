import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Superhero> superheroes;

    public Database() {
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void addSuperheroes(List<Superhero> superheroes) {
        for (int i = 0; i < superheroes.size(); i++) {
            this.superheroes.add(superheroes.get(i));
        }
    }

    public void deleteSuperhero(Superhero superhero) {
        superheroes.remove(superhero);
    }

    public void deleteSuperheroes() {
        superheroes.clear();
    }
}
