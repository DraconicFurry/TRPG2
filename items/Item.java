package items;
import items.consumables.*;
import items.armor.*;

public abstract class Item implements Comparable<Item> {
    
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;    
    }
    
    public int getValue() {
        return value;
    }
    
    /*  Sort order:
        1: Weapons
        2: Armor (Helmet > Shoulderpads > Chestpiece > Leggings)
        3: Consumables (Damage > AOE Damage > Heal > Summon)
        4: Resources (By name)
        5: Junk Items (By name)
        6: Nulls
    */
    
    public int compareTo(Item other) {
        int itemType = 0, otherType = 0;
        
        if (this instanceof Weapon) {
            itemType = 4;
        } else if (this instanceof Consumable) {
            itemType = 3;
        } else if (this instanceof ResourceItem) {
            itemType = 2;
        } else if (this instanceof StackItem) {
            itemType = 1;    
        }
        
        if (other instanceof Weapon) {
            otherType = 4;
        } else if (other instanceof Consumable) {
            otherType = 3;
        } else if (other instanceof ResourceItem) {
            otherType = 2;
        } else if (other instanceof StackItem) {
            otherType = 1;    
        }
        
        if (itemType != otherType) {
            return otherType - itemType;
        } else if (this.getValue() != other.getValue()) {
            return other.getValue() - this.getValue();
        } else if (!this.getName().equals(other.getName())) {
            return ((this.getName().charAt(0)) - (other.getName().charAt(0)));
        } else {
            return 0;
        }
    }
}
