import java.util.*;

public class Player extends Creature {

	private int gold;
	private int XP;
	//private Inventory inv;
	
	public Player(String name, int level, int HP, int MP) {
		super(name, level, HP, MP);
		gold = 0;
		//inv = new Inventory();
	}
	
	public Player(String name, int level, int XP, int HP, int MP, Weapon wep, Inventory inv, int gold) {
		super(name, level, HP, MP, wep);
		this.XP = XP;
		this.gold = gold;
		//this.inv = inv;
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
	
	public void reward(int gold, int XP) {
		this.gold += gold;
		this.XP += XP
		levelUp();
	}
	
	public int getXP() {
		return XP;
	}
}