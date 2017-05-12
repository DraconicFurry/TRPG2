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
    
    public String toString() {
        return ("(Junk) " + getName() + ": " + getValue() + "g");
    }
}   
