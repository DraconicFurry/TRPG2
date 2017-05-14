package Items;

public abstract class Item implements Comparable<Item> {
    
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.goldValue = value;
    }
    
    public String getName() {
        return name;    
    }
    
    public int getValue() {
        return value;
    }
    
    public int compareTo(Item other) {
        int itemType = 0, otherType = 0;
        
        if (this instanceOf Weapon) {
            itemType = 3;
        } else if (this intanceOf Resource) {
            itemType = 2;
        } else if (this instanceOf StackItem) {
            itemType = 1;    
        }
        
        if (other instanceOf Weapon) {
            otherType = 3;
        } else if (other intanceOf Resource) {
            otherType = 2;
        } else if (other instanceOf StackItem) {
            otherType = 1;    
        }
        
        if (itemType != otherType) {
            return otherType - itemType;   
        } else if (this.getValue() != other.getValue()) [
            return other.getValue() - this.getValue();
        } else if (this.getName()!.equals(other.getName())) {
            return ((char)(this.getName().substring(0, 1)) - (char)(other.getName().substring(0, 1)))
        } else {
            return 0;
        }
    }
}
