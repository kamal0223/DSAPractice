package leetcode;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/*https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> int[] output
 *  ->Do i have constraints to solve the problem? -->
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be?
 *  
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  -> Validate with the interviewer if the data set is fine -> its depends on the interviewer
 *  
 *  3. Do i know how to solve it?
 *  
 *  Yes - Great, is there an alternate? -> Yes
 *  No - Can i break down the problem into sub problems? 
 *  then -> 
 * 
 * 4. Ask for hint (if you do not know how to solve it?) 
 *  		-> Ask one time and thank the interviewer
 *  		-> Worst Case! even after got the hint, we don't know how to solve, then convince them and prove with your confidence 
 *  		   level to get the next question 
 *  
 * 5. Do I know alternate solutions as well? - yes
 * 	
 * 	Yes - What are those?
 *     way of Approach to solve with the following
 *    -> Brute Force (Simple Technique) -->  
 *    -> inbuilt approach --> List
 *  No - Can i break down the problems into sub problems?
 * 
 * 6. If you know alternate solutions-> find out the O notations (performance)
 *  Then explain the both or the best (depends on the time)
 *  
 *  Approach 1-> Start with the worst -> Improve to optimize -> End up with the beset
 *  Approach 2-> Write down the options and benefits and code the best
 *  
 * 7. Start with the Pseudo code
 * 
 * 8. Implement them in the code (editor)
 * 
 * 9. Test against the different data set
 * 
 * 10. If it fails, debug them to solve it
 */

public class PlusOne {
	
	@Test
	public void test1() throws Exception {
		int[] input = {1,2,3};
		int[] output = {1,2,4};
		Assert.assertEquals(true, Arrays.equals(new int[] {1,2,4}, usingStringConversion(input)));
	}
	
	@Test
	public void test2() throws Exception {
		int[] input = {4,3,9,9};
		int[] output = {4,4,0,0};
		Assert.assertEquals(true, Arrays.equals(new int[] {4,4,0,0}, usingStringConversion(input)));
	}
	
	@Test
	public void test3() throws Exception {
		int[] input = {0};
		int[] output = {1};
		Assert.assertEquals(true, Arrays.equals(new int[] {1}, usingStringConversion(input)));
	}
	
	/*
	 * Get the last element of the input array and add 1 to it, store each element in array temp
	 * create two pointer left at input array end and right at temp array end
	 * condition to check if right pointer < 0
	 * add the left pointer value and right pointer value and store it in left pointer value
	 * then decrement left and right
	 * return input array
	*/
	
	/*
	 * initialize sum = 0
	 * convert the int array to integer by traversing through it to the lenght of array
	 * multiple the sum to 10 and add this sum to the element
	 * Now add 1 to the integer
	 * convert to string
	 * create an output array of size of string
	 * traverse through the length of string
	 * add each element to corresponding index of output array
	 * 
	 * 
	 * 		sum = sum*10;
	 * 		sum = sum+intput[i]
	
	*/	
	
	private int[] usingStringConversion(int[] input) {
		
		int sum = 0;
		for(int i = 0;i<input.length;i++) {
			sum = sum*10+input[i];
		}
		sum++;
		String str = Integer.toString(sum);    // time complexity O(n) | space complexity O(n*m)
		int[] output = new int[str.length()];
		for(int j = 0;j<str.length();j++) {
			output[j] = Integer.parseInt(Character.toString(str.charAt(j)));
		}
		System.out.println(Arrays.toString(output));
		return output;
		
		
		/*
		 * if(input[input.length-1] != 9) { input[input.length-1]++; return input; }
		 * //if the last element in array is 9
		 * 
		 * else { input[input.length-1] = 0; input[input.length-2]++; }
		 * 
		 * System.out.println(Arrays.toString(input)); return input;
		 */
	}

}
