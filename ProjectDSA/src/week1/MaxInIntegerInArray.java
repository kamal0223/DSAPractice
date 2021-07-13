package week1;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;


/*
 * Given an array of integers nums find the max value
 * 
 * Problem Solving Techniques :
 * 1. Do you understand the question?
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int[] array
 * 	->what is the expected output? --> int output
 *  ->Do i have constraints to solve the problem? --> Do not sort the array and no negative numbers in array
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be? -> 
 *  
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  ----> Positive - {1,3,3,5,6,3}, output = 5
 *  ----> Negative - {}, outuput  = exception
 *  ----> Edge - {3,3,3,3}, output = 3
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

public class MaxInIntegerInArray {

	@Test
	public void test1() throws Exception {
		int[] input = {1,3,2,5,6,3};
		int output = 6;
		System.out.println(usingCollectionMax(input));
		Assert.assertEquals(output, usingCollectionMax(input));
	}
	
	@Test (expected = Exception.class)
	public void test2() throws Exception {
		int[] input = {};
		usingCollectionMax(input);
	}
	
	@Test
	public void test3() throws Exception {
		int[] input = {3,3,3,3,3};
		int output = 3;
		System.out.println(usingCollectionMax(input));
		Assert.assertEquals(output, usingCollectionMax(input));
	}
	
	/*
	 * initialize variable int maxValue to 0
	 * traverse through the array till the length 
	 * 	if the value at index i is greater than sum, then reassign sum = value in index i
	 * return the max value when loop is completed 
	*/
	private int bruteForce(int[] input) throws Exception {
		
		if(input.length == 0) throw new Exception("Empty input arrays are invalid");
		int max = 0;
		for(int i=0;i<input.length;i++) {
			if(input[i]>max) max = input[i];
		}
		return max;
		
	}
	
	/*
	 * Create a arraylist by passing Arrays.asList in constructor
	 * In Collections.max pass the list as arguement to get the max value in int type
	 * return the int max value
	 * Time complexity is O[2n]
	*/
	private int usingCollectionMax(int[] input) {
		
		List<Integer> ali = new ArrayList<Integer>(input.length);
		for(int i:input) {  //O[n]
			ali.add(i);
		}

		return Collections.max(ali); //iterator is used so time complexity is O[n]

		
	}
	
}
