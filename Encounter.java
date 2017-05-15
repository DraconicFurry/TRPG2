import java.util.*;
import helpers.Input;
import items.*;

public class Encounter {
  
	Creature player;
	ArrayList<Creature> enemies;
	ArrayList<Creature> allies;
  
	public Encounter(Creature player, ArrayList<Creature> enemies) {
		this.player = player;
    	this.enemies = enemies;
		this.allies = null;
 	}
	
	public Encounter(Creature player, ArrayList<Creature> enemies, ArrayList<Creature> allies) {
		this.player = player;
    	this.enemies = enemies;
		this.allies = allies;
 	}
  
  	public Encounter(Creature player, Creature[] enemies) {
  		this.player = player;
    	this.enemies = new ArrayList<Creature>();
    	for (int i = 0; i < enemies.length; i++) {
      		this.enemies.add(enemies[i]);
    	}
	}

	public void run() {
		while(!player.isDead && enemies.size() > 0) {
			playerAction();
			if (allies != null) {
				for (int i = 0; i < allies.size(); i++) {
					allyAction(allies.get(i));
				}
			}
			for (int i = 0; i < enemies.size(); i++) {
				enemyAction(enemies.get(i));
			}
		}
	}
	
	public void playerAction() {
		boolean turnOver = false;
		while (!turnOver) {
			System.out.println("1: Attack");
			System.out.println("2: Skills");
			System.out.println("3: Items");
			System.out.println("4: Run");
			int action = Input.validIntPrompt("action number", 4);
			switch (action) {
				case 1:
					for (int i = 0; i < enemies.size(); i++) {
						System.out.println((i + 1) + ": " + enemies.get(i).getName());
					}
					int target = input.validIntPrompt("target", enemies.size());
					enemies.get(target - 1).takeDamage(player.getWep().calculateAtk());
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
					System.out.println("Items not yet implemented.");
					break;
				case 4:
					if ((int)(Math.random() * 2) == 1) { //50% chance
						while(enemies.size() > 0) {
							enemies.remove(0);
						}
						//Drop 50% of gold
					} else {
						System.out.println("Failed to run!");
					}
					turnOver = true;
					break;
			}
		}
	}
							 
	public void allyAction(Creature ally) {
		int target = (int)(Math.random() * enemies.size());
		enemies.get(target).takeDamage(ally.getWep().calculateAtk());
		if (enemies.get(target).isDead) {
			//Rewards
			enemies.remove(target);
		}
	}
	
	public void enemyAction(Creature enemy) {
		if (allies == null) {
			player.takeDamage(enemy.getWep().calculateAtk());
		} else {
			int target = (int)(Math.random() * (allies.size() + 1));
			if (target == 0) {
				player.takeDamage(enemy.getWep().calculateAtk());	
			} else {
				allies.get(target - 1).takeDamage(enemy.getWep().calculateAtk());
				if (allies.get(target - 1).isDead) {
					allies.remove(target - 1);	
				}
			}
		}
	}
}
