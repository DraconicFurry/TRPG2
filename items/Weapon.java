package items;
import items.consumables.*;
import items.armor.*;
import helpers.*;
import meta.*;

public class Weapon extends Item {
    
    private int minDam;
    private int maxDam;
    private int damRange;
    private boolean isRanged;
    private boolean isMagic;
    
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
