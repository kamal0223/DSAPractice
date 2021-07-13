package week1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


/*
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 * 	Input: nums1 = [1,2,2,1],  [1,2,3,4,5]
 * 	nums2 = [2,2]               [3,4,3]
 * 	Output: [2]                  [3,4]
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> int[] output
 *  ->Do i have constraints to solve the problem? --> result array can be in any order
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

public class IntersectionOfArray {

	//positive
	@Test
	public void test1() {
		int[] input1 = {2,2};
		int[] input2 = {1,2,2,3,4};
		int[] intersection = {2};
		
		System.out.println("intersetion input1 "+Arrays.toString(usingSet(input1, input2)));
		Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
	}

	//positive with single occurence of intersection
	@Test
	public void test2() {
		int[] input1 = {1,2,3,4,5};
		int[] input2 = {2,4,3};
		int[] intersection = {2,3,4};
		Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
	}

	//Negative case
	@Test
	public void test3() {
		int[] input1 = {1,2,2,3,4};
		int[] input2 = {5,6};
		int[] intersection = {};
		Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
	}

	//edge
	@Test
	public void test4() {
		int[] input1 = {};
		int[] input2 = {1,2,3,3};
		int[] intersection = {};
		
		Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
	}

	/*
	 * Initialize a hashset of Integer type
	 * Traverse throught the first input array till the length
	 * Inside the first loop, traverse through the second input array till the length
	 * Match the values of first and second array
	 * if match found then add the input array one to hashset and break second loop as other matches can be omitted
	 * initialize output array of int of size of set
	 * Traverse through the set and add each element from to output array
	 * return output array
	 */

	//time complexity is O(n*m)
	// space complexity is O(n)
	private int[] bruteForce(int[] input1, int[] input2) {

		Set<Integer> hs = new HashSet<Integer>();
		for(int i=0;i<input1.length;i++) {
			for(int j=0;j<input2.length;j++) {
				if(input1[i] == input2[j]) {
					hs.add(input1[i]);
					break;
				}
			}
		}

		int[] output = new int[hs.size()];
		int b = 0;
		for(Integer each:hs) {
			output[b++] = each;
		}

		return output;
	}

	
	/*
	 * create 2 hashset
	 * Traverse the first input array and add elements to first set.
	 * Traverse the second input array and add elements to second set
	 * using set retainall function compare first set with second set 
	 * to get the intersection of two sets
	 * convert the set to int array by traversing the set and add the each set value to first input array
	 * return the input array one of length size of set
	 * 	
	*/	
	//time complexity = O(nlogn)
	//space compexity = O(1)
	private int[] usingSet(int[] input1, int[] input2) {
		
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		for(int i=0;i<input1.length;i++) {
			set1.add(input1[i]);
		}
		for(int i=0;i<input2.length;i++) {
			set2.add(input2[i]);
		}
		set1.retainAll(set2);
		int a =0;
		
		for(Integer each:set1) {
			input1[a] = each;
			a++;
		}
		
		System.out.println("intersection set "+set1.toString());
		return Arrays.copyOf(input1, set1.size());
		
	
		
	}
}

