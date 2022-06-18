package com.stringOperation.testCases;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.string.operations.Operations;

public class CorrectCase {

	private File file = Operations.getFile(Operations.FILE_PATH);
	
	@Test
	public void test1() {
		
		ArrayList<String> actualOutput = Operations.getCorrectPunctuation(file, "delhi");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("Delhi");
		
		if (actualOutput.isEmpty()) {
			fail("test 1 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}

	@Test
	public void test2() {
		
		ArrayList<String> actualOutput = Operations.getCorrectPunctuation(file, "aaron");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("Aaron");
		
		if (actualOutput.isEmpty()) {
			fail("test 2 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}
}
