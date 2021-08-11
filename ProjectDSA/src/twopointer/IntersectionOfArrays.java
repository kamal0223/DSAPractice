package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/*Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays and 
 * you may return the result in any order.
		 * 	Input: nums1 = [1,2,2,1],  [1,2,3,4,5]
		 * 	nums2 = [2,2]               [3,4,3]
		 * 	Output: [2,2]                  [3,4]*/

/* Problem Solving Techniques :
	 * 1. Do you understand the question? - Yes
	 * 		Yes - Go to next step
	 * 		No - Ask the person to provide more detail with example(s).
	 * 
	 *  ->what is the input(s)? --> int[] array
	 * 	->what is the expected output? --> int[] output
	 *  ->Do i have constraints to solve the problem? --> using 2 pointer
	 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
	 *  ->How big is your test data will be? -> 
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
	 * 5. Do I know alternate solutions as well?
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

public class IntersectionOfArrays {
	
	//positive
		@Test
		public void test1() {
			int[] input1 = {2,2};
			int[] input2 = {1,2,2,3,4};
			int[] intersection = {2,2};
			
			Assert.assertTrue(Arrays.equals(intersection, usingTwoPointer(input1, input2)));
		}

		//positive with single occurence of intersection
		@Test
		public void test2() {
			int[] input1 = {1,2,4,5};
			int[] input2 = {5,4,5};
			int[] intersection = {4,5};
			Assert.assertTrue(Arrays.equals(intersection, usingTwoPointer(input1, input2)));
		}

		//Negative case
		@Test
		public void test3() {
			int[] input1 = {1,2,2,3,4};
			int[] input2 = {5,6};
			int[] intersection = {};
			Assert.assertTrue(Arrays.equals(intersection, usingTwoPointer(input1, input2)));
		}

		//edge
		@Test
		public void test4() {
			int[] input1 = {};
			int[] input2 = {1,2,3,3};
			int[] intersection = {};
			Assert.assertTrue(Arrays.equals(intersection, usingTwoPointer(input1, input2)));
		}
		
		
		/*
		 * sort both the inputs
		 * initialize an output array with size of smallest array
		 * Initialize a left pointer at start of first array and 
		 * right pointer at start of second array
		 * Traverse till condition left<smallerArray.length
		 * if value of left<right then increment left
		 * if value of right<left then increment right
		 * if value of left == right add it to output array and increment both left, right
		 * return the output array
		*/

		private int[] usingTwoPointer(int[] input1, int[] input2) {
			//merge input1 and 2
			//int[] input1 = {1,2,4,5};
			//int[] input2 = {5,4,5};
			
			Arrays.sort(input1);
			Arrays.sort(input2);
			int[] output = new int[Math.min(input1.length, input2.length)];
			
			int left = 0, right = 0;
			int k = 0;
			while(left<input1.length && right<input2.length) {
				if(input1[left]<input2[right]) left++;
				else if(input2[right]<input1[left]) right++;
				else {                            //when left value = right value
					output[k] = input1[left++];
					right++;
					k++;
				}
			}
			
			System.out.println(Arrays.toString(Arrays.copyOf(output, k)));
			return Arrays.copyOf(output, k);
		}
		
		

}
