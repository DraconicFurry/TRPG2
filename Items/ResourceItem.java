package Items;

public class ResourceItem extends StackItem {

    public ResourceItem(String name, int value, int amount) {
        super(name, value, amount);    
    }
    
    public String toString() {
        return ("(Resource Item) " + getName() + ": " + getValue() + "g");
    }
}
