package items;
import items.consumables.*;
import items.armor.*;
import helpers.*;
import meta.*;

public class ResourceItem extends StackItem {

    public ResourceItem(String name, int value, int amount) {
        super(name, value, amount);    
    }
    
    public String toString() {
        return ("(Resource Item) " + getName() + "x" + getAmount() + ", " + getValue() + "g (" + (getValue() * getAmount()) + "g total)");
    }
}
