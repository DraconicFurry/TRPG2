package items.armor;

public class Chestpiece extends Armor {

    public Chestpiece(String name, int value, int defense) {
        super(name, value, defense);
    }
    
    public String toString() {
        return ("(Chestpiece) " + getName() + ", " + getDefense() + " armor, " + getValue() + "g");
    }    
}
