public class Weapon extends Item {
    
    private int minDam;
    private int maxDam;
    private int damRange;
    private boolean isRanged;
    private boolean isMagic;
    
    public Weapon(minDam, maxDam, isRanged, isMagic) {
        this.minDam = minDam;
        this.maxDam = maxDam;
        this.isRanged = isRanged;
        this.isagic = isMagic;
        this.damRange = maxDam - minDam;
    }
    
    public int calculateAtk() {
        return (int)((Math.Random() * damRange) + minDam);
    }
}
