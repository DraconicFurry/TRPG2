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
	
	public Creature(String name, int level, int HP, int MP) {
		this.level = level;
		this.MHP = HP;
		this.MMP = MP;
		isDead = false;
	}
	
	private levelUp() {
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
	
	public takeDamage(int damage) { //add isRanged and isMagic
		HP -= damage;
		if (HP <= 0) {
			HP = 0;
			isDead = true;
		}
	}
}


