public class Weapon extends Item {
    
    private int minDam;
    private int maxDam;
    private int damRange;
    private boolean isRanged;
    
    public Weapon(String name, int value, int minDam, int maxDam, boolean isRanged) {
        super(name, value);
        this.minDam = minDam;
        this.maxDam = maxDam;
        this.damRange = maxDam - minDam;
        this.isRanged = isRanged;
    }
    
    public int calculateAtk() {
        return (int)((Math.Random() * damRange) + minDam);
    }
    
    public String toString() {
        String range;
        String magic;
        
        if (isRanged) {
            range = "Ranged";        
        } else {
            range = "Melee";
        }
        
        return ("(Weapon) " + getName() + " (" + range + "): " + minDam + " - " + maxDam);
    }
}
