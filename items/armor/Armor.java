package items.armor;
import items.*;

public abstract class Armor extends Item {

    int defense;
    
    public Armor(String name, int value, int defense) {
        super(name, value);
        this.defense = defense;
    }
    
    public int getDefense() {
        return defense;
    }
}
