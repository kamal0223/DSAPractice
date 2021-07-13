package twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



/*Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one. You must implement a solution with a linear runtime complexity and 
use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4*/

/* Problem Solving Techniques :
	 * 1. Do you understand the question? - Yes
	 * 		Yes - Go to next step
	 * 		No - Ask the person to provide more detail with example(s).
	 * 
	 *  ->what is the input(s)? --> int[] input
	 * 	->what is the expected output? --> int
	 *  ->Do i have constraints to solve the problem? --> solve using O(n) time complexity and O(1) space complexity
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
public class OnlyOcurrenceElementArray {
	
	@Test
	public void test1() throws Exception {
		int[] input = {2,2,1};
		int output = 1;
		System.out.println(usingTwoPointer(input));
		Assert.assertEquals(output, workingCode(input));
		//Assert.assertTrue(Arrays.equals(usingThreePass(input), output));
	}
	
	@Test
	public void test2() throws Exception {
		int[] input = {1,4,4,1,3};
		int output = 3;
		System.out.println(usingTwoPointer(input));
		Assert.assertEquals(output, workingCode(input));
	}
	
	@Test (expected = Exception.class)
	public void test3() throws Exception {
		int[] input = {1,2,1,2};
		System.out.println(usingTwoPointer(input));
		//Assert.assertEquals(output, usingTwoPointer(input));
	}
	
	@Test (expected = Exception.class)
	public void test4() throws Exception {
		int[] input = {1,2,1,2};
		System.out.println(usingTwoPointer(input));
		//Assert.assertEquals(output, usingTwoPointer(input));
	}

	/*two pointer
	 *have to pick up the element for which count is one
	 *sort the array
	 *int duplicate = 0;
	 *keep left pointer at index 0
	 *Right pointer at index 0
	 *Traverse through the loop till right pointer is lenght-1
	 **if index is same then move right pointer
	 **if(leftvalue!=rightvalue) move right
	 *if leftValue==rightValue || if left value is already present in duplicate then increment left++ and duplicate = left
	 *else make tempUnique = 0 visited element tracker, increment left pointer and right pointer
	*/
	
	
	
	
	private int usingTwoPointer(int[] input) throws Exception {
	
		Arrays.sort(input);
		//int duplicate = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		int counter = 1;
		while(right<input.length) {
			
			
			if(left == right) right++;
			if(input[left] == input[right]) { 
				counter++;  //2
				left++;
				}
			if(counter == 1) return input[left+1];
			//counter reset to 1 on left pointer moving 
			if(input[left]!=input[right]) {
				left++; 
				counter = 1;
			}
			
			//if(right == input.length-2 && left == input.length-2) return input[right];
		}
		throw new Exception("No single element found");
	}
	
	
	private int workingCode(int[] input) throws Exception {
		Arrays.sort(input);
		//int duplicate = Integer.MIN_VALUE;
		int left = 0;
		int right = 1;
		while(right<input.length) {
			//
			if(input[left]!=input[right]) return input[left];
			left = left+2;
			right = right+2;
			if(right>=input.length) return input[right-1];
		}
		throw new Exception();
	}

}
