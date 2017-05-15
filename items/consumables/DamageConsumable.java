package items.consumables;
import com.*;
import java.util.*;
import helpers.Input;
public class DamageConsumable extends Consumable {
  
    public DamageConsumable(String name, int effectScale, int value, int amount) {
        super(name, effectScale, value, amount);
        setType(1);
    }
  
    public void use(Player player, List<Creature> allies, List<Creature> enemies) {
        int choice = Input.validIntPrompt("enemy target", enemies.size());
        enemies.get(choice).takeDamage(getScale());
        remove(1);            
    }
}
