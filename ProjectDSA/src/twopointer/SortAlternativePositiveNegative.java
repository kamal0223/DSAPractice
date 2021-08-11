package twopointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*array of nums, contains equal no of positve and negative, rearrange in an order +ve and then -ve in alternate positions.
Constraint: cannot use extra space
eg : int[] input = {12, -90, -100, 15, 98, 99, -56, -2};
		   expected output {12, -90, 15, -100, 98,-56,99,-2}*/

/*Input: String input
Output: String output
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and sliding window
*/
public class SortAlternativePositiveNegative {
	
	@Test
	public void test1() {
		int[] input = {12, -90, -100, 15, 98, 99, -56, -2};
		Assert.assertTrue(Arrays.equals(new int[] {12, -56, 98, -100, 15, -90, 99, -2}, usingTwoPointer(input)));
	}
	
	//negative
	@Test (expected = RuntimeException.class)
	public void test2() {
		int[] input = {};
		usingTwoPointer(input);
	}
	
	/*
	 * delcare two pointer left as zero and right to length-1
	 * iterate till left is less than right
	 * 	if(value left == positive) then left++
	 * 	else if(value right == negative) then right--
	 * 	else swap left and right
	 * Now the positve are first half and negative at second half
	 * iterate till left is less than right
	 *  if left is even then left++
	 *  if righ is odd then right--
	 *  else swap left and right
	 *  
	 *  return input
		time complexity - O(2n) and space complexity - O(1)
	
	*/
	
	public int[] usingTwoPointer(int[] input) {
		
		int left = 0, right = input.length-1;

		if(input.length == 0) throw new RuntimeException("input cannot be empty");
		while(left<right) {
			if(Integer.signum(input[left]) == 1) left++;
			if(Integer.signum(input[right]) == -1) right--;			
			if(Integer.signum(input[left]) == -1 && Integer.signum(input[right]) == 1){
				int temp = input[left];
				input[left++] = input[right];
				input[right--] = temp;
			}

		}
		System.out.println(Arrays.toString(input));
		left = 0;
		right = input.length-1;
		while(left<right) {
			if(left%2 == 0) left++;
			else if(right%2 != 0) right--;
			else {
				int temp = input[left];
				input[left++] = input[right];
				input[right--] = temp;
			}
		}
		
		System.out.println(Arrays.toString(input));
		return input;
		
	}

}
