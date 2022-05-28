package com.string.operations;

import java.io.File;
import java.util.Scanner;

public class Operations {

	public Operations() {
		// TODO Auto-generated constructor stub
	}
	
	public static File getFile(String path) {
		File file = new File(path);
		return file;
	}
	
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
	
	public static String performOperation(String input) {
		return "0";
		
	}
	
	public static void printOutput(String result) {
		System.out.println("Output: "+result);
	}
	
}
