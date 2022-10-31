public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private String race;
    private int creationYear;
    private double strength;

    public Superhero() {
    }

    public Superhero(String privateName) {
        this.privateName = privateName;
    }

    public Superhero(String heroName, String privateName, String race) {
        this.heroName = heroName;
        this.privateName = privateName;
        this.superPower = "none";
        this.race = race;
        this.creationYear = 2000;
        this.strength = 5000;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        if (!heroName.equals("Null")) {
            this.heroName = heroName;
        } else {
            this.heroName = "";
        }
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void addSuperPower(String superPower) {
        this.superPower += superPower;
    }

    public void removeSuperPower(int superPower) {
        String[] powers = getSuperPower().split("((?<=\\.))");
        String power = powers[superPower].replace(powers[superPower], "");
        powers[superPower] = power;
        StringBuilder superPowers = new StringBuilder();
        for (String pow : powers) {
            superPowers.append(pow);
        }
        setSuperPower(superPowers.toString());
        presentSuperPowers();
    }

    public void presentSuperPowers() {
        String[] powers = getSuperPower().split("\\.");
        for (int i = 0; i < powers.length; i++) {
            System.out.printf("%s: %s\n", i, powers[i]);
        }
        System.out.println("\n");
    }

    public double getStrength() {
        return strength;
    }

    public boolean setStrength(double strength) {
        if (strength < 10000 || strength > 0) {
            this.strength = strength;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String printSuperhero;
        if (!heroName.equals("")) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nRace: %s\nStrength: %s\n==============================\n",
            heroName, privateName, superPower,creationYear,race,strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nRace: %s\nStrength: %s\n==============================\n",
                    privateName, superPower,creationYear,race,strength);
        }
        return printSuperhero;
    }
}
