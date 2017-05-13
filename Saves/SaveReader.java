package Saves;
import java.util.*;
import java.io.*;
import Helpers.Input;

public class SaveLoad {
	
	public Creature readSave(String fileName) throws FileNotFoundException {
		File toLoad = new File(fileName + ".txt");	
		return new Creature("Test", 1, 50, 30);
	}
}
