public class SummonConsumable extends Consumable {

    private Creature ally;
    
    public SummonConsumable(int effectLevel, String name, String creatureName, int level, int HP, int MP, Weapon wep) {
        super(effectLevel, name);
        setType(4);
        ally = new Creature(creatureName, level, HP, MP, wep);
    }
    
    public void use(Player player, List allies, List enemies) {
        allies.add(ally);
        remove(1);
    }
}
