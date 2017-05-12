import java.util.*;

public class Encounter {
  
	Creature player;
	ArrayList<Creature> enemies;
  
	public Encounter(Creature player, ArrayList<Creature> enemies) {
		this.player = player;
    	this.enemies = enemies;
 	}
  
  	public Encounter(Creature player, Creature[] enemies) {
  		this.player = player;
    	this.enemies = new ArrayList<Creature>();
    	for (int i = 0; i < enemies.length; i++) {
      		this.enemies.add(enemies[i];
    	}
	}

	public run() {
		while(!player.isDead && enemies.size() > 0) {
			playerAction();
			for (int i = 0; i < enemies.size(); i++) {
				enemyAction(enemies.get(i));
			}
		}
	}
	
	public playerAction() {
		while (!turnOver) {
			System.out.println("1: Attack");
			System.out.println("2: Skills");
			System.out.println("3: Run");
			int action = validIntPrompt("action number", 3);
			switch (action) {
				case 1:
					for (int i = 0; i < enemies.size(); i++) {
						System.out.println((i + 1) + ": " + enemies.get(i).getName());
					}
					int target = validIntPrompt("target", enemies.size());
					enemies.get(target - 1).takeDamage(player.wep.calculateAtk());
					if (enemies.get(target - 1).isDead) {
						//Gold + XP rewards here
						enemies.remove(target - 1);
					}
					turnOver = true;
					break;
				case 2:
					System.out.println("Skills not yet implemented.");
					break;
				case 3:
					if ((int)(Math.random() * 2) == 1) { //50% chance
						while(enemies.size() > 0) {
							enemies.remove(0);
						}
					}
					turnOver = true;
					break;
			}
		}
	}
	
	public enemyAction(Creature enemy) {
		//placeholder
	}
}
