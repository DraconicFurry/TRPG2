package items.consumables;
import java.util.*;
import items.*;
import com.*;

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
    
    public abstract void use(Player player, List<Creature> allies, List<Creature> enemies);
   
    public String toString() {
        return ("(Consumable Type " + consumeType + ") " + getName() + "x" + getAmount() + ", Effect Level " + getScale() + ", " + getValue() + "g");
    }
}
