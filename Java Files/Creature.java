import java.util.*;

public class Creature {
	
	String name;
	int level;
	int XP;
	int HP;
	int MHP;
	boolean isDead;
	int MP;
	int MMP;
	Weapon wep;
	
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


