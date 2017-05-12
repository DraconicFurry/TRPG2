public class JunkItem extends Item {

    private int numberOf;
    
    public JunkItem(String name, int value, int numberOf) {
        super(name, value);
        this.numberOf = numberOf;
    }
    
    public String toString() {
        return ("(Junk Item) " + super.getName + "x" + numberOf + ": " + super.getValue + "g");
    }
}
