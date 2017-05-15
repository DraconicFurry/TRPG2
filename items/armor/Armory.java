package items.armor;
import items.*;
import items.consumables.*;
import meta.*;

public class Armory {

    private Armor[] army;
    private Player owner;
    
    public Armory(Player owner) {
        army = new Armor[4];
        army[0] = new Helmet("Starter Helmet", 1, 10);
        army[1] = new Shoulderpads("Starter Shoulderpads", 1, 15);
        army[2] = new Chestpiece("Starter Chestpiece", 1, 20);
        army[3] = new Leggings("Starter Leggings", 1, 15);
        this.owner = owner;
    }
    
    public void equip(Armor newArmor) throws InsufficientItemException {
        int index = 0;
        
        if (nameSearch(newArmor.getName()) == -1) {
            throw new InsufficientItemException()
        } else {
            index = nameSearch(newArmor.getName());
        }
        
        if (newArmor instanceof Helmet) {
            Armor temp = army[0];
            army[0] = newArmor;
            owner.inv.getInv()[index] = temp;
        } else if (newArmor instanceof Shoulderpads) {
            Armor temp = army[1];
            army[1] = newArmor;
            owner.inv.getInv()[index] = temp;
        } else if (newArmor instanceof Chestpiece) {
            Armor temp = army[2];
            army[2] = newArmor;
            owner.inv.getInv()[index] = temp;
        } else {
            Armor temp = army[3];
            army[3] = newArmor;
            owner.inv.getInv()[index] = temp;
        } 
    }
        
    public int totalDefense() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += army[i].getDefense();
        }
        return sum;
    }
}




