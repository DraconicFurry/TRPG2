package items.armor;
import items.*;
import items.consumables.*;
import helpers.*;
import meta.*;

public class Helmet extends Armor {

    public Helmet(String name, int value, int defense) {
      super(name, value, defense);
    }
    
    public String toString() {
        return ("(Helmet) " + getName() + ", " + getDefense() + " armor, " + getValue() + "g");
    }
}
