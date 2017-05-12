public class Weapon extends Item {
    
    private String name;
    private int minDam;
    private int maxDam;
    private int damRange;
    private boolean isRanged;
    private boolean isMagic;
    
    public Weapon(String name, int minDam, int maxDam, boolean isRanged, boolean isMagic) {
        this.name = name
        this.minDam = minDam;
        this.maxDam = maxDam;
        this.damRange = maxDam - minDam;
        this.isRanged = isRanged;
        this.isagic = isMagic;
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
        
        if (isMagic) {
            magic = "Magical";
        } else {
            magic = "Physical";
        }
        
        return (name + "(" + range + ", " + magic + "): " + minDam + "-" + maxDam);
    }
}
