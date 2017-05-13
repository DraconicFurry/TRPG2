import java.util.*;

public class RunGame {
	public static void main(String[] args) {
		boolean quit = false;
		while (!quit) {
			System.out.println("1: New Character");
			System.out.println("2: Load Character");
			System.out.println("3: Help");
			System.out.println("4: Quit");
			System.out.println("5: Run Test Scenario");
			int menuChoice = Input.validIntPrompt("menu item", 5);
			switch (menuChoice) {
				case 1:
					System.out.println("Character creation not yet implemented.");
					break;
				case 2:
					System.out.println("Save/Load not yet implemented.");
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
		}
	}
	
	public static void runTest() {
	
	}
	
	public static void helpMenu() {
		boolean quit = false;
		while (!quit) {
			System.out.println("1: Combat");
			System.out.println("2: Equipment");
			System.out.println("3: Stats and Leveling");
			System.out.println("4: Effects and Abilities");
			System.out.println("5: Return to Menu");
			int menuChoice = Input.validIntPrompt("help topic", 5);
			switch (menuChoice) {
				case 1:
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
		}
	}
}
