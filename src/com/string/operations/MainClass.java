package com.string.operations;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   
		String input = Operations.readInput();
		
		String result = Operations.performOperation(input);
		
		Operations.printOutput(result);
		
	}
	

}






