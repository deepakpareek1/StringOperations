package com.string.operations;

import java.io.File;
import java.io.FileNotFoundException;
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
	public static String readInput() {
		String str = "";
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream
		try {
			System.out.println("Input: ");
			str= sc.nextLine(); //reads string
			sc.close();
		} catch (Exception ex) {
			System.out.println("Error in reading input: " + ex.getMessage());
		} finally {
			sc.close();
		}
		return str;
	}
	
	/*
	 * 
	 * @param: 
	 */
	public static String performOperation(String input) {
		File file = getFile("D:\\dictionary.txt");
		return "0";
		
	}
	
	/*
	 * Printing result
	 * @param: result
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
	 * Find word
	 * @param: 
	 */
	public static void printOutput(String result) {
		System.out.println("Output: "+result);
	}
	
}

