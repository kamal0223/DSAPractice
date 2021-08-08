package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class CountofProceedingNum {

	/*
	 *Given an integer array arr, count how many elements x there are, such that x + 1
	 *is also in arr. If there are duplicates in arr, count them separately.
	 *Input: arr = [1,2,3,5,6]    1,2,3,4   left = 
	 *Output: 4                      3
	 *Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

	 * Problem Solving Techniques :
	 * 1. Do you understand the question? - Yes
	 * 		Yes - Go to next step
	 * 		No - Ask the person to provide more detail with example(s).
	 * 
	 *  ->what is the input(s)? --> int[] input
	 * 	->what is the expected output? --> int output
	 *  ->Do i have constraints to solve the problem? -->2 <= nums.length <= 500, 0 <= nums[i] <= 100
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
	
	//positive
		@Test
		public void test1() {
			int[] input = {1,2,3,4,5};
			Assert.assertEquals(4, usingTwoPointer(input));
		}
		

		@Test
		public void test2() {
			int[] input = {1,2,3,4};
			Assert.assertEquals(3, usingTwoPointer(input));
		}
		
		@Test
		public void test3() {
			int[] input = {2,11,5,7};
			Assert.assertEquals(0, usingTwoPointer(input));
		}
		
		@Test
		public void test4() {
			int[] input = {3,7,8,43};
			Assert.assertEquals(1, usingTwoPointer(input));
		}
		
		/*
		 * initialize a counter
		 * initialize 2 pointers left from start of array
		 * right from end of array
		 * traverse the array using pointers till the left and right pointers meets
		 * 		if left pointer equals right-1 then increment counter by checking value at left pointer equals it left+1
		 * 		check if value at left pointer is equal to value of (left+1)+1 and increment counter
		 * 		check if the value at right pointer is equal to value of (right-1)-1 and increment counter
		 * 		increment left pointer and decrement right
		 * return counter
		
		time complexity - O(n/2)
		space complexity - O(1)
		*/
		private int usingTwoPointer(int[] input) {

			int counter = 0;
			int left = 0, right = input.length-1;
			while(left<right) {
				if(left == right-1) {
					if(input[left] == input[left+1]-1) return ++counter;
				}
				if(input[left] == input[left+1]-1) counter++;
				if(input[right] == input[right-1]+1) counter++;
				left++;
				right--;
			}
			return counter;
		}
}
