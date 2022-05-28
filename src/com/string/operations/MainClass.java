package com.string.operations;

import java.io.File;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = Operations.getFile("D:\\dictionary.txt");
		   
		String input = Operations.readInput();
		
		String result = Operations.performOperation(input);
		
		Operations.printOutput(result);
		
	}
	

}
