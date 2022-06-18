package com.stringOperation.testCases;

import java.io.File;

import org.junit.Test;

import com.string.operations.Operations;

public class CheckWordExists {
	
	private File file = Operations.getFile(Operations.FILE_PATH);
	
	@Test
	public void test1() {
		
		equals(Operations.findWord(file,  "delhi").compareToIgnoreCase("Delhi"));
	}
	
	@Test
	public void test2() {
		
		equals(Operations.findWord(file, "deliberalization").compareToIgnoreCase("deliberalization"));
	}
	
	@Test
	public void test3() {
		
		equals(Operations.findWord(file, "zyzzogeton").compareToIgnoreCase("Zyzzogeton"));
	}
	
	@Test
	public void test4() {
		
		equals(Operations.findWord(file, "parasitary").compareToIgnoreCase("Parasitary"));
	}

}
