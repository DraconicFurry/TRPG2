imports Items.*;

public abstract class Armor extends Item {

    int defense;
    
    public Armor(String name, int value, int defense) {
        super(name, value);
        this.defense = defense;
    }
    
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    } 
    
    public int getDefense() {
        return defense;
    }
}
