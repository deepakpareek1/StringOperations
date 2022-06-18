package com.string.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Operations {

	public static String FILE_PATH = "C:/Users/dpareek/Documents/dictionary.txt";
	
	private static Scanner scanner;
	private static String REGEX_3 = "[\\/\\-']";
	private static String REGEX_4 = "(.)\1";

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
	public static void performOperation(File file, String option, String input) {
		String output = "Incorrect Input";
		ArrayList<String> lstOutput = null;
		
		if (option.equals("1")) {
			output = findWord(file, input);
			Operations.printOutput(output);
		} else if (option.equals("2")) {
			lstOutput = getCorrectCase(file, input);
			Operations.printOutput(lstOutput);
		} else if (option.equals("3")) {
			lstOutput = getCorrectPunctuation(file, input);
			Operations.printOutput(lstOutput);
		} else if (option.equals("4")) {
			lstOutput = getCorrectDuplicateLetters(file, input);
			Operations.printOutput(lstOutput);
		} else if (option.equals("5")) {
			lstOutput = getCorrectAdjacentLetters(file, input);
			Operations.printOutput(lstOutput);
		} else if (option.equals("6")) {
			lstOutput = getTransposingLetters(file, input);
			Operations.printOutput(lstOutput);
		} else {
			Operations.printOutput(output);
		}
		
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
	public static ArrayList<String> getCorrectCase(File file, String matchWord) {
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
		return wordList;
	}
	
	/*
	 * Exercise 3: Correct punctuation
	 * @param: file, matchWord
	 */
	public static ArrayList<String> getCorrectPunctuation(File file, String matchWord) {
		
	    ArrayList<String> wordList = new ArrayList<>();
	    
	    try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        
		        if (isWordMatch(line, matchWord, REGEX_3)) {
			        
		        	wordList.add(line);
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
	    
		return wordList;
	}
	
	/*
	 * Matching two string after removal of special chars
	 */
	private static boolean isWordMatch(String line, String matchWord, String regex) {
		boolean isMatch = false;
		
		String tmpLine = line.replaceAll(regex, "");
		String tmpMatchWord = matchWord.replaceAll(regex, "");
		
		if (tmpLine.equalsIgnoreCase(tmpMatchWord)) {
			isMatch = true;
		}
		
		return isMatch;
	}
	
	/*
	 * Exercise 4: Correct duplicate letters
	 * @param: file, matchWord
	 */
	public static ArrayList<String> getCorrectDuplicateLetters(File file, String matchWord) {
		ArrayList<String> wordList = new ArrayList<>();
		try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(matchWord.contains(line)) { 
		        	wordList.add(line);
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
		return wordList;
	}
	
	/*
	 * Exercise 5: Correct adjacent letters
	 * @param: file, matchWord
	 */
	public static ArrayList<String> getCorrectAdjacentLetters(File file, String matchWord) {
		ArrayList<String> wordList = new ArrayList<>();
		try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(matchWord.length() == line.length() && isAdjacentCharMatch(line, matchWord))
		        { 
		        	wordList.add(line);
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
		return wordList;
	}
	
	/*
	 * Matching adjacent mistaken chars in a word
	 */
	private static boolean isAdjacentCharMatch(String line, String matchWord){
		boolean isMatch = false;
		char anyChar = '.';
		
		for(int i=0;i<matchWord.length()-1;i++) {
			String regex = matchWord.replace(matchWord.charAt(i), anyChar);
			// Create & match dynamic Pattern object
		     Pattern r = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		     Matcher m = r.matcher(line);
		     if (m.matches()) {
		    	 isMatch = true;
		    	 break;
		     }
		}
		return isMatch;	
	}
	
	/*
	 * Exercise 6: Transposing letters
	 * @param: file, matchWord
	 */
	public static ArrayList<String> getTransposingLetters(File file, String matchWord) {
		ArrayList<String> wordList = new ArrayList<>();
		try {
		    scanner = new Scanner(file);
		    
		    //now read the file line by line...
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        if(matchWord.length() == line.length() && isTransposingCharMatch(line, matchWord))
		        { 
		        	wordList.add(line);
		        }
		    }
		} catch(FileNotFoundException e) { 
			System.out.println("Read file error: "+ e.getMessage());
		}
		return wordList;
	}
	
	/*
	 * Matching transposing mistaken chars in a word
	 */
	private static boolean isTransposingCharMatch(String line, String matchWord){
		boolean isMatch = false;
		char pos1, pos2;
		StringBuilder word = new StringBuilder();
		
		word.append(matchWord);
		for(int i=0;i<matchWord.length()-1;i++) {
			
			pos1 = word.charAt(i);
			pos2 = word.charAt(i+1);
			
				if (pos1 != pos2) {
					
					word.setCharAt(i, pos2);
					word.setCharAt(i+1, pos1);
					
					// Create & match dynamic Pattern object
				     Pattern r = Pattern.compile(word.toString(), Pattern.CASE_INSENSITIVE);
				     Matcher m = r.matcher(line);
				     if (m.matches()) {
				    	 isMatch = true;
				    	 break;
			     }
			}
			i++;
		}
		return isMatch;	
	}
	
	/*
	 * Print result
	 * @param: result
	 */
	public static void printOutput(String result) {
		result = result.isEmpty() ? "None" : result;
		System.out.println("Output: "+result);
	}
	
	/*
	 * Print result list
	 * @param: result list
	 */
	public static void printOutput(ArrayList<String> result) {
		if (result.isEmpty()){
			System.out.println("Output: None");
		} else {
			System.out.println("Output list: ");
			for(String str: result) {
				System.out.println(str);
			}
		}
		
	}
	
}

