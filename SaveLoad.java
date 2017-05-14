import java.util.*;
import java.io.*;
import Helpers.Input;

public class SaveLoad {
	
	public Player readSave(int fileNum) throws FileNotFoundException {
		File[] saveFiles = new File("SaveFiles").listFiles();
		File toLoad = saveFiles[fileNum];
		Scanner sc = new Scanner(toLoad);
		return new Player("Test", 1, 50, 30);
	}
	
	public void saveGame(Creature player) {
		File save = new File("SaveFiles/" + player.getName() + ".txt");
		if (save.exists()) {
			Scanner sc = new Scanner(save);
			//Read necessary data from existing savefile
			save.delete();
		}
		save.createNewFile();
		OutputStream out = new OutputStream(save);
		//Write data to new file
	}
	
	public void listFiles() {
		File saveFolder = new File("SaveFiles");
		File[] saveFiles = saveFolder.listFiles();
		Scanner sc;
		for (int i = 0; i < saveFiles.length; i++) {
			sc = new Scanner(saveFiles[i]);
			System.out.println((i + 1) + ": " + sc.next());
		}
	}
	
	public int numFiles() {
		return new File("SaveFiles").listFiles().length();	
	}
}
