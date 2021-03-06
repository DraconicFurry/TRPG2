package items.consumables;
import com.*;
import java.util.*;

public class AreaDamageConsumable extends Consumable {
    
    public AreaDamageConsumable(String name, int effectScale, int value, int amount) {
        super(name, effectScale, value, amount);
        setType(2);
    }

    public void use(Player player, List<Creature> allies, List<Creature> enemies) {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).takeDamage(getScale());
        }
        remove(1);
    }
}
