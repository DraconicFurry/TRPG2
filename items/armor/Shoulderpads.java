package items.armor;

public class Shoulderpads extends Armor {

    public Shoulderpads(String name, int value, int defense) {
      super(name, value, defense);
    }
    
    public String toString() {
        return ("(Shoulderpads) " + getName() + ", " + getDefense() + " armor, " + getValue() + "g");
    }    
}    
