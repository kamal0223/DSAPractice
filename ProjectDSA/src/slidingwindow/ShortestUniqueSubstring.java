package slidingwindow;

import org.junit.Assert;
import org.junit.Test;

/*Write a program to return the shortest substring having all the unique characters of the string
Input: "abbcafcb" Output: "bcaf"*/

/*Input: String input
Output: String output
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and sliding window
*/

public class ShortestUniqueSubstring {
	
	@Test //positive
	public void test1() {
		String input = "abbcafcb";
		Assert.assertTrue(usingWindowSliding(input).equals("bcaf"));
	}
	
	@Test //positive
	public void test2() {
		String input = "abcfccbaaeg";
		Assert.assertTrue(usingWindowSliding(input).equals("abcf"));
	}
	
	//negative
	@Test (expected = RuntimeException.class)
	public void test3() {
		String input = "";
		Assert.assertTrue(usingWindowSliding(input).equals(""));
	}
	
	@Test //edge
	public void test4() {
		String input = "aaaaaa";
		Assert.assertTrue(usingWindowSliding(input).equals("a"));
	}

	/*
	 * declare two pointers left and right at zero
	 * declare shortDistinct as integer max
	 * iterate till right goes to last element
	 * check if the element ascii count is 0 then move right pointer
	 * else stop right pointer, get the right-left
	 * get the minium of previous shortDistinct and current right-left
	 * 	loop till right ascii counter becomes zero
	 * 		decrement the ascii count of that char
	 * 		increment left only if left!=right
	
	*/
	private String usingWindowSliding(String input) {
		
		if(input.length() == 0) throw new RuntimeException("input string cannot be empty");
		if(input.length() == 1) return input;
		
		int left = 0, right = 0;
		int windowUnique = 0;
		int[] asciiCounter = new int[128];
		String tempString = "";
		while(right<input.length()) {
			if(asciiCounter[input.charAt(right)] == 0) {
				asciiCounter[input.charAt(right)]++;
				right++;
			}
			else {
				if((right-left)>windowUnique)  {
					tempString = input.substring(left, right);
					windowUnique = right-left;
				}
				while(asciiCounter[input.charAt(right)] > 0) {
					asciiCounter[input.charAt(left++)]--;
				}
			}
			
		}
		System.out.println(tempString);
		return tempString;
	}

}
