import Items.*;
package Consumables;

public class SummonConsumable extends Consumable {

    private Creature ally;
    
    public SummonConsumable(String name, int effectLevel, String creatureName, int level, int HP, int MP, Weapon wep) {
        super(effectLevel, name);
        setType(4);
        ally = new Creature(creatureName, level, HP, MP, wep);
    }
    
    public void use(Player player, List allies, List enemies) {
        allies.add(ally);
        remove(1);
    }
}
