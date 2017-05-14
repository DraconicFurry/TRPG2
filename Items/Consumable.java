public abstract class Consumable extends StackItem {

    private int consumeType;
    private int effectScale
    
    public Consumable(int consumeType, int effectScale) {
        this.consumeType = consumeType;
        this.effectScale = effectScale;
    }
    
    public int getType() {
        return consumeType;
    }
    
    public int getScale() {
        return effectScale;
    }
    
    public void use();
   
    public String toString() {
        return ("(Consumable Type " + consumeType + ") " + getname() + "x" + getAmount() + ": " + getValue() + "g (" + (getValue() * amount) + "g total)");
    }
}
