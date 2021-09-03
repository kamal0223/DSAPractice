package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/*Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively.Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and 
the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

*/

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] input1, input[] input2, int m, n
 * 	->what is the expected output? --> int[] output
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
public class SortTwoArrays {
	
	@Test
	public void test1() {
		int[] input1 = {1,2,3,0,0,0};
		int[] input2 = {2,5,6};
		int m = 3, n = 3;
		usingTwoPointer(input1, input2, m, n);
	}

	@Test
	public void test2() {
		int[] input1 = {0};
		int[] input2 = {1};
		int m = 0, n = 1;
		usingTwoPointer(input1, input2, m, n);
	}
	
	@Test
	public void test3() {
		
		int[] input1 = {1};
		int[] input2 = {0};
		int m = 1, n = 0;
		usingTwoPointer(input1, input2, m, n);
	}
	
	
	
	/* 
	 * traverse through the input2 array from 0 till length
	 * 		add the element from input2 to input1 from position m and increment m
	 * sort the input1 to ascending order using sort function
	 * 
	
	*/
		
	
	private int[] usingBruteForce(int[] input1, int[] input2, int m, int n) {
		
		/*
		if(m == 0) nums1 = nums2;
	        int i = m-1, j = n-1, k = m+n-1;
	        while(n != 0 && m !=0 && j>=0 && i>=0){
	            if(nums1[i]<nums2[j]) nums1[k--] = nums2[j--];
	            else nums1[k--] = nums1[i--];
	        }
		
		 */
		
		for(int i = 0;i<input2.length;i++){
	          input1[m++] = input2[i];
	      }
	        Arrays.sort(input1);
	        return input1;
		
	}
	

	
	private void usingTwoPointer(int[] nums1, int[] nums2, int m, int n) {
		  //if(m == 0) nums1 = nums2;
	        int i = m-1, j = n-1, k = m+n-1;
	        while(j>=0 || i>=0){
	        	int num1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
	            int num2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
	            if(num1<num2) {
	            	nums1[k] = num2;
	            	j--;
	            }
	            else {
	            	nums1[k] = num1;
	            	i--;
	            }
	            k--;
	        }
		  //System.out.println(Arrays.toString(nums1));
	}
}
