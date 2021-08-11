package slidingwindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that 
every character in t (including duplicates) is included in the window. If there is no such substring, 
return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.*/

public class MinimumWindowSubstring {

	@Test //positive
	public void test1() {
		String input = "ADOBECODEBANC";
		String t = "ABC";
		Assert.assertEquals("BANC", usingSlidingWindow(input, t));
	}
	
	//negative
	@Test (expected = RuntimeException.class)
	public void test2() {
		String input = "A";
		String t = "AA";
		Assert.assertEquals("BANC", usingSlidingWindow(input, t));
	}
	
	@Test
	public void test3() {
		String input = "c";
		String t = "c";
		Assert.assertEquals("c", usingSlidingWindow(input, t));
	}
	
	@Test
	public void test4() {
		String input = "advbsc";
		String t = "advbsc";
		Assert.assertEquals("advbsc", usingSlidingWindow(input, t));
	}
	


/*
declare two hashmap say targetMap and inputMap
add the target char to targetmap with count as value 
declare two pointer left and right at zero

iterate till left reaches the end of input
check if the input char is contained in map key.
	then add to the inputHashMap with counter increment in value

if(sum of inputMapvalues == sum of targetMap values) stop the right
	get the minumWindow as this window
	get the minumWindowSize as this right-left
	loop through till the right count of the i == 0
		increment left 
		check if the input char is contained in map key and minumwindowSize<right-left
		get the minumWindow as this window
		get the minumWindowSize as this right-left
		if input char is contained in map key decrement the count
increment the right

return tempString

return tempString
*/
	
	private String usingSlidingWindow(String input, String target) {
		Map<Character,Integer> targetMap = new HashMap<>();
		Map<Character,Integer> inputMap = new HashMap<>();
		String tempString = "";
		int targetSum = 0;
		String miniumWindow = "";
		for (int i = 0; i < target.length(); i++) {
			targetMap.put(input.charAt(i), targetMap.getOrDefault(input.charAt(i), 0)+1);
			targetSum = targetSum+targetMap.get(input.charAt(i));
		}
		int left = 0, right = 0;
		while (left<input.length()) {
			int sum = 0;
			if(inputMap.containsKey(input.charAt(right))) {
				inputMap.put(input.charAt(right), inputMap.getOrDefault(input.charAt(right), 0)+1);
				sum = sum+inputMap.get(input.charAt(right));
			}
			
			if(sum == targetSum) {
				miniumWindow = input.substring(left, right);
				while (inputMap.get(input.charAt(right-1)) == 0) {
					left++;
					if(targetMap.containsKey(input.charAt(left))) {
						inputMap.put(input.charAt(right), inputMap.getOrDefault(input.charAt(right), 1)-1);
						sum--;
						if(sum == targetSum) miniumWindow = input.substring(left, right);
						
					}
				}
			}
		}
		
		return "";
	}
}
