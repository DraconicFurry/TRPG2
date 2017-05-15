import java.util.*;
import Items.*;
import Armor.*;

public class Player extends Creature {

	private int gold;
	private int XP;
	private Inventory inv;
	private int defense;
	
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
	
	public void addArmory(Player player) {
		this.army = new Armory(player);	
	}
	
	public void equipWep(Weapon wep) throws InventoryFullException, InsufficientItemException {
      		int index = Input.searchName(inv.getInv(), wep.getName());
      		Weapon temp = getWep();
      		setWep(wep);
      		inv.trash(index, 1);
      		inv.add(temp);
	}
	
	public int totalDefense() {
		return inv.getArmory().totalDefense();
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
