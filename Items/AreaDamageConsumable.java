public class AreaDamageConsumable extends Consumable {
    
    public AreaDamageConsumable(int effectScale, String name, int value, int amount);
        super(effectScale, name, value, amount);
        setType(2);
    }

    public void use(Player player, List allies, List enemies) {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).takeDamage(getScale());
        }
        remove(1);
    }
}
