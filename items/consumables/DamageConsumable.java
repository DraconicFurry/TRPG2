package items.consumables;
import items.*;
import items.armor.*;
import meta.*;
import helpers.*;
public class DamageConsumable extends Consumable {
  
    public DamageConsumable(String name, int effectScale, int value, int amount) {
        super(effectScale, name, value, amount);
        setType(1);
    }
  
    public void use(Player player, List allies, List enemies) {
        int choice = Input.validIntPrompt("enemy target", enemies.size());
        enemies.get(choice).takeDamage(getScale());
        remove(1);            
    }
}
