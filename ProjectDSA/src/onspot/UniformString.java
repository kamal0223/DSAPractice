package onspot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class UniformString {

	/*Input: String input, int[] targetValues
	Output: String[] output 
	constraints: 

	TestData set: Positive
				  Negative
				  Edge
	Approaches Known: two pointer
	*/
	
	@Test
	public void test1() {
		String input = "abbccaadf";
		int[] target = {4,2,5,3,7};
		Assert.assertTrue(Arrays.equals(new String[] {"true","true","false","true","false"}, uniformString(input,target)));
	}
	
	@Test
	public void test2() {
		String input = "baaaa";
		int[] target = {1,2,4,3};
		Assert.assertTrue(Arrays.equals(new String[] {"true","true","true","true"}, uniformString(input,target)));
	}
	
	@Test
	public void test3() {
		String input = "c";
		int[] target = {1,2,4,3};
		Assert.assertTrue(Arrays.equals(new String[] {"false","false","false","true"}, uniformString(input,target)));
	}

	private String[] uniformString(String input, int[] target) {
		
		/*
		 * we need to find subarrays of repeating characters
		 * if it is not repeating then find the next character
		 * 
		 * declare pointers left at 0 and right at 0
		 * declare a hashmap
		 * add the target as key and set all its value as false in a Hash map
		 * declare a sum int to 0
		 * iterate the loop till left pointer reaches the end
		 * if the left and right has same character
		 * get the char int value at right by 
		 * 		get the ascii value of character of a-z is 97-122 so asciivalue-96 gives 1-26
		 * add the int value to sum and update sum 
		 * move right++
		 * else if left and right character not matching
		 * 	check if the sum is present in hashmap key, if yes then make that corresponding value to true
		 *  reset the sum to 0
		 *  move left to right pointer
		 * after the loop replace the sum value to true. so it will update if the key is present
		 * the entries in map are not in insertion order
		 * iterate the target array
		 * 	get the corresponding boolean from map and assign to output
		 * return output
		 * 
		 * time complexity = O(m+n) so O(n)
		 * space complexity = O(n) since we use Map
		 */
		
		int left = 0, right= 0;
		Map<Integer,Boolean> hm = new HashMap<Integer,Boolean>();
		//iterate the target and add false to all target
		for (int i = 0; i < target.length; i++) {
			hm.put(target[i], false);
		}
		int sum = 0;
		while (left<=input.length()-1 && right<=input.length()-1) {
			//get the char ascii value-96 to get 1-26
			int leftAscii = input.charAt(left)-96;
			int rightAscii = input.charAt(right)-96;
			if(leftAscii == rightAscii) {
				sum += rightAscii;
				//make true as value for corresponding sum value in map
				hm.replace(sum, true);
				right++;
			}else if(leftAscii != rightAscii) {
				sum = 0;
				left = right;
			}
		}
		//get the last value from input string sum
		hm.replace(sum, true);
		String[] output = new String[target.length];
		for (int i = 0; i < target.length; i++) {
			output[i] = String.valueOf(hm.get(target[i]));
		}
		
		System.out.println(Arrays.toString(output));
		return output;
	}
}
