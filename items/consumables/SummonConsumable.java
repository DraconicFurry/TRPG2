package items.consumables;
import com.*;
import items.*;
import java.util.*;

public class SummonConsumable extends Consumable {

    private Creature ally;
    
    public SummonConsumable(String name, int value, int amount, String creatureName, int level, int HP, int MP, Weapon wep) {
        super(name, 1, value, amount);
        setType(4);
        ally = new Creature(creatureName, level, HP, MP, wep);
    }
    
    public void use(Player player, List allies, List enemies) {
        allies.add(ally);
        remove(1);
    }
}
