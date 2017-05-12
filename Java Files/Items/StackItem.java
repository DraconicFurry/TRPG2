public class StackItem extends Item {

    private int ammount;
    // private int maxAmmount;
    
    public StackItem(String name, int value, int ammount) {
        super(name, value);
        this.ammount = ammount;
    }
    
    public int getAmmount() {
        return ammount;
    }
    
    public String toString() {
        return ("(Junk) " + getName() + ": " + getValue() + "g");
    }
}   
