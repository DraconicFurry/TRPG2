import java.util.*;

public class Creature {
	
	private String name;
	private int level;
	private int XP;
	private int HP;
	private int MHP;
	public boolean isDead;
	private int MP;
	private int MMP;
	prviate Weapon wep;
	
	public Creature(String name, int level, int HP, int MP, Weapon wep) {
		this.level = level;
		this.MHP = HP;
		this.MMP = MP;
		isDead = false;
		this.wep = wep;
	}
	
	public Creature(String name, int level, int HP, int MP) {
		this.level = level;
		this.MHP = HP;
		this.MMP = MP;
		isDead = false;
		this.wep = new Weapon("Fists", 1, 1, false, false);
	}
	
	public String getName() {
		return name;
	}
	
	public Weapon getWep() {
		return wep;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getXP() {
		return XP;
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
		
		if (MP < 0) {
			MP = 0;
		}
	}
	
	private void levelUp() {
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
	
	public void takeDamage(int damage) { //add isRanged and isMagic
		HP -= damage;
		if (HP <= 0) {
			HP = 0;
			isDead = true;
		}
	}
}


