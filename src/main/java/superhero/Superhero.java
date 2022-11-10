package superhero;

import java.time.LocalDateTime;


public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private int creationYear;
    private boolean isHuman;
    private double strength;


    public Superhero() {}

    public Superhero(String heroName, String privateName, String superPower, boolean isHuman, int creationYear, double strength) {
        this.heroName = heroName;
        this.privateName = privateName;
        this.superPower = superPower;
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    //Get methods
    public String getHeroName() { return heroName; }
    public String getPrivateName() { return privateName; }
    public double getStrength() { return strength; }
    public boolean getIsHuman(){ return isHuman; }
    public String getSuperPower() { return superPower; }
    public int getCreationYear() {return creationYear; }

    //Set methods
    public void setHeroName(String heroName) {
        if (!heroName.isEmpty()) {
            this.heroName = heroName;
        } else {
            this.heroName = "";
        }
    }

    public void setPrivateName(String privateName) { this.privateName = privateName;}

    public void setSuperPower(String superPower) { this.superPower = superPower; }

    public void setIsHuman(boolean isHuman) { this.isHuman = isHuman; }

    public boolean setStrength(double strength) {
        if (strength <= 10000 || strength > 0) {
            this.strength = strength;
        } else {
            return false;
        }
        return true;
    }

    public boolean setCreationYear(int creationYear) {
        if (creationYear <= LocalDateTime.now().getYear()) {
            this.creationYear = creationYear;
            return true;
        }
        return false;
    }

    public String printIsHuman() {
        if (getIsHuman()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String toString() {
        String printSuperhero;
        if (!heroName.equals("")) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n==============================\n",
                    heroName, privateName, superPower,creationYear,printIsHuman(),strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n=============================\n",
                    privateName, superPower,creationYear,printIsHuman(),strength);
        }
        return printSuperhero;
    }
}
