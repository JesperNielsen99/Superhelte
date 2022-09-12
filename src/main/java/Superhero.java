import java.text.DecimalFormat;

public class Superhero {
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private String heroName;
    private String privateName;
    private String superPower;
    private String race;
    private int creationYear;
    private double strength;

    public Superhero() {
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
        if (!privateName.equals("Null")) {
            this.privateName = privateName;
        } else {
            this.privateName = "";
        }
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        if (strength < 10000 || strength > -10000) {
            if (strength < 1 && strength != 0) {
                this.strength = strength * -1;
            } else {
                this.strength = strength;
            }
        } else {
            this.strength = 0;
        }
    }

    public String toString() {
        String printSuperhero;
        if (!heroName.equals("")) {
            printSuperhero = "%-10s: %-15s, %-15s, %-4s, 6%s\n";
            printSuperhero = String.format(printSuperhero, heroName, privateName,
                    superPower, creationYear, decimalFormat.format(strength));
        } else {
            printSuperhero = "%-10s: %-15s, %-15s, %-4s, 6%s\n";
            printSuperhero = String.format(printSuperhero, privateName,
                    superPower, creationYear, decimalFormat.format(strength));
        }
        return printSuperhero;
    }
}
