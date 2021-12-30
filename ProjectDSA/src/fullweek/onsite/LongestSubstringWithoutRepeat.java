package fullweek.onsite;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/*
Longest Substring without repeating character


Given a string s, find the length of the longest substring without repeating characters.

input:String
output: integer
approach: sliding window
 */
public class LongestSubstringWithoutRepeat {

	@Test
	public void test1() {
		String input = "abcabcbb";
		Assert.assertEquals(3, longestSubString(input));
	}

	@Test
	public void test2() {
		String input = "bbbbb";
		Assert.assertEquals(1, longestSubString(input));
	}

	@Test
	public void test3() {
		String input = "pwwkew";
		Assert.assertEquals(3, longestSubString(input));
	}

	/*
	 * declare an output int
	 * delcare a hashmap with key as characters and value as integer
	 * declare two pointers left as 0 and right as 0
	 * iterate till the left reaches end
	 * check if the map value is not greater than 1
	 *  get the value at right and add its occurence in map
	 * 	increment right
	 * if map value is greater than 1
	 * 	 if right-left+1 is greater than output. update output
	 * 	 loop the characters till right map value becomes 1
	 * continue the loop
	 * 	
	 * 
	 */

	private int longestSubString(String input) {

		int output = 0;
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		int left = 0, right=0;
		while(right<input.length()) {
			hm.put(input.charAt(right),hm.getOrDefault(input.charAt(right), 0)+1);
			while(hm.get(input.charAt(right))>1) {
				//decrement the count in map of left pointer
				hm.put(input.charAt(left), hm.get(input.charAt(left))-1);
				left++;
			}

			if(right-left+1> output) output = right-left+1;
			right++;
		}
		return output;
	}

	private int longestSubString2(String input) {

		int output = 0;
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		int left = 0, right=0;
		while(right<input.length()) {
			hm.put(input.charAt(right),hm.getOrDefault(input.charAt(right), 0)+1);
			if(hm.get(input.charAt(right))>1) {
				//decrement the count in map of left pointer
				hm.put(input.charAt(left), hm.get(input.charAt(left))-1);
				left++;
			}
			if(right-left+1> output) output = right-left+1;
			right++;
		}
		return output;
	}

}
