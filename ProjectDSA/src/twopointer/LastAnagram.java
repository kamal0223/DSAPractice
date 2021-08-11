package twopointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*Given a string and target string, find the last matching anagram

String input = "abddcadca" target = adc
String output = "dca"*/



/*Input: String input, string target
Output: String output
constraints: time complexity O(n) and space O(n)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: sliding window
*/
public class LastAnagram {
	
	@Test //positive
	public void test1() {
		String input = "abddcadca";
		String target = "adc";
		Assert.assertTrue(lastAnagram(input, target).equals("dca"));
	}
	
	@Test //positive
	public void test5() {
		String input = "abddcad";
		String target = "adc";
		Assert.assertTrue(lastAnagram(input, target).equals("cad"));
	}
	@Test //negative
	public void test2() {
		String input = "abddcadca";
		String target = "aec";
		Assert.assertTrue(lastAnagram(input, target).equals(""));
	}
	
	@Test (expected = RuntimeException.class) //negative
	public void test3() {
		String input = "";
		String target = "aec";
		Assert.assertTrue(lastAnagram(input, target).equals(""));
	}
	
	@Test //edge
	public void test4() {
		String input = "ace";
		String target = "ace";
		Assert.assertTrue(lastAnagram(input, target).equals("ace"));
	}

	/*
	 * 
	 *declare asciicounter of 128 size
	 *declare tempString
	 *declare asciiTargetCount of 128
	 * iterate the target and add the count to asciiTargetCount
	 *declare left and right to zero
	 *iterate the input string
	 *add the asciicount of each element in asciiCounter
	 *move right 
	 *when right reaches target.lenght then stop right
	 *check if asciicounter matches asciiTargetCount
	 *tempString and add the substring to it
	 *move left pointer and decrement the asciicount
	 *repeat the same steps till right reaches the end
	 *
	 *return tempString
		
	time complexity - O(n) space complex - O(1)- constant as it will not grow
	*/
	private String lastAnagram(String input, String target) {
		
		if(input.length() == 0) throw new RuntimeException("input string cannoto be empty");
		
		int[] asciiCounter = new int[128];
		int[] asciiCounterTarget = new int[128];
		String tempString = "";
		for (int i = 0; i < target.length(); i++) {
			asciiCounterTarget[target.charAt(i)]++;
		}
		
		int left = 0, right = 0;
		while(right<input.length()) {
			asciiCounter[input.charAt(right++)]++;
			if(right-left == target.length()) {
				if(Arrays.equals(asciiCounter, asciiCounterTarget)) {
					tempString = input.substring(left,right);
				}
				asciiCounter[input.charAt(left++)]--;
				
			}
		}
		
		return tempString;
	}


}
