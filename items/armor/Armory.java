package items.armor;
import com.*; 
import items.*;
import helpers.*;


public class Armory {

    public Armor[] army;
    public Player owner;
    
    public Armory(Player owner) {
        army = new Armor[4];
        army[0] = new Helmet("Starter Helmet", 1, 10);
        army[1] = new Shoulderpads("Starter Shoulderpads", 1, 15);
        army[2] = new Chestpiece("Starter Chestpiece", 1, 20);
        army[3] = new Leggings("Starter Leggings", 1, 15);
        this.owner = owner;
    }
    
    public Armor equip(Armor newArmor) throws InsufficientItemException {
        if (Input.searchName(owner.inv.getInv(), newArmor.getName()) == -1) {
            throw new InsufficientItemException();
        }
        
        if (newArmor instanceof Helmet) {
            Armor temp = army[0];
            army[0] = newArmor;
            return temp;
        } else if (newArmor instanceof Shoulderpads) {
            Armor temp = army[1];
            army[1] = newArmor;
            return temp;
        } else if (newArmor instanceof Chestpiece) {
            Armor temp = army[2];
            army[2] = newArmor;
            return temp;
        } else {
            Armor temp = army[3];
            army[3] = newArmor;
            return temp;
        } 
    }
        
    public int totalDefense() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += army[i].getDefense();
        }
        return sum;
    }
    
    public void display() {
        System.out.println("------------Armor------------");
        for (int i = 0; i < 4; i++) {
            if (army[i] == null) {
                System.out.println((i + 1) + ": None");
            } else {
                System.out.println((i + 1) + ": " + army[i].toString());
            }
        }
    }
}




