package Helpers;
import java.util.*;

public class Input {
	
	public static int intPrompt(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input " + prompt + ":");
		System.out.print(">> ");
		try {
			return sc.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input.");
			return intPrompt(prompt);
		}
	}
	
	public static int validIntPrompt(String prompt, int max) {
		int out = intPrompt(prompt);
		while (out > max || out < 1) {
			System.out.println("Invalid Input.");
			out = intPrompt(prompt);
		}
		return out;
	}
	
	public static int validIntPrompt(String prompt, int min, int max) {
		int out = intPrompt(prompt);
		while (out > max || out < min) {
			System.out.println("Invalid Input.");
			out = intPrompt(prompt);
		}
		return out;
	}
	
	public static String strPrompt(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input " + prompt + ":");
		System.out.print(">> ");
		try {
			return sc.next();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input.");
			return strPrompt(prompt);
		}
	}
}
