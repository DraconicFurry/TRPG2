package Items;

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
        
        if (amount < 0) {
            amount = 0;   
        }
    }
    
    public String toString() {
        return ("(Junk) " + getName() + "x" + amount + ": " + getValue() + "g (" + (super.getValue * amount) + "g total)");
    }
}   
