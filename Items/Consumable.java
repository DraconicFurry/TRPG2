public abstract class Consumable extends StackItem {

    private int consumeType;
    private int effectScale
    
    public Consumable(int effectScale, String name, int value, int amount) {
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
        return ("(Consumable Type " + consumeType + ") " + getname() + "x" + getAmount() + ": " + getValue() + "g (" + (getValue() * amount) + "g total)");
    }
}
