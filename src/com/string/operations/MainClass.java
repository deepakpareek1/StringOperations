package com.string.operations;

import java.io.File;
import java.util.ArrayList;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = Operations.getFile("C:/Users/dpareek/Documents/dictionary.txt");
		
		ArrayList<String> input = Operations.readInput();
		
		String option = input.get(0);
		String str = input.get(1);
		
		Operations.performOperation(file, option, str);
	
		
	}
	

}






