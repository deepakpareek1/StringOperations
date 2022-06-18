package com.stringOperation.testCases;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.string.operations.Operations;

public class CorrectDulicateLetters {

	private File file = Operations.getFile(Operations.FILE_PATH);
	
	@Test
	public void test() {
		
		ArrayList<String> actualOutput = Operations.getCorrectDuplicateLetters(file, "aall");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("a");
		expectedOutput.add("aa");
		expectedOutput.add("aal");
		expectedOutput.add("all");
		expectedOutput.add("l");
		
		
		if (actualOutput.isEmpty()) {
			fail("test 1 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}

}
