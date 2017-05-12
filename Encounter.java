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
		while(true) { //replace with end condition
			playerAction();
			for (int i = 0; i < enemies.size(); i++) {
				enemyAction(enemies.get(i));
			}
		}
	}
	
	public playerAction() {
		//placeholder
	}
	
	public enemyAction(Creature enemy) {
		//placeholder
	}
}
