package onspot;

import org.junit.Assert;
import org.junit.Test;

public class LargestEvenLengthWord {

	@Test
	public void test1() {
		String input = "Time to write great code";
		Assert.assertEquals("Time", longestEvenWord(input));
	}
	
	@Test
	public void test2() {
		String input = "to write great code";
		Assert.assertEquals("code", longestEvenWord(input));
	}
	
	@Test
	public void test3() {
		String input = "Tim write great ode";
		Assert.assertEquals("No even lenght word", longestEvenWord(input));
	}

	private String longestEvenWord(String input) {
		//get each word as String array 
		String[] split = input.split("\\s+");
		//iterate the array
		int previousEvenLen = 0;
		String longest = "";
		for (int i = 0; i < split.length; i++) {
			int wordLen = split[i].length();
			//check if word length is even. 
			//compare the word length with previous high even word lenth
			//if yes then pick the index in int
			if(wordLen%2 == 0 && wordLen>previousEvenLen) {
				previousEvenLen = wordLen;
				longest = split[i];
			}
		}
		if(longest == "") return "No even lenght word";
		return longest;
	}
	
}
