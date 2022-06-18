package com.stringOperation.testCases;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.string.operations.Operations;

public class CorrectPunctuation {

	private File file = Operations.getFile(Operations.FILE_PATH);
	
	@Test
	public void test1() {
		
		ArrayList<String> actualOutput = Operations.getCorrectPunctuation(file, "cant");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("cant");
		expectedOutput.add("can't");
		
		if (actualOutput.isEmpty()) {
			fail("test 1 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}
	
	@Test
	public void test2() {
		
		ArrayList<String> actualOutput = Operations.getCorrectPunctuation(file, "don't");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("dont");
		
		if (actualOutput.isEmpty()) {
			fail("test 2 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}
	
	@Test
	public void test3() {
		
		ArrayList<String> actualOutput = Operations.getCorrectPunctuation(file, "bar/post");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("barpost");
		
		if (actualOutput.isEmpty()) {
			fail("test 2 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}

}
