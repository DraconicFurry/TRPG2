package helpers;
import items.*;
import java.util.*;
@SuppressWarnings(value = { "resource" })

public class Input {
	
	public static int intPrompt(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nInput " + prompt + ":");
		System.out.print(">> ");
		int out;
		try {
			out = sc.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("\nInvalid Input.\n");
			out = intPrompt(prompt);
		}
		System.out.println();
		return out;
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
		System.out.println("\nInput " + prompt + ":");
		System.out.print(">> ");
		String out;
		try {
			out = sc.next();
		} catch (InputMismatchException ex) {
			System.out.println("\nInvalid Input.\n");
			out = strPrompt(prompt);
		}
		System.out.println();
		return out;
	}
	
   	public static int searchName(Item[] arr, String name) {
      		for (int i = 0; i < arr.length; i++) {
         		if (arr[i] != null && arr[i].getName() == name) {
            			return i;
         		}
      		}
      		return -1;
   	}  	
}
