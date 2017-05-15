package com;
import java.util.*;
import items.*;
import items.armor.*;
import helpers.*;

public class Player extends Creature {

	private int gold;
	private int XP;
	Inventory inv;
	Armory army;
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
      		Weapon temp = this.wep;
      		this.wep = wep;
      		inv.trash(index, 1);
      		inv.add(temp);
	}
	
	    
    	public void equipArmor(int index) throws IllegalArgumentException {
        	if (inv.getInv()[index] instanceof Helmet || inv.getInv()[index] instanceof Shoulderpads || 
        		inv.getInv()[index] instanceof Chestpiece || inv.getInv()[index] instanceof Leggings) {
            		Armor temp = army.equip((Armor)inv.getInv()[index]);
            		inv.getInv()[index] = temp;
        	} else {
            		throw new IllegalArgumentException();
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
