package com;
import helpers.*;
import items.*;
import items.armor.*;
import java.util.ArrayList;

public class RunGame {
	public static void main(String[] args) {
		boolean quit = false;
		System.out.println("Fursade v0.0.1 initialized.\n");
		while (!quit) {
			System.out.println("1: New Character");
			System.out.println("2: Load Character");
			System.out.println("3: Help");
			System.out.println("4: Quit");
			System.out.println("5: Run Test Scenario");
			System.out.println();
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
              		} catch (Exception ex) {
                  		System.out.println("No savefiles found.");
                  		break;
               		}
					try {
						int fileChoice = Input.validIntPrompt("file number", SaveLoad.numFiles());
						Player loadPlayer = SaveLoad.readSave(fileChoice - 1);
						runGame(loadPlayer);
					} catch (Exception ex) {
						System.out.println("Savefile not found. Your save data may be corrupted.");
					}
					break;
				case 3:
					helpMenu();
					break;
				case 4:
					quit = true;
					break;
				case 5:
					runTest();
					break;
			}
			System.out.println();
		}
	}
	
	public static void runTest() {
		System.out.println("No test scenario loaded.");
	}
	
	public static void runGame(Player player) {		
		while (true) {
			System.out.println("\n-------Tavern-------");
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
					System.out.println(player.toString()); //replace with detailed statrs view later
					break;
				case 3:
					invMenu(player);
					break;
				case 4:
					try {
					shopMenu(player);
					} catch (Exception ex) {
					}
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
			if (levelMod == 0) {
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
		String wepName = "Claws"; //replace this and next 2 lines with weapon type generator
		boolean ranged = false;
		boolean magic = false;
		return new Creature(name, enemyLevel, health, mana, new Weapon(wepName, 0, minDam, maxDam, ranged, magic));
	}
	
	public static void invMenu(Player player) {
		System.out.println();
        player.inv.display();
        System.out.println();
        while (true) {
        	System.out.println("-----Inventory Menu-----");
            System.out.println("1: Equip");
            System.out.println("2: Throw Away");
            System.out.println("3: Back");
            int invChoice = Input.validIntPrompt("Inventory Action", 3);
            System.out.println();

            switch (invChoice) {
                case 1:
                	System.out.println("These are your currently equipped weapon and armor:");
                    System.out.println(player.getWep().toString());
                    player.army.display();
                    System.out.println();
                    System.out.println("And this is your bag. Look for weapons or pieces of armor to equip!");
                    player.inv.display();
                    int toEquipIndex = Input.validIntPrompt("the number of a weapon or piece of armor in your bag to equip", player.inv.getInv().length);
                    try {
                        if (player.inv.getInv()[toEquipIndex] instanceof Weapon) {
                            player.equipWep(toEquipIndex);
                            System.out.println("Sucessfully equipped weapon!");
                        } else if (player.inv.getInv()[toEquipIndex] instanceof Armor) {
                            player.equipArmor(toEquipIndex);
                            System.out.println("Sucessfully equipped armor!");
                        } else {
                        	throw new InsufficientItemException();
                        }
                    } catch (Exception ex) {
                        System.out.println("Not a weapon or piece of armor.");
                    }
                    break;
                case 2: 
                	System.out.println("Here is your bag. Remember, you can sell items in the shop instead of throwing them away!");
                	player.inv.display();
                    int toTrashIndex = Input.validIntPrompt("item's number", player.inv.getInv().length);
                    if (player.inv.getInv()[toTrashIndex] instanceof StackItem) {
                    	StackItem temp = (StackItem) player.inv.getInv()[toTrashIndex];
                        int toTrashNum = Input.validIntPrompt("number to throw away", temp.getAmount());
                        try {
                        	if (player.inv.getInv()[toTrashIndex] == null) {
                        		throw new InsufficientItemException();
                        	}
                        	player.inv.trash(toTrashIndex, toTrashNum);
                        } catch (Exception ex) {
                        	System.out.println("You cannot throw that away");
                        }
                    } else if (player.inv.getInv()[toTrashIndex] instanceof Item) {
                    	try {
                    		player.inv.trash(toTrashIndex, 1);
                    	} catch (Exception ex) {
                    		System.out.println("You cannot throw that away");
                    	}
                    } else {
                    	System.out.println("Not an item, cannot be thrown away");
                    }
                    break;
                case 3:
                	return;
            }
            System.out.println();
        }
    }
	
	public static void shopMenu(Player player) throws InventoryFullException, InsufficientItemException {
		// WE NEED AN ARRAY OF ITEMS OR WHATEVER THE DUDE SELLS
		//Im thinking the shop guy has his own "inventory" which gets displayed
		// This is a temp one just for practice purposes
		// We can establish it wherever I'm thinking that it updates every time you clear a dungeon/fight
		// But to make it truly random we would need that array of possible Items from which it would take random Items
		boolean shopContinue = true;
		Inventory shopInv = new Inventory(5);
		shopInv.add(new StackItem("Hobgoblin Horn", 3, 10));
		shopInv.add(new Weapon("Skeleton Arm", 15, 10, 20, false, false));
		shopInv.add(new ResourceItem("Iron", 7, 5));
		System.out.println("You have " + player.gold + "g\n");
		showShopInv(shopInv);
		
		while (shopContinue) {
			System.out.println("1: Buy");
			System.out.println("2: Sell");
			System.out.println("3: Back");
			int shopMenuChoice = Input.validIntPrompt("shop choice", 3);
			switch (shopMenuChoice) {
				case 1:
					int shopBuyChoice = Input.validIntPrompt("item to buy", shopInv.getInv().length);
					if (shopInv.getInv()[shopBuyChoice] instanceof StackItem) {
						StackItem temp = (StackItem) shopInv.getInv()[shopBuyChoice];
						int buyNumber = Input.validIntPrompt("number to buy", temp.getAmount());
						int firstStackNum = temp.getAmount(); 
						temp.changeAmount(buyNumber);
						player.inv.add(temp);
						temp.changeAmount(firstStackNum - buyNumber);
						player.reward(temp.getValue() * buyNumber * -1, 0);
					} else {
						player.inv.add(shopInv.getInv()[shopBuyChoice]);
						shopInv.trash(shopBuyChoice, 1);
						shopInv.sortInv();
						player.reward(shopInv.getInv()[shopBuyChoice].getValue() * -1, 0);
					}
					break;
					
				case 2:
					player.inv.display();
					int toSellIndex = Input.validIntPrompt("item to sell", player.inv.getInv().length);
	                if (player.inv.getInv()[toSellIndex] instanceof StackItem) {
	                	StackItem temp = (StackItem) player.inv.getInv()[toSellIndex];
	                    int toSellNum = Input.validIntPrompt("number to throw away", temp.getAmount());
	                    	player.reward(player.inv.trash(toSellIndex, toSellNum), 0);
	                } else {
	                	try {
	                		player.inv.trash(toSellIndex, 1);
	                	} catch (Exception ex) {
	                	}
	                }	
	                break;
				case 3:
					shopContinue = false;
					break;
			}
		}
	}
	
	public static void showShopInv(Inventory shopInv) {
		System.out.println("------------Shop-------------");
		for (int i = 0; i < shopInv.getInv().length; i++) {
			System.out.println(i + ": " + shopInv.getInv()[i].toString());;
		}
	}
	
	public static Player createCharacter() {
		String name = Input.strPrompt("character name");
		System.out.println();
		System.out.println("Choose a Weapon:");
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
