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
        (5) 1: Weapons
        (4) 2: Armor (Helmet > Shoulderpads > Chestpiece > Leggings)
        (3) 3: Consumables (Damage > AOE Damage > Heal > Summon)
        (2) 4: Resources (By name)
        (1) 5: Junk Items (By name)
        (0) 6: Nulls
    */
    
    public int compareTo(Item other) {
        int itemType = getSortType(this);
        int otherType = getSortType(other);
        
        if (itemType != otherType) {
            return itemType - otherType;
        } else if (this.getValue() != other.getValue()) {
            return this.getValue() - other.getValue();
        } else if (!this.getName().equals(other.getName())) {
            return this.getName().compareTo(other.getName());
        } else {
            return 0;
        }
    }
    
    private int getSortType(Item item) {
        double itemType = 0;
        
        if (item instanceof Weapon) {
            itemType = 5;
        } else if (item instanceof Armor) {
            if (item instanceof Helmet) {
                itemType = 4.9;
            } else if (item instanceof Shoulderpads) {
                itemType = 4.8;
            } else if (item instanceof Chestpiece) {
                itemType = 4.7;
            } else {
                itemType = 4.6;
            }
        } else if (item instanceof Consumable) {
            if (item instanceof DamageConsumable) {
                itemType = 3.9;
            } else if (item instanceof AreaDamageConsumable) {
                itemType = 3.8;
            } else if (item instanceof HealConsumable) {
                itemType = 3.7;
            } else {
                itemType = 3.6;
            }
        } else if (item instanceof ResourceItem) {
            itemType = 2;
        } else if (item instanceof StackItem) {
            itemType = 1;    
        } else {
            itemType = 0;
        }
        return (int)(itemType * 10);
    }
}
