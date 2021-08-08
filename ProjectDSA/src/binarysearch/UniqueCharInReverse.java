package binarysearch;

import org.junit.Assert;
import org.junit.Test;

//Given an array of characters, print the unique characters in reverse order


/*Input: char[] input
Output: char[] reversedUnique
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and binary search
*/
public class UniqueCharInReverse {
	
	@Test //positive
	public void test1() {
		char[] input = {'e','e','h','h','l','p','p','p','r','s'};
		Assert.assertTrue(usingBruteForce(input).equals("srl"));
		}
	
	@Test //edge
	public void test2() {
		char[] input = {'e','e','h','h'};
		Assert.assertTrue(usingBruteForce(input).equals(""));
		}
	
	@Test (expected = RuntimeException.class)//negative
	public void test3() {
		char[] input = {};
		usingBruteForce(input);
		}

	
	//time complexity = O(n) space complexity = O(128) or O(n)
	private String usingBruteForce(char[] input) {
		
		if(input.length == 0) throw new RuntimeException("input cannot be empty");
		
		int[] asciChar = new int[128];
		String reverseUnique = "";
		for (int i = 0; i < input.length; i++) {
			asciChar[input[i]]++;
		}
		for(int i = 127;i>=0;i--) {
			if(asciChar[i] == 1) {
				reverseUnique = reverseUnique+(char) i;
				System.out.println(reverseUnique);
			}
		}
		
		return reverseUnique;
	}
	
	
	

}
