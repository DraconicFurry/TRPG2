package com;
import java.util.*;
import helpers.Input;

public class Encounter {
  
	Player player;
	ArrayList<Creature> enemies;
	ArrayList<Creature> allies;
	ArrayList<Creature> dEnemies;
	ArrayList<Creature> dAllies;
  
	public Encounter(Player player, ArrayList<Creature> enemies) {
		this.player = player;
    	this.enemies = enemies;
    	dEnemies = new ArrayList<Creature>();
		this.allies = null;
 	}
	
	public Encounter(Player player, ArrayList<Creature> enemies, ArrayList<Creature> allies) {
		this.player = player;
    	this.enemies = enemies;
		this.allies = allies;
		dEnemies = new ArrayList<Creature>();
    	dAllies = new ArrayList<Creature>();
 	}
  
	//Constructor is unnecessary, will uncomment and update if ever used
  	/*public Encounter(Creature player, Creature[] enemies) {
  		this.player = player;
    	this.enemies = new ArrayList<Creature>();
    	for (int i = 0; i < enemies.length; i++) {
      		this.enemies.add(enemies[i]);
    	}
    	dEnemies = new ArrayList<Creature>();
    	dAllies = new ArrayList<Creature>();
	}*/

	public void run() {
		int startSize = enemies.size();
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
		if (player.isDead) {
			endBattle(false, false);
		} else if (dEnemies.size() == startSize) { //all enemies have been killed, player did not run
			endBattle(true, false);
		} else {  //player ran
			endBattle(true, true);
		}
	}
	
	public void playerAction() {
		boolean turnOver = false;
		while (!turnOver) {
			System.out.println();
			System.out.println(player);
			if (allies != null) {
				System.out.println("\n ---Allies---");
				for (int i = 0; i < allies.size(); i++) {
					System.out.println(allies.get(i));
				}
			}
			System.out.println("\n ---Enemies---");
			for (int i = 0; i < enemies.size(); i++) {
				System.out.println(enemies.get(i));
			}
			System.out.println();
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
					int target = Input.validIntPrompt("target", enemies.size());
					enemies.get(target - 1).takeDamage(player.getWep().calculateAtk(), player.name);
					if (enemies.get(target - 1).isDead) {
						dEnemies.add(enemies.remove(target - 1));
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
					} else {
						System.out.println("Failed to run!");
					}
					turnOver = true;
					break;
			}
		}
	}
							 
	public void allyAction(Creature ally) {
		if (enemies.size() > 0) {
			int target = (int)(Math.random() * enemies.size());
			enemies.get(target).takeDamage(ally.getWep().calculateAtk(), ally.name);
			if (enemies.get(target).isDead) {
				dEnemies.add(enemies.remove(target));
			}
		}
	}
	
	public void enemyAction(Creature enemy) {
		if (allies == null || allies.size() <= 0) {
			player.takeDamage(enemy.getWep().calculateAtk(), enemy.name);
		} else {
			int target = (int)(Math.random() * (allies.size() + 1));
			if (target == 0) {
				player.takeDamage(enemy.getWep().calculateAtk(), enemy.name);	
			} else {
				allies.get(target - 1).takeDamage(enemy.getWep().calculateAtk(), enemy.name);
				if (allies.get(target - 1).isDead) {
					dAllies.add(allies.remove(target - 1));	
				}
			}
		}
	}
	
	public void endBattle(boolean survived, boolean ran) {
		if (!survived) {
			System.out.println("You died. All rewards lost.");
		} else {
			if (ran) {
				System.out.println("You escaped from battle! 50% of gold earned in this fight was lost.");
			} else {
				System.out.println("You won!");
			}
			calculateRewards(ran);
		}
	}
	
	public void calculateRewards(boolean ran) {
		for (int i = 0; i < dEnemies.size(); i++) {
			int gEarned = dEnemies.get(i).level * 5;
			gEarned += (int)(Math.random() * 5 * dEnemies.get(i).level);
			player.gold += gEarned;
			player.XP += dEnemies.get(i).level * 5;
			player.levelUp();
			//Item drops
		}
	}
}
