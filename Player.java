package meta;
import items.*;
import items.consumables.*;
import items.armor.*;
import helpers.*;
import java.util.*;

public class Player extends Creature {

	private int gold;
	private int XP;
	Inventory inv;
	int defense;
	
	public Player(String name, int level, int HP, int MP) {
		super(name, level, HP, MP);
		gold = 0;
		XP = 0;
		inv = new Inventory();
		defense = totalDefense();
	}
	
	public Player(String name, int level, int XP, int HP, int MP, Weapon wep, Inventory inv, int gold) {
		super(name, level, HP, MP, wep);
		this.gold = gold;
		this.XP = XP;
		this.inv = inv;
	}
	
	public void addArmory(Armory army) {
		this.army = army;	
	}
	
	public void equipWep(Weapon wep) throws InventoryFullException, InsufficientItemException {
      		int index = Input.searchName(inv.getInv(), wep.getName());
      		Weapon temp = getWep();
      		setWep(wep);
      		inv.trash(index, 1);
      		inv.add(temp);
	}
	
	    
    	public void equipArmor(int index) {
        	int choice = Input.intPrompt("armor to equip");
        
        	if (inv.getInv()[choice] instanceof Helmet || inv.getInv()[choice] instanceof Shoulderpads || inv.getInv()[choice] instanceof Chestpiece || inv.getInv()[choice] instanceof Leggings) {
            		army.equip((Armor)inv[choice]);
        	} else {
            		throw new InsufficientItemException();
        	}
    	}
	
	public int totalDefense() {
		return army.totalDefense();
	}
	
	public void levelUp() {
		if (XP >= (level * 100)) {
			XP -= level * 100;
			level++;
			//Increase stats
			MHP += 50;
			MMP += 25;
			//Restore HP and MP
			HP = MHP;
			MP = MMP;
		}
	}
	
	public void reward(int gold, int XP) {
		this.gold += gold;
		this.XP += XP;
		levelUp();
	}
	
	public int getXP() {
		return XP;
	}
}
