package items;

public class StackItem extends Item {

    private int amount;
    // private int maxAmmount;
    
    public StackItem(String name, int value, int amount) {
        super(name, value);
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void add(int num) {
        amount += num;
    }
    
    public void remove(int num) {
        amount -= num;  
    }
    
    public String toString() {
        return ("(Junk) " + getName() + "x" + amount + ", " + getValue() + "g (" + (getValue() * amount) + "g total)");
    }
}   
