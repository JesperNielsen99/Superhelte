import java.time.LocalDateTime;


public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private boolean isHuman;
    private int creationYear;
    private double strength;

    //Get methods
    public String getHeroName() { return heroName; }
    public String getPrivateName() { return privateName; }
    public double getStrength() { return strength; }
    public boolean getIsHuman(){ return isHuman; }
    public String getSuperPower() { return superPower; }
    public int getCreationYear() {return creationYear; }

    //Set methods
    public void setHeroName(String heroName) {
        if (!heroName.isEmpty()) { this.heroName = heroName; }
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

    public void addSuperPower(String superPower) {
        this.superPower += superPower;
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
        // TODO: 04/11/2022 Check this HAMZA!!!!!! 
        if (heroName != null) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n==============================\n",
                    heroName, privateName, superPower,creationYear,printIsHuman(),strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n=============================\n",
                    privateName, superPower,creationYear,printIsHuman(),strength);
        }
        return printSuperhero;
    }
}
