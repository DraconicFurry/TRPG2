package items;

public class Weapon extends Item {
    
    int minDam;
    int maxDam;
    int damRange;
    boolean isRanged;
    boolean isMagic;
    
    public Weapon(String name, int value, int minDam, int maxDam, boolean isRanged, boolean isMagic) {
        super(name, value);
        this.minDam = minDam;
        this.maxDam = maxDam;
        this.damRange = maxDam - minDam;
        this.isRanged = isRanged;
        this.isMagic = isMagic;
    }
    
    public int calculateAtk() {
        return (int)((Math.random() * damRange) + minDam);
    }
    
    public int getMin() {
    	return minDam;
    }
    
    public int getMax() {
    	return maxDam;
    }
    
    public boolean getRanged() {
    	return isRanged;
    }
    
    public boolean getMagic() {
    	return isMagic;
    }
    
    public String toString() {
        String range;
        String magic;
        
        if (isRanged) {
            range = "Ranged";        
        } else {
            range = "Melee";
        }
        
        if (isMagic) {
            magic = "Magical";
        } else {
            magic = "Physical";
        }
        
        return ("(Weapon) " + getName() + " (" + range + ", " + magic + "): " + minDam + " - " + maxDam + ", " + getValue() + "g");
    }
}
