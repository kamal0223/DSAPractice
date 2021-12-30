package cisco;

import org.junit.Test;



import junit.framework.Assert;

public class WordCount {
	
	@Test
	public void test1() {
		String str = "How many words are in a half-dozen, 13";
		Assert.assertEquals(7, wordCount(str));
	}
	
	@Test
	public void test2() {
		String str = "How many, words  are in a half dozen, 13";
		Assert.assertEquals(8, wordCount(str));
	}
	
	@Test
	public void test3() {
		String str = "13, 14";
		Assert.assertEquals(0, wordCount(str));
	}
	
	@Test
	public void test4() {
		String str = "";
		Assert.assertEquals(0, wordCount(str));
	}

	/*
	 * declare a count variable
	 *split the word based on spaces it would have trailing and leading spaces and empty element 
	 *iterate the string array and 
	 *check if the word is not a integer
	 *yes-> then increment count
	 *no-> move on with other element
	 *return count
	 */
	private int wordCount(String str) {
		
		//a regex to check if the word has all digits
		int count = 0;
		String[] splitWords = str.split(" ");
		for (String string : splitWords) {
			String input = string.replaceAll("[^a-zA-Z]", "");
				if(input.trim().length()>0)  count++;
		}
		return count;
	}

}
