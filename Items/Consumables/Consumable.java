package Consumables;
import Items.*;
import java.util.*;

public abstract class Consumable extends StackItem {

    private int consumeType;
    private int effectScale;
    
    public Consumable(String name, int effectScale, int value, int amount) {
        super(name, value, amount);
        this.effectScale = effectScale;
    }
    
    public void setType(int type) {
        this.consumeType = type;
    }
    
    public int getType() {
        return consumeType;
    }
    
    public int getScale() {
        return effectScale;
    }
    
    public void use(Player player, List allies, List enemes);
   
    public String toString() {
        return ("(Consumable Type " + consumeType + ") " + getname() + "x" + getAmount() + ", Effect Level " + getScale() + ", " + getValue() + "g");
    }
}
