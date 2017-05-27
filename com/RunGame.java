package com;
import helpers.*; 
import java.util.*; //
import java.io.*; //
import items.*;
import items.armor.*;
import java.util.ArrayList;

public class RunGame {
	public static void main(String[] args) throws FileNotFoundException, IOException, InventoryFullException {
		System.out.println("TRPG v0.0.1 initialized.\n");
		while (true) {
			System.out.println("1: New Character");
			System.out.println("2: Load Character");
			System.out.println("3: Help");
			System.out.println("4: Quit");
			System.out.println("5: Run Test Scenario");
			int menuChoice = Input.validIntPrompt("menu item", 5);
			System.out.println();
			switch (menuChoice) {
				case 1:
					Player player = createCharacter();
					try {
						SaveLoad.saveGame(player);
               		} catch (Exception ex) {
                  		System.out.println("Savefile creation failed.");
               		}
					runGame(player);
					break;
				case 2:
					try {
					   	SaveLoad.listFiles();
					   	System.out.println((SaveLoad.numFiles() + 1) + ": Return to Menu");
              		} catch (Exception ex) {
                  		System.out.println("No savefiles found.");
                  		break;
               		}
					try {
						int fileChoice = Input.validIntPrompt("file number", SaveLoad.numFiles() + 1);
						if (fileChoice == SaveLoad.numFiles() + 1) {
							break;
						} else {
							Player loadPlayer = SaveLoad.readSave(fileChoice - 1);
							runGame(loadPlayer);
						}
					} catch (Exception ex) {
						System.out.println("This savefile is corrupted.");
					}
					break;
				case 3:
					helpMenu();
					break;
				case 4:
					return;
				case 5:
					try {
						runTest();
					} catch (FileNotFoundException e) {
						System.out.println("File not found.");
					}
					break;
			}
			System.out.println();
		}
	}
	
	public static void runTest() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Savefiles/Test.txt"));
		while (sc.hasNext()) {
			Input.strPrompt("any character to read next token");
			System.out.println(sc.next());
		}
		sc.close();
	}
	
	public static void runGame(Player player) {
		while (true) {
			System.out.println("\n---Tavern---");
			System.out.println("1: Random Battle");
			System.out.println("2: Stats");
			System.out.println("3: Inventory");
			System.out.println("4: Shop");
			System.out.println("5: Quit");
			int tavernChoice = Input.validIntPrompt("menu item", 5);
			switch (tavernChoice) {
				case 1:
					randBattle(player);
					break;
				case 2:
					System.out.println("---" + player.name + "---");
					System.out.println("Level " + player.level + ", XP: " + player.XP + "/" + (player.level * 100));
					System.out.println("Gold: " + player.gold);
					System.out.println("HP: " + player.HP + "/" + player.MHP + ", MP: " + player.MP + "/" + player.MMP);
					System.out.println(player.wep);
					System.out.println(player.army.army[0]);
					System.out.println(player.army.army[1]);
					System.out.println(player.army.army[2]);
					System.out.println(player.army.army[3]);
					break;
				case 3:
					invMenu(player);
					break;
				case 4:
					System.out.println("Shop not yet implemented");
					break;
				case 5:
					return;
			}
		}
	}
	
	public static void randBattle(Player player) {
		ArrayList<Creature> enemies = new ArrayList<Creature>();
		int numEnemies = 3;
		int enemyLevel = player.level;
		int mod = ((int)Math.random() * 3) - 1; //generates -1, 0, or 1
		numEnemies -= mod;
		enemyLevel += mod; //creates either 4 weak enemies, 3 normal enemies, or 2 strong enemies
		if (enemyLevel <= 0) {enemyLevel = 1; numEnemies--;}
		for (int i = 0; i < numEnemies; i++) {
			enemies.add(randEnemy(enemyLevel, true));
		}
		
		if (player.allies != null) {
			new Encounter(player, enemies, player.allies).run();
		} else {
			new Encounter(player, enemies).run();
		}
	}
	
	public static Creature randEnemy(int enemyLevel, boolean changeLevel) {
		if (changeLevel) {
			int levelMod = (int)(Math.random()*4); //generates a number between 0 and 3
			if (levelMod == 0 && enemyLevel > 1) {
				enemyLevel--;
			} else if (levelMod == 3) {
				enemyLevel++;
			} //25% chance to increase level, 25% chance to decrease level
		}
		
		int health = enemyLevel * 10;
		int mana = enemyLevel * 5;
		int minDam = enemyLevel * 2;
		int maxDam = minDam + (enemyLevel);
		
		//modify stats, randomly trading one stat for another
		int modPoints = (enemyLevel / 2) + 1;
		while (modPoints > 0) {
			int statDown = (int)(Math.random() * 4);
			int statUp = (int)(Math.random() * 4);
			switch (statDown) {
				case 1:
					health -= 5;
					break;
				case 2:
					mana -= 3;
					break;
				case 3:
					minDam -= 1;
					maxDam -= 1;
					break;
				case 4:
					maxDam -= 2;
					break;
			}
			switch (statUp) {
				case 1:
					health += 5;
					break;
				case 2:
					mana += 3;
					break;
				case 3:
					minDam += 1;
					maxDam += 1;
					break;
				case 4:
					maxDam += 2;
					break;
			}
			modPoints--;
		}
		
		String name = "Wolf"; //replace with enemy name generator
		boolean ranged = false;
		if (Math.random() > 0.50) {ranged = true;}
		boolean magic = false;
		if (Math.random() > 0.50) {magic = true;}
		String wepName = NameGenerator.generateWepName(ranged, magic); //replace this and next 2 lines with weapon type generator
		return new Creature(name, enemyLevel, health, mana, new Weapon(wepName, 0, minDam, maxDam, ranged, magic));
	}
	
	public static void invMenu(Player player) {
        boolean back = false;
        player.inv.display();
        while (!back) {
            System.out.println("1: Display");
            System.out.println("2: Equip");
            System.out.println("3: Throw Away");
            System.out.println("4: Back");
            int invChoice = Input.validIntPrompt("Inventory Action", 4);
            System.out.println();

            switch (invChoice) {
                case 1:
                    player.inv.display();
                    break;
                case 2:
                    System.out.println(player.getWep().toString());
                    player.army.display();
                    int toEquipIndex = Input.validIntPrompt("item to equip", player.inv.getInv().length);
                    try {
                        if (player.inv.getInv()[toEquipIndex] instanceof Weapon) {
                            player.equipWep(toEquipIndex);
                        } else {
                            player.equipArmor(toEquipIndex);
                        }
                    } catch (Exception ex) {
                        System.out.println("Not a weapon or armor.");
                    }
                    break;
                case 3: 
                    int toTrashIndex = Input.validIntPrompt("item's number", player.inv.getInv().length);
                    if (player.inv.getInv()[toTrashIndex] instanceof StackItem) {
                    	StackItem temp = (StackItem) player.inv.getInv()[toTrashIndex];
                        int toTrashNum = Input.validIntPrompt("number to throw away", temp.getAmount());
                        try {
                        	player.inv.trash(toTrashIndex, toTrashNum);
                        } catch (Exception ex) {
                        }
                    } else {
                    	try {
                    		player.inv.trash(toTrashIndex, 1);
                    	} catch (Exception ex) {
                    	}
                    }	
                    break;
                case 4:
                    back = true;
                    break;
            }
            System.out.println();
        }
    }
	
	public static Player createCharacter() {
		String name = Input.strPrompt("character name");
		Weapon meleePhys = new Weapon("Trainee's Sword", 0, 5, 10, false, false);
		Weapon rangePhys = new Weapon("Recruit's Bow", 0, 5, 10, true, false);
		Weapon meleeMagi = new Weapon("Conjured Dagger", 0, 5, 10, false, true);
		Weapon rangeMagi = new Weapon("Apprentice's Staff", 0, 5, 10, true, true);
		System.out.println("1: " + meleePhys);
		System.out.println("2: " + rangePhys);
		System.out.println("3: " + meleeMagi);
		System.out.println("4: " + rangeMagi);
		int wepChoice = Input.validIntPrompt("weapon choice", 4);
		Weapon wep;
		switch (wepChoice) {
			case 1:
				wep = meleePhys;
				break;
			case 2:
				wep = rangePhys;
				break;
			case 3:
				wep = meleeMagi;
				break;
			case 4:
				wep = rangeMagi;
				break;
			default:
				wep = meleePhys;
				break;
		}
		Player player = new Player(name, 1, 0, 50, 30, wep, new Inventory(10), 0);
		Armory army = new Armory(player);
		player.addArmory(army);
		return player;
	}
	
	public static void helpMenu() {
		System.out.println("1: Combat");
		System.out.println("2: Equipment");
		System.out.println("3: Stats and Leveling");
		System.out.println("4: Effects and Skills");
		System.out.println("5: Return to Menu");
		int menuChoice = Input.validIntPrompt("help topic", 5);
		System.out.println();
		switch (menuChoice) {
			case 1:
				System.out.println("Combat takes place in turns. First the player acts, then the player's allies act, then the enemies act.");
				System.out.println("This cycle repeats until all enemies are killed, the player dies, or the player runs from combat.");
				System.out.println("Each turn, the player will have the option of attacking an enemy, using a skill, using an item, or fleeing.");
				System.out.println("Regular attacks deal moderate damage, target a single enemy, and consume no mana.");
				System.out.println("Skills consume mana, but are more powerful than normal attacks, and some skills can heal or buff your team.");
				System.out.println("Items have a variety of different effects, and are consumed upon use.");
				System.out.println("If you attempt to run, you have a 50% chance to succeed. Failing to run will end your turn.");
				System.out.println("If you successfully escape from combat, you will drop half the gold you earned in the battle.");
				System.out.println("If you die, you lose all gold and XP earned since you last visited the tavern.");
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				return;
		}
		System.out.println();
	}
}
