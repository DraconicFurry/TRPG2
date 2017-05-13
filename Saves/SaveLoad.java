package Saves;
import java.util.*;
import java.io.*;
import Helpers.Input;

public class SaveLoad {
	
	public Creature readSave(String fileName) throws FileNotFoundException {
		File toLoad = new File(fileName + ".txt");
		Scanner sc = new Scanner(toLoad);
		return new Creature("Test", 1, 50, 30);
	}
	
	public void saveGame(Creature player) {
		File save = new File(player.getName() + ".txt");
		if (save.exists()) {
			Scanner sc = new Scanner(save);
			//Read necessary data from existing savefile
			save.delete();
		}
		save.createNewFile();
		OutputStream out = new OutputStream(save);
		//Write data to new file
	}
}
