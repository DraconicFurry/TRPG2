import java.util.*;
import Helpers.*;
import Items.*;
import Saves.*;

public class RunGame {
	public static void main(String[] args) {
		boolean quit = false;
		System.out.println("TRPG2 initialized.\n");
		while (!quit) {
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
					SaveLoad.saveGame(player);
					runGame(player);
					break;
				case 2:
					SaveLoad.listFiles();
					int fileChoice = validIntPrompt("file number", SaveLoad.numFiles());
					try {
						Player player = SaveLoad.readSave(fileChoice - 1);
					} catch {
						System.out.println("Savefile not found. Your save data may be corrupted.");
					}
					runGame(player);
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
		
	}
	
	public static Player createCharacter() {
		
	}
	
	public static void helpMenu() {
		boolean quit = false;
		while (!quit) {
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
					quit = true;
					break;
			}
			System.out.println();
		}
	}
}
