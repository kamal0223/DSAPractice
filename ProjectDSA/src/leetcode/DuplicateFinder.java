package leetcode;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;


/*https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
Given an integer array nums, return true if any value appears at least twice in the array, and 
		return false if every element is distinct.
*/
/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> boolean
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

public class DuplicateFinder {


	@Test
	public void test1() throws Exception {
		int[] input = {1,2,3,1};
		Assert.assertEquals(true, usingTwoPointer(input));
	}

	@Test
	public void test2() throws Exception {
		int[] input = {1,2,3,4};
		Assert.assertEquals(false, usingTwoPointer(input));
	}


	@Test
	public void test3() throws Exception {
		int[] input = {1,1,1,3,3,4,3,2,4,2};
		Assert.assertEquals(true, usingTwoPointer(input));
	}

	@Test (expected = Exception.class)
	public void test4() throws Exception {
		int[] input = {};
		usingTwoPointer(input);
	}

	/*//1,2,3,4,5,6,6
	 * sort the array ascending
	 * Place left pointer at starting position
	 * place right pointer at the end of array
	 * check for condition when left<right
	 * 	check if element at left is equal to its next element then return true
	 * 	else increment the left pointer
	 *  check if element at right is equal to its preceeding element then return true
	 *  else decrement the right pointer
		When no match is found then loop ends
	 *at the end of method return false
	 */
	private boolean usingTwoPointer(int[] input) throws Exception {

		if(input.length == 0) throw new Exception();
		
		Arrays.sort(input);
		int left = 0, right = input.length-1;
		while(left<right) {
			if(input[left] == input[left+1]) return true;
			else left++;
			if(input[right] == input[right-1]) return true;
			else right--;
		}

		return false;

	}

}
