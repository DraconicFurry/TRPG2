package com;
//import java.util.*;
import items.*;

public class Creature {
	
	String name;
	int level;
	int HP;
	int MHP;
	boolean isDead;
	int MP;
	int MMP;
	Weapon wep;
	
	public Creature(String name, int level, int HP, int MP, Weapon wep) {
		this.level = level;
		this.HP = HP;
		this.MHP = HP;
		this.MP = MP;
		this.MMP = MP;
		isDead = false;
		this.wep = wep;
	}
	
	public Creature(String name, int level, int HP, int MP) {
		this.level = level;
		this.HP = HP;
		this.MHP = HP;
		this.MP = MP;
		this.MMP = MP;
		isDead = false;
		this.wep = new Weapon("Paws", 0, 1, 1, false, false);
	}
	
	public String getName() {
		return name;
	}
	
	public Weapon getWep() {
		return wep;
	}
	
	public void setWep(Weapon other) {
		this.wep = other;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHealth() {
		return HP;
	}
	
	public int getMaxHealth() {
		return MHP;
	}
	
	public int getMana() {
		return MP;
	}
	
	public int getMaxMana() {
		return MMP;
	}
	
	public void changeMana(int difference) {
		MP += difference;
		
		if (MP > MMP) {
			MP = MMP;
		}
	}
	
	public void takeDamage(int damage) { //add isRanged and isMagic
		HP -= damage;
		if (HP <= 0) {
			HP = 0;
			isDead = true;
		}
	}
	
	public void heal(int health) {
		HP += health;
		if (HP > MHP) {
			HP = MHP;
		}
	}
	
	public String toString() {
		return (name + ": " + HP + "/" + MHP + "    " + MP + "/" + MMP);	
	}
}


