package com.stringOperation.testCases;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.string.operations.Operations;

public class CorrectAdjacentLetters {
	
	private File file = Operations.getFile(Operations.FILE_PATH);

	@Test
	public void test() {
		
		ArrayList<String> actualOutput = Operations.getCorrectAdjacentLetters(file, "felhi");
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("Delhi");
		
		if (actualOutput.isEmpty()) {
			fail("test 2 is failed");
		} else {
			assertTrue(actualOutput.containsAll(expectedOutput));
		}
	}

}
