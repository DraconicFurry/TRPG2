public class DamageConsumable extends Consumable {
  
    public DamageConsumable(int effectScale, String name, int value, int amount) {
        super(effectScale, name, value, amount);
        setType(1);
    }
  
    public void use(Player player, List allies, List enemies) {
        int choice = Input.validIntPrompt("enemy target", enemies.size());
        enemies.get(choice).takeDamage(getScale());
        remove(1);            
    }
}
