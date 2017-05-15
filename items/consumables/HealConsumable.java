package items.consumables;
import items.*;
import items.armor.*;
import meta.*;
import helpers.*;

public class HealConsumable extends Consumable {

    public HealConsumable(String name, int effectScale, int value, int amount) {
        super(effectScale, name, value, amount);
        setType(3);
    }
    public void use(Player player, List allies, List enemies) {
        int target = 0;
        
        if (allies.size() != 0) {
            target = Input.validIntPrompt("heal target", allies.size());
            
            if (target == 1) {
                player.heal(getScale());
            } else {
                allies.get(target).heal(getScale());
            }
        } else {
            player.heal(getScale());
        }
        remove(1);
    }
}       
