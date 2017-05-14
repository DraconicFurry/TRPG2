import Items.*;
import TRPG2.*;
package Consumables;

public class SummonConsumable extends Consumable {

    private Creature ally;
    
    public SummonConsumable(String name String creatureName, int level, int HP, int MP, Weapon wep) {
        super(1, name);
        setType(4);
        ally = new Creature(creatureName, level, HP, MP, wep);
    }
    
    public void use(Player player, List allies, List enemies) {
        allies.add(ally);
        remove(1);
    }
}
