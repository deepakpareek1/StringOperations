package com.string.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

	private static Scanner scanner;

	public Operations() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * fetching file from given path
	 * @param: file path
	 */
	public static File getFile(String path) {
		File file = null;
		try {
			file = new File(path);
			
		} catch (Exception ex) {
			System.out.println("Error in fetching file: " + ex.getMessage());
		};
		return file;
	}
	
	/*
	 * Reading from standard input
	 * @param: 
	 */
	public static ArrayList<String> readInput() {
		ArrayList<String> input = new ArrayList<String>();
		String option = "";
		String str = "";
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream
		try {

			System.out.println("1: Check if a word exists");
			System.out.println("2: Correct case");
			System.out.println("3: Correct punctuation");
			System.out.println("4: Correct duplicate letters");
			System.out.println("5: Correct adjacent letters");
			System.out.println("6: Transposing letters");
			System.out.println("Please enter operation number:");
			option = sc.nextLine(); //reads option
			System.out.println("Please enter operation string:");
			str = sc.nextLine(); // reads string
			sc.close();
			input.add(option);
			input.add(str);
		} catch (Exception ex) {
			System.out.println("Error in reading input: " + ex.getMessage());
		} finally {
			sc.close();
		}
		return input;
	}
	
	/*
	 * 
	 * @param: 
	 */
	public static String performOperation(File file, String option, String input) {
		String output = "Incorrect Input";
		
		if (option.equals("1")) {
			output = findWord(file, input);
		} else if (option.equals("2")) {
			output = getCorrectCase(file, input);
		} else if (option.equals("3")) {
			output = getCorrectPunctuation(file, input);
		} else if (option.equals("4")) {
			output = getCorrectDuplicateLetters(file, input);
		} else if (option.equals("5")) {
			output = getCorrectAdjacentLetters(file, input);
		} else if (option.equals("6")) {
			output = getTransposingLetters(file, input);
		}
		return output;
		
	}
	
	/*
	 * Exercise 1: Check if a word exists
	 * @param: file, matchWord
	 */
	public static String findWord(File file, String matchWord) {
		String word = null;
		try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(line.equalsIgnoreCase(matchWord)) { 
		            word = line;
		            break;
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
		return word;
	}
	
	/*
	 * Exercise 2: Correct case
	 * @param: file, matchWord
	 */
	public static String getCorrectCase(File file, String matchWord) {
		ArrayList<String> wordList = new ArrayList<>();
		try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(line.equalsIgnoreCase(matchWord)) { 
		        	String tmpStr = line.substring(0, 1).toUpperCase() + line.substring(1, line.length()).toLowerCase();
		        	wordList.add(tmpStr);
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
		return String.join(", ", wordList);
	}
	
	/*
	 * Exercise 3: Correct punctuation
	 * @param: file, matchWord
	 */
	public static String getCorrectPunctuation(File file, String matchWord) {
		return "";
	}
	
	/*
	 * Exercise 4: Correct duplicate letters
	 * @param: file, matchWord
	 */
	public static String getCorrectDuplicateLetters(File file, String matchWord) {
		return "";
	}
	
	/*
	 * Exercise 5: Correct adjacent letters
	 * @param: file, matchWord
	 */
	public static String getCorrectAdjacentLetters(File file, String matchWord) {
		return "";
	}
	
	/*
	 * Exercise 6: Transposing letters
	 * @param: file, matchWord
	 */
	public static String getTransposingLetters(File file, String matchWord) {
		return "";
	}
	
	/*
	 * Print result
	 * @param: 
	 */
	public static void printOutput(String result) {
		System.out.println("Output: "+result);
	}
	
}

