public class DamageConsumable extends Consumable {
  
    public void use(Player player, List allies, List enemies) {
        int choice = Input.validIntPrompt("enemy target", enemies.size());
        enemies.get(choice).takeDamage(getScale());
        remove(1);            
    }
}
