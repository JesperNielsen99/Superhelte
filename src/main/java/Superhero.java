public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private boolean isHuman;
    private int creationYear;
    private double strength;

    public Superhero() {
    }

    public Superhero(String heroName, String privateName, String superPower, boolean isHuman, int creationYear, double strength) {
        this.heroName = heroName;
        this.privateName = privateName;
        this.superPower = superPower;
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    public Superhero(String privateName, String superPower, boolean isHuman, int creationYear, double strength) {
        heroName = "";
        this.privateName = privateName;
        this.superPower = superPower;
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public boolean getIsHuman(){
        return isHuman;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
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
        } else {
            this.strength = 0;
            return false;
        }
        return true;
    }

    public String printIsHuman() {
        if (getIsHuman() == true) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String toString() {
        String printSuperhero;
        if (!heroName.equals("")) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n==============================",
                    heroName, privateName, superPower,creationYear,printIsHuman(),strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n==============================",
                    privateName, superPower,creationYear,printIsHuman(),strength);
        }
        return printSuperhero;
    }
}
