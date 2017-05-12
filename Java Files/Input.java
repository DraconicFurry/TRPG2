import java.util.*;

public class Input {
	
	public int intPrompt(String prompt) {
		Scanner sc = new Scanner(System.out);
		System.out.println("Input " + prompt + ":");
		System.out.print(">> ");
		try {
			return sc.nextInt();
		} catch Exception {
			System.out.println("Invalid Input.");
			return intPrompt(prompt);
		}
	}
	
	public int validIntPrompt(String prompt, int max) {
		int out = intPrompt(prompt);
		while (out > max || out < 1) {
			System.out.println("Invalid Input.");
			out = intPrompt(prompt);
		}
		return out;
	}
	
	public int validIntPrompt(String prompt, int min, int max) {
		int out = intPrompt(prompt);
		while (out > max || out < min) {
			System.out.println("Invalid Input.");
			out = intPrompt(prompt);
		}
		return out;
	}
	
	public String strPrompt(String prompt) {
		Scanner sc = new Scanner(System.out);
		System.out.println("Input " + prompt + ":");
		System.out.print(">> ");
		try {
			return sc.next();
		} catch Exception {
			System.out.println("Invalid Input.");
			return strPrompt(prompt);
		}
	}
}
